package com.opm.userController;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.opm.CustomSort.SortByDateForMeeting;
import com.opm.database.Meeting;
import com.opm.service.MeetingDAOJDBCImpl;

@Controller
public class MeetingController {
	
	@Autowired
	private MeetingDAOJDBCImpl meetingJDBC;
	
	private int getSessionProjectId()
	{
		int projectId=(int)RequestContextHolder.currentRequestAttributes().getAttribute("projectId", RequestAttributes.SCOPE_SESSION);
		return projectId;
	}
	
	@RequestMapping("/meeting")
	private String getMeetings(ModelMap model) {
		List<Meeting> meeting = meetingJDBC.getMeetings(getSessionProjectId());
		meeting.sort(new SortByDateForMeeting());
		String data="";
		for(Meeting m : meeting) {
			data+="[";
			data+="'"+m.getDate().toString()+"','"+m.getTopic()+"','"+m.getConclusion()+"'";
			data+="],";
		}
		model.addAttribute("data",data);
		return "meeting";
	}
	
	@RequestMapping("/meeting/addMeeting")
	private String addMeeting(ModelMap model,@RequestParam("date") Date date, @RequestParam("topic") String topic, @RequestParam("conclusion") String conclusion ){
		Meeting meeting = new Meeting(getSessionProjectId(),topic, conclusion, date);
		meetingJDBC.addMeeting(meeting);
		return "redirect:/meeting";
	}
	
	
}

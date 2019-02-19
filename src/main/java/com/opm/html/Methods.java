package com.opm.html;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opm.database.Milestone;
import com.opm.database.Project;
import com.opm.database.ProjectChat;
import com.opm.database.Task;
import com.opm.database.TaskChat;
import com.opm.database.User;
import com.opm.service.TaskDAOJDBCImpl;

public class Methods {
	private static Calendar cal;


	@Autowired
	private TaskDAOJDBCImpl taskJDBC;
	public static String errorMessage(String message)
	{
		return "<div class=\"alert alert-danger\">"+message+"</div>";
	}
	public static String successMessage(String message)
	{
		return "<div class=\"alert alert-success\">"+message+"</div>";
	}

	public static String jsAlert(String message)
	{
		return "<script> window.alert("+message+") </script>";
	}

	public static String getProjectPanel(Project project,int i)
	{
		String view = " <div style=\"border-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px; border :1px solid #ddd;  background-color: #f5f5f5;padding: 5px; margin-top: 10px; width: 100%;float:left;\"><h3 style=\"margin:3px;\">" + 
				"	<a href=\"/user/projects/moreInfo?projectId="+project.getProjectId()+"\">" + project.getProjectName() + "</a>"+ 
				"  <form action=\"/user/projects/moreInfo?projectId="+project.getProjectId()+"\" method=\"post\" style=\"float:right; width:auto; height:auto;\">" + 
				"  <button type=\"submit\" class=\"btn btn-default\" style=\"border: 0px;" + 
				"    border-radius: 4px;" + 
				"    -webkit-font-smoothing: antialiased;" + 
				"    font-weight: bold;" + 
				"    padding: 4px;" + 
				"    margin-right: 10px;" + 
				"    vertical-align: middle;" + 
				"    text-align: center;" + 
				"    background-color: #3367d6;" + 
				"    color: rgb(255, 255, 255);" + 
				"    width: auto;" + 
				"    float: right;\">More Info</button></form>" + 
				"	<form action=\"/user/projects/delete?projectId="+project.getProjectId()+"\" method=\"post\" style=\"float:right; width:auto; height:auto;\">" + 
				"    <button type=\"submit\" class=\"btn btn-default\" style=\"border: 0px;" + 
				"    border-radius: 4px;" + 
				"    -webkit-font-smoothing: antialiased;" + 
				"    font-weight: bold;" + 
				"    padding: 4px;" + 
				"    margin-right: 10px;" + 
				"    vertical-align: middle;" + 
				"    text-align: center;" + 
				"    background-color: rgb(230, 0, 35);" + 
				"    color: rgb(255, 255, 255);" + 
				"    width: auto;" + 
				"    float: right;\">Delete</button></form></h3></div>" + 
				"  	<div style=\"border-radius: 5px; border-top-right-radius: 0px; border-top-left-radius: 0px; border-bottom:1px solid #ddd; border-right:1px solid #ddd; border-left:1px solid #ddd; padding: 5px;display: block;/* height: 108px; */\">\r\n" + 
				"	<p>		"+
				project.getDescription()+
				"    </p>" + 
				"  </div>";
		return view;
	}

	public static String listParticipant(User user)
	{
		String view = 
				"<li><div class=\"container\" style=\"float: left; background-color: white; margin-top:5px; border-radius: 4px;\">" + 
						"  <img src=\""+user.getImage()+"\" alt=\"Avatar\" style=\"width:auto; height: 30px; margin-top: 4px; \">" + 
						"  <b>"+user.getName()+"</b>" + 
						"<div style=\"float:right\">"+
						"<a href=\"/project/deleteParticipant?username="+user.getUsername()+"\" style=\"float: right; padding: 0px 10px;\"><button\r\n" + 
						"type=\"button\" class=\"btn btn-danger\">Delete</button></a>" +
						"</div>"+
						"</div></li>";

		return view;
	}


	public static String getChat(ProjectChat chat, User user, int i)
	{

		String view="";
		if(i==0)
		{
			view="<div class=\"container\"" + 
					"			style=\"float: left; background-color: white; margin-top: 5px; border-radius: 10px;\">" + 
					"			<img src=\""+user.getImage()+"\" alt=\"Avatar\"" + 
					"				style=\"float: right; width: auto; height: 30px; margin-top: 4px;\"> <b><p style=\"float: right; margin: 10px;  margin-right: 5px; \">" +
					user.getName() +
					"				</p></b>" + 
					"			<p style=\"margin-top: 2px;\">"+chat.getMessage()+"</p>" + 
					"			<span class=\"time-right\" style=\"float: right; margin-top: 2px;\">"+ chat.getTimestamp()+"</span>" + 
					"		</div>";
		}
		else
		{
			view="<div class=\"container\"" + 
					"			style=\"float: left; background-color: white; margin-top: 5px; border-radius: 10px;\">" + 
					"			<img src=\""+user.getImage()+"\" alt=\"Avatar\"" + 
					"				style=\"width: 10%; height: 30px; margin-top: 4px;\"> <b>" +
					user.getName() +
					"				</b>" + 
					"			<p style=\"margin-top: 2px;\">"+chat.getMessage()+"</p>" + 
					"			<span class=\"time-right\">"+ chat.getTimestamp()+"</span>" + 
					"		</div>";
		}
		return view;
	}

	public static String getTaskChat(TaskChat chat, User user, int i)
	{

		String view="";
		if(i==0)
		{
			view="<div class=\"container\"" + 
					"			style=\"float: left; background-color: white; margin-top: 5px; border-radius: 10px;\">" + 
					"			<img src=\""+user.getImage()+"\" alt=\"Avatar\"" + 
					"				style=\"float: right; width: auto; height: 30px; margin-top: 4px;\"> <b><p style=\"float: right; margin: 10px;  margin-right: 5px; \">" +
					user.getName() +
					"				</p></b>" + 
					"			<p style=\"margin-top: 2px;\">"+chat.getMessage()+"</p>" + 
					"			<span class=\"time-right\" style=\"float: right; margin-top: 2px;\">"+ chat.getTimestamp()+"</span>" + 
					"		</div>";
		}
		else
		{
			view="<div class=\"container\"" + 
					"			style=\"float: left; background-color: white; margin-top: 5px; border-radius: 10px;\">" + 
					"			<img src=\""+user.getImage()+"\" alt=\"Avatar\"" + 
					"				style=\"width: 10%; height: 30px; margin-top: 4px;\"> <b>" +
					user.getName() +
					"				</b>" + 
					"			<p style=\"margin-top: 2px;\">"+chat.getMessage()+"</p>" + 
					"			<span class=\"time-right\">"+ chat.getTimestamp()+"</span>" + 
					"		</div>";
		}
		return view;
	}


	public static String getMilestone(Milestone mile,List<Task> task) {
		int ct=0,tt=0;
		java.util.Date date = new java.util.Date();
		Date sd = new Date(date.getTime());
		Date ed = new Date(0);


		for(Task t : task) {
			sd.setTime(Math.min(t.getStartDate().getTime(),sd.getTime()));
			ed.setTime(Math.max(t.getEndDate().getTime(),ed.getTime()));
			if(t.getStatus().contains("completed"))
				ct++;
			tt++;
		}
		if(sd.getTime()>ed.getTime())
			ed.setTime(sd.getTime());

		int per=0;
		try {
			per = (ct*100)/tt;
		}
		catch(Exception e)
		{
			per = 100;
		}
		int i=mile.getMilestoneId();
		String view="<div class=\"panel-group\" id=\"accordion\"\r\n" + 
				"		style=\"float: left; width: 100%;\">\r\n" + 
				"		<div class=\"panel panel-default\" style=\"height: auto;\">\r\n" + 
				"			<div class=\"panel-heading\" style=\"height: 50px;\">\r\n" + 
				"				<h4 class=\"heading\"\r\n" +  
				"					style=\"margin-left: 0px; margin-right: 10px; width: 150px;\">"+mile.getMilestoneName()+"</h4>\r\n" + 
				"				<h4 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">"+mile.getTimestamp()+"</h4>\r\n" + 
				"				<h4 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">"+sd+"\r\n" + 
				"				</h4>\r\n" + 
				"				<h4 class=\"heading\" style=\"margin-right: 5px; width: 180px;\">"+ed+"\r\n" + 
				"					</h4>\r\n" +
				"	<div class=\"w3-container\" style=\"float:right; width: 20%;\">\r\n" + 
				"  <div class=\"w3-white\">\r\n" + 
				"    <div id=\"myBar"+mile.getMilestoneId()+"\" class=\"w3-blue\" style=\"height:25px;width:0\"><h5 style=\"text-align: center;margin-top:10px;\">"+per+"%</h5></div>\r\n" + 
				"  </div>\r\n" + 
				"  <br>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<script>\r\n" + 
				"\r\n" + 
				"  var elem = document.getElementById(\"myBar"+mile.getMilestoneId()+"\");   \r\n" + 
				"  var width = "+per+";\r\n" + 
				"   elem.style.width = width + '%'; \r\n" + 
				"\r\n" + 
				"</script>\r\n" + 
				"			</div>\r\n"+
				"	<div class=\"panel-body\">\r\n" ;		
		for(Task t: task) {
			view+=		 
					"			<div style=\"width:auto; float:left\">" +
							"				<a href=\"/milestone/task?taskId="+t.getTaskId()+"\"><h6 class=\"heading\"\r\n" + 
							"					style=\"margin-left: 0px; margin-right: 10px; width: 180px;\">"+t.getTaskName()+"</h6></a>\r\n" + 
							"				<h6 class=\"heading\"\r\n" + 
							"					style=\"margin-left: 0px; margin-right: 10px; width: 180px;\">"+t.getTimestamp()+"</h6>\r\n" + 
							"				<h6 class=\"heading\"\r\n" + 
							"					style=\"margin-left: 0px; margin-right: 10px; width: 180px;\">"+t.getStartDate()+"</h6>\r\n" + 
							"				<h6 class=\"heading\"\r\n" + 
							"					style=\"margin-left: 0px; margin-right: 10px; width: 180px;\">"+t.getEndDate()+"</h6>\r\n" + 
							"				<div\r\n" + 
							"					style=\"margin-left: 0px; margin-right: 10px; margin-top: 10px;margin-down:10px; float:left;width: 100px;\">\r\n";


			Date now = new Date(date.getTime());
			if(t.getStatus().contains("completed"))
			{
				view+="					<span class=\"label label-success\"\r\n" + 
						"						style=\"padding: 5px; font-size: 1em;\">Completed</span>\r\n" + 
						"				</div>\r\n" ; 
			}
			else if(t.getStartDate().getTime()-now.getTime()>0)
			{
				view+="					<span class=\"label label-info\"\r\n" + 
						"						style=\"padding: 5px; font-size: 1em;\">Upcoming</span>\r\n" + 
						"				</div>\r\n" ;
			}
			else if(t.getEndDate().getTime()-now.getTime()<0)
			{
				view+="					<span class=\"label label-danger\"\r\n" + 
						"						style=\"padding: 5px; font-size: 1em;\">Overdue</span>\r\n" + 
						"				</div>\r\n" ;
			}
			else
			{
				view+="					<span class=\"label label-warning\"\r\n" + 
						"						style=\"padding: 5px; font-size: 1em;\">Progress</span>\r\n" + 
						"				</div>\r\n" ;
			}
			view+=	"				<div\r\n" + 
					"					style=\"margin-left:100px ; margin-right: 10px; margin-top: 0px;margin-down:10px; float:right;width: auto;\">\r\n"+
					"<form action=\"/milestone/deleteTask?taskId="+t.getTaskId()+"\" method=\"post\">\r\n" + 
					"<button type=\"submit\" class=\"btn btn-danger\" id=\"delete"+i+"\"\r\n" + 
					"				style=\"border: 0px; height: auto; display: inline-block; border-radius: 1px; -webkit-font-smoothing: antialiased; padding: 0px 5px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: auto;\">\r\n" + 
					" Delete </button>\r\n" +
					"	</form>" +
					"</div>" +
					"</div>";
		}
		view+=	"			<br />\r\n" + 
				"			<!-- ADD BUTTON -->\r\n" + 
				"			<button type=\"submit\" class=\"btn btn-success\" id=\"addT"+i+"\"\r\n" + 
				"				style=\"float:left; border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; margin-left: 0px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: 10%;\"\r\n" + 
				"				onclick=\"document.getElementById('form"+i+"').style.display='block'\">Add\r\n" + 
				"				Task</button>\r\n" + 
				"\r\n" + 
				"			<div id=\"form"+i+"\" class=\"panel panel-default\"\r\n" + 
				"				style=\"background-color: rgb(255, 255, 255); border-radius: 8px; position: relative; text-align: center; width: 440px; margin: auto; min-height: initial; box-shadow: rgba(0, 0, 0, 0.45) 0px 2px 10px; padding: 55px; padding-top: 20px; margin-top: 25px; display: none;\">\r\n" + 
				"\r\n" + 
				"				<form action=\"/milestone/addTask?milestoneId="+mile.getMilestoneId()+"\" method=\"post\">\r\n" + 
				"					<center>\r\n" + 
				"						<div class=\"form-group\" style=\"margin-top: 40px;\">\r\n" + 
				"							<label for=\"TasktName\">Task Name:</label> <input type=\"text\"\r\n" + 
				"								class=\"form-control\" id=\"taskName\"\r\n" + 
				"								placeholder=\"Enter Task Name\" name=\"taskName\"\r\n" + 
				"								style=\"width: 60%;\" required=\"required\" />\r\n" + 
				"						</div>\r\n" + 
				"					</center>\r\n" + 
				"					<center>\r\n" + 
				"						<div class=\"form-group\" style=\"margin-top: 40px;\">\r\n" + 
				"							<label for=\"TaskStartDate\">Task Start Date:</label> <input\r\n" + 
				"								type=\"date\" class=\"form-control\" id=\"startDate\"\r\n" + 
				"								name=\"startDate\" style=\"width: 60%;\" required=\"required\" />\r\n" + 
				"						</div>\r\n" + 
				"					</center>\r\n" + 
				"					<center>\r\n" + 
				"						<div class=\"form-group\" style=\"margin-top: 40px;\">\r\n" + 
				"							<label for=\"TaskEndDate\">Task End Date:</label> <input\r\n" + 
				"								type=\"date\" class=\"form-control\" id=\"endDate\"\r\n" + 
				"								name=\"endDate\" style=\"width: 60%;\" required=\"required\" />\r\n" + 
				"						</div>\r\n" + 
				"					</center>\r\n" + 
				"					<center>\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"							<label for=\"comment\">Description:</label>\r\n" + 
				"							<textarea class=\"form-control\" rows=\"5\" id=\"description\" name=\"description\"\r\n" + 
				"								style=\"resize: none;\" required=\"required\"></textarea>\r\n" + 
				"						</div>\r\n" + 
				"					</center>\r\n" + 
				"					<button type=\"submit\" class=\"btn btn-default\"\r\n" + 
				"						style=\"border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(230, 0, 35); color: rgb(255, 255, 255); width: 50%;\">Submit</button>\r\n" + 
				"				</form>\r\n" + 
				"\r\n" + 
				"				<form action=\"/milestone\">\r\n" + 
				"					<button type=\"submit\" id=\"cancel\" class=\"btn btn-success\"\r\n" + 
				"						style=\"border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 15px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin-top: 10px; vertical-align: middle; text-align: center; background-color: rgb(0, 250, 35); color: rgb(255, 255, 255); width: 50%;\">Cancel</button>\r\n" + 
				"				</form>\r\n" + 
				"			</div>\r\n" + 
				"\r\n" + 
				"<form action=\"/milestone/deleteMilestone?milestoneId="+mile.getMilestoneId() +"\" method=\"post\" style=\"float:left;\">"+
				"			<button type=\"submit\" class=\"btn btn-danger\" id=\"deleteMT"+mile.getMilestoneId()+"\"\r\n" + 
				"				style=\" border: 0px; height: 28px; display: inline-block; border-radius: 4px; -webkit-font-smoothing: antialiased; padding: 0px 18px; font-size: 10px; font-weight: bold; outline: none; box-shadow: none; cursor: pointer; margin: 10px; vertical-align: middle; text-align: center; color: rgb(255, 255, 255); width: auto;\">\r\n" + 
				"				Delete\r\n" + 
				"				Milestone</button>\r\n" +
				"</form> " +
				"	</div>" +
				"			<br />\r\n" + 
				"			</div>\r\n"+
				"		</div>\r\n" ;
		return view;
	}

	int toInt(String s)
	{
		int x=0;
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			x*=10;
			x+=(c-'0');
		}
		return x;
	}

	public String DisplayReport(List<Task> task) {
		
		
		java.util.Date date = new java.util.Date();
		Date sd = new Date(date.getTime());
		Date ed = new Date(0);


		for(Task t : task) {
			sd.setTime(Math.min(t.getStartDate().getTime(),sd.getTime()));
			ed.setTime(Math.max(t.getEndDate().getTime(),ed.getTime()));
		}
		if(sd.getTime()>ed.getTime())
			ed.setTime(sd.getTime());
		
		long days =((ed.getTime()-sd.getTime())/86400000)+1;
		
		String view="<html>\r\n" + 
				"<head>\r\n" + 
				"  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
				"  <script type=\"text/javascript\">\r\n" + 
				"    google.charts.load('current', {'packages':['gantt']});\r\n" + 
				"    google.charts.setOnLoadCallback(drawChart);\r\n" + 
				"\r\n" + 
				"    function daysToMilliseconds(days) {\r\n" + 
				"      return days * 24 * 60 * 60 * 1000;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    function drawChart() {\r\n" + 
				"\r\n" + 
				"      var data = new google.visualization.DataTable();\r\n" + 
				"      data.addColumn('string', 'Task ID');\r\n" + 
				"      data.addColumn('string', 'Task Name');\r\n" + 
				"      data.addColumn('date', 'Start Date');\r\n" + 
				"      data.addColumn('date', 'End Date');\r\n" + 
				"      data.addColumn('number', 'Duration');\r\n" + 
				"      data.addColumn('number', 'Percent Complete');\r\n" + 
				"      data.addColumn('string', 'Dependencies');\r\n" + 
				"\r\n" +
				"      data.addRows([\r\n" ;
				System.out.println("okk");
				for(Task t : task ) {
					String d = (t.getStartDate().toString());
					String tokens[] = d.split("-");
					view+="['"+t.getTaskId()+"','"+t.getTaskName()+"',new Date("+toInt(tokens[0])+","+(toInt(tokens[1])-1)+","+toInt(tokens[2])+"),";
					tokens=(t.getEndDate().toString().split("-"));
					view+="new Date("+toInt(tokens[0])+","+(toInt(tokens[1])-1)+","+toInt(tokens[2])+"),null,100,"+t.getDescription();
					view+="],";
				}
				view+= 
				"      ]);\r\n" + 
				"\r\n" + 
				"      var options = {\r\n" + 
				"        height: 1000,\r\n" +
				"		width:"+50*days +
				"      };\r\n" + 
				"\r\n" + 
				"      var chart = new google.visualization.Gantt(document.getElementById('chart_div'));\r\n" + 
				"\r\n" + 
				"      chart.draw(data, options);\r\n" + 
				"    }\r\n" + 
				"  </script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"  <div id=\"chart_div\"></div>\r\n" +
				"</body>\r\n" + 
				"</html>";
		return view;
	}
}



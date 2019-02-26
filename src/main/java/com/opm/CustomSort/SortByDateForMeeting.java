package com.opm.CustomSort;

import java.util.Comparator;

import com.opm.database.Meeting;

public class SortByDateForMeeting implements Comparator<Meeting>{

	@Override
	public int compare(Meeting o1, Meeting o2) {
		return (int) (o1.getDate().getTime()-o2.getDate().getTime());
	}

}

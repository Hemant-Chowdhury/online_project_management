package com.opm.CustomSort;

import java.util.Comparator;

import com.opm.database.TaskChat;

public class SortByTimeForTask implements Comparator<TaskChat>{

	@Override
	public int compare(TaskChat o1, TaskChat o2) {
		return (int) (o1.getTimestamp().getTime()-o2.getTimestamp().getTime());
	}

}

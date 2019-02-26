package com.opm.CustomSort;

import java.util.Comparator;

import com.opm.database.TaskFeed;

public class SortByTimeForTaskFeed implements Comparator<TaskFeed>{

	@Override
	public int compare(TaskFeed o1, TaskFeed o2) {
		return (int) (o2.getTimestamp().getTime()-o1.getTimestamp().getTime());
	}
}

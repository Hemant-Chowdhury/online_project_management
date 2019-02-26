package com.opm.CustomSort;

import java.util.Comparator;

import com.opm.database.ProjectFeed;

public class SortByTimeForProjectFeed implements Comparator<ProjectFeed>{

	@Override
	public int compare(ProjectFeed o1, ProjectFeed o2) {
		return (int) (o2.getTimestamp().getTime()-o1.getTimestamp().getTime());
	}
}

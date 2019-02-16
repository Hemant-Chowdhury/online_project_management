package com.opm.CustomSort;

import java.util.Comparator;

import com.opm.database.ProjectChat;

public class SortByTime implements Comparator<ProjectChat>{

	@Override
	public int compare(ProjectChat o1, ProjectChat o2) {
		return (int) (o1.getTimestamp().getTime()-o2.getTimestamp().getTime());
	}

}

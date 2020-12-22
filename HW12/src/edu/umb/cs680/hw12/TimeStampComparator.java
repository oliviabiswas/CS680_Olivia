package edu.umb.cs680.hw12;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {

	public int compare(ApfsElement fsElement1, ApfsElement fsElement2) {
		return fsElement2.getModifiedDate().compareTo(fsElement1.getModifiedDate());
	}

}
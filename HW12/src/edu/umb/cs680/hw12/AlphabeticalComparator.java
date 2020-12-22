package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement fse1, ApfsElement fse2) {
		return fse1.getName().compareTo(fse2.getName());
	}
}
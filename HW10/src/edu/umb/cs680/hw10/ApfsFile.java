package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime modifiedTime) {
		super(parent, name, size, creationTime, ownerName, modifiedTime);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
	}

	public void accept(ApfsFSVisitor v) {
		v.visit(this);
	}

}
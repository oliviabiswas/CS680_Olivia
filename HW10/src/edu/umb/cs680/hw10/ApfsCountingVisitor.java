package edu.umb.cs680.hw10;

public class ApfsCountingVisitor implements ApfsFSVisitor {
	int directoryNum = 0;
	int fileNum = 0;
	int linkNum = 0;

	public void visit(ApfsDirectory directory) {
		directoryNum++;
	}

	public void visit(ApfsFile file) {
		fileNum++;
	}

	public void visit(ApfsLink link) {
		linkNum++;
	}

	public int getDirectoryNum() {
		return this.directoryNum;
	}

	public int getFileNum() {
		return this.fileNum;
	}

	public int getLinkNum() {
		return this.linkNum;
	}

}
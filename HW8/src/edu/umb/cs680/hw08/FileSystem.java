package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {

	private static FileSystem instance = null;
	private LinkedList<Directory> rootDirectories;
	public static FileSystem getFileSystem() {
		if(instance==null)
			instance = new FileSystem ();
		return instance;
	}
	private FileSystem() {};
	
	public LinkedList<Directory> getRootDirectories() {
		return this.rootDirectories;
	}
	
	
	public void appendRootDirectory(Directory rootDirectory) {
		rootDirectories = new LinkedList<Directory>();
		rootDirectories.add(rootDirectory);
	}
	
	public static void main(String[] args) {
		System.out.println("File System Main Class");
	}
}
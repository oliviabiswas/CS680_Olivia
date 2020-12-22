package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;

class DirectoryTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setFileStructure() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 1300, localTime);
		File b = new File(applications, "b", 350, localTime);
		File c = new File(home, "c", 500, localTime);
		File d = new File(home, "d", 700, localTime);
		Link x = new Link(home, "x", 0, localTime, applications);
		File e = new File(code, "e", 70, localTime);
		File f = new File(code, "f", 130, localTime);	
		Link y = new Link(code, "y", 0, localTime, b);
		
		//creation of files and adding root dir
		FileSystem.getFileSystem().appendRootDirectory(root);
		
	}
	
	private String[] fsElementToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), 
				Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, 
						Integer.toString(d.getTotalSize()),
						Integer.toString(d.countChildren())};
		return directorystring;
	}

	
	
	@Test
	void testDirectoryAndFiles() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("home", fileSystem.getRootDirectories().get(0).findDirByName("home").getName());
		assertSame("root", fileSystem.getRootDirectories().get(0).findDirByName("root").getName());
		assertSame("applications", fileSystem.getRootDirectories().get(0).findDirByName("applications").getName());
		assertSame("code", fileSystem.getRootDirectories().get(0).findDirByName("code").getName());
		assertSame("a", fileSystem.getRootDirectories().get(0).findFileByName("a").getName());
		assertSame("f", fileSystem.getRootDirectories().get(0).findFileByName("f").getName());
	} 
	
	@Test
	void testIfDirectoryOrNot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirectories().get(0).findDirByName("root").isDirectory());
		assertTrue(fileSystem.getRootDirectories().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirectories().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirectories().get(0).findDirByName("code").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("a").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("b").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("c").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("d").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("e").isDirectory());
		assertFalse(fileSystem.getRootDirectories().get(0).findFileByName("f").isDirectory());
	}
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = fileSystem.getRootDirectories().get(0).findDirByName("code");
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
	
	@Test
	void verifyDirectoryFileNumbers() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("a", fileSystem.getRootDirectories().get(0).findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", fileSystem.getRootDirectories().get(0).findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", fileSystem.getRootDirectories().get(0).findDirByName("home").getFiles().get(0).getName());
		assertSame("d", fileSystem.getRootDirectories().get(0).findDirByName("home").getFiles().get(1).getName());
		assertSame("e", fileSystem.getRootDirectories().get(0).findDirByName("code").getFiles().get(0).getName());
		assertSame("f", fileSystem.getRootDirectories().get(0).findDirByName("code").getFiles().get(1).getName());
	}
	@Test
	void verifyCodeSize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(200, fileSystem.getRootDirectories().get(0).findDirByName("code").getTotalSize());

		
	}
	@Test
	void testSubDirectories() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("applications", fileSystem.getRootDirectories().get(0).findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", fileSystem.getRootDirectories().get(0).findDirByName("root").getSubDirectories().get(1).getName());
		assertSame("code", fileSystem.getRootDirectories().get(0).findDirByName("home").getSubDirectories().get(0).getName());
	}
	
	@Test
	void testSubFilesAndFolderNumber() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(2, fileSystem.getRootDirectories().get(0).findDirByName("root").countChildren());
		assertEquals(2, fileSystem.getRootDirectories().get(0).findDirByName("applications").countChildren());
		assertEquals(3, fileSystem.getRootDirectories().get(0).findDirByName("home").countChildren());
		assertEquals(2, fileSystem.getRootDirectories().get(0).findDirByName("code").countChildren());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3050", "2" };
		Directory actual = fileSystem.getRootDirectories().get(0).findDirByName("root");
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
	@Test
	void verifyrootsize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirectories().get(0).findDirByName("root").getTotalSize());	
	}
	
	@Test
	public void verifyDirectoryEqualityHome() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
		Directory actual = fileSystem.getRootDirectories().get(0).findDirByName("home");
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
	
	@Test
	void verifyFolderSize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirectories().get(0).findDirByName("root").getTotalSize());
		assertEquals(200, fileSystem.getRootDirectories().get(0).findDirByName("code").getTotalSize());
		assertEquals(1650, fileSystem.getRootDirectories().get(0).findDirByName("applications").getTotalSize());
		assertEquals(1400, fileSystem.getRootDirectories().get(0).findDirByName("home").getTotalSize());
		
	}
	@Test
	public void verifyDirectoryEqualityApplications() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1650", "2" };
		Directory actual = fileSystem.getRootDirectories().get(0).findDirByName("applications");
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
}

package edu.umb.cs680.hw09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {

	private String[] apfsElementToArray(ApfsElement e) {
		String[] eInfo = { e.getName(), e.getOwnerName(), Integer.toString(e.getSize()) };
		return eInfo;
	}

	@Test
	public void APFSEqualityTest() {
		APFS APFS1 = APFS.getInstance();
		APFS APFS2 = APFS.getInstance();
		assertSame(APFS1, APFS2);
	}

	@Test
	public void TestToGetRootDir() {
		APFS APFS1 = APFS.getInstance();
		APFS1.initFileSystem("myapfs", 100);
		String[] actual = this.apfsElementToArray(APFS1.getRootDir());
		String[] expected = { "myapfs", "Admin", "0" };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void TestToCreateDefaultRoot() {
		APFS APFS1 = APFS.getInstance();
		String[] actual = this.apfsElementToArray(APFS1.getRootDir());
		String[] expected = { "myapfs", "Admin", "0" };
		assertArrayEquals(expected, actual);
	}

}
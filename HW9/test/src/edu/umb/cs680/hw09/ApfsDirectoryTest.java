package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApfsDirectoryTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, date2, "Admin", date2);
	static ApfsFile a = new ApfsFile(null, "a", 1, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(null, "b", 2, date2, "Admin", date2);
	static ApfsFile c = new ApfsFile(null, "c", 3, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(null, "d", 4, date2, "Admin", date2);
	static ApfsFile e = new ApfsFile(null, "e", 5, date2, "Admin", date2);
	static ApfsFile f = new ApfsFile(null, "f", 6, date2, "Admin", date2);
	static ApfsLink x = new ApfsLink(null, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(null, "y", 0, date2, null, "Admin", date2);

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isFile()), d.getName(), d.getCreationTime().toString(),
				String.valueOf(d.isDirectory()), Integer.toString(d.getTotalSize()),
				Integer.toString(d.countChildren()), d.getOwnerName(), d.getModifiedDate().toString() };
		return dirInfo;
	}

	@BeforeAll
	static void init() {
		root.appendChild(home);
		root.appendChild(applications);
		home.appendChild(code);
		applications.appendChild(a);
		applications.appendChild(b);
		home.appendChild(c);
		home.appendChild(d);
		code.appendChild(e);
		code.appendChild(f);
		home.appendChild(x);
		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}

	@Test
	public void checkEqualityOfDirectoryRoot() {
		String[] expected = { "false", "root", date1.toString(), "true", "21", "2", "Admin", date2.toString() };
		ApfsDirectory dir = root;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void CheckEqualityOfDirectoryHome() {
		String[] expected = { "false", "Home", date1.toString(), "true", "18", "4", "Admin", date2.toString() };
		ApfsDirectory dir = home;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void CheckEqualityOfDirectoryCode() {
		String[] expected = { "false", "Code", date2.toString(), "true", "11", "3", "Admin", date2.toString() };
		ApfsDirectory dir = code;
		String[] actual = dirToStringArray(dir);
		assertArrayEquals(expected, actual);
	}
}
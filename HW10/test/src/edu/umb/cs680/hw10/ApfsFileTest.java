package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApfsFileTest {

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

	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), f.getParent().getName(), String.valueOf(f.isDirectory()),
				d.getOwnerName(), d.getModifiedDate().toString() };
		return fileInfo;
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
	public void verifyEqualityOfFileA() {
		String[] expected = { "true", "a", "1", date1.toString(), "Applications", "false", "Admin", date2.toString() };
		ApfsFile file = a;
		String[] actual = fileToStringArray(file);
		System.out.println(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileB() {
		String[] expected = { "true", "b", "2", date2.toString(), "Applications", "false", "Admin", date2.toString() };
		ApfsFile file = b;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileC() {
		String[] expected = { "true", "c", "3", date1.toString(), "Home", "false", "Admin", date2.toString() };
		ApfsFile file = c;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileD() {
		String[] expected = { "true", "d", "4", date2.toString(), "Home", "false", "Admin", date2.toString() };
		ApfsFile file = d;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileE() {
		String[] expected = { "true", "e", "5", date2.toString(), "Code", "false", "Admin", date2.toString() };
		ApfsFile file = e;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyEqualityOfFileF() {
		String[] expected = { "true", "f", "6", date2.toString(), "Code", "false", "Admin", date2.toString() };
		ApfsFile file = f;
		String[] actual = fileToStringArray(file);
		assertArrayEquals(expected, actual);
	}
}
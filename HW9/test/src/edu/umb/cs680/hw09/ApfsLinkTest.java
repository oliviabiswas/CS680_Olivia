package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApfsLinkTest {

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

	@Order(1)
	@Test
	public void checkLinkTest() {
		Boolean actual = x.isLink();
		Boolean expected = true;
		assertSame(expected, actual);
	}

	@Order(2)
	@Test
	public void checkTargetSizeTest() {
		int actual = x.getTargetSize();
		int expected = 3;
		assertSame(expected, actual);
	}

	@Order(3)
	@Test
	public void checkTargetIsLinkTest() {
		Boolean actual = x.targetisLink();
		Boolean expected = false;
		assertSame(expected, actual);
	}

	@Order(4)
	@Test
	public void checkTargetIsFileTest() {
		Boolean actual = x.targetisFile();
		Boolean expected = false;
		assertSame(expected, actual);
	}

	@Order(5)
	@Test
	public void checkTargetIsDirectoryTest() {
		Boolean actual = x.targetisDirectory();
		Boolean expected = true;
		assertSame(expected, actual);
	}

	@Order(6)
	@Test
	public void testSetTarget() {
		x.setTarget(code);
		ApfsElement actual = x.getTarget();
		ApfsDirectory expected = code;
		assertSame(expected, actual);
	}

	@Order(7)
	@Test
	public void checkEqualityOfLinkX() {
		ApfsDirectory expected = code;
		ApfsElement actual = x.getTarget();
		assertSame(expected, actual);
	}

	@Order(8)
	@Test
	public void checkEqualityOfLinkY() {
		ApfsFile expected = b;
		ApfsElement actual = y.getTarget();
		assertSame(expected, actual);
	}
}
package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class ApfsFileSearchVisitorTest {
	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	static ApfsDirectory home = new ApfsDirectory(root, "Home", 0, date1, "Admin", date2);
	static ApfsDirectory applications = new ApfsDirectory(root, "Applications", 0, date1, "Admin", date2);
	static ApfsDirectory code = new ApfsDirectory(root, "Code", 0, date2, "Admin", date2);
	static ApfsFile a = new ApfsFile(applications, "a", 1, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(applications, "b", 2, date2, "Admin", date2);
	static ApfsFile c = new ApfsFile(home, "c", 3, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(home, "d", 4, date2, "Admin", date2);
	static ApfsFile e = new ApfsFile(code, "e", 5, date2, "Admin", date2);
	static ApfsFile f = new ApfsFile(code, "f", 6, date2, "Admin", date2);
	static ApfsLink x = new ApfsLink(home, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(code, "y", 0, date2, null, "Admin", date2);

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
	public void fileSearchATest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		ApfsFile[] expected = { a };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void fileSearchBTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		ApfsFile[] expected = { b };
		assertArrayEquals(expected, actual);
	}
}
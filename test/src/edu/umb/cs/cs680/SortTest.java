package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class SortTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void SORTElementsOfRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Sort s1 = new Sort();
		s1.execute();
		Ls ls1 = new Ls();
		ls1.execute();
		//System.out.print("root\n");
		assertEquals("a\nhome\nsystem\n", outContent.toString());
	}
	
	
}

package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PwdTest {
	
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
	public void PWDPrintCurrentDirectoryRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory A = new Directory(null, "root", "owner1D");
		f1.setRoot(A);
		Pwd p1 = new Pwd();
		p1.execute();
		//System.out.print("root\n");
		assertEquals("root\n", outContent.toString());
	}

}

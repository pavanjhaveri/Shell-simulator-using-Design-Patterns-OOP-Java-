package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class RedoTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	static CommandHistory cHis = new CommandHistory();

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
	public void REDO_PWDPrintCurrentDirectoryRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory A = new Directory(null, "root", "owner1D");
		f1.setRoot(A);
		Pwd p1 = new Pwd();
		p1.execute();
		cHis.push(p1);
		cHis.pop().execute();
		//System.out.print("root\n");
		assertEquals("root\nroot\n", outContent.toString());
	}

	
	
}

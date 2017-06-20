package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class HistoryTest {
	
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
	public void History_PWD_LS() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Pwd p1 = new Pwd();
		p1.execute();
		cHis.push(p1);
		Ls ls1 = new Ls();
		ls1.execute();
		cHis.push(ls1);
		cHis.History();
		//System.out.print("root\n");
		assertEquals("root\na\nLs\nPwd\n", outContent.toString());
	}

	
	
}

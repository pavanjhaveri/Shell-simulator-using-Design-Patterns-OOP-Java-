package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CdTest {
	
	
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
	public void CDHome() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Cd mkdir1 = new Cd("home");
		mkdir1.execute();
		Pwd p1 = new Pwd();
		p1.execute();
		//System.out.print("root\n");
		assertEquals("home\n", outContent.toString());
	}
	
	@Test
	public void CDDotDot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Cd mkdir1 = new Cd("home");
		mkdir1.execute();
		Cd mkdir2 = new Cd("..");
		mkdir2.execute();
		Pwd p1 = new Pwd();
		p1.execute();
		//System.out.print("root\n");
		assertEquals("root\n", outContent.toString());
	}
	
	@Test
	public void CD_ToRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Cd mkdir1 = new Cd("home");
		mkdir1.execute();
		Cd mkdir2 = new Cd(null);
		mkdir2.execute();
		Pwd p1 = new Pwd();
		p1.execute();
		//System.out.print("root\n");
		assertEquals("root\n", outContent.toString());
	}

}

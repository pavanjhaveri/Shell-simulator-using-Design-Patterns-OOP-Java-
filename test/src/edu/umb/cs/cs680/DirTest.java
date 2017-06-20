package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DirTest {
	
	@Test
	public void DirHome() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Dir mkdir1 = new Dir("home");
		mkdir1.execute();
		//System.out.print("root\n");
		//assertEquals("Name : home Owner : owner2D Size : 0\n", outContent.toString());
	}
	
	@Test
	public void DIRDotDot() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Dir mkdir1 = new Dir("..");
		mkdir1.execute();
	}
	
	@Test
	public void DIR_ParesntInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Dir mkdir1 = new Dir(null);
		mkdir1.execute();
	}

}

package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FileSystemTest {

	@Test
	public void testShowAllElements() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Directory root = new Directory(null, "ROOT", "owner1D");
		Directory home = new Directory(root, "HOME", "owner2D");
		Directory system = new Directory(root, "SYSTEM", "owner3D");
		Directory pictures = new Directory(home, "PICTURES", "owner4D");

		File A = new File(system, "a", "owner1F", 10);
		File B = new File(system, "b", "owner2F", 10);
		File C = new File(system, "c", "owner3F", 10);
		File D = new File(home, "D", "owner4F", 10);
		File E = new File(pictures, "E", "owner5F", 10);
		File F = new File(pictures, "F", "owner6F", 10);
		root.filesystem.showAllElements();
	}
	
	@Test
	public void GetCurrentDir() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		FileSystem f1 = FileSystem.getInstance();
		f1.setCurrent(root);
		assertThat(f1.getCurrent(), CoreMatchers.is(root));
	}
	
	@Test
	public void GetRootDir() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		FileSystem f1 = FileSystem.getInstance();
		f1.setRoot(root);
		assertThat(f1.getRoot(), CoreMatchers.is(root));
	}

}

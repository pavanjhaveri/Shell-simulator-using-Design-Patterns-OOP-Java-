package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CpTest {

	@Test
	public void CPHomeToSystemNotRemovedFromRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Cp mkdir1 = new Cp("home", "system");
		mkdir1.execute();
		//System.out.print("root\n");
		assertThat(root.getChildren().size(), CoreMatchers.is(3));
	}
	
	@Test
	public void CPHomeToSystemAddedToSystem() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Cp mkdir1 = new Cp("home", "system");
		mkdir1.execute();
		//System.out.print("root\n");
		assertThat(system.getChildren().size(), CoreMatchers.is(1));
	}

}

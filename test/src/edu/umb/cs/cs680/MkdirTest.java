package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MkdirTest {

	@Test
	public void MKDIRHomeInRoot() {
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		File A = new File(root, "a", "owner1F", 10);
		f1.setRoot(root);
		Mkdir mkdir1 = new Mkdir("home");
		mkdir1.execute();
		//System.out.print("root\n");
		assertThat(root.getChildren().size(), CoreMatchers.is(2));
	}

}

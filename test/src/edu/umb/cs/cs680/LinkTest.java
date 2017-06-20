package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class LinkTest {
	Directory root = new Directory(null, "ROOT" , "owner1D");
	Directory home = new Directory(root, "HOME" , "owner2D");
	Directory system = new Directory(root, "SYSTEM" , "owner3D");
	
	@Test
	public void linkGetSize() {
		Link A = new Link(home, system);
		assertThat(A.getTargetSize(), CoreMatchers.is(0));
	}

	@Test
	public void linkGetParent() {
		Link A = new Link(home, system);
		assertThat(A.getParent(), CoreMatchers.is(home));
	}
	
}

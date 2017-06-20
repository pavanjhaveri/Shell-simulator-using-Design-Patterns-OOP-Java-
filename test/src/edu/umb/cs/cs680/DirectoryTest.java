package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class DirectoryTest {

	@Test
	public void DirectoryGetSize() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		assertThat(A.getSize(), CoreMatchers.is(0));
	}


	@Test
	public void getRootsize() {
		Directory root = new Directory(null, "ROOT" , "owner1D");
		Directory home = new Directory(root, "HOME" , "owner2D");
		Directory system = new Directory(root, "SYSTEM" , "owner3D");
		Directory pictures = new Directory(home, "PICTURES" , "owner4D");
		
		File A = new File(system, "a", "owner1F", 10);
		File B = new File(system, "b", "owner2F", 10);
		File C = new File(system, "c", "owner3F", 10);
		File D = new File(home, "D", "owner4F", 10);
		File E = new File(pictures, "E", "owner5F", 10);
		File F = new File(pictures, "F", "owner6F", 10);
		assertThat(root.getSize(), CoreMatchers.is(60));
		
	}

	@Test
	public void DirectoryGetName() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		assertThat(A.getName(), CoreMatchers.is("ROOT"));
	}
	
	@Test
	public void DirectoryGetOwner() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		assertThat(A.getOwner(), CoreMatchers.is("owner1D"));
	}
	
	@Test
	public void DirectoryGetParent() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		Directory B = new Directory(A, "HOME" , "owner2D");
		assertThat(B.getParent(), CoreMatchers.is(A));
	}
	
	@Test
	public void DirectoryGetFileFalse() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		assertThat(A.isFile(), CoreMatchers.is(false));
	}
	
	


}

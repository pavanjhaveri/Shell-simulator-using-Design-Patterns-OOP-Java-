package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FileTest {

	@Test
	public void fileGetSize() {
		File A = new File(null, "a", "owner1F", 10);
		assertThat(A.getSize(), CoreMatchers.is(10));
	}

	@Test
	public void FileGetName() {
		File A = new File(null, "a", "owner1F", 10);
		assertThat(A.getName(), CoreMatchers.is("a"));
	}
	
	@Test
	public void FileGetOwner() {
		File A = new File(null, "a", "owner1F", 10);
		assertThat(A.getOwner(), CoreMatchers.is("owner1F"));
	}
	
	@Test
	public void FileGetParent() {
		Directory A = new Directory(null, "ROOT", "owner1D");
		File A1 = new File(A, "a", "owner1F", 10);
		assertThat(A1.getParent(), CoreMatchers.is(A));
	}
	
	@Test
	public void FileGetFileTrue() {
		File A = new File(null, "a", "owner1F", 10);
		assertThat(A.isFile(), CoreMatchers.is(true));
	}
	
	
}

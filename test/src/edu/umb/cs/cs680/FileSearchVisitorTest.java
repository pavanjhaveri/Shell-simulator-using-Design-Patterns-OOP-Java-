package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FileSearchVisitorTest {

	@Test
	public void GetFileJPEG() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		File A = new File(root, "A.txt", "owner1F", 10);
		File B = new File(root, "B.jpeg", "owner2F", 10);
		FileSearchVisitor visitor = new FileSearchVisitor(".jpeg");
		root.accept( visitor );
		assertThat(visitor.getFoundFiles().size(), CoreMatchers.is(1));

	}
	
	@Test
	public void GetFileTXT() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		File A = new File(root, "A.txt", "owner1F", 10);
		File B = new File(root, "B.jpeg", "owner2F", 10);
		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		root.accept( visitor );
		assertThat(visitor.getFoundFiles().size(), CoreMatchers.is(1));

	}
}

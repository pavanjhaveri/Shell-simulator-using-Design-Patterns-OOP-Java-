package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class CountingVisitorTest {

	@Test
	public void Count2Directories() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		Directory home = new Directory(root, "HOME", "owner2D");
		CountingVisitor visitor = new CountingVisitor();
		root.accept( visitor );
		assertThat(visitor.getDirNum(), CoreMatchers.is(2));

	}

	@Test
	public void Count2Files() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		File A = new File(root, "A.txt", "owner1F", 10);
		File B = new File(root, "B.jpeg", "owner2F", 10);
		CountingVisitor visitor = new CountingVisitor();
		root.accept( visitor );
		assertThat(visitor.getFileNum(), CoreMatchers.is(2));
	}
	
	@Test
	public void Count1Link() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		Directory home = new Directory(root, "HOME", "owner2D");
		Directory system = new Directory(root, "SYSTEM", "owner3D");
		Link X = new Link(home, system);
		CountingVisitor visitor = new CountingVisitor();
		root.accept( visitor );
		assertThat(visitor.getLinkNum(), CoreMatchers.is(1));
		
	}

}

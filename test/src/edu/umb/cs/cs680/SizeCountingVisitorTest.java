package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class SizeCountingVisitorTest {

	@Test
	public void GetTotalSize3Directories2Files1link() {
		Directory root = new Directory(null, "ROOT", "owner1D");
		File A = new File(root, "A.txt", "owner1F", 10);
		File B = new File(root, "B.jpeg", "owner2F", 10);
		Directory home = new Directory(root, "HOME", "owner2D");
		Directory system = new Directory(root, "SYSTEM", "owner3D");
		Link X = new Link(home, system);
		SizeCountingVisitor visitor = new SizeCountingVisitor();
		root.accept( visitor );
		assertThat(visitor.getTotalSize(), CoreMatchers.is(20));

	}

}

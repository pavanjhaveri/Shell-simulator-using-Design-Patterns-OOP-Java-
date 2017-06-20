package edu.umb.cs.cs680;

public class SizeCountingVisitor implements FSVisitor {
	private int totalSize = 0;


	public void visit(Link link) {
		totalSize = totalSize + link.getDiskUtil();
	}

	public void visit(Directory dir) {
		totalSize = totalSize + dir.getDiskUtil();
	}

	public void visit(File file) {
		totalSize = totalSize + file.getDiskUtil();
	}

	public int getTotalSize() {
		return totalSize;
	}

}

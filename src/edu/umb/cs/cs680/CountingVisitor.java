package edu.umb.cs.cs680;

public class CountingVisitor implements FSVisitor {
	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	public void visit(Link link) {
		linkNum++;
	}

	public void visit(Directory dir) {
		dirNum++;

	}

	public void visit(File file) {
		fileNum++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}
	
	

}

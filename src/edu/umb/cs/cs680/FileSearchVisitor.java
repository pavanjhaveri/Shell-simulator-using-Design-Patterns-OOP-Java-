package edu.umb.cs.cs680;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor {
	private String extension;
	private ArrayList<File> foundFiles = new ArrayList<File>();
	
	

	public FileSearchVisitor(String extension) {
		this.extension = extension;
	}

	public void visit(Link link) {
		return;
	}

	public void visit(Directory dir) {
		return;

	}

	public void visit(File file) {
		if(file.getName().contains(extension)){
			foundFiles.add(file);
		}
	}

	public 	ArrayList<File> getFoundFiles() {
		return foundFiles;
	}



}

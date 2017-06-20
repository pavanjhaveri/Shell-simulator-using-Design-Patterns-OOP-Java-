package edu.umb.cs.cs680;

import java.util.ArrayList;


public class Directory extends FSElement {

	public ArrayList<FSElement> children = new ArrayList<FSElement>();
	FileSystem filesystem = FileSystem.getInstance();
	
	public Directory(Directory root, String name, String owner) {
		super(root);
		this.setName(name);
		this.setOwner(owner);
		this.setSize(0);
		this.filesystem.rootDir = this;	
		this.filesystem.currentDir = this;
	}
	

	public ArrayList<FSElement> getChildren() {
		return children;
	}
	
	public void setChildren(ArrayList<FSElement> children) {
		this.children = children;
	}
	
	public void appendChildren(FSElement fs) {
		this.children.add(fs);
	}
	
	public int getSize(){
		int size123 = 0;
		
		for(FSElement f : children)
		{
		size123 = size123 + f.getSize();
		}
	
	return size123;
	}

	@Override
	public void accept(FSVisitor v) {
		v.visit(this);

		for(FSElement e: children){

		e.accept(v);

		}
		
	}

	@Override
	public int getDiskUtil() {
		return 0;
	}
}

package edu.umb.cs.cs680;



public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size) {
		super(parent);
		this.setName(name);
		this.setOwner(owner);
		this.setSize(size);
		// TODO Auto-generated constructor stub
	}

	public int getSize(){
		return this.size;
	}
	
	@Override
	public void accept(FSVisitor v) {
		v.visit(this);
		
	}

	@Override
	public int getDiskUtil() {
		return this.size;
	}
}

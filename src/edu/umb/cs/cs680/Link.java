package edu.umb.cs.cs680;

import java.util.ArrayList;

public class Link extends FSElement{

	public ArrayList<FSElement> linkChildren = new ArrayList<FSElement>();
	public Link(Directory parent, FSElement fs1) {
		super(parent);
		//parent.appendChildren(fs1);
		appendChildren(fs1);
	}

	public void appendChildren(FSElement fs) {
		linkChildren.add(fs);
	}
	
	public int getSize(){
		return 0;
	}
	
	
	public int getTargetSize(){
		int size123 = this.getSize();
		
		for(FSElement f : linkChildren)
		{
		size123 = size123 + f.getSize();
		}
	
	return size123;
	}
	
	@Override
	public void accept(FSVisitor v) {
		v.visit(this);
		
	}

	@Override
	public int getDiskUtil() {
		return 0;
	}
}

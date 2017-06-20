package edu.umb.cs.cs680;

import java.util.Date;

public abstract class FSElement {
	
	private String Name;
	private String owner;
	private Date created;
	private Date lastModified;

	 int size;
	Directory parent;
	
	
	public FSElement(Directory parent) {
		super();
		this.parent = parent;
		if(parent!=null){
			parent.appendChildren(this);
		}
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isFile() {
		if(this.getClass().getName() == "edu.umb.cs.cs680.Directory"){
			return false;
		}else{
			return true;
		}
	}
	
	public int getSize(){
	
	return -1;
		
	}

	public Directory getParent() {
		return parent;
	}

	
	public void accept(FSVisitor v){};
	public int getDiskUtil(){
		return 0;
	}
	

}

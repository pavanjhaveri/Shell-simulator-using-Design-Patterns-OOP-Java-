package edu.umb.cs.cs680;

public class Mkdir implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;

	public Mkdir(String d) {

		this.d = d;
	}

	public void execute() {
	
		Directory dir1 = new Directory(f1.getCurrent(), d, f1.getCurrent().getOwner());
		
		f1.setCurrent(dir1.getParent());
		f1.sort(f1.getCurrent());
		//System.out.println(dir1.getName() + dir1.getOwner());
		//f1.addChild(f1.getCurrent(), dir1);
		//f1.getCurrent().appendChildren(dir1);
		
		}

	}



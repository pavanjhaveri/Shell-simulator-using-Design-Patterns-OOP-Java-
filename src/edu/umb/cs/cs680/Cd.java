package edu.umb.cs.cs680;

public class Cd implements Command{

	FileSystem f1 = FileSystem.getInstance();
	private String dir;

	public Cd(String dir) {
		this.dir = dir;
	}

	public void execute() {
		//System.out.println(dir == null);
		if(this.dir == null || this.dir.equals("")){
			f1.setCurrent(f1.getRoot());
			//System.out.println("No such directory");
		}else if(this.dir.equals("..")){
			f1.setCurrent(f1.getCurrent().getParent());
		}else if(getDirectory() !=null){
			f1.setCurrent(getDirectory());
		}else{
			System.out.println("No such directory");
		}
	}
	
	public Directory getDirectory() {
		for(FSElement f : f1.currentDir.getChildren())
		{
		if(f.getName().equals(this.dir)){
			return (Directory)f;
		}
		}
		return null;
	}

}

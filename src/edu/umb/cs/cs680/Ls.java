package edu.umb.cs.cs680;

public class Ls implements Command{

	FileSystem f1 = FileSystem.getInstance();

	public void execute() {
		if(f1.currentDir.getChildren().size() == 0){
			System.out.print("No children" + "\n");
		}else{		
			for(FSElement f : f1.currentDir.getChildren())
			{
			System.out.print(f.getName() + "\n");
			}
		}
		
	}

}

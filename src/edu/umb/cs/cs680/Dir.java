package edu.umb.cs.cs680;

public class Dir implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;

	public Dir(String d) {

		this.d = d;
	}

	public void execute() {
		if(this.d == null || this.d.equals("")){
			if (f1.currentDir.getChildren().size() == 0) {
				System.out.println("No children");
			} else {
				for (FSElement f : f1.currentDir.getChildren()) {
					System.out.print("Name : " + f.getName() + " Owner : " + f.getOwner() + " Size : " + f.getSize() + "\n");
				}
			}
		}else if(this.d.equals("..")){
			System.out.print("Name : " + f1.getCurrent().getName() + " Owner : " + f1.getCurrent().getOwner() + " Size : 0" + "\n");
		}else{
			if (f1.currentDir.getChildren().size() == 0) {
				System.out.println("No children");
			} else {
				for (FSElement f : f1.currentDir.getChildren()) {
					if(this.d.equals(f.getName())){
						System.out.println("Name : " + f.getName() + " Owner : " + f.getOwner() + " Size : " + f.getSize());
					}
					
					
				}
			}
		}

		
		}

	}



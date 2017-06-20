package edu.umb.cs.cs680;

public class Ln implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;
	private String d1;

	public Ln(String d, String d1) {

		this.d = d;
		this.d1 = d1;
	}

	public void execute() {
	
		FSElement fab = null;
		FSElement fab2 = null;
		for (int i = 0; i < f1.getCurrent().getChildren().size(); i++) {
			if (this.d.equals(f1.getCurrent().getChildren().get(i).getName())) {
				fab = f1.getCurrent().getChildren().get(i);
				//f1.getCurrent().getChildren().remove(i);
			}
		}
		
		for (int i = 0; i < f1.getCurrent().getChildren().size(); i++) {
			if (this.d1.equals(f1.getCurrent().getChildren().get(i).getName())) {
				fab2 = f1.getCurrent().getChildren().get(i);
				System.out.println(fab2.getName());
				//f1.setCurrent((Directory)f1.getCurrent().getChildren().get(i));				
			}
		}
		
		Link l1 = new Link ((Directory)fab, fab2);
		
		
		//f1.getCurrent().appendChildren(fab);
		//f1.setCurrent(f1.getCurrent().getParent());
		}

	}



package edu.umb.cs.cs680;

public class Mv implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;
	private String d1;

	public Mv(String d, String d1) {

		this.d = d;
		this.d1 = d1;
	}

	public void execute() {
	
		FSElement fab = null;
		for (int i = 0; i < f1.getCurrent().getChildren().size(); i++) {
			if (this.d.equals(f1.getCurrent().getChildren().get(i).getName())) {
				fab = f1.getCurrent().getChildren().get(i);
				f1.getCurrent().getChildren().remove(i);
			}
		}
		
		for (int i = 0; i < f1.getCurrent().getChildren().size(); i++) {
			if (this.d1.equals(f1.getCurrent().getChildren().get(i).getName())) {
				f1.setCurrent((Directory)f1.getCurrent().getChildren().get(i));				
			}
		}
		
		f1.getCurrent().appendChildren(fab);
		f1.setCurrent(f1.getCurrent().getParent());
		}

	}



package edu.umb.cs.cs680;

public class Rmdir implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;

	public Rmdir(String d) {

		this.d = d;
	}

	public void execute() {
		if (f1.currentDir.getChildren().size() == 0) {
			System.out.println("No children");
		} else {
			for (int i = 0; i < f1.getCurrent().getChildren().size(); i++) {
				if (this.d.equals(f1.getCurrent().getChildren().get(i).getName())) {
					f1.getCurrent().getChildren().remove(i);
				}
			}
		}

	}

}

package edu.umb.cs.cs680;

public class Chown implements Command {

	FileSystem f1 = FileSystem.getInstance();
	private String d;

	public Chown(String d) {

		this.d = d;
	}

	public void execute() {
		f1.getCurrent().setOwner(d);

	}

}

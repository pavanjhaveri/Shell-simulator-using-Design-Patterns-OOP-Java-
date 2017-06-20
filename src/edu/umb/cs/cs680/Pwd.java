package edu.umb.cs.cs680;

public class Pwd implements Command {

	FileSystem f1 = FileSystem.getInstance();
	@Override
	public void execute() {
		System.out.print(f1.getCurrent().getName() + "\n");

	}

}

package edu.umb.cs.cs680;

public class Sort implements Command {

	FileSystem f1 = FileSystem.getInstance();
	@Override
	public void execute() {
		f1.sort(f1.getCurrent());

	}

}

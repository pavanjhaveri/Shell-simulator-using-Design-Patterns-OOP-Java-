package edu.umb.cs.cs680;

import java.util.Stack;

public class CommandHistory {

	Stack<Command> s1 = new Stack<Command>();
	
	public void push(Command c1) {
		s1.push(c1);
	}

	public Command pop() {
		return s1.pop();
		
	}
	
	public void History(){
		int temp = s1.size();
		for(int j=0; j<temp; j++){
			System.out.print(s1.pop().getClass().getSimpleName() + "\n");	
		}
		 
	}
}

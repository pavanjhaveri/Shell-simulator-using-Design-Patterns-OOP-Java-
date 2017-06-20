package edu.umb.cs.cs680;

import java.util.ArrayList;
import java.util.Collections;

public class FileSystem {

	private FileSystem() {};
	Directory rootDir;
	Directory currentDir;

	private static FileSystem instance = null;

	public static FileSystem getInstance() { // factory method

		if (instance == null)

			instance = new FileSystem();

		return instance;

	}
	
	public void showAllElements(){
		rootDir = this.rootDir.getParent().getParent();
		System.out.println(this.rootDir.getName());
		System.out.println("+++");
		dummy(rootDir);		
	}
	
	public void dummy(Directory rootDir1){
		for(FSElement f: rootDir1.children)
		{
			if(f.isFile())
			{
				System.out.println(f.getName());
			}else{
				System.out.println(f.getName());
				System.out.println("+++");
				Directory dir = (Directory)f;
				dummy(dir);
				System.out.println("---");
			}
		}
	}
	
	public Directory getCurrent(){
		return this.currentDir;
	
	}
	
	public void setCurrent(Directory current){
		//System.out.println("Hi");
		this.currentDir = current;
	
	}
	
	public void setRoot(Directory root1){
		this.currentDir = root1;
		this.rootDir = root1;
	
	}
	
	public Directory getRoot(){
		return rootDir;
	
	}
	
	public void addChild(Directory current, FSElement child){
		current.appendChildren(child);
	
	}
	
	public ArrayList<FSElement> sort(Directory dir){
		Collections.sort(dir.getChildren(), new AlphabeticalComparator());
		return dir.getChildren();
	}
	
}

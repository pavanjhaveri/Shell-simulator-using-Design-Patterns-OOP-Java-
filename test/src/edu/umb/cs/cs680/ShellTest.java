package edu.umb.cs.cs680;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ShellTest {

	@Test
	public void testUserClient() {
		ArrayList<Command> cmd = new ArrayList<>();
		CommandHistory cHis = new CommandHistory();
		FileSystem f1 = FileSystem.getInstance();
		Directory root = new Directory(null, "root", "owner1D");
		Directory system = new Directory(root, "system", "owner3D");
		Directory home = new Directory(root, "home", "owner2D");
	
		Directory pictures = new Directory(home, "PICTURES", "owner4D");
		File A = new File(system, "a", "owner1F", 10);
		File B = new File(system, "b", "owner2F", 10);
		File C = new File(system, "c", "owner3F", 10);
		File D = new File(home, "D", "owner4F", 10);
		File E = new File(pictures, "E", "owner5F", 10);
		File F = new File(pictures, "F", "owner6F", 10);
		Link X = new Link(home, system);
		Link Y = new Link(pictures, E);
		f1.setRoot(root);
		System.out.println("A small demo of SHELL ----------> (Can try for any commands)");
		CountingVisitor visitor = new CountingVisitor();
		SizeCountingVisitor visitorS = new SizeCountingVisitor();
		int i=0;
		String abc [] = {"pwd","cd system","pwd","cd ..","pwd", "cd home","pwd", "chown pavan" , "cd","dir home","visitor", "mkdir pavan" ,"ls", "rmdir pavan","sort", "ls","history"};
		while (i<abc.length) {
			System.out.print("> ");
			System.out.println(abc[i]);
			//Scanner input = new Scanner(System.in);
			// int choice = input.nextInt();
			//String abc = input.nextLine();
			String def[] = abc[i].split(" ");
			// System.out.println(def[0]);
			switch (def[0]) {
			case "pwd":
				// System.out.println(f1.getCurrent().getName());
				Pwd p1 = new Pwd();
				p1.execute();
				cHis.push(p1);
				break;
			case "cd":
				Cd c;
				if (def.length == 1) {
					c = new Cd(null);
				} else {
					c = new Cd(def[1]);
				}
				c.execute();
				cHis.push(c);
				break;
			case "ls":
				Ls l = new Ls();
				l.execute();
				cHis.push(l);
				break;
			case "dir":
				Dir dir1;
				if (def.length == 1) {
					dir1 = new Dir(null);
				} else {
					dir1 = new Dir(def[1]);
				}
				//Dir dir1 = new Dir(def[1]);
				dir1.execute();
				cHis.push(dir1);
				break;
			case "mkdir":
				Mkdir mkdir1 = new Mkdir(def[1]);
				mkdir1.execute();
				cHis.push(mkdir1);
				break;
			case "rmdir":
				Rmdir rmdir1 = new Rmdir(def[1]);
				rmdir1.execute();
				cHis.push(rmdir1);
				break;
			case "chown":
				Chown chown1 = new Chown(def[1]);
				chown1.execute();
				cHis.push(chown1);
				break;
			case "mv":
				Mv mv1 = new Mv(def[1], def[2]);
				mv1.execute();
				cHis.push(mv1);
				break;
			case "cp":
				Cp cp1 = new Cp(def[1], def[2]);
				cp1.execute();
				cHis.push(cp1);
				break;
			case "ln":
				Ln ln1 = new Ln(def[1], def[2]);
				ln1.execute();
				cHis.push(ln1);
				break;
			case "sort":
				Sort s1 = new Sort();
				s1.execute();
				cHis.push(s1);
				break;
			case "redo":
				cHis.pop().execute();
				;
				break;
			case "history":
				cHis.History();
				break;
			case "visitor":
				root.accept(visitor);
				System.out.println("No. of Directory = " + visitor.getDirNum() + " No. of File =  "
						+ visitor.getFileNum() + " No. of Link = " + visitor.getLinkNum());
				root.accept(visitorS);
				System.out.println("Total size == " + visitorS.getTotalSize());
				System.out.println("Enter the file you wanna search : ");
				//Scanner input9 = new Scanner(System.in);
				String choice14 = "a";
				FileSearchVisitor visitorF = new FileSearchVisitor(choice14);
				root.accept(visitorF);
				System.out.println(visitorF.getFoundFiles().size() + " file/s found");
				break;
			case "exit":
				System.exit(0);
			}
			i++;
		}
	}

}

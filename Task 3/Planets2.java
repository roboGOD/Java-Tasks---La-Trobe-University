import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Planets2 {

	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter file name: ");
			String filename = sc.nextLine();

			RandomAccessFile f = new RandomAccessFile(filename, "r");
			// checks if this file is empty
			if(f.read() == -1)
				System.out.println("This file is empty.");
			else {
				// If the file is not empty, then the user is presented with a menu, as shown below:
				// Main Menu
				// 1. Show Planet Connections
				// 2. Exit
				// Enter choice >>
				boolean flag = true;
				String sname = null;
				String shr = null;
				ArrayList<String> outputs = new ArrayList<String>();
				
				while(flag) {
					f.seek(0);
					outputs.clear();

					int choice;
					System.out.print("Main Menu\n1. Show Planet Connections\n2. Exit\nEnter choice >> ");
					choice = Integer.parseInt(sc.nextLine());
					
					switch(choice) {
						case 1:
						System.out.print("Enter the name of the star: ");
						sname = sc.nextLine();
						
						String s;
						while((s=f.readLine()) != null) {
							String sarr[] = s.split(";");
							if(sarr[0].equalsIgnoreCase(sname)) {
								outputs.add(sarr[2]+"\t"+sarr[3]);
								shr = sarr[1];
							}
							else if(sarr[2].equalsIgnoreCase(sname)) {
								outputs.add(sarr[0]+"\t"+sarr[1]);
								shr = sarr[3];
							}
						}
						if(outputs.size() == 0) {
							System.out.println("\nNo match found for "+sname+"\n");
						}
						else {
							System.out.println("\nMatches for "+sname+" ("+shr+") are:");
							for(String name : outputs)
								System.out.println(name);
							System.out.println();
						}
						break;

						case 2:
						flag = false;
						break;

						default:
						System.out.println("The option entered is incorrect.");
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
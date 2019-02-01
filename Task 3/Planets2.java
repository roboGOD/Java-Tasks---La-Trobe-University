import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Planets2 {

	static String readLine(FileReader f) throws IOException {
		String s = "";
		int i=f.read();
		if(i == -1) 
			return null;
		while(i != -1 && (char)i != '\n') {
			s += String.valueOf((char)i);
			i = f.read();
		}
		return s;
	}

	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter file name: ");
			String filename = sc.nextLine();

			FileReader f = new FileReader(filename);
			// checks if this file is empty
			if(f.read() == -1)
				System.out.println("This file is empty.");
			else {
				// If the file is not empty, then the user is presented with a menu, as shown below:
				// Main Menu
				// 1. Show Planet Connections
				// 2. Exit
				// Enter choice >>
				f.close();
				boolean flag = true;
				String sname = null;
				String shr = null;
				ArrayList<String> outputs = new ArrayList<String>();
				
				while(flag) {
					f = new FileReader(filename); // Move the pointer at the begining of the file
					outputs.clear(); // Empty the ArrayList

					int choice;
					System.out.print("Main Menu\n1. Show Planet Connections\n2. Exit\nEnter choice >> ");
					choice = Integer.parseInt(sc.nextLine());
					
					switch(choice) {
						case 1: // Show planet connections
						System.out.print("Enter the name of the star: ");
						sname = sc.nextLine(); // Name of the star
						
						String s;
						while((s=readLine(f)) != null) { // Keep reading file line by line
							String sarr[] = new String[4];
							int k = 0;
							String temp="";
							for(int i=0; i<s.length(); i++) {
								if(s.charAt(i) != ';') {
									temp += String.valueOf(s.charAt(i));
								}
								else {
									sarr[k] = temp;
									temp = "";
									k++;
								}
							}
							sarr[k] = temp;
							if(sarr[0].equalsIgnoreCase(sname)) { // Check if the first star name matches with the given one
								outputs.add(sarr[2]+"\t"+sarr[3]); // Add to output list
								shr = sarr[1];
							}
							else if(sarr[2].equalsIgnoreCase(sname)) { // Check if the second star name matches with the given one
								outputs.add(sarr[0]+"\t"+sarr[1]); // Add to output list
								shr = sarr[3];
							}
						}

						// If no match found, output list size will be 0
						if(outputs.size() == 0) {
							System.out.println("\nNo match found for "+sname+"\n");
						}
						else { // Else print all the outputs
							System.out.println("\nMatches for "+sname+" ("+shr+") are:");
							for(String name : outputs)
								System.out.println("\t"+name);
							System.out.println();
						}
						break;

						case 2: // Exit
						flag = false;
						System.out.println("Closing...");
						break;

						default: // Invalid option
						System.out.println("The option entered is incorrect.");
					}
					f.close();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
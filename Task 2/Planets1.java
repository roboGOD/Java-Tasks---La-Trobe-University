import java.util.Scanner;
import java.io.*;


class Planets1 {

	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);

			// Get filename and open the file.
			System.out.print("Enter file name: ");
			String filename = sc.nextLine();

			FileReader ff = new FileReader(filename);
			BufferedReader f = new BufferedReader(ff);
			
			// Get HR Code
			System.out.print("Enter HR Code: ");
			String code = sc.nextLine();

			String s;
			boolean notFound = true;
			while((s=f.readLine())!=null) { // Read the file line by line.
				String sarr[] = s.split(";"); // Split the line by ';'
				if(sarr[2].equalsIgnoreCase(code)) { // Check if HR Code matches with the given one.
					notFound = false;
					System.out.println("\""+sarr[2]+"\""+" is "+sarr[0]+" also known as "+sarr[1]+"."); // print the match
					break;
				}
			}
			if(notFound) // If no match found
				System.out.println("No match found for HR code "+"\""+code+"\"");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
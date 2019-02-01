import java.util.Scanner;
import java.io.*;


class Planets1 {

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

			// Get filename and open the file.
			System.out.print("Enter file name: ");
			String filename = sc.nextLine();

			FileReader f = new FileReader(filename);
			
			// Get HR Code
			System.out.print("Enter HR Code: ");
			String code = sc.nextLine();

			String s;
			boolean notFound = true;
	
			while((s=readLine(f))!=null) { // Read the file line by line.
				String sarr[] = new String[3];
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
import java.util.Scanner;
import java.io.*;


class Planets1 {

	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter file name: ");
			String filename = sc.nextLine();

			FileReader ff = new FileReader(filename);
			BufferedReader f = new BufferedReader(ff);
			
			System.out.print("Enter HR Code: ");
			String code = sc.nextLine();

			String s;
			boolean notFound = true;
			while((s=f.readLine())!=null) {
				String sarr[] = s.split(";");
				if(sarr[2].equalsIgnoreCase(code)) {
					notFound = false;
					System.out.println("\""+sarr[2]+"\""+" is "+sarr[0]+" also known as "+sarr[1]+".");
				}
			}
			if(notFound)
				System.out.println("No match found for HR code "+"\""+code+"\"");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
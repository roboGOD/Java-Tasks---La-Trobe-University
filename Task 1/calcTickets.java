import java.util.Scanner;

class CalcTickets {
	String ticket;

	CalcTickets(String ticket) {
		this.ticket = ticket;
	}

	// Validate the ticket string and calculate price.
	float validateAndCalc() {
		String s = this.ticket;
		float price = 0;
		s = s.toUpperCase(); // Works for both upper and lower case
		int l = s.length();
		
		// Validate length of ticket
		if(l < 4 || l > 7) {
			System.out.println("String of length "+l+" is invalid.");
			return -1.0f;
		}
		
		else {
			// Validate ticket class
			char start = s.charAt(0);
			switch(start) {
				case 'A':
				price += 50;
				break;
				
				case 'C':
				price += 100;
				break;

				case 'T':
				price += 200;
				break;

				default:
				System.out.println("Invalid ticket class: '"+start+"'");
				return -1.0f;
			}

			// Add in the digits (No need to check)
			int digits = Integer.parseInt(s.substring(1,4));
			price += digits;

			// Check if optional characters are there
			switch(l) {
				case 5: // One optional character
				char op1 = s.charAt(4);
				switch(op1) {
					case 'X':
					price += 25.50f;
					break;

					case 'B':
					price += 33.75f;
					break;

					case 'K':
					price += 41.33f;
					break;

					default:
					System.out.println("Invalid optional character at location 5: "+op1);
					return -1.0f;
				}
				break;

				case 6: // Two optional characters
				String op2 = s.substring(4);
				switch(op2) {
					case "BX":
					price += 105.45f;
					break;

					case "KX":
					price += 200.50f;
					break;

					default:
					System.out.println("Invalid optional characters at location 5 and 6: '"+op2+"'");
					return -1.0f;
				}
				break;

				case 7: // Three optional characters
				String op3 = s.substring(4);
				if(op3.equals("XBK"))
					price += 400.0f;
				else {
					System.out.println("Invalid optional characters at location 5, 6 and 7: '"+op3+"'");
					return -1.0f;
				}
				break;
			}

		}

		return price;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		CalcTickets C = new CalcTickets(s);

		float p = C.validateAndCalc();
		if(p > 0) // Print the price only if it's positive. Negative means ticket is invalid.
			System.out.println("Price: "+p);
	}
}

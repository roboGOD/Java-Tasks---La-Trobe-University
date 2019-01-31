import java.util.Random;
import java.util.Scanner;

// Missile class which controls the changes to missiles.
class Missile {
	int x;
	int y;

	Missile() {
		Random R1 = new Random();
        // Generates a random number in range -10 to 10, both inclusive.
        // nextInt(21) generates a range of 0 to 20, both inclusive.
        // subtracting 10 we get desired range of -10 to 10.
		this.x = R1.nextInt(21)-10;
		this.y = 0;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

    // update() function takes input from the user.
    // It returns true if the input is valid, false if invalid.
	boolean update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select a command: ");
		System.out.println("up\ndown\nleft\nright\nup left\nup right\ndown left\ndown right");
		System.out.print("Option >> ");

		String choice = sc.nextLine();

        // choice is case insensitive. That's why toLoweCase.
		switch(choice.toLowerCase()) {
			case "up":
			this.y += 2;
			break;

			case "down":
			this.y -= 2;
			break;

			case "left":
			this.x -= 2;
			break;

			case "right":
			this.x += 2;
			break;

			case "left up":
			this.y += 1;
			this.x -= 1;
			break;

			case "right up":
			this.y += 1;
			this.x += 1;
			break;

			case "left down":
			this.y -= 1;
			this.x -= 1; 
			break;

			case "right down":
			this.x += 1;
			this.y -= 1;
			break;

			default:
			System.out.println("\n"+choice+" is an Invalid Option. Please try again.\n");
            return false; // Invalid choice
		}
        return true;
	}

    // Checks if Missile is out of range. i.e. x < -10 or x > 10
    boolean outOfRange() {
        return (this.x < -10 && this.x > 10);
    }

    // Checks if Missile hit the ground. i.e. y < 0
    boolean hitGround() {
        return (this.y < 0);
    }
}

// Asteroid class which updates the movement of asteroid in every iteration.
class Asteroid {
	int x,y;
	boolean left;

	Asteroid() {
		Random R1 = new Random();
        // Generate a boolean to see to start from left or right.
		this.left = R1.nextBoolean();

		if(this.left) { // Start from left.
			this.x= -5;
			this.y= 10;
		}
		else { // Start from right.
			this.x = 5;
			this.y = 10;
		}
	}

    // Move the asteroid towards the ground.
	void update() {
		if(this.left) // Move towards right
			this.x += 1;
		else // Move towards left
			this.x -= 1;

        // Move down
		this.y -= 1;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

    // Checks whether the asteroid hit the ground
	boolean hit() {
		return y <= 0;
	}
}

// Main class
class DOTP {
 
	public static void main(String args[]) {
        // Initialize Missile and Asteroid via Constructors
		Missile m = new Missile();
		Asteroid a = new Asteroid();
 
        // Print the initial values
		System.out.println("\nInitial Values:");
		System.out.println("Asteroid: "+a.getX()+" "+a.getY());
		System.out.println("Missile: "+m.getX()+" "+m.getY()+"\n");
    
        // Iterate till win or lose
		while(true) {
			boolean updated = m.update(); // Update missile co-ordinates
            if(updated) // Update asteroid co-ordinates only if missile co-ordinates are updated
                a.update();
 
			if(m.getX() == a.getX() && m.getY() == a.getY()) { // The missile hit the asteroid
				System.out.println("\nYou win!!\nThe Asteroid is destroyed.");
				break;
			}			
 
			if(a.hit()) { // The asteroid hit the ground
				System.out.println("\nThe Asteroid hit the ground.\nYou lose!!\n");
				break;
			}

            if(m.hitGround()) { // The missile hit the ground.
                System.out.println("\nThe Missile hit the ground.\nYou lose!!\n");
                break;
            }

            if(m.outOfRange()) { // The missile goes out of range.
                System.out.println("\nThe Missile went out of range.\n The asteroid hit the ground.\nYou lose!!\n");
                break;
            }
            
            // Print the updated co-ordinates of Missile and Asteroid.
			System.out.println("\nAsteroid: "+a.getX()+" "+a.getY());
			System.out.println("Missile: "+m.getX()+" "+m.getY()+"\n");
 
		}
	}
}
import java.util.Random;
import java.util.Scanner;
 
class Missile {
	int x;
	int y;

	Missile() {
		Random R1 = new Random();
		this.x = R1.nextInt(21)-10;
		this.y = 0;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

	boolean update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select a command: ");
		System.out.println("up\ndown\nleft\nright\nup left\nup right\ndown left\ndown right");
		System.out.print("Option >> ");

		String choice = sc.nextLine();

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
            return false;
		}
        return true;
	}

    boolean outOfRange() {
        return (this.x < -10 && this.x > 10);
    }

    boolean hitGround() {
        return (this.y < 0);
    }
}

class Asteroid {
	int x,y;
	boolean left;

	Asteroid() {
		Random R1 = new Random();
		this.left = R1.nextBoolean();

		if(this.left) {
			this.x= -5;
			this.y= 10;
		}
		else {
			this.x = 5;
			this.y = 10;
		}
	}

	void update() {
		if(this.left)
			this.x += 1;

		else
			this.x -= 1;

		this.y -= 1;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

	boolean hit() {
		return y <= 0;
	}
}

 
class DOTP {
 
	public static void main(String args[]) {
		Missile m = new Missile();
		Asteroid a = new Asteroid();
 
		System.out.println("\nInitial Values:");
		System.out.println("Asteroid: "+a.getX()+" "+a.getY());
		System.out.println("Missile: "+m.getX()+" "+m.getY()+"\n");
 
		while(true) {
			boolean updated = m.update();
            if(updated)
                a.update();
 
			if(m.getX() == a.getX() && m.getY() == a.getY()) {
				System.out.println("\nYou win!!\nThe Asteroid is destroyed.");
				break;
			}			
 
			if(a.hit()) {
				System.out.println("\nThe Asteroid hit the ground.\nYou lose!!\n");
				break;
			}

            if(m.hitGround()) {
                System.out.println("\nThe Missile hit the ground.\nYou lose!!\n");
                break;
            }

            if(m.outOfRange()) {
                System.out.println("\nThe Missile went out of range.\n The asteroid hit the ground.\nYou lose!!\n");
                break;
            }
 
			System.out.println("\nAsteroid: "+a.getX()+" "+a.getY());
			System.out.println("Missile: "+m.getX()+" "+m.getY()+"\n");
 
		}
	}
}
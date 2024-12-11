/* Nicole Marchant
 * Project 1
 * 1/22/2024
 * Prompts user for input, creates and stores Players, calculates average age,
 *   outputs average age and tallest player information at or below average age.
 */
import java.util.ArrayList;
import java.util.Iterator; // https://www.geeksforgeeks.org/iterating-arraylists-java/
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		char escape;
		
		ArrayList<Player> playerArray = new ArrayList<>();
		Player currentPlayer = null;
		Height height = null;
		String name = null;
		int age = 0;
		int feet = 0;
		int inches = 0;
		
		int averageAge = 0;
		int totalAge = 0;
		int playerCount = 0;
		
		
		// Repeatedly prompt for players
		do {

			System.out.println("Enter Player Name");
			name = userInput.next();
			
			System.out.println("Enter Player Age");
			age = userInput.nextInt();
			
			System.out.println("Enter Player Feet");
			feet = userInput.nextInt();
			
			System.out.println("Enter Player Inches");
			inches = userInput.nextInt();
			
			height = new Height(feet, inches);
			
			currentPlayer = new Player(name, height, age);
			playerArray.add(currentPlayer);
			totalAge += age;
			playerCount++;
			
			System.out.println("Enter 'Q' to stop adding players, Enter any other character to continue");
			escape = userInput.next().charAt(0);
		}while(escape != 'q' && escape != 'Q');
		
		averageAge = totalAge/playerCount;
		System.out.println(String.format("Average age: %d", averageAge));
		
		Player tallestPlayer = null;
		Iterator<Player> playerIterator = playerArray.iterator();
		while(playerIterator.hasNext()) {
			currentPlayer = playerIterator.next();
			if(currentPlayer.age <= averageAge) {
				tallestPlayer = currentPlayer;
			}
		}
		System.out.print("The tallest player: ");
		System.out.print(tallestPlayer.toString());
		
		userInput.close();
	}
}

import java.util.Scanner;


// Start of the GamePlay class
public class GamePlay {
    private static Players player;
    private static Turn turn;

    public static void main(String[] args) {
        // Start of the main method
        Scanner input = new Scanner(System.in);
        
        // Create a new Hosts object
        Hosts host = new Hosts(null);
        // Call the randomizeNum method
        host.randomizeNum();
        String answer;
        // Start of the 1st loop
        do {
            // Ask the user for their name
            System.out.print("Enter your name: ");
            String firstName = input.next();
            // Ask the user if they want to enter a last name
            System.out.print("Would you like to enter a last name? (yes/no): ");
            answer = input.next();
            // If the user enters yes, ask for their last name
            if (answer.equalsIgnoreCase("yes")) {
                System.out.print("Enter your last name: ");
                String lastName = input.next();
                player = new Players(firstName, lastName);
            } else {
                player = new Players(firstName);
            }
            // Create a new Turn object
            turn = new Turn();

            // Start of the 2nd loop to repeat the game
            while (!turn.takeTurn(player, host)) {
                System.out.println(player.toString());
            }
            // ask the user if they want to play again
            System.out.println(player.toString());
            System.out.print("Would you like to play again? (yes/no): ");
            answer = input.next();
            if (answer.equalsIgnoreCase("yes")) {
                host.randomizeNum();
            }
            
            // only loop if the user enters yes
        } while (answer.equalsIgnoreCase("yes"));
        input.close();


    }// End of the main method
}// End of the GamePlay class

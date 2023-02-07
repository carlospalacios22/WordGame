import java.util.Scanner;

// Start of the GamePlay class
public class GamePlay {
    private static Players player;
    private static Turn turn;
    private static Players[] currentPlayers = new Players[3];
    private static int currentPlayerIndex = 0;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Create a new Hosts object
        Hosts host = new Hosts(null);
        
        // Loop to create 3 players
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String firstName = input.next();
            System.out.print("Would you like to enter a last name? (yes/no): ");
            String answer = input.next();
            
            if (answer.equalsIgnoreCase("yes")) {
                System.out.print("Enter your last name: ");
                String lastName = input.next();
                currentPlayers[i] = new Players(firstName, lastName);
            } else {
                currentPlayers[i] = new Players(firstName);
            }
        }
        
        String answer;
        // Start of the 1st loop
        do {
            host.randomizeNum();
            currentPlayerIndex = 0;
            // Start of the 2nd loop to repeat the game
            while (true) {
                player = currentPlayers[currentPlayerIndex];
                turn = new Turn();
                if (turn.takeTurn(player, host)) {
                    System.out.println(player.toString());
                    break;
                }
                System.out.println(player.toString());
                currentPlayerIndex++;
                if (currentPlayerIndex == 3) {
                    currentPlayerIndex = 0;
                }
            }
            // ask the user if they want to play again
            System.out.print("Would you like to play again? (yes/no): ");
            answer = input.next();
        } while (answer.equalsIgnoreCase("yes"));
        input.close();

        
    }// End of the main method
}// End of the GamePlay class

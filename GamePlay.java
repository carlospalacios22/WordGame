import java.util.Scanner;

public class GamePlay {
    private static Players[] currentPlayers;
    public static void main(String[] args) {
  
        Scanner input = new Scanner(System.in);

        currentPlayers = new Players[3];
        String answer;
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the first name of player " + (i + 1));
            String firstName = input.next();

            System.out.print("Would you like to enter a last name? (yes/no): ");
            answer = input.next();
            String lastName = "";
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Enter the last name of player " + (i + 1));
                lastName = input.next();
            }

            currentPlayers[i] = new Players(firstName, lastName);
        }

        do {
            // loop through all the players
            for (int i = 0; i < 3; i++) {
                Hosts host = new Hosts();
                System.out.println("\n" + host.getIntro(currentPlayers[i].getFirstName()));

                Turn turn = new Turn();
                boolean isWinner = turn.takeTurn(currentPlayers[i], host);

                if (isWinner) {
                    System.out.println(currentPlayers[i].toString());
                    break;
                }

                // if the current player is the last one, reset the counter
                if (i == 2) {
                    i = -1;
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            answer = input.next();
        } while (answer.equalsIgnoreCase("yes"));
        input.close();
    }
}

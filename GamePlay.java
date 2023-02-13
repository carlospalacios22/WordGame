
// import scanner library
import java.util.Scanner;

// Start of GamePlay class
public class GamePlay {
  private Players[] currentPlayers;
  //  start of main method
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    GamePlay game = new GamePlay();
    // Create the host
    Hosts host = new Hosts("Pennybags","");
    
    Numbers.generateNumber();
    Turn turn = new Turn();
    game.currentPlayers = new Players[3];
    // Ask for the players names
    for (int i = 0; i < game.currentPlayers.length; i++) {
      System.out.print("Enter player " + (i + 1) + " name: ");
      String name = input.nextLine();
      // Ask if they want to enter a last name
      System.out.print("Would you like to enter a last name? (yes/no): ");
      String answer = input.nextLine();
      if (answer.equals("yes")) {
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        game.currentPlayers[i] = new Players(name, lastName);
      } else {
        game.currentPlayers[i] = new Players(name);
      }
      game.currentPlayers[i].setMoney(1000);
    }
    
    String answer;
    boolean playAgain = true;
    while (playAgain) {
      int currentPlayerIndex = 0;
      while (!turn.takeTurn(game.currentPlayers[currentPlayerIndex % 3], host)) {
        currentPlayerIndex++;
      }// End of while loop

      // Ask if they want to play again
      System.out.println("Would you like to play again? (yes/no): ");
      answer = input.nextLine();
      // If they say no, then end the game
      if (answer.equals("no")) {
        playAgain = false;
      } else {
        Numbers.generateNumber();
      }// End of if else statement


    }// End of while loop
  }// End of main method
}// End of GamePlay class

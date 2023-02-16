

// libraries
import java.util.Scanner;

//Start of GamePlay class
public class GamePlay {
    // instance variables
  private Players[] currentPlayers;

//Start of main method
  public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      GamePlay game = new GamePlay();
      Hosts host = new Hosts("Pennybags", "");
      
      host.enterPhrase();
      
      Turn turn = new Turn();
      // 3 players in the game
      game.currentPlayers = new Players[3];
      // for loop to get the players names
      for (int i = 0; i < game.currentPlayers.length; i++) {
          System.out.print("Enter player " + (i + 1) + " name: ");
          String name = input.nextLine();
          System.out.print("Would you like to enter a last name? (yes/no): ");
          String answer = input.nextLine();
          // if statement to get the players last name
          if (answer.equals("yes")) {
              System.out.print("Enter your last name: ");
              String lastName = input.nextLine();
              game.currentPlayers[i] = new Players(name, lastName);
              
          } else {
              game.currentPlayers[i] = new Players(name);
          }
          // sets the players money 
            game.currentPlayers[i].setMoney(1000);
      }
      

      String answer;
      boolean playAgain = true;
      // while loop to play the game
      while (playAgain) {
          int currentPlayerIndex = 0;
         
          while (!turn.takeTurn(game.currentPlayers[currentPlayerIndex % 3], host)) {
            currentPlayerIndex++;
        }
        // if statement to play again
        System.out.println("Would you like to play again? (yes/no): ");
        answer = input.nextLine();
        if (answer.equals("no")) {
            playAgain = false;
        } else {
            host.enterPhrase();
            
        }//End of if statement
    }//End of while loop
}//End of main method
}//End of GamePlay class

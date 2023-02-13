

//importing the Scanner class
import java.util.Scanner;



//Beginning of GamePlay class


public class GamePlay {
  private Players player;
//beginning of main method
  public static void main(String[] args) {
    //creating a new Scanner object
    Scanner input = new Scanner(System.in);
    GamePlay game = new GamePlay();

    //creating a new Hosts object
    Hosts host = new Hosts("Pennybags","");
    host.randomizeNum();
    Turn turn = new Turn();
//prompting the user to enter their name
    System.out.print("Enter your name: ");
    String name = input.nextLine();
//prompting the user to enter their last name
    System.out.print("Would you like to enter a last name? (yes/no): ");
    String answer = input.nextLine();
    //if the user enters yes, then they will be prompted to enter their last name
    if (answer.equals("yes")) {
      System.out.print("Enter your last name: ");
      String lastName = input.nextLine();
      game.player = new Players(name, lastName);

    } else {
      //if the user enters no, then they will not be prompted to enter their last name
      game.player = new Players(name);
    }
//setting the player's money to 1000
    game.player.setMoney(1000);



    boolean playAgain = true;
    while (playAgain) {
      while (!turn.takeTurn(game.player, host)) {

      
      }
      //prompting the user to play again
      System.out.println("Would you like to play again? (yes/no): ");
      answer = input.nextLine();

      //if the user enters yes, then the game will restart
      if (answer.equals("no")) {
        playAgain = false;

        //if the user enters no, then the game will end
      } else {
        host.randomizeNum();
      }// end of if else


    }// end of while loop
  }// end of main method
}// enmd of GamePlay class

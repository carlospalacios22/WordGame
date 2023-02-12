import java.util.Scanner;

public class GamePlay {
  private Players player;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    GamePlay game = new GamePlay();

    
    Hosts host = new Hosts("Pennybags","");
    host.randomizeNum();
    Turn turn = new Turn();

    System.out.print("Enter your name: ");
    String name = input.nextLine();

    System.out.print("Would you like to enter a last name? (yes/no): ");
    String answer = input.nextLine();
    if (answer.equals("yes")) {
      System.out.print("Enter your last name: ");
      String lastName = input.nextLine();
      game.player = new Players(name, lastName);
    } else {
      game.player = new Players(name);
    }

    game.player.setMoney(1000);

    boolean playAgain = true;
    while (playAgain) {
      while (!turn.takeTurn(game.player, host)) {

      
      }
      System.out.println("Would you like to play again? (yes/no): ");
      answer = input.nextLine();
      if (answer.equals("no")) {
        playAgain = false;
      } else {
        host.randomizeNum();
      }
    }
  }
}

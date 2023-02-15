import java.util.Scanner;

public class GamePlay {
  private Players[] currentPlayers;

  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      GamePlay game = new GamePlay();
      Hosts host = new Hosts("Pennybags", "");
      host.enterPhrase();
      Turn turn = new Turn();
      game.currentPlayers = new Players[3];
      for (int i = 0; i < game.currentPlayers.length; i++) {
          System.out.print("Enter player " + (i + 1) + " name: ");
          String name = input.nextLine();
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
        }

        System.out.println("Would you like to play again? (yes/no): ");
        answer = input.nextLine();
        if (answer.equals("no")) {
            playAgain = false;
        } else {
            host.enterPhrase();
        }
    }
}
}

import java.util.Random;
import java.util.Scanner;

public class Turn {
  public boolean takeTurn(Players player, Hosts host) {
    Scanner input = new Scanner(System.in);

    // Ask the player to guess a letter
    System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter a letter: ");
    String guessStr = input.nextLine().toLowerCase();
    char guess = guessStr.charAt(0);

    // Check if the guess is a letter
    if (!Character.isLetter(guess)) {
      System.out.println("Invalid input. Please enter a letter.");
      return false;
    }

    try {
      // Evaluate the guess using the findLetters method from the Phrases class
      boolean result = Phrases.findLetters(guess);

      // If the guess is correct, then display the winnings
      Random random = new Random();
      int prizeType = random.nextInt(2);
      int winnings = 0;

      // If the prize type is 0, then it is money
      if (prizeType == 0) {
        Money money = new Money();
        winnings = money.displayWinnings(player, result);

      // If the prize type is 1, then it is physical
      } else {
        Physical physical = new Physical();
        winnings = physical.displayWinnings(player, result);
      }

      player.setMoney(player.getMoney() + winnings);
      System.out.println(player.toString());
      return result;
    } catch (MultipleLettersException e) {
      System.out.println(e.getMessage());
    }

    return false;
  }
}

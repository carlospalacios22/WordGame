
// Library Imports
import java.util.Random;
import java.util.Scanner;


// Start of Turn class
public class Turn {


  // Start of takeTurn method
  public boolean takeTurn(Players player, Hosts host) {
    // Ask the player to guess a number

    System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter your guess between 0 and 100: ");
    Scanner input = new Scanner(System.in);
    int guess = input.nextInt();

    // Compare the guess to the number
    boolean result = Numbers.compareNumber(guess);

    // If the guess is correct, then display the winnings
    Random random = new Random();
    int prizeType = random.nextInt(2);

    // If the prize type is 0, then it is money
    int winnings = 0;
    if (prizeType == 0) {
      Money money = new Money();
      winnings = money.displayWinnings(player, result);

      // If the prize type is 1, then it is physical
    } else {
      Physical physical = new Physical();
      winnings = physical.displayWinnings(player, result);
    }

    // If the guess is correct, then display the winnings
    player.setMoney(player.getMoney() + winnings);
    System.out.println(player.toString());
    return result;


  }// End of takeTurn method
}// End of Turn class

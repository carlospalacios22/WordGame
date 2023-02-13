

// import Scanner;
import java.util.Scanner;
// Start of Turn class
public class Turn {
  // Money amounts
    private final int INCREMENT_AMOUNT = 500;
    private final int DECREMENT_AMOUNT = 200;
  // Start of takeTurn method
    public boolean takeTurn(Players player, Hosts host) {
      // Ask the player to guess a number
      System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter your guess between 0 and 100: ");
      Scanner input = new Scanner(System.in);
      // Get the players guess
      int guess = input.nextInt();
      // Compare the players guess to the random number
      boolean result = Numbers.compareNumber(guess);
      // If the guess is correct, then add 500 to the players money
      if (result) {
        player.setMoney(player.getMoney() + INCREMENT_AMOUNT);
        System.out.println("Congratulations! " + player.getFirstName() + " won $" + INCREMENT_AMOUNT);
        System.out.println(player.toString());
        return true;
        // If the guess is incorrect, then subtract 200 from the players money
      } else {
        player.setMoney(player.getMoney() - DECREMENT_AMOUNT);
        System.out.println(player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
        System.out.println(player.toString());
        return false;
      }// End of if else statement

    }// End of takeTurn method
    
}// End of Turn class

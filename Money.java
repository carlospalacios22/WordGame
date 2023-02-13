

import java.util.Scanner;

public class Money implements Award {
  private final int INCREMENT_AMOUNT = 500;
  private final int DECREMENT_AMOUNT = 200;

  @Override
  public int displayWinnings(Players player, boolean correctGuess) {
    if (correctGuess) {
      System.out.println(player.getFirstName() + " won $" + INCREMENT_AMOUNT);
      return INCREMENT_AMOUNT;
    } else {
      System.out.println(player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
      return -DECREMENT_AMOUNT;
    }
  }
}

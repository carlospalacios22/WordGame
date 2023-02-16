


public class Money implements Award {
  private final int INCREMENT_AMOUNT = 500;
  private final int DECREMENT_AMOUNT = 200;

  //Start of displayWinnings method
  @Override
  public int displayWinnings(Players player, boolean correctGuess) {
      if (correctGuess) {
          System.out.println(player.getFirstName() + " won $" + INCREMENT_AMOUNT);
          player.addWinnings(INCREMENT_AMOUNT);
          return INCREMENT_AMOUNT;
      } else {
          System.out.println(player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
          player.addLosses(DECREMENT_AMOUNT);
          return -DECREMENT_AMOUNT;


      }//End of if statement
  }//End of displayWinnings method
}//End of Money class

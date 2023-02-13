import java.util.Random;

// Start of Numbers class
public class Numbers {
  public static int randomNum;
  // Start of generateNumber method
  public static void generateNumber() {
    Random rand = new Random();
    randomNum = rand.nextInt(101);
  }
  
  public static boolean compareNumber(int guess) {
    // If the guess is correct, then return true
    if (guess == randomNum) {
      System.out.println("Congratulations, you guessed the number!");
      return true;
      // If the guess is too high, then return false
    } else if (guess > randomNum) {
      System.out.println("I'm sorry. That guess was too high.");
      return false;
    } else {
      // If the guess is too low, then return false
      System.out.println("I'm sorry, That guess was too low.");
      return false;
    }// End of if else statement


  }// End of compareNumber method
}// End of Numbers class

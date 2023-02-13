
// import Random library
import java.util.Random;


//beginning of Numbers class
public class Numbers {
  private static int randomNum;

  //getter method
  public static int getRandomNum() {
    return randomNum;
  }
  //setter method
  
  public static void setRandomNum(int randomNum) {
    Numbers.randomNum = randomNum;
  }
  //this method will generate a random number
  public void generateNumber() {
    Random rand = new Random();
    randomNum = rand.nextInt(101);
  }


  //this method will compare the user's guess to the random number
  public boolean compareNumber(int guess) {
    if (guess == randomNum) {

      //if the user's guess is equal to the random number, then the user will win
      System.out.println("Congratulations, you guessed the number!");
      return true;
    } else if (guess > randomNum) {

      //if the user's guess is greater than the random number
      System.out.println("I'm sorry. That guess was too high.");
      return false;
    } else {
      //if the user's guess is less than the random number
      System.out.println("I'm sorry, That guess was too low.");
      return false;
    }//end of if else


  }//end of compareNumber method
}//end of Numbers class

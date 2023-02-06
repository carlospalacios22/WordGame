import java.util.Random;

public class Numbers {
  private int randomNum;
  
  public int getRandomNum() {
    return randomNum;
  }
  
  public void setRandomNum(int randomNum) {
    this.randomNum = randomNum;
  }
  
  public void generateNumber() {
    Random random = new Random();
    this.randomNum = random.nextInt(101);
  }
  
  public boolean compareNumber(int guess) {
    if (guess == this.randomNum) {
      System.out.println("Congratulations, you guessed the number!");
      return true;
    } else if (guess > this.randomNum) {
      System.out.println("I'm sorry.  That guess was too high.");
      return false;
    } else {
      System.out.println("I'm sorry, That guess was too low.");
      return false;

      
    }// End of if/else
  }// End of compareNumber
}// End of Numbers

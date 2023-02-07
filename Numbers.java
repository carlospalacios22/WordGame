import java.util.Random;


// Start of the Numbers class
public class Numbers {
    private static int randomNum;

//    private int guess;
    public static int getRandomNum() {
        return randomNum;
    }
//    public int getGuess() {
    public static void setRandomNum(int randomNum) {
        Numbers.randomNum = randomNum;
    }

    public void generateNumber() {
        Random rand = new Random();
        randomNum = rand.nextInt(101);
    }// end of generateNumber method
        
    
    public boolean compareNumber(int guess) {
        return guess == randomNum;
    }// end of compareNumber method
}// end of Numbers class

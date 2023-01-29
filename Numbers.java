
//using the Random library
import java.util.Random;


//////////////////////////////////////////


public class Numbers {
    private static int randomNum;

    public void generateNumber() 
    {
        Random rand = new Random();
        randomNum = rand.nextInt(101);
    }

    public boolean compareNumber(int guess) 
    {
        if (randomNum == guess) {
            System.out.println("Congratulations, you guessed the number!");
            return true;
        } else if (randomNum < guess) {
            System.out.println("I'm sorry. That guess was too high.");
            return false;
        } else {
            System.out.println("I'm sorry, That guess was too low.");
            return false;
        }
    }

    public static int getRandomNum() 
    {
        return randomNum;
    }

    public static void setRandomNum(int randomNum) 
    {
        Numbers.randomNum = randomNum;
    }

    public int getNumToGuess() {
        return randomNum;
    }

    public int getRandomNumber() {
        return 0;
    }
}

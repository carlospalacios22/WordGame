
//using the Random library
import java.util.Random;


//////////////////////////////////////////
//using the Random library
import java.util.Random;

//Class Numbers start
public class Numbers {
    private int randomNum;

    public void generateNumber() 
    {
        Random rand = new Random();
        randomNum = rand.nextInt(101);
    }

  //Boolean for the number guess inputs using IF/ELSE
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

        public int getRandomNum() 
    {
        return randomNum;
    }

    public void setRandomNum(int randomNum) 
    {
        this.randomNum = randomNum;
    }
    
}//Numbers class ends 

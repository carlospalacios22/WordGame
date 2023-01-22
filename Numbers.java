
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

  

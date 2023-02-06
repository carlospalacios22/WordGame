
/* 
//Import Scanner library for input/outputs
import java.util.Scanner;


public class Turn {
    
    public boolean takeTurn(Person player) {
        Numbers number = new Numbers();
      
        
        Scanner input = new Scanner(System.in);
        System.out.println(player.getFirstName() + ", please enter a number to  guess my number between 0 - 100: ");
        int guess = input.nextInt();
        
        boolean correctGuess = number.compareNumber(guess);
        int winAmount = 500;
        int loseAmount = 200;
        //
        if (correctGuess) {
            player.increaseMoney(winAmount);
            System.out.println("Congratulations " + player.getFirstName() + "! You won " + winAmount + " dollars.");
        } else {
            player.decreaseMoney(loseAmount);
            System.out.println("Sorry " + player.getFirstName() + ", your guess was incorrect. You lost " + loseAmount + " dollars.");
            if (guess > number.getNumToGuess()) {
                System.out.println("Your guess was too high.");
            } else {
                System.out.println("Your guess was too low.");
            }
        }
        System.out.println(player.toString());
        return correctGuess;
    }
    
    
}

*/

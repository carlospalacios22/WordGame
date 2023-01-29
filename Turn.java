//Import Scanner library for input/outputs
import java.util.Scanner;






public class Turn {
    
    public boolean takeTurn(Person player) {
        Numbers number = new Numbers();
        number.generateNumber();
        
        Scanner input = new Scanner(System.in);
        System.out.println(player.getFirstName() + ", please enter your guess: ");
        int guess = input.nextInt();
        
        boolean correctGuess = number.compareNumber(guess);
        int winAmount = 100;
        int loseAmount = 50;
        
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

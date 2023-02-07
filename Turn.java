import java.util.Scanner;

public class Turn {
  public boolean takeTurn(Players player, Hosts host) {

    
      System.out.println("Rich Uncle Pennybags: " + player.getFirstName() + ", enter a guess for the random number between 0 and 100.");
      Scanner input = new Scanner(System.in);
      int guess = input.nextInt();
      Numbers numbers = new Numbers();
      boolean correctGuess = numbers.compareNumber(guess);
      if (correctGuess) {
          player.setMoney(player.getMoney() + 500);
          System.out.println("Congratulations, " + player.getFirstName() + "! You are the winner.");
        
          return true;
      } else {
          player.setMoney(player.getMoney() - 200);
         
          System.out.println("Your guess was too " + (guess > Numbers.getRandomNum() ? "high." : "low."));
          return false;
      }
  }
}

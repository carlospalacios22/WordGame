import java.util.Scanner;

// Start of the Turn class
public class Turn {
  public boolean takeTurn(Players player, Hosts host) {

        // Ask the user for a guess
      System.out.println("Rich Uncle Pennybags: " + player.getFirstName() + ", enter a guess for the random number between 0 and 100.");
      Scanner input = new Scanner(System.in);
      int guess = input.nextInt();

        // Create a new Numbers object
       Numbers numbers = new Numbers();
       
      // Call the compareNumber method
      boolean correctGuess = numbers.compareNumber(guess);


        // If the guess is correct, add $500 to the player's money
      if (correctGuess) {
          player.setMoney(player.getMoney() + 500);
          System.out.println("Congratulations, " + player.getFirstName() + "! You are the winner.");
        
          return true;
      } // end of if statement



      // If the guess is incorrect, subtract $200 from the player's money
      else {
          player.setMoney(player.getMoney() - 200);
         
          System.out.println("Your guess was too " + (guess > Numbers.getRandomNum() ? "high." : "low."));
          return false;

      }// end of if/else statement
  }// end of takeTurn method
}// end of Turn class

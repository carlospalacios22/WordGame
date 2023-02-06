import java.util.Scanner;


//Begin of class GamePlay
public class GamePlay {
  private Person player;
  

  // Begin of main

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    GamePlay game = new GamePlay();
    
    System.out.print("Enter your first name: ");
    String firstName = input.nextLine();
    
    System.out.print("Would you like to enter a last name? (y/n): ");
    String lastNameResponse = input.nextLine();
    
    if (lastNameResponse.equalsIgnoreCase("y")) {
      System.out.print("Enter your last name: ");
      String lastName = input.nextLine();
      game.player = new Person(firstName, lastName);
    } else {
      game.player = new Person(firstName);
    }
    
    Numbers numbers = new Numbers();
    numbers.generateNumber();
    
    System.out.println("Hi " + game.player.getFirstName() + "! Let's play a game. I'm thinking of a number between 0 and 100.");
    boolean correctGuess = false;
    while (!correctGuess) {
      System.out.print("What's your guess, " + game.player.getFirstName() + "? ");
      int guess = input.nextInt();
      correctGuess = numbers.compareNumber(guess);


    }// End of while loop
  }// End of main
}// End of GamePlay

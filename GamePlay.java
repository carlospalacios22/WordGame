//Import Scanner library for input/outputs
import java.util.Scanner;

//Main Class for the game
//Gameplay class Start

public class GamePlay {
    private Person player;
    private Numbers randomNumber;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();

        game.randomNumber = new Numbers();
        game.randomNumber.generateNumber();

        System.out.print("What is your first name? ");
        String firstName = sc.nextLine();
        
        //Prompt for the last name if no then it will not get the last name 
        System.out.print("Would you like to enter a last name? (y/n) ");
        String lastNameResponse = sc.nextLine();
        if (lastNameResponse.equalsIgnoreCase("y")) {
            System.out.print("What is your last name? ");
            String lastName = sc.nextLine();
            game.player = new Person(firstName, lastName);
        } else {
            game.player = new Person(firstName);
        }
        
            boolean correctGuess = false;
        
        //added loop until the number is gussed corrrectly 
        while (!correctGuess) 
        {
            System.out.print(game.player.getFirstName() + ", please enter a number to  guess my number between 0 - 100: ");
            int guess = sc.nextInt();
            sc.nextLine();
            correctGuess = game.randomNumber.compareNumber(guess);
     
        }
        
        
        
    }// end of void main
    
    
}//end of Gameplay
    
    
   
    
    


//Import Scanner library for input/outputs
import java.util.Scanner;


public class GamePlay {
    private Players player;
    private Hosts host;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();

        game.host = new Hosts();
        game.host.randomizeNum();

        System.out.print("What is your first name? ");
        String firstName = sc.nextLine();
        
        // Prompt for the last name
        //if user enters y then get the last name.
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
     
        }//end of guess loop
        
        
        
    }// end of void main
    
    
}//end of Gameplay
    
    
   
    
    

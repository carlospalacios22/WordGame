
//Import Scanner library for input/outputs
import java.util.Scanner;

//Start of GamePlay
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
        System.out.print("Would you like to enter a last name? (y/n) ");
        String lastNameResponse = sc.nextLine();
        if (lastNameResponse.equalsIgnoreCase("y")) {
            System.out.print("What is your last name? ");
            String lastName = sc.nextLine();
            game.player = new Players(firstName, lastName, 0.0);
        } else {
            game.player = new Players(firstName, 0.0);
        }
        
        Turn turn = new Turn();

        // loop that allows the player to keep playing or stop
        boolean keepPlaying = true;
        while (keepPlaying) {
            boolean correctGuess = false;
            while (!correctGuess) {
                correctGuess = turn.takeTurn(game.player);
            }
            
            System.out.print("Do you want to keep playing? (y/n) ");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("n")) {
                keepPlaying = false;
            } else {
                game.host.randomizeNum();
            }
        }//end of game loop


    }//end of void main



}//Numbers class ends 

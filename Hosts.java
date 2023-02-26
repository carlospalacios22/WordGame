

import java.util.Scanner;


//Start of Hosts class
public class Hosts extends Person {
    private String gamePhrase;
//Start of Hosts constructor
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
        this.gamePhrase = "";
    }
//Start of enterPhrase method
    public void enterPhrase() {
        Scanner input = new Scanner(System.in);
        System.out.println(getFirstName() + ", please enter a phrase for the players to guess:");
        this.gamePhrase = input.nextLine();
        Phrases.setGamePhrase(gamePhrase);
    }

    public void randomizePhrase() {
        enterPhrase();

    }//End of randomizePhrase method
    public Object getGamePhrase() {
        return null;
    }

}//End of Hosts class

import java.util.Scanner;

public class Hosts extends Person {
    private String gamePhrase;

    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
        this.gamePhrase = "";
    }

    public void enterPhrase() {
        Scanner input = new Scanner(System.in);
        System.out.println(getFirstName() + ", please enter a phrase for the players to guess:");
        this.gamePhrase = input.nextLine();
        Phrases.setGamePhrase(gamePhrase);
    }

    public void randomizePhrase() {
        enterPhrase();
    }
}

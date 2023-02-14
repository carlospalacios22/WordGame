import java.util.Scanner;

public class Hosts extends Person {

    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void enterPhrase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phrase for the players to guess: ");
        String phrase = scanner.nextLine();
        Phrases.setGamePhrase(phrase);
    
        System.out.println("Do you want to enter a new phrase? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            enterPhrase();
        }
    }
}

import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {
        System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter a letter:");
        Scanner input = new Scanner(System.in);
        String letter = input.nextLine();
        try {
            Phrases.findLetters(letter);
        } catch (MultipleLettersException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a letter, not a number or symbol");
        }
        System.out.println(Phrases.getPlayingPhrase());
        return !Phrases.getPlayingPhrase().contains("_");
    }
}




public class Hosts extends Person {
  
    private static String gamePhrase;

    // constructor
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }
    
    // method to set the game phrase
    public static void setGamePhrase(String phrase) {
        gamePhrase = phrase;
    }
    
    // method to get the game phrase
    public static String getGamePhrase() {
        return gamePhrase;
    }
}

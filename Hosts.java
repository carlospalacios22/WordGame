


// This class is a subclass of Person
public class Hosts extends Person {

    private static String gamePhrase;

    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }
 

    /// Getters and Setters
    public void choosePhrase() {
        Phrases.generatePhrase();
        gamePhrase = Phrases.randomPhrase;
    }// End of choosePhrase method

    
}// End of Hosts class

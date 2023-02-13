



// This class is a subclass of Person
public class Hosts extends Person {

    private Numbers number;

    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }
 

    /// Getters and Setters
    public void randomizeNum() {
        this.number = new Numbers();
        this.number.generateNumber();
    }// End of randomizeNum method

    
}// End of Hosts class

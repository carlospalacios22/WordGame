


// This class is a subclass of Person

public class Hosts extends Person {
    
//instance variable
    private Numbers number;


//constructor
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }
 

    //this method will generate a random number
    public void randomizeNum() {
        this.number = new Numbers();
        this.number.generateNumber();
    }


}//end of Hosts class

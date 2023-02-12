




public class Hosts extends Person {

    private Numbers number;

    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }
 

    
    public void randomizeNum() {
        this.number = new Numbers();
        this.number.generateNumber();
    }
}

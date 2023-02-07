




// extends Person class to Hosts class
public class Hosts extends Person {
  public Hosts(String firstName) {
    super(firstName);
    
  }
// randomizeNum method by calling the generateNumber method from the Numbers class
  public void randomizeNum() {
      Numbers numbers = new Numbers();
      numbers.generateNumber();
  }
}

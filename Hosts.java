
//reduced the code from lesson3 to be more simple.



// extends Person class to Hosts class
public class Hosts extends Person {
  public Hosts() {
    super(firstName);
    
  }// end of Hosts constructor


// randomizeNum method by calling the generateNumber method from the Numbers class
  public void randomizeNum() {
      Numbers numbers = new Numbers();
      numbers.generateNumber();
  }// end of randomizeNum method


public String getIntro(String firstName) {

   
    return "It's your turn, " + firstName;
}// end of getIntro method



}// end of Hosts class

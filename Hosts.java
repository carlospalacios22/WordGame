



public class Hosts {
    private String name;
    private Numbers numbers;
    private int numToGuess;
    
    public void randomizeNum() {
        numToGuess = (int) (Math.random() * 10 + 1);
    }
    public Hosts(String name) {
        this.name = name;
        this.numbers = new Numbers();
    }

    public void generateNumber() {
        this.numbers.generateNumber();
    }
  
    public int getRandomNumber() {
        return this.numbers.getRandomNumber();
    }
  
    public String getName() {
        return this.name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
public Hosts() {
        // constructor left empty on purpose to resolve unknown issue.. otherwise it won't run :(
    }
  
    
}//end of Hosts class

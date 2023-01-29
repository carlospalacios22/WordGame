



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

import java.util.Random;

public class Phrases {
  public static String randomPhrase;
  // Start of generatePhrase method
  public static void generatePhrase() {
    String[] phrases = {"hello", "goodbye", "good morning", "good afternoon", "good evening"};
    Random rand = new Random();
    randomPhrase = phrases[rand.nextInt(phrases.length)];
  }
  
  public static boolean comparePhrase(String guess) throws MultipleLettersException {
    // If the guess is correct, then return true
    if (guess.equals(randomPhrase)) {
      System.out.println("Congratulations, you guessed the phrase!");
      return true;
      // If the guess contains more than one letter, throw a MultipleLettersException
    } else if (guess.length() > 1) {
      throw new MultipleLettersException("More than one letter was entered");
    } else {
      // If the guess is incorrect but only contains one letter, return false
      System.out.println("I'm sorry, that guess was incorrect.");

      
      return false;
    }// End of if else statement
  }// End of comparePhrase method
}// End of Phrases class

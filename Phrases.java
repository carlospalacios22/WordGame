import java.util.Random;

public class Phrases {
  public static String randomPhrase;
  public static String playingPhrase;

  public static void generatePhrase() {
    String[] phrases = {
      "It's not rocket science",
      "Kill two birds with one stone",
      "Piece of cake",
      "Let the cat out of the bag",
      "Barking up the wrong tree"
    };
    Random rand = new Random();
    randomPhrase = phrases[rand.nextInt(phrases.length)];
    playingPhrase = randomPhrase.replaceAll("[a-zA-Z]", "_");
  }

  public static String getPhrase() {
    return playingPhrase;
  }
}

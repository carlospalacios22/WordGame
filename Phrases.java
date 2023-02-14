import java.util.ArrayList;
import java.util.Random;

public class Phrases {
  public static String gamePhrase;
  public static String playingPhrase;
  public static ArrayList<Integer> indices;

  public static void generatePhrase() {
    String[] phrases = {
      "It's not rocket science",
      "Kill two birds with one stone",
      "Piece of cake",
      "Let the cat out of the bag",
      "Barking up the wrong tree"
    };
    Random rand = new Random();
    gamePhrase = phrases[rand.nextInt(phrases.length)];
    playingPhrase = gamePhrase.replaceAll("[a-zA-Z]", "_");
  }

  public static String getPhrase() {
    return playingPhrase;
  }

  public static void findLetters(String letter) throws MultipleLettersException {
    if (letter.length() != 1) {
      throw new MultipleLettersException();
    }
    indices = new ArrayList<>();
    int index = gamePhrase.indexOf(letter);
    while (index >= 0) {
      indices.add(index);
      index = gamePhrase.indexOf(letter, index + 1);
    }
    if (indices.size() > 0) {
      char[] charArray = playingPhrase.toCharArray();
      for (int i = 0; i < indices.size(); i++) {
        charArray[indices.get(i)] = letter.charAt(0);
      }
      playingPhrase = new String(charArray);
      if (!playingPhrase.contains("_")) {
        System.out.println("Congratulations, you won!");
        // award a prize here
      }
    }
  }
}

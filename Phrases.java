import java.util.ArrayList;

public class Phrases {
    public static String gamePhrase;
    public static String playingPhrase;
    public static ArrayList<Integer> indices;
  
    public static void setGamePhrase(String phrase) {
      gamePhrase = phrase;
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
  

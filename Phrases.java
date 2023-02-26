// Start of Phrases class
public class Phrases {

    // instance variables
    private static Object gamePhrase;
    private static String playingPhrase;

    // method to set the game phrase
    public static void setGamePhrase(Object object) {
        gamePhrase = object;
        // replaces all the letters in the phrase with underscores
        playingPhrase = ((String) gamePhrase).replaceAll("[a-zA-Z]", "_");
    }

    // method to set the secret phrase
    public static void setSecretPhrase(String secretPhrase) {
        setGamePhrase(secretPhrase);
    }

    // method to get the playing phrase
    public static String getPlayingPhrase() {
        return playingPhrase;
    }

    // method to find letters in the game phrase
    public static boolean findLetters(String letter) throws MultipleLettersException {
        // if statement to check if the letter is more than one character
        if (letter.length() != 1) {
            throw new MultipleLettersException();
        }
        boolean foundLetter = false;
        // for loop to find the letters in the phrase
        for (int i = 0; i < ((String) gamePhrase).length(); i++) {
            if (Character.toLowerCase(((String) gamePhrase).charAt(i)) == letter.charAt(0)) {
                playingPhrase = playingPhrase.substring(0, i) + ((String) gamePhrase).charAt(i) + playingPhrase.substring(i + 1);
                foundLetter = true;
            }
        }
        return foundLetter;
    }
}

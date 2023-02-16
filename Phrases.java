



// Start of Phrases class
public class Phrases {

    // instance variables
    private static String gamePhrase;
    private static String playingPhrase;


//Start of setGamePhrase method
    public static void setGamePhrase(String phrase) {
        gamePhrase = phrase;
        // replaces all the letters in the phrase with underscores
        playingPhrase = gamePhrase.replaceAll("[a-zA-Z]", "_");
    }
//Start of getPlayingPhrase method
    public static String getPlayingPhrase() {
        return playingPhrase;
    }

//Start of findLetters method
    public static boolean findLetters(String letter) throws MultipleLettersException {
        // if statement to check if the letter is more than one character
        if (letter.length() != 1) {
            throw new MultipleLettersException();
        }
        boolean foundLetter = false;
        // for loop to find the letters in the phrase
        for (int i = 0; i < gamePhrase.length(); i++) {
            if (Character.toLowerCase(gamePhrase.charAt(i)) == letter.charAt(0)) {
                playingPhrase = playingPhrase.substring(0, i) + gamePhrase.charAt(i) + playingPhrase.substring(i + 1);
                foundLetter = true;
            }
        }
        return foundLetter;


    }//End of findLetters method
}//End of Phrases class

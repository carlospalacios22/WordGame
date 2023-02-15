public class Phrases {
    private static String gamePhrase;
    private static String playingPhrase;

    public static void setGamePhrase(String phrase) {
        gamePhrase = phrase;
        playingPhrase = gamePhrase.replaceAll("[A-Za-z]", "_");
    }

    public static String getPlayingPhrase() {
        return playingPhrase;
    }

    public static void findLetters(String letter) throws MultipleLettersException {
        if (letter.length() > 1) {
            throw new MultipleLettersException();
        }
        for (int i = 0; i < gamePhrase.length(); i++) {
            if (gamePhrase.charAt(i) == letter.charAt(0)) {
                playingPhrase = playingPhrase.substring(0, i) + letter + playingPhrase.substring(i + 1);
            }
        }
        if (!playingPhrase.contains("_")) {
            System.out.println("Congratulations, you won!");
            // award prize
        }
    }
}

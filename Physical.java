

import java.util.Random;

import javax.swing.JOptionPane;

public class Physical implements Award {
    // Array of physical prizes
    private String[] prizes = {"A trip to Hawaii", "A brand new car", "A year's supply of chocolate", "A 65-inch TV", "A luxury cruise"};
    private final int PRIZE_INDEX;
    private static final int WINNINGS = 0;

    // Constructor to get a random prize
    public Physical() {
        Random rand = new Random();
        PRIZE_INDEX = rand.nextInt(prizes.length);
    }

    // Overridden method to display the winnings
    @Override
    public int displayWinnings(Players player, boolean isGuessCorrect) {
        if (isGuessCorrect) {
            // If the guess is correct, then display the "won prize"
            JOptionPane.showMessageDialog(null, "Congratulations " + player.getFirstName() + "! You won " + prizes[PRIZE_INDEX]);
        } else {
            // If the guess is incorrect, then display the "could have won prize"
            JOptionPane.showMessageDialog(null, "Unfortunately " + player.getFirstName() + ", you lost. You could have won " + prizes[PRIZE_INDEX]);
        }
        return WINNINGS;
    }
}

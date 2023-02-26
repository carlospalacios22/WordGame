




import javax.swing.JOptionPane;

public class Money implements Award {
    private final int INCREMENT_AMOUNT = 500;
    private final int DECREMENT_AMOUNT = 200;

    // Start of displayWinnings method
    @Override
    public int displayWinnings(Players player, boolean correctGuess) {
        if (correctGuess) {
            JOptionPane.showMessageDialog(null, player.getFirstName() + " won $" + INCREMENT_AMOUNT);
            player.addWinnings(INCREMENT_AMOUNT);
            return INCREMENT_AMOUNT;
        } else {
            JOptionPane.showMessageDialog(null, player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
            player.addLosses(DECREMENT_AMOUNT);
            return -DECREMENT_AMOUNT;
        }
    }// End of displayWinnings method
}// End of Money class

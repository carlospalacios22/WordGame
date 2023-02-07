public class Money implements Award {
    private int winAmount;
    private int loseAmount;

    public Money(int winAmount, int loseAmount) {
        this.winAmount = winAmount;
        this.loseAmount = loseAmount;
    }

    
    public int displayWinnings(Player player, boolean guessCorrect) {
        if (guessCorrect) {
            System.out.println(player.getFirstName() + " won " + winAmount + " dollars!");
            return winAmount;
        } else {
            System.out.println(player.getFirstName() + " lost " + loseAmount + " dollars.");
            return -loseAmount;
        }
    }
}

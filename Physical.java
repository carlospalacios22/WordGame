import java.util.Random;

public class Physical implements Award {
    private String[] physicalPrizes = {"Car", "Boat", "Vacation", "TV", "Phone"};
    
    public int getRandomPrize() {
        Random random = new Random();
        int index = random.nextInt(physicalPrizes.length);
        return index;
    }

    public int displayWinnings(Players player, boolean isCorrect) {
        if (isCorrect) {
            int prizeIndex = getRandomPrize();
            System.out.println(player.getFirstName() + " won " + physicalPrizes[prizeIndex]);
            return 0;
        } else {
            int prizeIndex = getRandomPrize();
            System.out.println(player.getFirstName() + " lost. They could have won " + physicalPrizes[prizeIndex]);
            return 0;
        }
    }// end of displayWinnings method

}// end of Physical class

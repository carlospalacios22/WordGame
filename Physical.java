

import java.util.Random;

public class Physical implements Award {
// Array of physical prizes
private String[] prizes = {"A trip to Hawaii", "A brand new car", "A year's supply of chocolate", "A 65-inch TV", "A luxury cruise"};
// Method to get a random prize
public int getRandomPrize() {
Random rand = new Random();

int randomIndex = rand.nextInt(prizes.length);
return randomIndex;
}

// Overde Method to display the winnings
@Override

public int displayWinnings(Players player, boolean isGuessCorrect) {
    // Get a random prize
int randomPrizeIndex = getRandomPrize();
if (isGuessCorrect) {
    // If the guess is correct, then display the "won prize"
System.out.println("Congratulations " + player.getFirstName() + "! You won " + prizes[randomPrizeIndex]);
return 0;
// If the guess is incorrect, then display the "could have won prize"
} else {
System.out.println("Unfortunately " + player.getFirstName() + ", you lost. You could have won " + prizes[randomPrizeIndex]);
return 0;
}// End of if-else

}// End of displayWinnings method
}// End of Physical class

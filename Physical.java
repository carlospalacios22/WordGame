

import java.util.Random;

public class Physical implements Award {
// Array of physical prizes
private String[] prizes = {"A trip to Hawaii", "A brand new car", "A year's supply of chocolate", "A 65-inch TV", "A luxury cruise"};

public int getRandomPrize() {
Random rand = new Random();
int randomIndex = rand.nextInt(prizes.length);
return randomIndex;
}

@Override
public int displayWinnings(Players player, boolean isGuessCorrect) {
int randomPrizeIndex = getRandomPrize();
if (isGuessCorrect) {
System.out.println("Congratulations " + player.getFirstName() + "! You won " + prizes[randomPrizeIndex]);
return 0;
} else {
System.out.println("Unfortunately " + player.getFirstName() + ", you lost. You could have won " + prizes[randomPrizeIndex]);
return 0;
}
}
}

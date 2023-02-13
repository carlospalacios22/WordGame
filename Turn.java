import java.util.Scanner;

public class Turn {
  public boolean takeTurn(Players player, Hosts host) {
    System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter your guess between 0 and 100: ");
    Scanner input = new Scanner(System.in);
    int guess = input.nextInt();
    boolean result = Numbers.compareNumber(guess);
    Money money = new Money();
    int winnings = money.displayWinnings(player, result);
    player.setMoney(player.getMoney() + winnings);
    System.out.println(player.toString());
    return result;
  }
}

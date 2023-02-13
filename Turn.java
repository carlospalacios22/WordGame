import java.util.Scanner;

public class Turn {
    private final int INCREMENT_AMOUNT = 500;
    private final int DECREMENT_AMOUNT = 200;
  
    public boolean takeTurn(Players player, Hosts host) {
      host.randomizeNum();
      Numbers numbers = new Numbers();
      System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter your guess between 0 and 100: ");
      Scanner input = new Scanner(System.in);
      int guess = input.nextInt();
      boolean result = numbers.compareNumber(guess);
      if (result) {
        player.setMoney(player.getMoney() + INCREMENT_AMOUNT);
        System.out.println("Congratulations! " + player.getFirstName() + " won $" + INCREMENT_AMOUNT);
        System.out.println(player.toString());
        return true;
      } else {
        player.setMoney(player.getMoney() - DECREMENT_AMOUNT);
        System.out.println(player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
        System.out.println(player.toString());
        return false;
      }
    }
  }
  

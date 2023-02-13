import java.util.Scanner;


//Beginning of the Turn class
public class Turn {
  //ammount of money the user will win or lose
    private final int INCREMENT_AMOUNT = 500;
    private final int DECREMENT_AMOUNT = 200;


  //beginning of takeTurn method
    public boolean takeTurn(Players player, Hosts host) {
      //creating a new Numbers object
      host.randomizeNum();
      Numbers numbers = new Numbers();
      //prompting the user to enter their guess
      System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter your guess between 0 and 100: ");
      Scanner input = new Scanner(System.in);
      //storing the user's guess
      int guess = input.nextInt();
      //calling the compareNumber method
      boolean result = numbers.compareNumber(guess);

      //if the user's guess is equal to the random number, then the user will win moeney
      if (result) {
        player.setMoney(player.getMoney() + INCREMENT_AMOUNT);
        //printing out the user's name and the amount of money they won
        System.out.println("Congratulations! " + player.getFirstName() + " won $" + INCREMENT_AMOUNT);
        //printing out the user's name and the amount of money they have
        System.out.println(player.toString());
        return true;

        //if the user's guess is not equal to the random number, then the user will lose money
      } else {
     
        player.setMoney(player.getMoney() - DECREMENT_AMOUNT);
        System.out.println(player.getFirstName() + " lost $" + DECREMENT_AMOUNT);
        System.out.println(player.toString());
        return false;
      }//end of if else


    }//end of takeTurn method
  }//end of Turn class
  

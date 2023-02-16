


import java.util.Scanner;


//Start of Turn class
public class Turn {
    //Start of takeTurn method
    public boolean takeTurn(Players player, Hosts host) {

        //Start of try/catch block
        System.out.println(host.getFirstName() + ": " + player.getFirstName() + ", please enter a letter:");
        Scanner input = new Scanner(System.in);
        String guess = input.nextLine();

        boolean foundLetter = false;
        try {
            
            foundLetter = Phrases.findLetters(guess);
        } catch (MultipleLettersException e) {
            System.out.println(e.getMessage());
        }

        if (foundLetter) {
            int winnings = new Money().displayWinnings(player, true);
            player.setMoney(player.getMoney() + winnings);
            System.out.println(player.toString());
        } else {
            System.out.println(Phrases.getPlayingPhrase());
        }
    
        if (Phrases.getPlayingPhrase().indexOf('_') == -1) {
            System.out.println("Congratulations, you won the game!");
            return true;
        } else {
            return false;


        }//End of if statement
    }//End of takeTurn method
}//End of Turn class

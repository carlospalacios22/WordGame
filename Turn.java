


//library
import javax.swing.*;

// Start of Turn class
public class Turn {
    
    private GUI gui;
    //  Turn constructor
    public Turn(GUI gui) {
        this.gui = gui;
    }

    // Start of takeTurn method
    public boolean takeTurn(Players player, Hosts host) {
        while (true) {
            // get the guess from the player
            String guess = JOptionPane.showInputDialog(gui, host.getFirstName() + ": " + player.getFirstName() + ", please enter a letter:");
            
            if (guess == null) {
                return false;
            }
    // check if the player entered a letter or return exception
            boolean foundLetter = false;
            try {
                foundLetter = Phrases.findLetters(guess);
            } catch (MultipleLettersException e) {
                JOptionPane.showMessageDialog(gui, e.getMessage());
            }
            // check if the player won
    
            if (foundLetter) {
                int winnings = new Money().displayWinnings(player, true);
                player.setMoney(player.getMoney() + winnings);
                JOptionPane.showMessageDialog(gui, player.toString());
            } else {
                // display the phrase with the letters guessed so far (bugged)
                JOptionPane.showMessageDialog(gui, Phrases.getPlayingPhrase());
                break;
            }
    // check if the players won 
            if (Phrases.getPlayingPhrase().indexOf('_') == -1) {
                JOptionPane.showMessageDialog(gui, "Congratulations, you won the game!");
                return true;
            }// end of if


        }// end of while loop
    
        return false;


    }// End of takeTurn method
    
    
}// End of Turn class

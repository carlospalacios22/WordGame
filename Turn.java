



import javax.swing.*;

public class Turn {
    
    private GUI gui;
    
    public Turn(GUI gui) {
        this.gui = gui;
    }

    public boolean takeTurn(Players player, Hosts host) {
        while (true) {
            String guess = JOptionPane.showInputDialog(gui, host.getFirstName() + ": " + player.getFirstName() + ", please enter a letter:");
            if (guess == null) {
                return false;
            }
    
            boolean foundLetter = false;
            try {
                foundLetter = Phrases.findLetters(guess);
            } catch (MultipleLettersException e) {
                JOptionPane.showMessageDialog(gui, e.getMessage());
            }
    
            if (foundLetter) {
                int winnings = new Money().displayWinnings(player, true);
                player.setMoney(player.getMoney() + winnings);
                JOptionPane.showMessageDialog(gui, player.toString());
            } else {
                JOptionPane.showMessageDialog(gui, Phrases.getPlayingPhrase());
                break;
            }
    
            if (Phrases.getPlayingPhrase().indexOf('_') == -1) {
                JOptionPane.showMessageDialog(gui, "Congratulations, you won the game!");
                return true;
            }
        }
    
        return false;
    }
    
    
}

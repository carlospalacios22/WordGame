
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    
    // instance variables
    private GamePlay game;
    private Hosts host;
    private Players[] players;
    private JLabel playersLabel;
    private JLabel hostLabel;
    private JLabel phraseLabel;
    
    // constructor
    public GUI() {
        // create the game, host, and players
        game = new GamePlay();
        host = new Hosts("Pennybags", "");
        players = new Players[3];
        
        // set up the main window
        setTitle("Word Guessing Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // create the UI components
        playersLabel = new JLabel("Players: None");
        hostLabel = new JLabel("Host: " + host.getFirstName());
        phraseLabel = new JLabel(Phrases.getPlayingPhrase());
        JButton addPlayerButton = new JButton("Add Player");
        JButton addHostButton = new JButton("Add Host");
        JButton startButton = new JButton("Start Game");
        
        // add the UI components to the window
        JPanel topPanel = new JPanel();
        topPanel.add(playersLabel);
        topPanel.add(addPlayerButton);
        topPanel.add(hostLabel);
        topPanel.add(addHostButton);
        add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel();
        centerPanel.add(phraseLabel);
        add(centerPanel, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // add event listeners to the buttons
        addPlayerButton.addActionListener(new AddPlayerListener());
        addHostButton.addActionListener(new AddHostListener());
        startButton.addActionListener(new StartGameListener());
    }
    
    // inner class to handle adding a new player
    private class AddPlayerListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // prompt the user to enter the player's name
            String name = JOptionPane.showInputDialog("Enter player name:");
            
            // create a new player with the entered name
            Players player = new Players(name);
            
            // add the player to the players array
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    break;
                }
            }
            
            // update the players label
            updatePlayersLabel();
        }
    }
    
    // inner class to handle adding a new host
    private class AddHostListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // prompt the user to enter the host's name
            String name = JOptionPane.showInputDialog("Enter host name:");
            
            // create a new host with the entered name
            host = new Hosts(name, "");
            
            // update the host label
            hostLabel.setText("Host: " + host.getFirstName());
        }
    }
    
    // inner class to handle starting the game
    private class StartGameListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // check if there are any players or a game phrase
            if (players[0] == null || Phrases.getPlayingPhrase().equals("")) {
                JOptionPane.showMessageDialog(null, "Error: No players or game phrase.");
                return;
            }
            
            // start the game
            boolean playAgain = true;
            while (playAgain) {
                int currentPlayerIndex = 0;
                while (!game.takeTurn(players[currentPlayerIndex % 3],host)) {
                    currentPlayerIndex++;
                }
                
                // show the result of the turn in a message dialog
                Players currentPlayer = players[currentPlayerIndex % 3];
                String message = "";
                int winnings = 0;
                if (Phrases.getPlayingPhrase().indexOf('_') == -1) {
                    message = "Congratulations, " + currentPlayer.getFirstName() + "! You won the game!";
                } else {
                    message = "Sorry, " + currentPlayer.getFirstName() + ", your guess was incorrect.";
                }
                winnings = currentPlayer.getMoney();
                JOptionPane.showMessageDialog(null, message + " Your current winnings: $" + winnings);
                
                // prompt the user to play again
                int playAgainChoice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                playAgain = (playAgainChoice == JOptionPane.YES_OPTION);
                
                if (playAgain) {
                    // reset the game and host
                    game = new GamePlay();
                    host.enterPhrase();
                    // clear the players array
                    players = new Players[3];
                    updatePlayersLabel();
                    // reset the phrase label
                    phraseLabel.setText(Phrases.getPlayingPhrase());
                }
            }
        }
    }
    
    // helper method to update the players label
    private void updatePlayersLabel() {
        String labelText = "Players:";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                labelText += " " + players[i].getFirstName();
            }
        }
        playersLabel.setText(labelText);
    }
    
    // main method to create and show the GUI
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}

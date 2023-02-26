
// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// Start of GUI class
public class GUI extends JFrame {

    // create an array of players 3 allowed players, no changes from branch 5
    private Players[] players = new Players[3];

    // create a host
    private Hosts host = new Hosts("Pennybags", "");
// JLabels for the players and host
    private JLabel playersLabel;
    private JLabel hostLabel;
    private JLabel phraseLabel;
    // buttons for adding a player and host
    private JButton addPlayerButton;
    private JButton addHostButton;
    private JButton startButton;
    
    public GUI() {

        // set the title of the window
        super("Word Guessing Game");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the window if not it will be too small
        setPreferredSize(new Dimension(500, 300));
        setLayout(new BorderLayout());
        
        // create a panel for the top section of the window
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        
        // create a label for the players
        playersLabel = new JLabel("Players:");
        topPanel.add(playersLabel);
        
        // create a label for the host
        hostLabel = new JLabel("Host: " + host.getFirstName());
        topPanel.add(hostLabel);
        // add the top panel to the window
        add(topPanel, BorderLayout.NORTH);
        
        // create a panel for the center section of the window
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        // create a label for the playing phrase
        phraseLabel = new JLabel(Phrases.getPlayingPhrase());
        centerPanel.add(phraseLabel);
        
        // create a button to start the game
        startButton = new JButton("Start Game");
        startButton.addActionListener(new StartButtonListener());
        centerPanel.add(startButton);
        // add the center panel to the window
        add(centerPanel, BorderLayout.CENTER);
        
        // create a panel for the bottom section of the window
        JPanel bottomPanel = new JPanel();
        
        // create a button to add a player
        addPlayerButton = new JButton("Add Player");
        addPlayerButton.addActionListener(new AddPlayerButtonListener());
        bottomPanel.add(addPlayerButton);
        
        // create a button to add a host
        addHostButton = new JButton("Add Host and Phrase");
        addHostButton.addActionListener(new AddHostButtonListener());
        bottomPanel.add(addHostButton);
        // add the bottom panel to the window
        add(bottomPanel, BorderLayout.SOUTH);
        // pack the window
        pack();
        // center the window
        setLocationRelativeTo(null);
    }
    
 // listener for the add player button
private class AddPlayerButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {


                // get the first name
                String firstName = JOptionPane.showInputDialog("Enter player " + (i + 1) + " first name:");

                // if the user clicks cancel, do nothing
                if (firstName != null && !firstName.trim().equals("")) {
                    String lastName = "";

                    // ask the user if they want to enter a last name
                    int option = JOptionPane.showConfirmDialog(GUI.this, "Do you want to enter a last name?", "Last Name", JOptionPane.YES_NO_OPTION);

                    // if the user clicks yes, get the last name
                    if (option == JOptionPane.YES_OPTION) {

                        // get the last name
                        lastName = JOptionPane.showInputDialog("Enter player " + (i + 1) + " last name:");
                        if (lastName == null) {
                            lastName = "";
                        }
                    }


                    // create a new player Array from Gameplay class moved here 
                    players[i] = new Players(firstName, lastName);
                    updatePlayersLabel();
                    break;

                }// 1st end of if


            }// 2nd end of if

        }// end of for loop

    }// end of actionPerformed method
}// end of AddPlayerButtonListener class

    
 // listener for the add host button
private class AddHostButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter host name:");
        if (name != null && !name.trim().equals("")) {
            String phrase = JOptionPane.showInputDialog("Enter a phrase for the players to guess:");
            if (phrase != null && !phrase.trim().equals("")) {
                host = new Hosts(name, "");
                Hosts.setGamePhrase(phrase);
                hostLabel.setText("Host: " + host.getFirstName());
            } else {
                JOptionPane.showMessageDialog(GUI.this, "Please enter a phrase for the players to guess.");


            }// end of if/else
        }// end  else "please enter a phrase"
    }// end of AddHostButtonListener class
}// end of AddHostButtonListener class

    
    // listener for the start game button
    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (Hosts.getGamePhrase() == null || ((String) Hosts.getGamePhrase()).trim().equals("")) {
                JOptionPane.showMessageDialog(GUI.this, "Please enter a game phrase.");
                return;
            }
    
            // Set the secret phrase for the players to guess
            Phrases.setGamePhrase(Hosts.getGamePhrase());
        // update the phrase label
            boolean hasPlayers = false;
            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    hasPlayers = true;
                    break;
                }
            }
            // check if there are any players
            if (!hasPlayers) {
                JOptionPane.showMessageDialog(GUI.this, "Please add at least one player.");
                return;
            }
    
            // start the game
            Turn turn = new Turn(null);
            int currentPlayerIndex = 0;
            while (!turn.takeTurn(players[currentPlayerIndex % 3], host)) {
                currentPlayerIndex++;
            }
            // ask the user if they want to play again
            int answer = JOptionPane.showConfirmDialog(GUI.this, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                // reset the game
                players = new Players[3];
                updatePlayersLabel();
                host = new Hosts(host.getFirstName(), "");
            // update the host label
                hostLabel.setText("Host: " + host.getFirstName());
                phraseLabel.setText(Phrases.getPlayingPhrase());
            } else {
                System.exit(0);

                
            }// end of if/else
        }// end of hasPlayers method
    }// end of StartButtonListener class
    
    //  method to update the players label
    private void updatePlayersLabel() {
        String playersText = "Players: ";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                playersText += players[i].getFirstName() + " - Current money: $" + players[i].getMoney() + " ";
            }
        }
        playersLabel.setText(playersText);


    }// end of updatePlayersLabel method
    
 

}// end of GUI class



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
    private JButton startButton;
    

    
    public GUI() {
  // set the title of the window
  super("Word Guessing Game");

// create the menu bar
JMenuBar menuBar = new JMenuBar();
setJMenuBar(menuBar);

// create the "Game" menu item
JMenu gameMenu = new JMenu("Game");
// add a mnemonic to the menu item (Alt-G)
gameMenu.setMnemonic(KeyEvent.VK_G);
menuBar.add(gameMenu);

// create the "New Game" menu item
JMenuItem newGameMenuItem = new JMenuItem("New Game"); 
// add a mnemonic to the menu item (Alt-N)
newGameMenuItem.setMnemonic(KeyEvent.VK_N);
gameMenu.add(newGameMenuItem);

// add an ActionListener to the "New Game" menu item
newGameMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // create a new instance of the GUI to start a new game
        GUI newGame = new GUI();
        newGame.setVisible(true);

        // dispose of the current game window
        dispose();
        
    }
    
});
        // create the "Add Player" menu item
        JMenuItem addPlayerMenuItem = new JMenuItem("Add Player");
        addPlayerMenuItem.setMnemonic(KeyEvent.VK_P);
        gameMenu.add(addPlayerMenuItem);
        addPlayerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < players.length; i++) {
                    if (players[i] == null) {
                        String firstName = JOptionPane.showInputDialog("Enter player " + (i + 1) + " first name:");
                        if (firstName != null && !firstName.trim().equals("")) {
                            String lastName = "";
                            int option = JOptionPane.showConfirmDialog(GUI.this, "Do you want to enter a last name?", "Last Name", JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                lastName = JOptionPane.showInputDialog("Enter player " + (i + 1) + " last name:");
                                if (lastName == null) {
                                    lastName = "";
                                }
                            }
                            players[i] = new Players(firstName, lastName);
                            updatePlayersLabel();
                            break;
                        }
                    }
                }
            }
        });

        // create the "Add Host" menu item
        JMenuItem addHostMenuItem = new JMenuItem("Add Host and Phrase");
        addHostMenuItem.setMnemonic(KeyEvent.VK_H);
        gameMenu.add(addHostMenuItem);
        addHostMenuItem.addActionListener(new ActionListener() {
            @Override
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
                    }
                }
            }
        });


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

        // pack the window
        pack();
        // center the window
        setLocationRelativeTo(null);
    }
    
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
        // create a string to hold the players
        String playersText = "Players: ";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                
                playersText += players[i].getFirstName() + " - Current money: $" + players[i].getMoney() + " ";
            }
        }
        playersLabel.setText(playersText);


    }// end of updatePlayersLabel method
    
 

}// end of GUI class

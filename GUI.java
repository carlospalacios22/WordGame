import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private Players[] players = new Players[3];
    private Hosts host = new Hosts("Pennybags", "");
    private JLabel playersLabel;
    private JLabel hostLabel;
    private JLabel phraseLabel;
    private JButton addPlayerButton;
    private JButton addHostButton;
    private JButton startButton;
    
    public GUI() {
        super("Word Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        add(centerPanel, BorderLayout.CENTER);
        
        // create a panel for the bottom section of the window
        JPanel bottomPanel = new JPanel();
        
        // create a button to add a player
        addPlayerButton = new JButton("Add Player");
        addPlayerButton.addActionListener(new AddPlayerButtonListener());
        bottomPanel.add(addPlayerButton);
        
        // create a button to add a host
        addHostButton = new JButton("Add Host");
        addHostButton.addActionListener(new AddHostButtonListener());
        bottomPanel.add(addHostButton);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    // listener for the add player button
    private class AddPlayerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    String name = JOptionPane.showInputDialog("Enter player " + (i + 1) + " name:");
                    if (name != null && !name.trim().equals("")) {
                        players[i] = new Players(name);
                        updatePlayersLabel();
                        break;
                    }
                }
            }
        }
    }
    
    // listener for the add host button
    private class AddHostButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Enter host name:");
            if (name != null && !name.trim().equals("")) {
                host = new Hosts(name, "");
                host.enterPhrase();
                hostLabel.setText("Host: " + host.getFirstName());
            }
        }
    }
    
    // listener for the start game button
    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (host.getGamePhrase() == null || ((String) host.getGamePhrase()).trim().equals("")) {
                JOptionPane.showMessageDialog(GUI.this, "Please enter a game phrase.");
                return;
            }
            
            boolean hasPlayers = false;
            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    hasPlayers = true;
                    break;
                }
            }
            if (!hasPlayers) {
                JOptionPane.showMessageDialog(GUI.this, "Please add at least one player.");
                return;
            }
            
            // start the game
            Turn turn = new Turn();
            int currentPlayerIndex = 0;
            while (!turn.takeTurn(players[currentPlayerIndex % 3], host)) {
                currentPlayerIndex++;
            }
            int answer = JOptionPane.showConfirmDialog(GUI.this, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                // reset the game
                players = new Players[3];
                updatePlayersLabel();
                host = new Hosts(host.getFirstName(), "");
                host.enterPhrase();
                hostLabel.setText("Host: " + host.getFirstName());
                phraseLabel.setText(Phrases.getPlayingPhrase());
            } else {
                System.exit(0);
            }
        }
    }
    
    // helper method to update the players label
    private void updatePlayersLabel() {
        String playersText = "Players: ";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                playersText += players[i].getFirstName() + " - Current money: $" + players[i].getMoney() + " ";
            }
        }
        playersLabel.setText(playersText);
    }
    
    // main method to start the application
    public static void main(String[] args) {
        // start the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}    

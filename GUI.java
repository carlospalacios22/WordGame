import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    
    private Players[] players = new Players[3];
    private Hosts host = new Hosts("","");
    private JLabel playersLabel;
    private JLabel hostLabel;
    private JLabel phraseLabel;
    private JButton startButton;
    
    public GUI() {
        super("Word Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set the size of the window if not it will be too small
        setPreferredSize(new Dimension(338, 263));
        setLayout(new BorderLayout());

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Create the "Game" menu
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        menuBar.add(gameMenu);
        
        // Create the "New Game" menu item
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.setMnemonic(KeyEvent.VK_N);
        gameMenu.add(newGameMenuItem);
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI newGame = new GUI();
                newGame.setVisible(true);
                dispose();
            }
        });
        
        // Create the "Add Player" menu item
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
        
        // Create the "Add Host" menu item
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
        
        // Create the top panel for the players and host
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        add(topPanel, BorderLayout.NORTH);
        
        playersLabel = new JLabel("Players:");
        topPanel.add(playersLabel);

    hostLabel = new JLabel("Host: " + host.getFirstName());
    topPanel.add(hostLabel);
    
    // Create the center panel for the phrase and start button
    JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    add(centerPanel, BorderLayout.CENTER);
    
    phraseLabel = new JLabel(Phrases.getPlayingPhrase(), SwingConstants.CENTER);
    centerPanel.add(phraseLabel);
    
    //Add the start button with different color and font 
    startButton = new JButton("Start Game");
    startButton.setFont(new Font("Arial", Font.BOLD, 18));
    startButton.setForeground(Color.BLUE);
    startButton.addActionListener(new StartButtonListener());
    centerPanel.add(startButton);
    
    
    // Create the bottom panel for the menu bar
    JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
    add(bottomPanel, BorderLayout.SOUTH);
    
    // Add the menu bar to the JFrame
    menuBar.add(gameMenu);
    
    // Set the size of the window and center it on the screen
    pack();
    setLocationRelativeTo(null);
}

private class StartButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (Hosts.getGamePhrase() == null || ((String) Hosts.getGamePhrase()).trim().equals("")) {
            JOptionPane.showMessageDialog(GUI.this, "Please enter a game phrase.");
            return;
        }
        
        Phrases.setGamePhrase(Hosts.getGamePhrase());
        
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
        
        Turn turn = new Turn(null);
        int currentPlayerIndex = 0;
        while (!turn.takeTurn(players[currentPlayerIndex % 3], host)) {
            currentPlayerIndex++;
        }
        
        int answer = JOptionPane.showConfirmDialog(GUI.this, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            players = new Players[3];
            updatePlayersLabel();
            host = new Hosts(host.getFirstName(), "");
            hostLabel.setText("Host: " + host.getFirstName());
            phraseLabel.setText(Phrases.getPlayingPhrase());
        } else {
            System.exit(0);
        }
    }
}

private void updatePlayersLabel() {
    String playersText = "Players: ";
    for (int i = 0; i < players.length; i++) {
        if (players[i] != null) {
            playersText += players[i].getFirstName() + " - Current money: $" + players[i].getMoney() + " ";
        }
    }
    playersLabel.setText(playersText);
}

}

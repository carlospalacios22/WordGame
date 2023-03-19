import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;


public class GUI extends JFrame {
    
    private Players[] players = new Players[3];
    private Hosts host = new Hosts("","");
    private JLabel playersLabel;
    private JLabel hostLabel;
    private JLabel phraseLabel;
    private JButton startButton;
    private JTextArea messageArea;
    private JScrollPane messageScrollPane;
    private JCheckBox saveMessagesCheckBox;
    private boolean saveMessages = false;
    private JLabel prizeLabel;
    private ImageIcon carIcon, chocolateIcon, cruisePrizeIcon, moneyIcon, tvPrizeIcon;
    private JLabel prizeImageLabel;
    

    public GUI() {

        
        super("Word Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // animates a image when the start button is pressed **NOT WORKING PROPERLY 
        RotatingImagePanel rotatingImagePanel = new RotatingImagePanel("images/questionmark.png");
        setContentPane(rotatingImagePanel);


        
        carIcon = new ImageIcon("images/car.jpg");
        chocolateIcon = new ImageIcon("images/chocolate.jpg");
        cruisePrizeIcon = new ImageIcon("images/cruiseprize.jpg");
        moneyIcon = new ImageIcon("images/money.jpg");
        tvPrizeIcon = new ImageIcon("images/tvprize.jpg");
        
        prizeImageLabel = new JLabel();
        prizeImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(prizeImageLabel, BorderLayout.SOUTH);
        
        prizeLabel = new JLabel();
        prizeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(prizeLabel, BorderLayout.SOUTH);
        

        // set the size of the window if not it will be too small
        setPreferredSize(new Dimension(388, 295));
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
            public void actionPerformed(ActionEvent newGamee) {
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
            public void actionPerformed(ActionEvent AddPlayer) {
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

            private void updatePlayersLabel() {
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

      // Create the "About" menu
JMenu aboutMenu = new JMenu("About");
aboutMenu.setMnemonic(KeyEvent.VK_A);
menuBar.add(aboutMenu);

// Create the "About" menu item
JMenuItem aboutMenuItem = new JMenuItem("About WordGame");
aboutMenuItem.setMnemonic(KeyEvent.VK_A);
aboutMenu.add(aboutMenuItem);
aboutMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent aBoutGame) {
        JOptionPane.showMessageDialog(GUI.this, "WordGame Version 0.001\n\n");
    }
});

// Create the "Layout" menu item
JMenuItem layoutMenuItem = new JMenuItem("Layout");
layoutMenuItem.setMnemonic(KeyEvent.VK_L);
aboutMenu.add(layoutMenuItem);
layoutMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(GUI.this, "This game was created using Java Swing.\n The layout is BorderLayout. This is to arrange the components in the GUI.\n A reason I used this layout is because the layouts provide a flexible platform\n for building GUI applications. Another good use of BorderLayout is that it\n makes everything simple to manage for example, by simply using\n south, north east and west and center. Code is also easier to put together and doesn't require anything complex. ");
    }
});
// Create the "Attribution" menu item
JMenuItem attributionMenuItem = new JMenuItem("Attribution");
attributionMenuItem.setMnemonic(KeyEvent.VK_T);
aboutMenu.add(attributionMenuItem);
attributionMenuItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent picLink) {
        // ADD the attribution text
        String attributionText = "<html>Image attributions:<br><br>" +
        "car.jpg - Source: <a href='images/car.jpg'>CAR</a><br>" +
        "chocolate.jpg - Source: <a href='images/chocolate.jpg'>Chocolate</a><br>" +
        "cruiseprize.jpg - Source: <a href='images/cruiseprize.jpg'>CruiseShip</a><br>" +
        "money.jpg - Source: <a href='images/money.jpg'>Money</a><br>" +
        "tvprize.jpg - Source: <a href='images/tvprize.jpg'>Tv 65 inch</a><br>" +
        "Sound attributions:<br><br>" +
        "background_music.wav - Source: <a href='sounds/background.wav'>Background Music</a></html>";
    
                // Create the JEditorPane for displaying the attribution text with clickable links
        JEditorPane jep = new JEditorPane("text/html", attributionText);
        jep.setEditable(false);
        jep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hyperLinks) {
                if (hyperLinks.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    String path = hyperLinks.getDescription();
        
                    if (path.equals("sounds/background.wav")) {
                        // Play the sound file, if it exists
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException soundPlay) {
                            soundPlay.printStackTrace();
                        }
                    } else {
                        File imageFile = new File(path);
                        if (imageFile.exists()) {
                            // Create a new JFrame to display the image
                            JFrame imageFrame = new JFrame("Image Viewer");
                            ImageIcon imageIcon = new ImageIcon(path);
                            JLabel imageLabel = new JLabel(imageIcon);
                            imageFrame.add(new JScrollPane(imageLabel));
                            imageFrame.pack();
                            imageFrame.setLocationRelativeTo(null);
                            imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            imageFrame.setVisible(true);
                        } else {
                            System.err.println("File not found: " + path);
                        }
                    }
                }
            }
        });

        // Add the JEditorPane to the JScrollPane
        JScrollPane scrollPane = new JScrollPane(jep);
        scrollPane.setPreferredSize(new Dimension(350, 220));

        // Display the JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "Attribution", JOptionPane.PLAIN_MESSAGE);
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

    // Add the message area and checkbox
    messageArea = new JTextArea();
    messageScrollPane = new JScrollPane(messageArea);
    add(messageScrollPane, BorderLayout.EAST);

    saveMessagesCheckBox = new JCheckBox("Save Messages");
    saveMessagesCheckBox.setToolTipText("Check this box to save messages between games.");
    saveMessagesCheckBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent SaveMsgs) {
            saveMessages = saveMessagesCheckBox.isSelected();
        }
    });
    centerPanel.add(saveMessagesCheckBox);

    // Add the start button
    startButton = new JButton("Start Game");
    startButton.setFont(new Font("Arial", Font.BOLD, 18));
    startButton.setForeground(Color.BLUE);
    startButton.addActionListener(new StartButtonListener(rotatingImagePanel));
    centerPanel.add(startButton);

    //Add a text box with scroll bars
    JTextArea resultArea = new JTextArea();
    resultArea.setEditable(false);
    resultArea.setLineWrap(true);
    resultArea.setWrapStyleWord(true);
    JScrollPane resultScrollPane = new JScrollPane(resultArea);
    resultScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, Integer.MAX_VALUE));
    resultScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
    add(resultScrollPane, BorderLayout.WEST);
    
    // Create the bottom panel for the menu bar
    JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
    add(bottomPanel, BorderLayout.SOUTH);

    // Add the menu bar to the JFrame
    menuBar.add(gameMenu);

    // Set the size of the window and center it on the screen
    pack();
    setLocationRelativeTo(null);
}// end of GUI constructor



public static void playBackgroundMusic(String filePath) {
    try {
        File audioFile = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music continuously

        // Prevent the program from closing before the audio is played
        Thread.sleep(10000);

    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException backGroundM) {
        backGroundM.printStackTrace();
    }
}

public class JFXPanel {

}


public class MediaPlayer {

    public static final String INDEFINITE = null;

    public void setCycleCount(String indefinite2) {
    }

    public void play() {
    }

}

//rotates the image to animate the background when the start button is pressed 
public class RotatingImagePanel extends JPanel {
    private Image backgroundImage;
    private double rotationAngle;

    public RotatingImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
        setRotationAngle(0);
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform transform = new AffineTransform();
        int x = (getWidth() - backgroundImage.getWidth(null)) / 2;
        int y = (getHeight() - backgroundImage.getHeight(null)) / 2;
        transform.translate(x, y);
        transform.rotate(Math.toRadians(rotationAngle), backgroundImage.getWidth(null) / 2, backgroundImage.getHeight(null) / 2);
        g2d.drawImage(backgroundImage, transform, null);
        g2d.dispose();
    }
}



private class StartButtonListener implements ActionListener {
    private Timer timer;
    private RotatingImagePanel rotatingImagePanel;

    public StartButtonListener(RotatingImagePanel rotatingImagePanel) {
        this.rotatingImagePanel = rotatingImagePanel;
        timer = new Timer(50, new ActionListener() {
            private double rotationAngle = 0;

            @Override
            public void actionPerformed(ActionEvent rottatimage) {
                rotationAngle += 1;
                if (rotationAngle >= 360) {
                    rotationAngle = 0;
                }
                rotatingImagePanel.setRotationAngle(rotationAngle);
            }
        });
    }

 

    public void actionPerformed(ActionEvent StartBTN) {


        playBackgroundMusic("sounds/background.wav");
        
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
            // Reset the game state
            players = new Players[3];
            updatePlayersLabel();
            host = new Hosts(host.getFirstName(), "");
            hostLabel.setText("Host: " + host.getFirstName());
            phraseLabel.setText(Phrases.getPlayingPhrase());

            if (!saveMessages) {
                messageArea.setText("");
            }
        } else {
            System.exit(0);
        }
        // When the correct word is guessed, update the prize image
            if (turn.takeTurn(players[currentPlayerIndex % 3], host)) {
                String gamePhrase = Phrases.getPlayingPhrase();
                updatePrizeImage(gamePhrase);
            }
 
        }
  // End of GUI class

//Method to update the prize image
    private void updatePrizeImage(String guessedWord) {
        if (guessedWord.equalsIgnoreCase("car")) {
            prizeImageLabel.setIcon(carIcon);
        } else if (guessedWord.equalsIgnoreCase("chocolate")) {
            prizeImageLabel.setIcon(chocolateIcon);
        } else if (guessedWord.equalsIgnoreCase("cruise")) {
            prizeImageLabel.setIcon(cruisePrizeIcon);
        } else if (guessedWord.equalsIgnoreCase("money")) {
            prizeImageLabel.setIcon(moneyIcon);
        } else if (guessedWord.equalsIgnoreCase("tv")) {
            prizeImageLabel.setIcon(tvPrizeIcon);
        } else {
            prizeImageLabel.setIcon(null);
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

}


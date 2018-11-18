import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuBar extends JFrame {       //contains the menu bar for instructions, starting, resetting, and quitting the game.
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu help;
    private JMenuItem newGame;
    private JMenuItem resetBoard;
    private JMenuItem quit;
    private JMenuItem instructions;
    private Font font = new Font("sans-serif", Font.PLAIN, 40);
    private Font font2 = new Font("sans-serif", Font.PLAIN, 35);

    public MenuBar(){
        super();
        setTitle("Sliding Puzzle");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //set window preferences
        JPanel panel = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(1000,1000);
            }};
        panel.setBackground(Color.white); //can be deleted or for future color changes
        add(panel);
        panel.setLayout(null);
        Icon startGame = new ImageIcon("C:/Users/Megan/Pictures/startButton.png");
        JButton playNow = new JButton(startGame);
        playNow.setBackground(Color.white);
        playNow.setBorderPainted(false);
        Icon title = new ImageIcon("C:/Users/Megan/Pictures/titlee.png");
        JLabel welcome = new JLabel(title);
        playNow.setBounds(350, 600, 312, 163);
        welcome.setBounds(new Rectangle(new Point(50,175), welcome.getPreferredSize()));
        panel.add(playNow);
        panel.add(welcome);
        pack();
        setVisible(true);
        setResizable(false);
        initializeMenuBar();
    }

    private void initializeMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        help = new JMenu("Help");

        //actions for menu items
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new game
            }});
        resetBoard = new JMenuItem("Reset Board");
        resetBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //reset board
            }});
        quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
        instructions = new JMenuItem("Instructions");
        instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String message = "The sliding tile puzzle challenges player's to slide the tiles into numeric order"
                        + " by shifting the shuffled tiles into place. Players are only allowed to move vertically"
                        + " or horizontally into the blank space.";
                final String html1 = "<html><body style='width: ";
                final String html2 = "px'>";
                JLabel label = new JLabel(html1 + "500" + html2 + message);
                label.setForeground(Color.black); //can be deleted or for future color changes
                label.setFont(font2);
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white); //can be deleted or for future color changes
                UI.put("Panel.background", Color.white); //can be deleted or for future color changes
                JOptionPane.showMessageDialog(null, label, "Instructions", JOptionPane.PLAIN_MESSAGE);
            }});
        //Set menu font
        newGame.setFont(font);
        resetBoard.setFont(font);
        quit.setFont(font);
        instructions.setFont(font);
        menu.setFont(font);
        help.setFont(font);

        //add items to menu
        menu.add(newGame);
        menu.add(resetBoard);
        menu.add(quit);
        help.add(instructions);
        menuBar.add(menu);
        menuBar.add(help);
        setJMenuBar(menuBar);
    }
}
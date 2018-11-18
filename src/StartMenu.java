import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

public class StartMenu extends JFrame{      //contains the pre-game starting display board.
    JPanel panel;
    GameWindow gw = new GameWindow();
    MenuBar mb = new MenuBar();

    public StartMenu(){
        super();

        setTitle("Sliding Puzzle");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel = new JPanel(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(1100,1100);
            }};
        panel.setBackground(Color.white); //can be deleted or for future color changes
        add(panel);
        panel.setLayout(null);
        setJMenuBar(mb.menuBar);

        try {
            //start game button
            Icon startGame = new ImageIcon(new URL("https://i.imgur.com/pdGD8Pa.png"));
            JButton playNow = new JButton(startGame);
            playNow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gw.setVisible(true);
                    setVisible(false);
                }});
            playNow.setBackground(Color.white);
            playNow.setBorderPainted(false);
            playNow.setBounds(400, 700, 307, 60);
            panel.add(playNow);
            //game title label
            Icon title = new ImageIcon(new URL("https://i.imgur.com/gwRUbpE.png"));
            JLabel welcome = new JLabel(title);
            welcome.setBounds(new Rectangle(new Point(50,200), welcome.getPreferredSize()));
            panel.add(welcome);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        pack();
        setVisible(true);
        setResizable(false);
    }
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameWindow extends JFrame {
    JButton[][] board;
    Container pane;
    MenuBar mb = new MenuBar();

    public GameWindow(){
        super();

        display();
        initializeBoard();
    }
    private void display(){
        pane = getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("Sliding Puzzle");
        setSize(1100,1100);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        board = new JButton[3][3];
        setJMenuBar(mb.menuBar);
    }
    void initializeBoard() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                btn.setBackground(Color.white);
                if (count <= 8) {
                    btn.setText(String.valueOf(count));
                } else {
                    btn.setBackground(Color.black);
                    btn.setText("");
                }
                board[i][j] = btn;
				/*btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getText().equals("")){
							//btn.setText(number);
						}
					}
				}); */
                pane.add(btn);
                count++;
            }
        }
    }
}
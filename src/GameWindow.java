import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GameWindow extends JFrame {        //contains the in-game puzzle board.
    JButton[][] board;
    Container pane;
    MenuBar mb = new MenuBar();
    ArrayList<Integer> reset; //keeps track of button order for board reset 
    Font font = new Font("sans-serif", Font.BOLD, 100);
    
    public GameWindow(){
        super();

        display();
        buttonSwap();
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


	public void buttonSwap() {
		int maxNum = 9;
		Integer currentNum = 0; //temp holds random number
		reset = new ArrayList<Integer>(); //keeps track of button order for board reset
		ArrayList<Integer> numbers = new ArrayList<Integer>(); //holds button values
		numbers.add(null);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				Random rand = new Random();
				int n = rand.nextInt(maxNum) + 0; //7 is max, 0 is min
				currentNum = numbers.get(n);
				reset.add(currentNum); //keeps track of button order for board reset
				numbers.remove(n);
				maxNum--;

				JButton btn = new JButton();
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
				if (currentNum == null) { //special format for blank tile
					btn.setBackground(Color.black);
					btn.setText("");

				} else {
					btn.setBackground(Color.white);
					btn.setText(String.valueOf(currentNum));
					btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {    //swaps the button clicked on with the null button
							JButton nullBtn = new JButton();

							nullBtn = getNullButton(board);
							if (checkNextTo(btn, nullBtn, board)) {    //if the button clicked on is vertically or horizontally next to the null button
								nullBtn.setBackground(btn.getBackground());        //set null button to the button clicked on
								nullBtn.setText(btn.getText());

								btn.setBackground(Color.black);        //sets the button clicked on to the new null button
								btn.setText("");
							}
							else { System.out.println("You can't swap these tiles."); }
						}
					});

				}

				board[i][j] = btn;
				pane.add(btn);
			}
		}
	}


	public Point getIndex(JButton btn, JButton[][] board) {		//returns the index of a given point
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if( board[i][j].equals(btn) ) {
					return new Point(i, j);
				}
			}
		}
		return null;
	}


	public boolean checkNextTo(JButton btn, JButton nullBtn, JButton[][] board) {    //checks if the button clicked on is vertically or horizontally next to the null button
		btnPoint = getIndex(btn,board);
		nullBtnPoint = getIndex(nullBtn,board);

		if ((btnPoint.equals(one)) && (nullBtnPoint.equals(two) || nullBtnPoint.equals(four))) {return true;}
		if ((btnPoint.equals(two)) && (nullBtnPoint.equals(one) || nullBtnPoint.equals(three) || nullBtnPoint.equals(five))) {return true;}
		if ((btnPoint.equals(three)) && (nullBtnPoint.equals(two) || nullBtnPoint.equals(six))) {return true;}
		if ((btnPoint.equals(four)) && (nullBtnPoint.equals(one) || nullBtnPoint.equals(five) || nullBtnPoint.equals(seven))) {return true;}
		if ((btnPoint.equals(five)) && (nullBtnPoint.equals(two) || nullBtnPoint.equals(four) || nullBtnPoint.equals(six) || nullBtnPoint.equals(eight))) {return true;}
		if ((btnPoint.equals(six)) && (nullBtnPoint.equals(three) || nullBtnPoint.equals(five) || nullBtnPoint.equals(nine))) {return true;}
		if ((btnPoint.equals(seven)) && (nullBtnPoint.equals(four) || nullBtnPoint.equals(eight))) {return true;}
		if ((btnPoint.equals(eight)) && (nullBtnPoint.equals(five) || nullBtnPoint.equals(seven)|| nullBtnPoint.equals(nine))) {return true;}
		if ((btnPoint.equals(nine)) && (nullBtnPoint.equals(six) || nullBtnPoint.equals(eight))) {return true;}

		else {return false;}
	}

	public JButton getNullButton(JButton[][] board) {
		JButton theNullBtn = new JButton();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getText() == ("")) {
					theNullBtn = board[i][j];
				}
			}
		}
		return theNullBtn;
	}
}
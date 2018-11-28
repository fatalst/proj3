import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

// images for game are downloaded during runtime. Program runs faster when images are downloaded first and saved as a file
// i.e:
// File f = new file("filepath")
// bimg =  ImageIO.read(f);


public class GameWindow extends JFrame {        //contains the in-game puzzle board.
    JButton[][] board;
    Container pane;
    MenuBar mb = new MenuBar();
    ArrayList<Integer> reset; //keeps track of button order for board reset
    Font font = new Font("sans-serif", Font.BOLD, 100);

    private Point btnPoint;
    private Point nullBtnPoint;
    private Point one = new Point(0,0);
    private Point two = new Point(0,1);
    private Point three = new Point(0,2);
    private Point four = new Point(1,0);
    private Point five = new Point(1,1);
    private Point six = new Point(1,2);
    private Point seven = new Point(2,0);
    private Point eight = new Point(2,1);
    private Point nine = new Point(2,2);

    public GameWindow() {
        super();
        display();
        buttonSwap();
    }

    private void display() {
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Sliding Puzzle");
        setSize(1100, 1100);
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
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(null);
        int num = 10;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                Random rand = new Random();
                int n = rand.nextInt(maxNum) + 0; //7 is max, 0 is min
                currentNum = numbers.get(n);
                reset.add(currentNum); //keeps track of button order for board reset
                numbers.remove(n);
                maxNum--;

                BufferedImage[][] ImageArr = new BufferedImage[3][3];
                ImageArr = imageDivide(ImageArr);
                ImageIcon img = new ImageIcon(ImageArr[i][j]);
                btn.setIcon(getScaledImage(img));
                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                if (currentNum == null) { //special format for blank tile
                    btn.setBackground(Color.black);
                    btn.setName("");
                    btn.setIcon(null);
                } else {
                    btn.setBackground(Color.white);
                    btn.setName(String.valueOf(currentNum));
                }
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {    //swaps the button clicked on with the null button
                        JButton nullBtn = new JButton();
                        nullBtn = getNullButton(board);

                        if (checkNextTo(btn, nullBtn, board)) {    //if the button clicked on is vertically or horizontally next to the null button
                            nullBtn.setBackground(btn.getBackground());        //set null button to the button clicked on
                            nullBtn.setName(btn.getName());
                            nullBtn.setIcon(btn.getIcon());

                            btn.setBackground(Color.black);        //sets the button clicked on to the new null button
                            btn.setName("");
                            btn.setIcon(null);
                        } else {
                            System.out.println("You can't swap these tiles.");
                        }
                        //Checks for winning board
                        gameOver(); 
						if(gameOver){
							System.out.println("You've completed the puzzle!");
						    //close the game window 
						}
                    }
                });

                board[i][j] = btn;
                pane.add(btn);
                System.out.println("Loading................................ "  + num + "%");
                num = num + 10;
            }
        }
        System.out.println("Loading................................ 100%");
    }

    public BufferedImage[][] imageDivide(BufferedImage[][] imgs) {      //crops photo into nine parts
        BufferedImage[][] images = new BufferedImage[3][3];

        //initializations required prior to try-catch
        int x = 1;  // = x-coordinate of upper left corner of square
        int y = 1;  // = y-coordinate of upper left corner of square
        int subW = 1;
        int subH = 1;
        int rW = 1;
        int rH = 1;

        BufferedImage bimg = null;
        URL url = null;

        try {       //loads image during runtime - "loading" is printed in console to display status of image stream
            //url = new URL("http://www.papertraildesign.com/wp-content/uploads/2017/06/emoji-sunglasses.png");       //sunglasses smiley face
            url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWOi91m_B4JhbQnDbkX_iWd_YfuNK4NPHqxQYWdmbe09LiEIgG");    //beach ball
            //url = new URL("https://image.shutterstock.com/z/stock-vector-high-saturation-colored-hologram-sticker-326338961.jpg");    //rainbow metal
            //url = new URL("https://cdn.pixabay.com/photo/2015/10/21/02/16/rainbow-background-998740_960_720.jpg");      //rainbow abstract

            bimg =  ImageIO.read(url);
            rW = ImageIO.read(url).getWidth() % 3 / 3;  //remainder
            rH = ImageIO.read(url).getHeight() % 3 / 3; //remainder
            subW = ImageIO.read(url).getWidth() / 3 + rW;
            subH = ImageIO.read(url).getHeight() / 3 + rH;

        } catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        //break up bimg into 9 [almost] equal parts
        images[0][0] = bimg.getSubimage(x, y, subW, subH);
        images[0][1] = bimg.getSubimage(subW, y, subW, subH);
        images[0][2] = bimg.getSubimage(subW * 2 , y, subW, subH);
        images[1][0] = bimg.getSubimage(x, subH, subW, subH);
        images[1][1] = bimg.getSubimage(subW, subH, subW, subH);
        images[1][2] = bimg.getSubimage(subW * 2, subH, subW, subH);
        images[2][0] = bimg.getSubimage(x, subH * 2, subW, subH);
        images[2][1] = bimg.getSubimage(subW, subH * 2, subW, subH);
        images[2][2] = bimg.getSubimage(subW * 2, subH * 2, subW, subH);
        return images;      //returns array of BufferedImages
    }

    public ImageIcon getScaledImage(ImageIcon img) {        //scales subImage to equal size of JButton
        ImageIcon scaledImage = img;
        Image image = img.getImage(); // transform to img Image object
        Image newImage = image.getScaledInstance(366, 366,  java.awt.Image.SCALE_SMOOTH); // scale to match size of JButton (Container height (1100) and width (1100) divided by 3 (=366x366))
        scaledImage = new ImageIcon(newImage);  // transform back to ImageIcon object
        return scaledImage;
    }

    public Point getIndex(JButton btn, JButton[][] board) { 		//returns the index of a given point
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if( board[i][j].equals(btn) ) {
                    return new Point(i, j); } } }
        return null;
    }

    public boolean checkNextTo(JButton btn, JButton nullBtn, JButton[][] board) {    //checks if the button clicked on is vertically or horizontally next to the null button
        btnPoint = getIndex(btn, board);
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
                if (board[i][j].getName() == ("")) {
                    theNullBtn = board[i][j]; } } }
        return theNullBtn;
    }
    
    public boolean gameOver(){
		if(board[0][0].getText() == ("1") && board[0][1].getText() == ("2") && board[0][2].getText() == ("3")
		   && board[1][0].getText() == ("4") && board[1][1].getText() == ("5") && board[1][2].getText() == ("6")
		   && board[2][0].getText() == ("7") && board[2][1].getText() == ("8") && board[2][2].getText() == ("")){
				gameOver = true;}
		
		return gameOver; 
	}
}
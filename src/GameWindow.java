package src.main;

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
import java.io.File;

import java.util.Random;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.awt.List;



// images for game are downloaded during runtime. Program runs faster when images are downloaded first and saved as a file
// i.e:
// File f = new file("filepath")
// bimg =  ImageIO.read(f);


public class GameWindow extends JFrame {        //contains the in-game puzzle board.
    JButton[][] board;
    Container pane;
    MenuBar mb = new MenuBar();
    ArrayList<Integer> reset; //keeps track of button order for board reset
    JButton[][] resetBoard = new JButton[3][3];
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

        ArrayList<BufferedImage> ImageList = imageDivide(); // divides image and puts it into a liner ArrayList
        ArrayList<JButton> ButtonList = new ArrayList<JButton>();
        int currentIndex = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                Random rand = new Random();
                int n = rand.nextInt(maxNum) + 0; //7 is max, 0 is min
                currentNum = numbers.get(n);
                reset.add(currentNum); //keeps track of button order for board reset
                numbers.remove(n);
                maxNum--;

                ImageIcon img = new ImageIcon(ImageList.get(currentIndex));
                currentIndex++;
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
                        if(gameOver()){
                            System.out.println("You've completed the puzzle!");
                            System.exit(0);
                            //close the game window
                        }
                    }
                });

                ButtonList.add(btn);
                System.out.println("Loading................................ "  + num + "%");
                num = num + 10;
            }
        }
        board = shuffle(ButtonList); // shuffles images then puts it in a 2d array
        System.out.println("Loading................................ 100%");
    }

    public ArrayList<BufferedImage> imageDivide() {      //crops photo into nine parts
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

        //initializations required prior to try-catch
        int x = 1;  // = x-coordinate of upper left corner of square
        int y = 1;  // = y-coordinate of upper left corner of square
        int subW = 1;
        int subH = 1;
        int rW = 1;
        int rH = 1;

        BufferedImage bimg = null;
        File file = null;

        try {       //loads image during runtime - "loading" is printed in console to display status of image stream
            file = randomFile();

            bimg =  ImageIO.read(file);
            rW = ImageIO.read(file).getWidth() % 3 / 3;  //remainder
            rH = ImageIO.read(file).getHeight() % 3 / 3; //remainder
            subW = ImageIO.read(file).getWidth() / 3 + rW;
            subH = ImageIO.read(file).getHeight() / 3 + rH;

        } catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        //break up bimg into 9 [almost] equal parts
        images.add(bimg.getSubimage(x, y, subW, subH));
        images.add(bimg.getSubimage(subW, y, subW, subH));
        images.add(bimg.getSubimage(subW * 2 , y, subW, subH));
        images.add(bimg.getSubimage(x, subH, subW, subH));
        images.add(bimg.getSubimage(subW, subH, subW, subH));
        images.add(bimg.getSubimage(subW * 2, subH, subW, subH));
        images.add(bimg.getSubimage(x, subH * 2, subW, subH));
        images.add(bimg.getSubimage(subW, subH * 2, subW, subH));
        images.add(bimg.getSubimage(subW * 2, subH * 2, subW, subH));
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
        boolean gameOver = false;
        if(board[0][0].getName() == ("1") && board[0][1].getName() == ("2") && board[0][2].getName() == ("3")
                && board[1][0].getName() == ("4") && board[1][1].getName() == ("5") && board[1][2].getName() == ("6")
                && board[2][0].getName() == ("7") && board[2][1].getName() == ("8") && board[2][2].getName() == ("")){
            gameOver = true;}
        return gameOver;
    }

    public JButton[][] shuffle(ArrayList<JButton> btns){ // shuffles the images
        Collections.shuffle(btns);

        JButton[][] buttonArray = new JButton[3][3];

        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            buttonArray[i][j] = btns.get(j + i * 3);
            pane.add(buttonArray[i][j]);
          }
        }

        for(int i = 0; i < buttonArray.length; i++){
          JButton[] aItem = buttonArray[i];
          int aLength = aItem.length;
          resetBoard[i] = new JButton[aLength];
          System.arraycopy(aItem, 0, resetBoard[i], 0, aLength);
        }

        return buttonArray;
    }

    public File randomFile(){
        Random rdm = new Random();
        return new File("assets/" + Integer.toString(rdm.nextInt(4) + 1) + ".jpg");
    }
}
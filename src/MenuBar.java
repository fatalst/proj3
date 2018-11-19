import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuBar extends JFrame{	//contains the menu bar for instructions, starting, resetting, and quitting the game.
	JMenuBar menuBar;
	private JMenu menu;
    private JMenu help;
    private JMenuItem newGame;
    private JMenuItem resetBoard;
    private JMenuItem quit;
    private JMenuItem instructions;
    private Font font = new Font("sans-serif", Font.PLAIN, 40); 
    
    public MenuBar(){
    	super(); 
    	
    	NewGame(); 
    	ResetBoard(); 
    	Quit(); 
    	Instructions(); 
    	
    	menu = new JMenu("Menu");
    	menu.setFont(font);
    	menu.add(newGame);
        menu.add(resetBoard);
        menu.add(quit);
    	
    	help = new JMenu("Help"); 
    	help.setFont(font); 
    	help.add(instructions);
    	
    	menuBar = new JMenuBar();
    	menuBar.add(menu);
        menuBar.add(help);
    }
    
    public void NewGame(){
    	newGame = new JMenuItem("New Game");
    	newGame.setFont(font);
    	
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				StartMenu sm = new StartMenu();
				GameWindow gw = new GameWindow(); 
            	sm.setVisible(false);
            	gw.setVisible(true);
            }});
    }
    
    public void ResetBoard(){ 
    	resetBoard = new JMenuItem("Reset Board");
    	resetBoard.setFont(font);
    	
        resetBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	GameWindow gw = new GameWindow(); 
            	Integer temp = 0;
                for(int i = 0; i < 3; i++){
                	for(int j = 0; j < 3; j++){
                		for(int k = 0; k < gw.reset.size(); k++){
                			temp = gw.reset.get(k); 
                			JButton btn = new JButton(); 
                			btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                			if(temp == null){
                				btn.setBackground(Color.black);
                				btn.setText("");
                			}else {
                				btn.setBackground(Color.WHITE);
                				btn.setText(String.valueOf(temp));
                			}
                			gw.board[i][j] = btn;
                			gw.pane.add(btn); 
                		}
                	}
                }
            }});
    }
    
    public void Quit(){
    	quit = new JMenuItem("Quit");
    	quit.setFont(font);
    	
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
    }
    
    public void Instructions(){
    	instructions = new JMenuItem("Instructions");
    	instructions.setFont(font);
    	
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
                label.setFont(font);
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white); //can be deleted or for future color changes
                UI.put("Panel.background", Color.white); //can be deleted or for future color changes
                JOptionPane.showMessageDialog(null, label, "Instructions", JOptionPane.PLAIN_MESSAGE);
            }});
    }
}

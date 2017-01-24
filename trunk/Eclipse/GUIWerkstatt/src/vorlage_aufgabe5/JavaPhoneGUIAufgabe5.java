package vorlage_aufgabe5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class implements a simple phone GUI. When creating a new object of this
 * class the GUI components, such as buttons, labels, etc. are displayed and
 * react on user actions, such as pressing a button.
 * 
 * @author H. Diethelm HTA Luzern, Christian Heldstab ZbW
 * @version 1.1 12.10.2006
 */
public class JavaPhoneGUIAufgabe5{
	
	// Main frame
	private JFrame mainFrame;
	
  	// Declare key buttons
	private JButton key1;
	private JButton key2;
	private JButton key3;
	private JButton key4;
	private JButton key5;
	private JButton key6;
	private JButton key7;
	private JButton key8;
	private JButton key9;
	private JButton key0;
	private JButton keyStar;
	private JButton keyHash;
  
  	// Declare other GUI elements
	private JTextField display;
	private JButton hook;
	private JLabel state;
  	
  	// Declare panels
	private JPanel keyPanel;
	private JPanel keyDisplayPanel;
	private JPanel hookStatePanel;
  	
  	public JavaPhoneGUIAufgabe5() {
  		// Main frame
  		mainFrame = new JFrame("Java Phone");
  		
  		// Create key buttons
  	  	key1 = new JButton("1");
  	  	key2 = new JButton("2");
  	  	key3 = new JButton("3");
  	  	key4 = new JButton("4");
  	  	key5 = new JButton("5");
  	  	key6 = new JButton("6");
  	  	key7 = new JButton("7");
  	  	key8 = new JButton("8");
  	  	key9 = new JButton("9");
  	  	key0 = new JButton("0");
  	  	keyStar = new JButton("*");
  	  	keyHash = new JButton("#");
  	  
  	  	// Create other GUI elements
  	  	display = new JTextField();
  	  	hook = new JButton("Hook off");
  	  	state = new JLabel("ready");
  	  	
  	  	// Create panels
  	  	keyPanel        = new JPanel();
  	  	keyDisplayPanel = new JPanel();
  	  	hookStatePanel  = new JPanel();
  	}
  	
  	// Assembles and displays the GUI.
  	public void paint(){
    	// Initialise frame and GUI elements
    	mainFrame.setBackground(Color.lightGray);
    	mainFrame.setResizable(false);
    	// Exit Application while pressing close-Box
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	display.setEditable(false);
    
    	// Set layout of all panels and frame
    	keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
    	keyDisplayPanel.setLayout(new BorderLayout(20, 20));
    	hookStatePanel.setLayout(new BorderLayout(20, 20));
    	mainFrame.setLayout(new BorderLayout(20, 20));
    	
   
    	// Add key buttons to key panel
    	keyPanel.add(key1);
    	keyPanel.add(key2);
    	keyPanel.add(key3);
    	keyPanel.add(key4);
    	keyPanel.add(key5);
    	keyPanel.add(key6);
    	keyPanel.add(key7);
    	keyPanel.add(key8);
    	keyPanel.add(key9);
    	keyPanel.add(keyHash);
    	keyPanel.add(key0);
    	keyPanel.add(keyStar);

	    // Assemble key/display panel
	    keyDisplayPanel.add(display, BorderLayout.NORTH);
	    keyDisplayPanel.add(keyPanel, BorderLayout.CENTER);
    
	    // Assemble hook/state panel
	    hookStatePanel.add(state, BorderLayout.NORTH);
	    hookStatePanel.add(hook, BorderLayout.CENTER);

	    // Add key/display panel and hook/state panel to frame
	    mainFrame.add(hookStatePanel, BorderLayout.WEST);
	    mainFrame.add(keyDisplayPanel, BorderLayout.CENTER);
	    mainFrame.setSize(300, 300);
	    mainFrame.setVisible(true);
  	}
  	
  	/**
	 * Inner class: Declare listener class for hook button
	 */
	class HookListener implements ActionListener {
	    // Is called when hook button is pressed
		public void actionPerformed(ActionEvent e) {
			// Change state label and hook button label
			if (e.getActionCommand().equals("Hook off")) {
				// Set label of hook button to "Hook on"
				// Set state label to "connected")
				hook.setText("Hook on");
				state.setText("connected");
			} else {
				// Set label of hook button to "Hook off"
				// Set state label to "ready"
				// Delete number in display text field
				// ...
			}
		}
	}
  
	
	// Declare listener class for key buttons
	// ...
  	
  	
  	/**
  	 * Main method to start the application
  	 */
	public static void main(String[] args) {
		JavaPhoneGUIAufgabe5 gui = new JavaPhoneGUIAufgabe5();
		gui.paint();
	}  	
}
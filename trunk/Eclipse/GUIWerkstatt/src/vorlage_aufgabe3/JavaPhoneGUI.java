package vorlage_aufgabe3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
 * class the GUI components, such as buttons, labels, etc. are just displayed.
 * They do not yet react on user actions, such as pressing a button, etc.
 * 
 * @author H. Diethelm HTA Luzern
 * @version 1.6 12.10.2016, AP
 */
public class JavaPhoneGUI{
	
	Font myPlainFont = new Font("Arial", Font.PLAIN, 30);
	Font myBoldFont = new Font("Arial", Font.BOLD, 30);

	// Main Frame
	private JFrame mainFrame;
	
	// Declare and create key buttons
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
	private JButton keyPound;
	private JButton keyHook;
	// ...

	// Declare and create other GUI elements
	private JTextField display;
	private JLabel status;
	// ...

	// Declare and create panels
	private JPanel displayPanel;
	private JPanel keyPanel;
	private JPanel keyDisplayPanel;
	private JPanel statusPanel;
	private JPanel hookPanel;
	// ...
	
	public JavaPhoneGUI() {
		this.mainFrame = new JFrame("Java Phone");
		
		// Declare and create key buttons
		this.key1 = new JButton("1");
		this.key2 = new JButton("2");
		this.key3 = new JButton("3");
		this.key4 = new JButton("4");
		this.key5 = new JButton("5");
		this.key6 = new JButton("6");
		this.key7 = new JButton("7");
		this.key8 = new JButton("8");
		this.key9 = new JButton("9");
		this.key0 = new JButton("0");
		this.keyStar = new JButton("*");
		this.keyPound = new JButton("#");
		this.keyHook = new JButton("Hook off");
		
		
		// addListeners
		this.key1.addActionListener(new KeyListener());
		this.key2.addActionListener(new KeyListener());
		this.key3.addActionListener(new KeyListener());
		this.key4.addActionListener(new KeyListener());
		this.key5.addActionListener(new KeyListener());
		this.key6.addActionListener(new KeyListener());
		this.key7.addActionListener(new KeyListener());
		this.key8.addActionListener(new KeyListener());
		this.key9.addActionListener(new KeyListener());
		this.key0.addActionListener(new KeyListener());
		this.keyStar.addActionListener(new KeyListener());
		this.keyPound.addActionListener(new KeyListener());
		this.keyHook.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					display.setText("");
					mainFrame.setVisible(false);
					mainFrame.dispose();
					System.exit(0);
				}
			});

		// Declare and create other GUI elements
		
		this.display = new JTextField("");
		this.display.setFont(myPlainFont);
		this.display.setForeground(Color.BLUE);
		this.status = new JLabel("ready");
		this.status.setFont(myBoldFont);
		this.status.setForeground(Color.GREEN);
		// ...

		// Declare and create panels
		this.keyPanel = new JPanel();
		this.keyDisplayPanel = new JPanel();
		this.statusPanel = new JPanel();
		this.hookPanel = new JPanel();
		this.displayPanel = new JPanel();
		// ...
	}


	// paints the frame and all widgets on it
	public void paint() {
		// Initialise frame and GUI elements
		mainFrame.setBackground(Color.lightGray);
		mainFrame.setResizable(false);
		display.setEditable(false);

		// Set layout of all panels and frames
		keyPanel.setLayout(new GridLayout(4, 3, 20, 20));
		keyDisplayPanel.setLayout(new BorderLayout(20, 20));
		hookPanel.setLayout(new BorderLayout(20,20));
		mainFrame.setLayout(new BorderLayout(20, 20));
		displayPanel.setLayout(new BorderLayout(20,20));
		statusPanel.setLayout(new BorderLayout(20,20));

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
		keyPanel.add(key0);
		keyPanel.add(keyStar);
		keyPanel.add(keyPound);
		hookPanel.add(keyHook, BorderLayout.CENTER);
		
		//Set Font of Keys
		key1.setFont(myBoldFont);
		key2.setFont(myBoldFont);
		key3.setFont(myBoldFont);
		key4.setFont(myBoldFont);
		key5.setFont(myBoldFont);
		key6.setFont(myBoldFont);
		key7.setFont(myBoldFont);
		key8.setFont(myBoldFont);
		key9.setFont(myBoldFont);
		key0.setFont(myBoldFont);
		keyStar.setFont(myBoldFont);
		keyPound.setFont(myBoldFont);
		keyHook.setFont(myBoldFont);
		
		//Add Display und Label
		keyDisplayPanel.add(display, BorderLayout.CENTER);
		statusPanel.add(status, BorderLayout.CENTER);

		// Assemble panels
		displayPanel.add(statusPanel, BorderLayout.WEST);
		displayPanel.add(keyDisplayPanel, BorderLayout.CENTER);
		mainFrame.add(displayPanel, BorderLayout.NORTH);
		mainFrame.add(keyPanel, BorderLayout.CENTER);
		mainFrame.add(hookPanel, BorderLayout.WEST);


		// Add key/display panel and hook/state panel to frame
		mainFrame.setSize(600, 600);
		mainFrame.setVisible(true);
		
		//Close on x
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class KeyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String ziffer = e.getActionCommand();
			display.setText(display.getText() + ziffer);
		}
	}
	
	class HookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			display.setText("");
			mainFrame.setVisible(false);
			mainFrame.dispose();
			System.exit(0);
		}
	}

	/**
	 * Main method to start the application
	 */
	public static void main(String[] args) {
		JavaPhoneGUI gui = new JavaPhoneGUI();
		gui.paint();
	}
}
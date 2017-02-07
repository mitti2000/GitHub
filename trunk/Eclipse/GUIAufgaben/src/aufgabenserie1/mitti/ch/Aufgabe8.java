package aufgabenserie1.mitti.ch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Aufgabe8 extends JFrame implements ActionListener {
	private JButton[] buttons;
	
	public Aufgabe8(){
		super("Aufgabe 8");
		initComponents();
		bindListener();
		initGui();
	}

	private void initComponents(){
		buttons = new MyButton[5];
		for(int i=0; i<5; i++){
			buttons[i] = new MyButton("Button " + (i+1));
		}
	}
	
	private void initGui(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(10,10));
		mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		setLayout(new FlowLayout());
		setSize(800,800);
		mainPanel.add(buttons[0], BorderLayout.NORTH);
		mainPanel.add(buttons[1], BorderLayout.EAST);
		mainPanel.add(buttons[2], BorderLayout.SOUTH);
		mainPanel.add(buttons[3], BorderLayout.WEST);
		mainPanel.add(buttons[4], BorderLayout.CENTER);
		
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void bindListener(){
		for(MyButton button : buttons){
			button.addActionListener(this);
		}
	}
	
	public static void main(String[] args){
		Aufgabe8 a1 = new Aufgabe8();
	}
	
	public void actionPerformed(ActionEvent e){
		MyButton button = (MyButton) e.getSource();
		button.count();
		System.out.println("Der Button mit der Bezeichnung '" + button.getText() 
			+ "' wurde schon " + button.getCount() + " gedr�ckt.");
		//button.setEnabled(false);
		//alleGedrueckt();
	}
	
	/*public void alleGedrueckt(){
		int zaehler = 0;
		for(JButton button : buttons){
			if(!button.isEnabled()) zaehler++;
		}
		
		if (zaehler>=5) System.exit(0);
	}*/

}

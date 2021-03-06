package aufgabenserie1.mitti.ch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Aufgabe7 extends JFrame implements ActionListener {
	private JButton[] buttons;
	
	public Aufgabe7(){
		super("Aufgabe 1");
		initComponents();
		bindListener();
		initGui();
	}

	private void initComponents(){
		buttons = new JButton[5];
		for(int i=0; i<5; i++){
			buttons[i] = new JButton("Button " + i);
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
		for(JButton button : buttons){
			button.addActionListener(this);
		}
	}
	
	public static void main(String[] args){
		Aufgabe7 a1 = new Aufgabe7();
	}
	
	public void actionPerformed(ActionEvent e){
		JButton button = (JButton) e.getSource();
		System.out.println("Es wurde '" + button.getText()  + " gedr�ckt.");
		button.setEnabled(false);
		alleGedrueckt();
	}
	
	public void alleGedrueckt(){
		int zaehler = 0;
		for(JButton button : buttons){
			if(!button.isEnabled()) zaehler++;
		}
		
		if (zaehler>=5) System.exit(0);
	}

}

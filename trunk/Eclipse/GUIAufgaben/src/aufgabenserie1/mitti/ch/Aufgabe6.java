package aufgabenserie1.mitti.ch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Aufgabe6 extends JFrame implements ActionListener {
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	public Aufgabe6(){
		super("Aufgabe 1");
		initComponents();
		bindListener();
		initGui();
	}

	private void initComponents(){
		button1 = new JButton("Button1");
		button2 = new JButton("Button2");
		button3 = new JButton("Button3");
		button4 = new JButton("Button4");
		button5 = new JButton("Button5");
	}
	
	private void initGui(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(10,10));
		mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		setLayout(new FlowLayout());
		setSize(800,800);
		mainPanel.add(button1, BorderLayout.NORTH);
		mainPanel.add(button2, BorderLayout.EAST);
		mainPanel.add(button3, BorderLayout.SOUTH);
		mainPanel.add(button4, BorderLayout.WEST);
		mainPanel.add(button5, BorderLayout.CENTER);
		
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void bindListener(){
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
	}
	
	public static void main(String[] args){
		Aufgabe6 a1 = new Aufgabe6();
	}
	
	public void actionPerformed(ActionEvent e){
		JButton button = (JButton) e.getSource();
		System.out.println("Es wurde '" + button.getText()  + " gedrückt.");
		button.setEnabled(false);
		alleGedrueckt();
	}
	
	public void alleGedrueckt(){
		if(!button1.isEnabled() && !button2.isEnabled() && !button3.isEnabled() && !button4.isEnabled() && !button5.isEnabled()){
			System.exit(0);
		}
	}

}

package aufgabenserie1.mitti.ch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Aufgabe2 extends JFrame {
	private JButton button1;
	
	public Aufgabe2(){
		super("Aufgabe 2");
		initComponents();
		bindListener();
		initGui();
	}

	private void initComponents(){
		button1 = new JButton("Button1");
	}
	
	private void initGui(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(10,10));
		mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		setLayout(new FlowLayout());
		setSize(400,100);
		mainPanel.add(button1, BorderLayout.CENTER);
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void bindListener(){
		button1.addActionListener(new ButtonListener());
	}
	
	public static void main(String[] args){
		Aufgabe2 a2 = new Aufgabe2();
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton) e.getSource();
			System.out.println("Es wurde '" + button.getText()  + " gedrückt.");
		}
	}

}

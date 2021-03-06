package ch.mitti.threaduebung1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.mitti.threaduebung2.Counter;

public class TestZaehler extends JFrame {
	private JButton start1, start2, stop1, stop2, halt1, halt2;
	private JLabel counter1, counter2;
	private JPanel mainpanel, panel1, panel2;
	private Counter c1, c2;
	
	public static void main(String[] args){
		TestZaehler testZaehler = new TestZaehler();
		
	}
	
	public TestZaehler(){
		
		this.setSize(800,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		counter1 = new JLabel("0");
		panel1 = new JPanel();
		mainpanel = new JPanel(new BorderLayout());
		panel1.setLayout(new FlowLayout());
		start1 = new JButton("start1");
		stop1 = new JButton("stop1");
		halt1 = new JButton("halt1");
		
		c1 = new Counter(counter1);
		
		start1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    c1.start();
			  } 
			} );
		
		
		stop1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    c1.interrupt();
			    c1 = new Counter(counter1);
			  } 
			} );
		
		
		halt1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    c1.toggleStatus();
			  } 
			} );
		
		
		panel1.add(start1);
		panel1.add(stop1);
		panel1.add(halt1);
		panel1.add(counter1);
		mainpanel.add(panel1, BorderLayout.CENTER);
		this.add(mainpanel);
		
		this.setVisible(true);
		
	}	
}

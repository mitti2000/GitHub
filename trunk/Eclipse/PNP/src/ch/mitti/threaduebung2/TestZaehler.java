package ch.mitti.threaduebung2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.awt.datatransfer.ClipboardTransferable;

public class TestZaehler extends JFrame {
	private JButton start1,stop1, halt1;
	private JLabel stopwatch, clocklabel;
	private JPanel mainpanel, panel1;
	private Counter counter;
	private Clock clock;
	
	public static void main(String[] args){
		TestZaehler testZaehler = new TestZaehler();
		
	}
	
	public TestZaehler(){
		
		this.setSize(800,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		stopwatch = new JLabel("");
		clocklabel = new JLabel("0");

		panel1 = new JPanel();
		mainpanel = new JPanel(new BorderLayout());
		panel1.setLayout(new FlowLayout());
		start1 = new JButton("start1");
		start1.setEnabled(true);
		stop1 = new JButton("stop1");
		stop1.setEnabled(false);
		halt1 = new JButton("halt1");
		
		counter = new Counter(stopwatch);
		clock = new Clock(clocklabel);
		
		clock.start();
		
		start1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    counter.start();
			    start1.setEnabled(false);
			    stop1.setEnabled(true);
			  } 
			} );
		
		
		stop1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    counter.interrupt();
			    counter = new Counter(stopwatch);
			    start1.setEnabled(true);
			    stop1.setEnabled(false);
			  } 
			} );
		
		
		halt1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    counter.toggleStatus();
			  } 
			} );
		

		
		panel1.add(start1);
		panel1.add(stop1);
		panel1.add(halt1);
		panel1.add(clocklabel);
		panel1.add(stopwatch);
		mainpanel.add(panel1, BorderLayout.NORTH);
		this.add(mainpanel);
		
		this.setVisible(true);
		
	}	
}

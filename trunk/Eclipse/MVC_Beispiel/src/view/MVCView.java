package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.MVCController;

public class MVCView extends JFrame { 

	private static final long serialVersionUID = 1L;
	JLabel label; 
     
    public MVCView() { 
        init(); 
    } 
     
    private void init() { 
        label = new JLabel(" "); 
        label.setHorizontalAlignment(JLabel.CENTER); 
        JButton button = new JButton("klick"); 
        button.addActionListener(new MVCController(this)); 
        this.add(label, BorderLayout.NORTH); 
        this.add(button, BorderLayout.CENTER); 
        this.pack(); 
        this.setTitle("MVC"); 
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setVisible(true); 
    } 
     
    public void setText(String s) { 
        label.setText(s); 
    } 
} 

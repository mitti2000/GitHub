package ch.zbw.prgf.zillig.kapitel11.transfer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class Menues extends JFrame implements ActionListener{
	private JMenuBar menubar1;
	private JMenu menu1, submenu;
	private JMenuItem menuitem1, menuitem2, menuitem3, submenuitem1, submenuitem2;
	
	public Menues(){
		initComponents();
		bindListener();
		initGui();
	}
	
	private void initComponents() {
		menubar1 = new JMenuBar();
		menu1 = new JMenu("Men� 1");
		submenu = new JMenu("Submen� 1");
		menuitem1 = new JMenuItem("Men� Item 1");
		menuitem2 = new JMenuItem("Men� Item 2");
		menuitem3 = new JMenuItem("Men� Item 3");
		submenuitem1 = new JMenuItem("SubMen� Item 1");
		submenuitem2 = new JMenuItem("SubMen� Item 2");
	}
	
	private void bindListener(){
		menuitem1.addActionListener(this);
		menuitem2.addActionListener(this);
		menuitem3.addActionListener(this);
		submenuitem1.addActionListener(this);
		submenuitem2.addActionListener(this);
	}
	
	private void initGui(){
		// Frame initialisieren
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(400,400);
		this.setJMenuBar(menubar1);
		
		// Men� Struktur aufbauen
		menubar1.add(menu1);
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.add(menuitem3);
		
		menu1.add(submenu);
		submenu.add(submenuitem1);
		submenu.add(submenuitem2);
		
		menuitem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuitem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		submenuitem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

		// java.net.URL imageURL = this.getClass().getResource("/Smiley.png");
		java.net.URL imageURL = this.getClass().getResource("/16x16.png");
		ImageIcon image = new ImageIcon(imageURL);
		menuitem2.setIcon(image);
		
		setVisible(true);	
	}
	
	public static void main(String[] args){
		Menues a1 = new Menues();
	}

	public void actionPerformed(ActionEvent arg0) {
		JMenuItem clicked = (JMenuItem)arg0.getSource();
		System.out.println("Men� " + clicked.getText() + " wurde ausgew�hlt.");
	}
}
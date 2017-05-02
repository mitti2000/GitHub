package ch.mitti.drachenkurve;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	int size;
	Zeichenflaeche zeichenflaeche;
	
	public MainFrame(){
		size = 1024;
		zeichenflaeche = new Zeichenflaeche(size);
		this.add(zeichenflaeche);
		this.setName("Drachenkurve");
		this.setSize(size,size);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static void main(String[] args){
		MainFrame main = new MainFrame();
	}
}

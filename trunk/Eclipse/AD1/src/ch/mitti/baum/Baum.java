package ch.mitti.baum;

import ch.aplu.*;
import ch.aplu.turtle.Turtle;

public class Baum {
	Turtle t;
	
	public Baum(int max, int min){
		t = new Turtle();
		t.speed(200);
		t.hideTurtle();
		t.setX(0);
		t.setY(-200);
		zeichnen(max, min);
	}
	
	public void zeichnen(int max, int min){
		
		if(max>min){
			t.forward(max);
			t.left(45);
			zeichnen(max/2, min);
			t.right(90);
			zeichnen(max/2, min);
			t.left(45);
			t.back(max);
		}
	
	}

	public static void main(String[] args) {
		Baum baum = new Baum(200,1);

	}

}

package ch.mitti.quadrate;
import ch.aplu.turtle.*;

public class Quadrate {
	
	Turtle t;
	
	public Quadrate(int max, int min){
		t = new Turtle();
		t.speed(200);
		t.hideTurtle();
		t.setX(0);
		t.setY(0);
		
		
		zeichnen(max, min, 0, -100);
	}
	
	public void zeichnen(int max, int min, int posX, int posY){
		if(max>min){
			t.setPos(posX-max/2, posY+max/2);
			t.right(90);
			t.forward(max);
			t.right(90);
			t.forward(max);
			t.right(90);
			t.forward(max);
			t.right(90);
			t.forward(max);
			zeichnen(max/2, min, posX+max, posY+max);
			zeichnen(max/2, min, posX-max, posY+max);
		}
	}

	public static void main(String[] args) {
		Quadrate quadrate = new Quadrate(100, 1);
		
	}

}

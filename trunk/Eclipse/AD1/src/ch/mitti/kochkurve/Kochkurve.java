package ch.mitti.kochkurve;
import ch.aplu.*;
import ch.aplu.turtle.Turtle;

public class Kochkurve {
	Turtle t;
	public Kochkurve(int max){
		t = new Turtle();
		t.speed(200);
		t.hideTurtle();
		t.setX(-200);
		t.setY(-50);
		t.right(90);
		zeichne(max);
	}
	
	public void zeichne(int max){
		if(max<5){
			t.forward(max);
			
		}
		else{
			zeichne(max/3);
			t.left(60);
			zeichne(max/3);
			t.right(120);
			zeichne(max/3);
			t.left(60);
			zeichne(max/3);
		}
	}

	public static void main(String[] args) {
		Kochkurve kochkurve = new Kochkurve(400);
	}

}

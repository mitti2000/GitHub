package ch.mitti.geometrische_figuren;

import java.awt.geom.*; //Alle Klassen des Geometrie-Pakets

public class Kreis extends Figur {
    // Attribute
    private int radius; //Radius des Kreises
    
    //Konstruktor
    public Kreis() {
    	super(50,50,"blue");
        this.radius=10;
        this.draw();
    }
    
    public Kreis(int xPosition, int yPosition, int radius, String color) {
    	super(xPosition, yPosition, color);
        this.radius=radius;
        this.draw();
    }

    // Dienste
    public void draw(){ //mit private und public ausprobieren
    	Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, super.getColor(), "Kreis", new Ellipse2D.Double(super.getxPosition(), super.getyPosition(), radius, radius));
    }

}

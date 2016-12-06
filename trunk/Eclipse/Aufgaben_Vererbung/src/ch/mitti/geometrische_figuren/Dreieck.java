package ch.mitti.geometrische_figuren;

import java.awt.*;
public class Dreieck extends Figur{

    private int xPnt2;
    private int yPnt2;
    private int xPnt3;
    private int yPnt3;


    public Dreieck() {
    	super(100,10,"green");
        this.xPnt2=20;
        this.yPnt2=100;
        this.xPnt3=180;
        this.yPnt3=100;
        this.draw();
    }

    public Dreieck(int xPosition,int yPosition,int xPnt2,int yPnt2,int xPnt3,int yPnt3, String color) {
        super(xPosition, yPosition, color);
        this.xPnt2=xPnt2;
        this.yPnt2=yPnt2;
        this.xPnt3=xPnt3;
        this.yPnt3=yPnt3;
        draw();
    }

    
    public void draw() {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { super.getxPosition(), xPnt2, xPnt3 };
            int[] ypoints = { super.getyPosition(), yPnt2, yPnt3 };
            canvas.draw(this, super.getColor(), "Dreeieck", new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
    }

}

package ch.mitti.drachenkurve;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Zeichenflaeche extends Canvas{
	
	ArrayList<Integer> directions;
	int size;
	int iterations;
	int pointX;
	int pointY;
	int pointX2;
	int pointY2;
	int length;
	//1=up; 2=rechts; 3=down; 4=left;
	int dir;
	int dirStart;
	boolean start;
	int anzahlKurven;
	
	public Zeichenflaeche(int size){
		this.size=size;
		this.iterations = 13;
		dir = 1;
		dirStart = 4;
		start = true;
		anzahlKurven = 4;
		
		length = 10;
		pointX = size/2;
		pointY = size/2;
		pointX2 = pointX;
		pointY2 = pointY;
		
		
		//1 = R; 0 = L
		this.directions = new ArrayList<Integer>();
		
		for(int i=0; i<iterations;i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(directions);
			temp.add(1);
			if(directions.size()>1) {
				directions.set(directions.size()/2, 0);
			}
			else if(directions.size()==1){
				directions.set(0, 0);
			}
			temp.addAll(directions);
			directions = temp;
			
		}
	}
	
	
	public void paint(Graphics g){		
		pointX = size/2;
		pointY = size/2;
		pointX2 = pointX;
		pointY2 = pointY;
		
		for(int j=anzahlKurven; j>=1; j--){
			switch(j){
			case 1: g.setColor(Color.RED);
				break;
			case 2: g.setColor(Color.BLUE);
				break;
			case 3: g.setColor(Color.BLACK);
				break;
			case 4: g.setColor(Color.GREEN);
				break;
			}
			dirStart = j;
			//Kurve Zeichen
			for(int i=0; i<directions.size(); i++) {
				drawCurve(g, i);
			}
			//***********
			start = true;
		}
	}
	
	public void drawCurve(Graphics g, int i){

			if(start){
				pointX = size/2;
				pointY = size/2;
				pointX2 = pointX;
				pointY2 = pointY;
				
				switch(dirStart){
				case 1:	pointX2 += length;
					break;
				
				case 2:	pointY2 += length;
					break;
					
				case 3:	pointX2 -= length;
					break;
					
				case 4:	pointY2 -= length;
					break;
				}
				g.fillOval(pointX, pointY, 10, 10);
				g.drawLine(pointX, pointY, pointX2, pointY2);
				pointX = pointX2;
				pointY = pointY2;
				start = false;
			}
			if(directions.get(i)==1){
				switch(dir){
				case 1:	pointX2 += length;
					break;
				
				case 2:	pointY2 += length;
					break;
					
				case 3:	pointX2 -= length;
					break;
					
				case 4:	pointY2 -= length;
					break;
				}
				
				if(dir<4) dir++;
				else dir=1;
			}
				
			else if(directions.get(i)==0){
				switch(dir){
				case 1:	pointX2 -= length;
					break;
				
				case 2:	pointY2 -= length;
					break;
					
				case 3:	pointX2 += length;
					break;
					
				case 4:	pointY2 += length;
					break;
				
				default: System.out.println("fehler");
					break;
				}
				
				if(dir>1) dir--;
				else dir=4;
			}
			
			
			
			g.drawLine(pointX, pointY, pointX2, pointY2);
			pointX = pointX2;
			pointY = pointY2;
	}
}

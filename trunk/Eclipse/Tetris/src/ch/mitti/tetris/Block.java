package ch.mitti.tetris;

import java.awt.Color;

public class Block {
	int type;
	Coordinates second;
	Coordinates third;
	Coordinates fourth;
	Color color;
	
	public Block(int type){
		this.type = type;
		switch(type){
		//Line
		case 1:
			color = Color.GRAY;
			second = new Coordinates(0,-1);
			third = new Coordinates(0, 1);
			fourth = new Coordinates(0, 2);
			break;
		//L-Left
		case 2:
			color = Color.RED;
			second = new Coordinates(0,-1);
			third = new Coordinates(-1, -1);
			fourth = new Coordinates(0, 1);
			break;
		//L-Right
		case 3:
			color = Color.GREEN;
			second = new Coordinates(-1,1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(0, 1);
			break;
		//S-Right
		case 4:
			color = Color.BLUE;
			second = new Coordinates(-1,-1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(1, 0);
			break;
		//S-Left
		case 5:
			color = Color.CYAN;
			second = new Coordinates(1,-1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(-1, 0);
			break;
		//T
		case 6:
			color = Color.YELLOW;
			second = new Coordinates(-1,0);
			third = new Coordinates(1, 0);
			fourth = new Coordinates(0, -1);
			break;
		//Square
		case 7:
			color = Color.ORANGE;
			second = new Coordinates(-1,0);
			third = new Coordinates(-1, 1);
			fourth = new Coordinates(0, 1);
			break;
		}
	}
	
	public int getType(){
		return type;
	}
	
	public void rotateLeft(Block block){
		int type = block.getType();
		switch(type){
		//Line
		case 1:
			color = Color.GRAY;
			second = new Coordinates(0,-1);
			third = new Coordinates(0, 1);
			fourth = new Coordinates(0, 2);
			break;
		//L-Left
		case 2:
			color = Color.RED;
			second = new Coordinates(0,-1);
			third = new Coordinates(-1, -1);
			fourth = new Coordinates(0, 1);
			break;
		//L-Right
		case 3:
			color = Color.GREEN;
			second = new Coordinates(-1,1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(0, 1);
			break;
		//S-Right
		case 4:
			color = Color.BLUE;
			second = new Coordinates(-1,-1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(1, 0);
			break;
		//S-Left
		case 5:
			color = Color.CYAN;
			second = new Coordinates(1,-1);
			third = new Coordinates(0, -1);
			fourth = new Coordinates(-1, 0);
			break;
		//T
		case 6:
			color = Color.YELLOW;
			second = new Coordinates(-1,0);
			third = new Coordinates(1, 0);
			fourth = new Coordinates(0, -1);
			break;
		//Square
		case 7:
			color = Color.ORANGE;
			second = new Coordinates(-1,0);
			third = new Coordinates(-1, 1);
			fourth = new Coordinates(0, 1);
			break;
		}
	}
}

package main;

import controller.MVCController;
import view.MVCView;

public class Main {

	public static void main(String[] args) {
		MVCView view = new MVCView();
		MVCController controller = new MVCController(view);

	}

}

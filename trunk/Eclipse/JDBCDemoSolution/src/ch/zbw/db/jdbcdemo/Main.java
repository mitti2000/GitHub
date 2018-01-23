package ch.zbw.db.jdbcdemo;

import java.awt.EventQueue;

import ch.zbw.db.jdbcdemo.app.DemoApp;
import ch.zbw.db.jdbcdemo.app.DemoAppSolution;
import ch.zbw.db.jdbcdemo.ui.Application;
import ch.zbw.db.jdbcdemo.ui.ApplicationWindow;
import ch.zbw.db.jdbcdemo.ui.MainWindow;

public class Main {
	public static boolean SOLUTION = false;
	
	private static Application AppCreate(ApplicationWindow window) {
		Application result;
		
		if (SOLUTION) {
			result = new DemoAppSolution(window);
		}
		else {
			result = new DemoApp(window);			
		}
		
		return result;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SOLUTION = args.length > 0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setApplication(AppCreate(window));
					window.display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

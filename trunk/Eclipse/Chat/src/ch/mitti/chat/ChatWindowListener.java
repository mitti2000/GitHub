package ch.mitti.chat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindowListener extends WindowAdapter {
	
	ClosableGui gui;
	
	public ChatWindowListener(ClosableGui gui) {
		this.gui = gui;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		gui.closeWindow();
	}
}

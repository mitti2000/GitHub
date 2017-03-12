package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MVCModel;
import view.MVCView;

public class MVCController implements ActionListener {

	private MVCView view;
	private MVCModel model;

	public MVCController(MVCView view) {
		this.view = view;
		this.model = new MVCModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.setText(model.getText());
	}
}
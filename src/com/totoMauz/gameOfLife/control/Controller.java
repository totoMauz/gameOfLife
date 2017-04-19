package com.totoMauz.gameOfLife.control;

import com.totoMauz.gameOfLife.model.IModel;
import com.totoMauz.gameOfLife.model.Model;
import com.totoMauz.gameOfLife.view.SwingView;

public class Controller implements IController {
	private IModel model;

	public Controller() {
		model = new Model(50, 50);
		model.initializeModel();
		model.updateModel();
		SwingView.setController(this);
	}

	@Override
	public void nextTick() {
		model.updateModel();
	}

}

package com.totoMauz.gameOfLife.control;

import com.totoMauz.gameOfLife.model.IModel;
import com.totoMauz.gameOfLife.model.Model;

public class Controller implements IController {
	private IModel model;

	public Controller() {
		model = new Model(3, 3);
		model.initializeModel();
	}
}

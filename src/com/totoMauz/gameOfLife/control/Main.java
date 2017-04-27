package com.totoMauz.gameOfLife.control;

import com.totoMauz.gameOfLife.model.IModel;
import com.totoMauz.gameOfLife.model.Model;
import com.totoMauz.gameOfLife.view.SwingView;

public class Main {

	public static void main(String[] args) {
		IController controller = new Controller();

		IModel model = new Model(50, 50);
		model.setView(new SwingView(controller));

		controller.setModel(model);
		controller.start();
	}
}

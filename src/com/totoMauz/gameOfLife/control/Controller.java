package com.totoMauz.gameOfLife.control;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.totoMauz.gameOfLife.model.IModel;
import com.totoMauz.gameOfLife.model.Model;

/**
 * Controller Implementation responsible for starting the game and keeping it
 * running.
 */
public class Controller implements IController {
	private IModel model;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	/**
	 * Initialize a new controller and implicitly a model and view as well.
	 * Start a loop updating the game.
	 */
	public Controller() {
		model = new Model(50, 50, this);
		model.initializeModel();

		final Runnable tickRunner = new Runnable() {
			@Override
			public void run() {
				nextTick();
			}
		};
		scheduler.scheduleAtFixedRate(tickRunner, 0, 50, TimeUnit.MILLISECONDS);
	}

	@Override
	public void nextTick() {
		model.updateModel();
	}

	@Override
	public void randomSeed() {
		model.initializeModel();
	}

}

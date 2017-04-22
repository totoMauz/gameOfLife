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
		this.model = new Model(50, 50, this);
		this.model.initializeModel();
	}

	@Override
	public void nextTick() {
		this.model.updateModel();
	}

	@Override
	public void randomSeed() {
		this.model.initializeModel();
	}

	@Override
	public void start() {
		final Runnable tickRunner = new Runnable() {
			@Override
			public void run() {
				nextTick();
			}
		};
		this.scheduler.scheduleAtFixedRate(tickRunner, 0, 50, TimeUnit.MILLISECONDS);
	}

}

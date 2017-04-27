package com.totoMauz.gameOfLife.control;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.totoMauz.gameOfLife.model.IModel;

/**
 * Controller Implementation responsible for starting the game and keeping it
 * running.
 */
public class Controller implements IController {
	private IModel model;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	@Override
	public void nextTick() {
		this.model.updateModel();
	}

	@Override
	public void restart() {
		this.model.initializeModel();
	}

	@Override
	public void start() {
		this.model.initializeModel();
		final Runnable tickRunner = new Runnable() {
			@Override
			public void run() {
				nextTick();
			}
		};
		this.scheduler.scheduleAtFixedRate(tickRunner, 0, 50, TimeUnit.MILLISECONDS);
	}

	@Override
	public void setModel(final IModel model) {
		this.model = model;
	}

}

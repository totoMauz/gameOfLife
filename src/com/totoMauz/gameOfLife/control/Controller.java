package com.totoMauz.gameOfLife.control;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import com.totoMauz.gameOfLife.model.IModel;
import com.totoMauz.gameOfLife.model.Model;

public class Controller implements IController {
	private IModel model;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public Controller() {
		model = new Model(50, 50, this);

		final Runnable tickRunner = new Runnable() {
			@Override
			public void run() {
				nextTick();
			}
		};
		final ScheduledFuture<?> tickHandle = scheduler.scheduleAtFixedRate(tickRunner, 0, 33,
				java.util.concurrent.TimeUnit.MILLISECONDS);

		scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				tickHandle.cancel(true);
			}
		}, 60 * 60, java.util.concurrent.TimeUnit.SECONDS);
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

package com.totoMauz.gameOfLife.control;

import com.totoMauz.gameOfLife.model.IModel;

/**
 * Control the game of life.
 */
public interface IController {
	/**
	 * Trigger next iteration of the game of life.
	 */
	void nextTick();

	/**
	 * Initialize the game of life with random values.
	 */
	void restart();

	/**
	 * Start the game.
	 */
	void start();

	/**
	 * Set the model implementation.
	 * 
	 * @param model
	 *            the model to use
	 */
	void setModel(IModel model);
}

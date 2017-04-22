package com.totoMauz.gameOfLife.control;

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
	void randomSeed();
}

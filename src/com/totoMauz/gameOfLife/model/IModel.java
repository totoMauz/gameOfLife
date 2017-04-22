package com.totoMauz.gameOfLife.model;

/**
 * Model the game of life.
 */
public interface IModel {
	/**
	 * Compute the next iteration of the game inplace.
	 */
	void updateModel();

	/**
	 * Initialize the model.
	 */
	void initializeModel();
}

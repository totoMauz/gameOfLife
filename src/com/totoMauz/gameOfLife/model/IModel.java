package com.totoMauz.gameOfLife.model;

import com.totoMauz.gameOfLife.view.IView;

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

	/**
	 * Set the view implementation.
	 * 
	 * @param view
	 *            the view to use
	 */
	void setView(IView view);
}

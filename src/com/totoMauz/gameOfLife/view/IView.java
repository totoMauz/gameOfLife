package com.totoMauz.gameOfLife.view;

/**
 * View the game of life.
 */
public interface IView {
	/**
	 * Render the latest game update.
	 * 
	 * @param data
	 *            the new data to render
	 */
	void updateView(boolean[] data);
}

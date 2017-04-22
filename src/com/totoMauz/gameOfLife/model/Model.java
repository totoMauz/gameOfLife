package com.totoMauz.gameOfLife.model;

import com.totoMauz.gameOfLife.control.IController;
import com.totoMauz.gameOfLife.view.IView;
import com.totoMauz.gameOfLife.view.SwingView;

/**
 * Model implementation with a simple array holding the game data. Responsible
 * for updating the view.
 */
public class Model implements IModel {
	public static int NUM_COLS;
	public static int NUM_ROWS;
	private final boolean[] currData;
	private final boolean[] nextData;
	private final Cursor cursor;

	private IView view;

	/**
	 * Instantiate a new model
	 * 
	 * @param x
	 *            number of rows of the game field.
	 * @param y
	 *            number of columns of the game field.
	 * @param controller
	 *            the controller to pass to the view.
	 */
	public Model(final int x, final int y, final IController controller) {
		view = new SwingView(controller);
		NUM_COLS = x;
		NUM_ROWS = y;
		currData = new boolean[NUM_COLS * NUM_ROWS];
		nextData = new boolean[NUM_COLS * NUM_ROWS];
		cursor = new Cursor();
	}

	@Override
	public void initializeModel() {
		for (int i = 0; i < currData.length; i++) {
			currData[i] = Math.random() >= 0.5;
		}
		view.updateView(currData);
	}

	@Override
	public void updateModel() {
		getNewData();

		System.arraycopy(nextData, 0, currData, 0, currData.length);

		view.updateView(currData);
	}

	private void getNewData() {
		for (int i = 0; i < currData.length; i++) {
			updateCell(i, getNumberOfAliveNeighbours(i));
		}
	}

	private void updateCell(final int i, final int numberOfNeighbours) {
		final boolean isCellAlive = currData[i];

		if (isCellAlive) {
			if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
				nextData[i] = false;
			} else {
				nextData[i] = true;
			}
		} else {
			if (numberOfNeighbours == 3) {
				nextData[i] = true;
			}
		}
	}

	private int getNumberOfAliveNeighbours(final int i) {
		int aliveNeighbours = 0;

		cursor.setPosition(i);

		if (currData[cursor.moveRight()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveDown()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveLeft()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveLeft()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveUp()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveUp()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveRight()]) {
			++aliveNeighbours;
		}

		if (currData[cursor.moveRight()]) {
			++aliveNeighbours;
		}

		return aliveNeighbours;
	}

	private class Cursor {
		private int pos;
		private final int MAX_POS = (Model.NUM_ROWS * Model.NUM_COLS);

		public void setPosition(final int pos) {
			this.pos = pos;
		}

		public int moveRight() {
			if (this.pos >= MAX_POS - 1) {
				this.pos = -1;
			}
			return ++this.pos;
		}

		public int moveLeft() {
			if (this.pos <= 1) {
				this.pos = MAX_POS;
			}
			return --this.pos;
		}

		public int moveDown() {
			this.pos += Model.NUM_ROWS;
			if (this.pos > MAX_POS - 1) {
				this.pos -= MAX_POS;
			}

			return this.pos;
		}

		public int moveUp() {
			this.pos -= Model.NUM_ROWS;
			if (this.pos < 0) {
				this.pos += MAX_POS;
			}
			return this.pos;
		}
	}
}

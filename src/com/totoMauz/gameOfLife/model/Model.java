package com.totoMauz.gameOfLife.model;

import com.totoMauz.gameOfLife.view.IView;

/**
 * Model implementation with a simple array holding the game data. Responsible
 * for updating the view.
 */
public class Model implements IModel {
	public static int NUM_COLS;
	public static int NUM_ROWS;
	private final boolean[] currCells;
	private final boolean[] nextCells;
	private final CellCursor cellCursor;

	private IView view;

	/**
	 * Instantiate a new model
	 * 
	 * @param numCols
	 *            number of rows of the game field.
	 * @param numRows
	 *            number of columns of the game field.
	 * @param controller
	 *            the controller to pass to the view.
	 */
	public Model(final int numCols, final int numRows) {
		NUM_COLS = numCols;
		NUM_ROWS = numRows;
		this.currCells = new boolean[NUM_COLS * NUM_ROWS];
		this.nextCells = new boolean[NUM_COLS * NUM_ROWS];
		this.cellCursor = new CellCursor();
	}

	@Override
	public void initializeModel() {
		for (int i = 0; i < this.currCells.length; i++) {
			this.currCells[i] = Math.random() >= 0.5;
		}
		this.view.updateView(this.currCells);
	}

	@Override
	public void updateModel() {
		computeNewGameIteration();

		System.arraycopy(this.nextCells, 0, this.currCells, 0, this.currCells.length);

		this.view.updateView(this.currCells);
	}

	private void computeNewGameIteration() {
		for (int i = 0; i < this.currCells.length; i++) {
			updateCellStatus(i, getCountOfLivingNeighbours(i));
		}
	}

	private void updateCellStatus(final int i, final int livingNeighbours) {
		if (this.currCells[i]) {
			this.nextCells[i] = livingNeighbours == 2 || livingNeighbours == 3;
		} else {
			this.nextCells[i] = livingNeighbours == 3;
		}
	}

	private int getCountOfLivingNeighbours(final int i) {
		int livingNeighbours = 0;

		this.cellCursor.setPosition(i);

		if (this.currCells[this.cellCursor.moveRight()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveDown()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveLeft()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveLeft()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveUp()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveUp()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveRight()]) {
			++livingNeighbours;
		}

		if (this.currCells[this.cellCursor.moveRight()]) {
			++livingNeighbours;
		}

		return livingNeighbours;
	}

	/**
	 * This cursor emulates a matrix from a vector and can visit surrounding
	 * fields.
	 */
	private class CellCursor {
		private int pos;
		private final int MAX_POS = (Model.NUM_ROWS * Model.NUM_COLS);

		public CellCursor() {
			super();
		}

		public void setPosition(final int pos) {
			this.pos = pos;
		}

		public int moveRight() {
			if (this.pos >= this.MAX_POS - 1) {
				this.pos = -1;
			}
			return ++this.pos;
		}

		public int moveLeft() {
			if (this.pos <= 1) {
				this.pos = this.MAX_POS;
			}
			return --this.pos;
		}

		public int moveDown() {
			this.pos += Model.NUM_ROWS;
			if (this.pos > this.MAX_POS - 1) {
				this.pos -= this.MAX_POS;
			}

			return this.pos;
		}

		public int moveUp() {
			this.pos -= Model.NUM_ROWS;
			if (this.pos < 0) {
				this.pos += this.MAX_POS;
			}
			return this.pos;
		}
	}

	@Override
	public void setView(final IView view) {
		this.view = view;
	}
}

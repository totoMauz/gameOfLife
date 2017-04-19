package com.totoMauz.gameOfLife.model;

import com.totoMauz.gameOfLife.view.IView;
import com.totoMauz.gameOfLife.view.SwingView;

public class Model implements IModel {
	private boolean[][] currData;
	private boolean[][] nextData;
	private Cursor cursor;

	private IView view;

	public Model(int x, int y) {
		view = new SwingView();
		currData = new boolean[x][y];
		nextData = new boolean[x][y];
		cursor = new Cursor(x - 1, y - 1);
	}

	@Override
	public void initializeModel() {
		for (int x = 0; x < currData.length; x++) {
			for (int y = 0; y < currData[x].length; y++) {
				currData[x][y] = Math.random() >= 0.5;
			}
		}
	}

	@Override
	public void updateModel() {
		getNewData();

		for (int x = 0; x < nextData.length; x++) {
			System.arraycopy(nextData[x], 0, currData[x], 0, currData[x].length);
		}

		view.updateView(currData);
	}

	private void getNewData() {
		for (int x = 0; x < currData.length; x++) {
			for (int y = 0; y < currData[x].length; y++) {
				updateCell(x, y, getNumberOfAliveNeighbours(x, y));
			}
		}
	}

	private void updateCell(final int x, final int y, final int numberOfNeighbours) {
		final boolean isCellAlive = currData[x][y];

		if (isCellAlive) {
			if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
				nextData[x][y] = false;
			} else {
				nextData[x][y] = true;
			}
		} else {
			if (numberOfNeighbours == 3) {
				nextData[x][y] = true;
			}
		}
	}

	private int getNumberOfAliveNeighbours(final int x, final int y) {
		int aliveNeighbours = 0;

		this.cursor.setPosition(x, y);
		this.cursor.moveRight();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveDown();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveLeft();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveLeft();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveUp();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveUp();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveRight();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		this.cursor.moveRight();
		if (currData[this.cursor.x][this.cursor.y]) {
			++aliveNeighbours;
		}

		return aliveNeighbours;
	}
}

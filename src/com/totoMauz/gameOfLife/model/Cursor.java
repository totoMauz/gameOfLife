package com.totoMauz.gameOfLife.model;

public class Cursor {
	private int maxX;
	private int maxY;

	public int x;
	public int y;

	public Cursor(final int maxX, final int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public void setPosition(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public void moveRight() {
		++x;
		if (x > maxX) {
			x = 0;
		}
	}

	public void moveLeft() {
		--x;
		if (x > 0) {
			x = maxX;
		}
	}

	public void moveUp() {
		--y;
		if (y > 0) {
			y = maxY;
		}
	}

	public void moveDown() {
		++y;
		if (y > maxY) {
			y = 0;
		}
	}
}

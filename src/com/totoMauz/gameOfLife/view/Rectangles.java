package com.totoMauz.gameOfLife.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Rectangles extends JPanel {
	private boolean[][] data;
	private static final int RECT_SIZE = 10;

	public Rectangles(final boolean[][] data) {
		this.data = data;
		this.setBounds(0, 0, data.length * RECT_SIZE, data.length * RECT_SIZE);
	}

	public void setNewData(final boolean[][] data) {
		this.data = data;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		for (int x = 0; x < this.data.length; x++) {
			for (int y = 0; y < this.data[x].length; y++) {
				if (this.data[x][y]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(x * RECT_SIZE, y * RECT_SIZE, RECT_SIZE, RECT_SIZE);
			}
		}
	}
}
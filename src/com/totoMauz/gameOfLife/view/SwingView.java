package com.totoMauz.gameOfLife.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.totoMauz.gameOfLife.control.IController;
import com.totoMauz.gameOfLife.model.Model;

/**
 * View implementation using Swing for the GUI.
 */
public class SwingView extends JFrame implements IView {
	private final JButton btnRnd = new JButton("(Re)Start");
	private Rectangles rectangles;
	private final IController controller;

	/**
	 * Initialize the Swing view and create controls.
	 * 
	 * @param controller
	 *            the controller which is triggered by controls.
	 */
	public SwingView(final IController controller) {
		super();
		this.setTitle("Game of Life");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 625, 575);
		addControls();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.controller = controller;
	}

	private void addControls() {
		btnRnd.setBounds(500, 0, 100, 30);
		btnRnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.randomSeed();
			}
		});
		this.add(btnRnd);
	}

	@Override
	public void updateView(final boolean[] data) {
		if (rectangles == null) {
			this.add(new Rectangles(data));
		} else {
			rectangles.setNewData(data);
		}
		this.revalidate();
		this.repaint();
	}

	private class Rectangles extends JPanel {
		private boolean[] data;
		private static final int RECT_SIZE = 10;

		public Rectangles(final boolean[] data) {
			this.data = data;
			this.setBounds(0, 0, data.length * RECT_SIZE, data.length * RECT_SIZE);
		}

		public void setNewData(final boolean[] data) {
			this.data = data;
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);

			for (int i = 0; i < this.data.length; i++) {
				if (this.data[i]) {
					g.setColor(Color.BLACK);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect((i % Model.NUM_ROWS) * RECT_SIZE, (i / Model.NUM_COLS) * RECT_SIZE, RECT_SIZE, RECT_SIZE);
			}
		}
	}
}

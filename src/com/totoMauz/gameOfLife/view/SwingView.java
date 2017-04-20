package com.totoMauz.gameOfLife.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.totoMauz.gameOfLife.control.IController;

public class SwingView extends JFrame implements IView {
	private final JButton btnRnd = new JButton("(Re)Start");
	private Rectangles rectangles;
	private final IController controller;

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
	public void updateView(final boolean[][] data) {
		if (rectangles == null) {
			this.add(new Rectangles(data));
		} else {
			rectangles.setNewData(data);
		}
		this.revalidate();
		this.repaint();
	}
}

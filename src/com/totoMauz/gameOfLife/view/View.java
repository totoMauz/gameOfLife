package com.totoMauz.gameOfLife.view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame implements IView {
	private final JButton btnStart = new JButton();

	public View() {
		super();
		this.setTitle("Game of Life");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 180, 140);
		addControls();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addControls() {
		btnStart.setText("(Re)start");
		btnStart.setBounds(40, 40, 100, 30);
		this.add(btnStart);

	}

	@Override
	public void updateView(boolean[][] data) {
		this.setSize(data.length * 10 + 50, data[0].length * 10);

	}

}

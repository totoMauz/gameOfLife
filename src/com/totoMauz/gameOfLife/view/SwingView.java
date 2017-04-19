package com.totoMauz.gameOfLife.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.totoMauz.gameOfLife.control.IController;

public class SwingView extends JFrame implements IView {
	private final JButton btnNext = new JButton();
	private static IController controller;

	public SwingView() {
		super();
		this.setTitle("Game of Life");
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 625, 575);
		addControls();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addControls() {
		btnNext.setText("Next Tick");
		btnNext.setBounds(500, 0, 100, 30);

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (SwingView.controller != null) {
					SwingView.controller.nextTick();
				}
			}
		});

		this.add(btnNext);
	}

	@Override
	public void updateView(boolean[][] data) {
		this.add(new Rectangles(data));
		this.revalidate();
		this.repaint();
	}

	public static void setController(IController controller) {
		SwingView.controller = controller;
	}
}

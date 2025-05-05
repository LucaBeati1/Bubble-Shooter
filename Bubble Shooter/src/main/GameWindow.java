package main;

import javax.swing.JFrame;

public class GameWindow {
	
	public GameWindow(GamePanel gamePanel) {
		
		JFrame jframe = new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);
		jframe.setFocusable(true);
	}

}

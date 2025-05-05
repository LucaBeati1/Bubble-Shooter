package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;

public class GamePanel extends JPanel {
	
	public Game game;
	
	public GamePanel(Game game) {
		
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		setFocusable(true);
	}
	
	public void setPanelSize() {
		
		Dimension size = new Dimension(game.screenWidth,game.screenHeight);
		setPreferredSize(size);
	}
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);	
		game.render(g);
		
		
}

}

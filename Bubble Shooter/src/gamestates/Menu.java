package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.Game;
import grid.GameGrid;

public class Menu extends State implements Statemethods {

	public Menu(Game game) {
		super(game);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.drawString("MENU", game.screenWidth/ 2, 200);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Gamestate.state = Gamestate.PLAYING;
		}

}
	}

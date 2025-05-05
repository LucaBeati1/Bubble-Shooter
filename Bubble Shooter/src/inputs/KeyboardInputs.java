package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;
import main.GamePanel;

public class KeyboardInputs implements KeyListener {
	
	public GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (Gamestate.state) {
		case MENU:
			gamePanel.game.menu.keyPressed(e);
			break;
		case PLAYING:
			gamePanel.game.playing.keyPressed(e);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (Gamestate.state) {
		case MENU:
			gamePanel.game.menu.keyReleased(e);
			break;
		case PLAYING:
			gamePanel.game.playing.keyReleased(e);
			break;
		default:
			break;
		}
		
	}

}

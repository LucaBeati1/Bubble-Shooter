package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface Statemethods {
	
	public void update();
	public void draw(Graphics g);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);

}

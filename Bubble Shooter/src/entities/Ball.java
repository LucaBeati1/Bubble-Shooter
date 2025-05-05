package entities;

import java.awt.Color;
import java.awt.Graphics;

import gamestates.Playing;
import main.Game;
import utilz.HelpMethods;

public class Ball extends Entity {
	
	public float centerX = x + width / 2;
	public float centerY = y + height / 2;
	public float xSpeed = 0;
	public float ySpeed = 0;
	public boolean empty;
	public boolean moving = false;
	public boolean checked = false;

	public Ball(float x, float y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public Ball(float x, float y, int width, int height, Color color, boolean empty) {
		super(x, y, width, height, color);
		this.empty = empty;
		
	}
	
	public void update() {
		
		updatePos();
		
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, width, height);
		//g.setColor(Color.white);
		//g.drawLine((int)x+25, (int)y+25, (int)x+25, (int)y+25);
	}
	
	public void updatePos() {
		
		x += xSpeed;
		y += ySpeed;
		
		if(HelpMethods.wallCollision(x, width))
			
			xSpeed *= -1;
	}
	

}

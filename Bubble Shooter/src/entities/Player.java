package entities;

import java.awt.Graphics;
import java.lang.Math;

public class Player extends Entity {
	
	public boolean left = false, right = false;
	public float xSpeed = 3;
	
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	public void update() {
		updatePos();
	}

	public void render(Graphics g) {
		g.drawLine((int)x, (int)y, width, height);
	}
	
	public void updatePos() {
		
		if(left)
			x -= xSpeed;
		if(right)
			x += xSpeed;
		
		if(x <= 505)
			x = 505;
		else if(x >= 695)
			x = 695;
		
			
		double a = width - x;
		double b = 10000 - a*a;
		b= Math.sqrt(b);
		y = (float) (height - b);
		
	}

	public void left(boolean left) {
		
		this.left = left;
		
	}
	
    public void right(boolean right) {
		
		this.right = right;
		
    }
    
    public void trajectory(Ball playerBall) {
    	
    	double a = width - x;
		double b = 10000 - a*a;
		b= Math.sqrt(b);
		
		playerBall.xSpeed = (float) (-a / 10);
		playerBall.ySpeed = (float) (-b / 10);
    	
    }

}

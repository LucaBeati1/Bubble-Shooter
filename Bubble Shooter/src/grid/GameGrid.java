package grid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import entities.Ball;
import gamestates.Playing;
import utilz.HelpMethods;

public class GameGrid {
	
	public entities.Ball[][] Balls;
	public entities.Ball playerBall;
	public entities.Ball nextBall;
	public int x;
	public int y;
	public int size = 50;
	public boolean even = true;
	public float playerBallX;
	public float playerBallY;
	public int iLength;
	public int jLength;
	public boolean collision = false;
	public int hit = 0;
	
	public GameGrid(Ball playerBall, Ball nextBall) {
		
		this.playerBall = playerBall;
		this.nextBall = nextBall;
		initGrid();
	}
	
	public void initGrid() {
		
		x = 400; y = 50;
		Balls = new entities.Ball[18][];
		for(int i = 0; i < Balls.length; i++) {
			
			if(even) {
				Balls[i] = new entities.Ball[8];
				even = false;
			}
			else {
				Balls[i] = new entities.Ball[7];
				even = true;
			}
		}
		
		
		for(int i = 0; i < Balls.length; i++) {
			
			if(i <= 8) {
			if(Balls[i].length == 8) {
			for(int j = 0; j < Balls[i].length; j++) {
				
				x = size * j + 400;
				y = 43 * i + 50;
				Balls[i][j] = new Ball( x, y, size, size, HelpMethods.randomColor(), false);
				}
			}
			else {
				
				for(int j = 0; j < Balls[i].length; j++) {
					
					x = size * j + 425;
					y = 43 * i + 50;
					Balls[i][j] = new Ball( x, y, size, size, HelpMethods.randomColor(), false);
				
			}
				
			}
			}
			else {
				if(Balls[i].length == 8) {
				for(int j = 0; j < Balls[i].length; j++) {
					
					x = size * j + 400;
					y = 43 * i + 50;
					Balls[i][j] = new Ball( x, y, size, size, HelpMethods.randomColor(), true);
					}
				}
				else {
					
					for(int j = 0; j < Balls[i].length; j++) {
						
						x = size * j + 425;
						y = 43 * i + 50;
						Balls[i][j] = new Ball( x, y, size, size, HelpMethods.randomColor(), true);
				}
			}
			}
			}
				
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < Balls.length; i++)
			for(int j = 0; j < Balls[i].length; j++) {
				//g.setColor(Color.white);
				//g.drawLine((int)Balls[i][j].x, (int)Balls[i][j].y, (int)Balls[i][j].x + 50, (int)Balls[i][j].y);
				//g.drawLine((int)Balls[i][j].x, (int)Balls[i][j].y+50, (int)Balls[i][j].x + 50, (int)Balls[i][j].y+50);
				//g.drawLine((int)Balls[i][j].x, (int)Balls[i][j].y, (int)Balls[i][j].x, (int)Balls[i][j].y + 50);
				//g.drawLine((int)Balls[i][j].x+50, (int)Balls[i][j].y, (int)Balls[i][j].x+50, (int)Balls[i][j].y + 50);
				if(Balls[i][j].empty == false) {
				g.setColor(Balls[i][j].color);
				g.fillOval((int) Balls[i][j].x, (int) Balls[i][j].y, size, size);
				}
				}
	}
	
	public void update() {
		
		cell();
		collisionBall();
		hit();
		
	}
	
	public void cell() {
		
		for(int i = 0; i < Balls.length; i++)
			for(int j = 0; j < Balls[i].length; j++) {
				if(playerBall.x + 25 > Balls[i][j].x + 1 && playerBall.x + 25 < Balls[i][j].x + 50 + 1)
					if(playerBall.y + 25 > Balls[i][j].y + 1 && playerBall.y + 25 < Balls[i][j].y + 50 + 1) {
						playerBallX = Balls[i][j].x;
						playerBallY = Balls[i][j].y;
						iLength = i;
						jLength = j;
					}
				}
		
	}
	
	public void collisionBall() {
			
			for(int i = 0; i < Balls.length; i++)
				for(int j = 0; j < Balls[i].length; j++) {
					if(collision == false && !Balls[i][j].empty) {
						
					if(HelpMethods.distance(playerBall.x, playerBall.y, Balls[i][j].x, Balls[i][j].y)<= 40)
						collision = true;
					}
				}
			if(playerBall.y - 50 <= 5) {
				collision = true;
			}
		}
	
	public void hit() {
		
		if(collision == true) {
		Balls[iLength][jLength].color = playerBall.color;
		Balls[iLength][jLength].empty = false;
		resetPlayerBall();
		HelpMethods.bubblePop(this);
		HelpMethods.bubbleFall(this);
		collision = false;
		hit++;
		moveGridDown();
		}
		
	}
	
	public void resetPlayerBall() {
		playerBall.xSpeed = 0;
		playerBall.ySpeed = 0;
		playerBall.x = 575;
		playerBall.y = 775;
		playerBall.moving = false;
		playerBall.color = nextBall.color;
		nextBall.color = HelpMethods.randomColor();
	}
	
	public void moveGridDown() {
		
		if(hit == 8) {
			
			for(int i = 0; i < Balls.length; i++)
				for(int j = 0; j < Balls[i].length; j++) {
					
					Balls[i][j].y += 43;
					if(Balls[i][j].y == 824) {
						Balls[i][j].y = 50;
						Balls[i][j].color = HelpMethods.randomColor();
						Balls[i][j].empty = false;
					}
				}
			hit = 0;
		}
		
	}
	
	public void gameOver() {
		
	}
	
}

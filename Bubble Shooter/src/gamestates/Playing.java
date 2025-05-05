package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entities.Ball;
import entities.Player;
import grid.GameGrid;
import main.Game;
import utilz.HelpMethods;

public class Playing extends State implements Statemethods {
	
	public Player player;
	public Ball playerBall;
	public Ball nextBall;
	public GameGrid grid;

	public Playing(Game game) {
		super(game);
		initClasses();
	}
	
	public void initClasses() {
		
		player = new Player(600, 700, 600, 800);
		playerBall = new Ball(575, 775, game.tileSize, game.tileSize,HelpMethods.randomColor());
		nextBall = new Ball(450, 775, game.tileSize, game.tileSize,HelpMethods.randomColor());
		grid = new GameGrid(playerBall, nextBall);
		
	}

	@Override
	public void update() {
		player.update();
		playerBall.update();
		grid.update();
		
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, game.screenWidth, game.screenHeight);
		g.setColor(Color.white);
		g.drawRect(400, 50, 400, 800);
		g.drawLine(400, 750, 800, 750);
		player.render(g);
		g.drawOval(575, 775, game.tileSize, game.tileSize);
		grid.render(g);
		playerBall.render(g);
		nextBall.render(g);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.left(true);
			break;
		case KeyEvent.VK_D:
			player.right(true);
			break;
			}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.left(false);
			break;
		case KeyEvent.VK_D:
			player.right(false);
			break;
        case KeyEvent.VK_SPACE:
        	if(!playerBall.moving) {
			player.trajectory(playerBall);
			playerBall.moving = true;
			}
			break;
			}
		
	}
	

}

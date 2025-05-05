package main;

import java.awt.Color;
import java.awt.Graphics;

import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;

public class Game implements Runnable {
	
	public GameWindow gameWindow;
	public GamePanel gamePanel;
	public Thread gameThread;
	public Playing playing;
	public Menu menu;
	
	public final int FPS = 60;
	public final int screenWidth = 1200;
	public final int screenHeight = 900;
	public final int gameWidth = 400;
	public final int gameHeight = 800;
	public final int tileSize = 50;
	
	public Game() {
		
		initClasses();
		
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocusInWindow();
		
		startGameLoop();
		
	}
    public void initClasses() {
		
		menu = new Menu(this);
		playing = new Playing(this);
	}

	public void startGameLoop() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime -lastTime)/drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if(delta >= 1) {
			update();
			gamePanel.repaint();
			delta--;
			drawCount++;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				timer = 0;
				drawCount = 0;
			}
		}
		
	}

	public void update() {
		
		switch (Gamestate.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		default:
			break;

		}
	}
	
	public void render(Graphics g) {
		
		switch (Gamestate.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
			playing.draw(g);
			break;
		default:
			break;
		}
	}

}

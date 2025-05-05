package entities;

import java.awt.Color;

public abstract class Entity {
	
	public float x, y;
	public int width, height;
	public Color color;
	
	public Entity(float x, float y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
public Entity(float x, float y, int width, int height, Color color) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

}

	package me.game.hitIt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stage {
	private int x,y;
	private HitIt instance;
	private Rectangle baseGround = new Rectangle(0, 485, 600, 25);
	
	public Stage(HitIt instance){
		this.instance = instance;
		
		
		}
	
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillRect(baseGround.x, baseGround.y, baseGround.width, baseGround.height);
	}

	public Rectangle getbounds(){
		return baseGround.getBounds();
	}
}

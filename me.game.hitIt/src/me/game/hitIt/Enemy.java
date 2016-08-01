package me.game.hitIt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	
private Rectangle enemie;
private int x,y,w= 30,h =30;
private int dy = 2;
private HitIt instance;
private boolean dead = false;


public Enemy(int x, int y, HitIt instance) {
	
	this.x =x;
	this.y =y;
	this.instance = instance;
	
	enemie = new Rectangle(this.x, this.y,w, h);

}
	
		
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillRect(enemie.x, enemie.y, enemie.width, enemie.height);
		
		move();
		
	}
	
	public void move(){
		isCollided();
		enemie.y+= dy;
		
	}
	public void isCollided(){
		if (enemie.intersects(instance.getstage().getbounds())){
			dy=0;
			dead = true;
			
		}
	}
	public boolean isdead(){
		return dead;
	}
/*	public boolean iscollidedwith(player p)
	{
		return enemie.getBounds().intersects(p.getbounds());
	}
	*/
	
	
	public Rectangle getenemybounds(){
		return enemie.getBounds();
	}

}

	
	

	
	

	
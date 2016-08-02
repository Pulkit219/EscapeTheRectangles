package me.game.hitIt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class player{
private int x,y;
private int w =16,h =16;
	private int dx;
	private int dy;
	private HitIt instance;
	private Rectangle ball;
 protected int lives = 35;

	
	
	
	public player(HitIt instance,int x, int y) {
	this.instance = instance;
	this.x= x;
	this.y= y;
	ball = new Rectangle(x,y, w,h);
	
	
	}

	public void draw(Graphics g){
		
		move();
		collidedWithEnemies();
		
		
		
		
		g.setFont(new Font("Century Gothic", Font.BOLD, 20));
	    g.drawString("Lives :" + lives , 10, 20);
	    gameover();
	    if(lives == 0){


	    }
	    
	    
		g.setColor(Color.red);
		g.fillOval(ball.x, ball.y, ball.width, ball.height);
	
		
}
	private void move(){
		iscollidedWithStage();
		
		ball.x+=dx;
		ball.y+=dy;
	
		
	}
	public void setDX(int values){
	this.dx = values;
	if(ball.x >= instance.getWidth() + this.dx- ball.getWidth()){
		ball.x= (int) (instance.getWidth()- ball.getWidth());
	}
	else if (ball.x < 0){
		ball.x=0; 
	}
	}
	public void setDY(int values){
		this.dy = values;
		}
	
	
	public void iscollidedWithStage(){
		if(!ball.intersects(instance.getstage().getbounds())){
			
			dx = 0 ;
			
			}
		else{
			dy =0;
		}
		
		}
	public void collidedWithEnemies(){
		ArrayList<Enemy>	enemies = instance.getmanager().getenemies();
		for(int i =0 ; i < enemies.size();i++ ){
			if(ball.intersects(enemies.get(i).getenemybounds())){
				lives--;
				System.out.println("over");
			}
		}
	}
	public Rectangle getplayerbounds(){
		return ball.getBounds();
	}
	
	
	
	
	public void gameover(){
		if(lives ==0){
			instance.over = true;

			
			
			
		}
		
		}
	public void drawover(Graphics g){
		g.setFont(new Font("Century Gothic", Font.BOLD, 30));
	    g.drawString("GAME OVER" , 200, 200);
		
	}
	 
/*	public void colliedWithEnemy(){
		
		for(int i = 0; i < en.size(); i++){
			
			if(ball.intersects(en.get(i).getbounds())){
				en.remove(en.get(i));
			}
		}
	} */
	
	}
	
	


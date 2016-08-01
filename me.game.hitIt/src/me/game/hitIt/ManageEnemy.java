package me.game.hitIt;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ManageEnemy {
	
	private int number;
	private HitIt instance;
	private int lives = 0;
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public ManageEnemy(int n, HitIt instance) {
		number = n;
		this.instance= instance;
		
		
		
	}
	
	public void spawn(){
		Random rand = new Random();
		int gtsize = enemies.size();
		if(gtsize < number){
		for(int i =0; i<number - gtsize ;i++){
			enemies.add(new Enemy(rand.nextInt(583),rand.nextInt(100), instance));
		}}
		else if(gtsize> number){
			for(int i =0; i < gtsize - number;i++){
				enemies.remove(i);
		}
		}
		
	}
public void draw(Graphics g){
	spawn();
	update();
	
	for(int i =0; i< enemies.size(); i++){
		enemies.get(i).draw(g);
	}
	//or
	
	/*for(Enemy e : enemies){
		e.draw(g);}*/
	
}
public void update(){
	boolean respawn = false;
	for(int i =0; i < enemies.size(); i++){
		if(enemies.get(i).isdead()){
			enemies.remove(i);
			respawn = true;
		}
	}if(respawn){
		spawn();
	}
}

/*public boolean collidingWithPlayer(){
	boolean c = false;
	for(int i =0; i<enemies.size();i++){
		if(instance.getplayer().getbounds().intersects(enemies.get(i).getenemy())){
			c = true;
			System.out.println("game over");}
		}
	return c;
}*/

public ArrayList<Enemy> getenemies(){
	return enemies;
}
}

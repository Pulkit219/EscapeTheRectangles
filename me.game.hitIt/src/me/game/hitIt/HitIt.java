package me.game.hitIt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HitIt extends JPanel implements KeyListener, ActionListener {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x = 5;
private int y = 5;
private player pl;
private Stage  st;
private ManageEnemy me;
Graphics g;

public boolean over = false;
Timer ti;
	public HitIt(){
		setSize(new Dimension(600,500));
		setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		addKeyListener(this);
		setFocusable(true);
		pl = new player(this,200,470);
		st = new Stage(this);
		me = new ManageEnemy(23,this);
		
		ti = new Timer(10,this);
		ti.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black	);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		


		
		if(!over){
		st.draw(g);
		pl.draw(g);
		me.draw(g);
		
		
		}
		else{
			pl.drawover(g);
		}
		   
		
		
		g.dispose();
		
	}

	public static void main(String[] args) {
		HitIt panel = new HitIt();
		JFrame frame = new JFrame();
		frame.setTitle("Hit iT");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		

	}
@Override
	public void update(Graphics g) {
	repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int getthekey = e.getKeyCode();
		
if(getthekey == KeyEvent.VK_UP){
	pl.setDY(-4);
		
		}
if(getthekey == KeyEvent.VK_DOWN){
			
	pl.setDY(+4);
		}
if(getthekey == KeyEvent.VK_LEFT){
	
	pl.setDX(-4);
}
if(getthekey == KeyEvent.VK_RIGHT){
	
	pl.setDX(+4);
}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		pl.setDX(0);
		pl.setDY(0);
			
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
				update(g);
		
	}
	public boolean gameover(){
		return over;
		
	}
	public Stage getstage(){
		return st;
	}
	public player getplayer(){
		return pl;
	}
 public ManageEnemy getmanager(){
	 return me;
 }


}

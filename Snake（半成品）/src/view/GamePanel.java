package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JPanel;

import entity.Food;
import entity.Ground;
import entity.Snake;
import util.Global;

public class GamePanel extends JPanel{
	private Snake snake;
	private  Food food;
	private Ground ground;
	public GamePanel() {
		this.setBackground(Color.PINK);
		this.setSize(28*15,30*15);
	}
	public void display(Snake snake,Food food, Ground ground){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(144,113,188));
		g2d.drawLine(Global.WIDTH*Global.CELL_SIZE, 0, Global.WIDTH*Global.CELL_SIZE, Global.HEIGHT*Global.CELL_SIZE);
		g2d.drawLine(0, 0, Global.WIDTH*Global.CELL_SIZE, 0);
		
		if(snake != null && food != null && ground != null){
			snake.drawMe(g2d);
			food.drawMe(g2d);
			ground.drawMe(g2d);
		}
		
	}
}

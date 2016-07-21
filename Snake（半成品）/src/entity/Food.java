package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import util.Global;

public class Food extends Point{
	
	/**
	 * 画出自己
	 */
	public void drawMe(Graphics2D g){
		g.setColor(new Color(43, 43, 43));
		g.fillRoundRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, 12,12);
	}
	/**
	 * 蛇吃到了自己
	 */
	public boolean isBySnake(Snake snake){
		if( snake.getHead().getX() == this.x && snake.getHead().getY() == this.y)
			return true;
		else
			return false;
	}
	public void addFood(Point p){
		this.x = p.x;
		this.y = p.y;
	}
}

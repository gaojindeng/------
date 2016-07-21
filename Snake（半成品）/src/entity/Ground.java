package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import util.Global;

public class Ground {
	private int[][] rec = new int[Global.WIDTH][Global.HEIGHT];

//	public Ground() {
//		for (int i = 0; i < Global.WIDTH; i++) {
//			for (int j = 0; j < Global.HEIGHT; j++) {
//				if (i == 0 || i == Global.WIDTH - 1)
//					rec[i][j] = 1;
//				if (j == 0 || j == Global.HEIGHT - 1)
//					rec[i][j] = 1;
//			}
//		}
//	}
	public void init(){
		for (int i = 0; i < Global.WIDTH; i++) {
			for (int j = 0; j < Global.HEIGHT; j++) {
				if (i == 0 || i == Global.WIDTH - 1)
					rec[i][j] = 1;
				if (j == 0 || j == Global.HEIGHT - 1)
					rec[i][j] = 1;
			}
		}
	}
	public boolean isBySnake(Snake snake){
		int x = snake.getHead().x;
		int y = snake.getHead().y;
		if(rec[x][y] == 1)
			return true;
		else
			return false;
	}
	public void drawMe(Graphics2D g) {
		
		g.setColor(Color.YELLOW);
		for (int i = 0; i < Global.WIDTH; i++) {
			for (int j = 0; j < Global.HEIGHT; j++) {
				if (rec[i][j] == 1) {
					g.fill3DRect(i * Global.CELL_SIZE, j * Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
		}
	}
	public Point getPoint(Snake snake){
		int x,y;
		do{
			x = new Random().nextInt(Global.WIDTH);
			y = new Random().nextInt(Global.HEIGHT);
			
		}while(rec[x][y] == 1 || snake.getDate().contains(new Point(x,y)));
		return new Point(x,y);
	}
}

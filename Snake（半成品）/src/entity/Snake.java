package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.LinkedList;

import listener.SnakeListener;
import util.Global;

public class Snake {
	public static final int UP=1;    //上移方向
	public static final int DOWN=-1; //下移方向
	public static final int LEFT=2;  //左移方向
	public static final int RIGHT=-2;//右移方向
	private int newDirection,oldDirection; //新的方向 ，旧的方向
	private Point tail; //蛇的尾部位置
	private SnakeListener snakeListener;
	private LinkedList<Point> date = new LinkedList<Point>(); //存储蛇身
	/**
	 * 蛇的初始化的时候
	 */
	public Snake() {
		init();
		newDirection = oldDirection = RIGHT;
	}
	public void init(){
		int x = Global.WIDTH / 2;
		int y = Global.HEIGHT / 2;
		
		for(int i = 0; i < 3; i++){
			date.add(new Point(x--,y));
		}
		newDirection = oldDirection = RIGHT;
	}
	public void addSnakeListener(SnakeListener snakeListener) {
		this.snakeListener = snakeListener;
	}
	public LinkedList<Point> getDate() {
		return date;
	}
	/**
	 * 蛇移动
	 */
	public void move(){
		tail = date.removeLast();
		int x = date.getFirst().x;
		int y = date.getFirst().y;
		if(newDirection + oldDirection != 0)
			oldDirection = newDirection;
		switch(oldDirection){
		case UP:
			y--;
			if(y < 0)
				y = Global.HEIGHT-1;
			break;
		case DOWN:
			y++;
			if(y >= Global.HEIGHT)
				y = 0;
			break;
		case LEFT:
			x--;
			if(x < 0)
				x = Global.WIDTH - 1;
			break;
		case RIGHT:
			x++;
			if(x >= Global.WIDTH)
				x = 0;
			break;
		}
		date.addFirst(new Point(x,y));
		System.out.println("蛇正在移动！");
		
	};
	/**
	 * 吃到食物
	 */
	public void eatFood(){
		date.add(tail);
	}
	public Point getHead(){
		return date.getFirst();
	}
	/**
	 * 蛇改变方向
	 */
	public void changeDirection(int Direction){
		if(newDirection + Direction != 0){
			newDirection = Direction;
		}
		System.out.println("蛇正在改变方向");
		
	}
	/**
	 * 蛇画出自己
	 */
	public void drawMe(Graphics2D g){
		
		g.setColor(new Color(43, 43, 43));
		
		for(Point p : date){
			g.fillRoundRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, 12,12);
		}
	}
	public boolean eatSelf(){
		for(int i = 1; i < date.size(); i++){
			if(getHead().equals(date.get(i)))
				return true;
		}
		return false;
	}
	public void start(){
		new StartGame().start();
	}
	class StartGame extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					snakeListener.snakeMove(Snake.this);
					move();
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

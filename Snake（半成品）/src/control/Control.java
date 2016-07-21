package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import entity.Food;
import entity.Ground;
import entity.Snake;
import listener.SnakeListener;
import view.GamePanel;

public class Control extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private  Food food;
	private Ground ground;
	private GamePanel gamePanel;
	public Control(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("事件");
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
		}
		
	}
	public void newGame(){
		food.addFood(ground.getPoint(snake));
		snake.start();
	}
	@Override
	public void snakeMove(Snake snake) {
		//判断是否吃到食物
		if(food.isBySnake(snake)){
			snake.eatFood();
			food.addFood(ground.getPoint(snake));
		}
		//判断是否碰到障碍物
		if(ground.isBySnake(snake)){
			JOptionPane.showMessageDialog(null, "GameOver");
			System.exit(0);
		}
		//判断是否碰到自己
		if(snake.eatSelf()){
			JOptionPane.showMessageDialog(null, "GameOver");
			System.exit(0);
		}
		gamePanel.display(snake, food, ground);
		
	}
}

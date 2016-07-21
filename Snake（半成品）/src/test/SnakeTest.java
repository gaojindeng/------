package test;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control;
import entity.Food;
import entity.Ground;
import entity.Snake;
import view.GamePanel;

public class SnakeTest {
	static Snake snake = new Snake();

	static Food food = new Food();
	static Ground ground = new Ground();
	static GamePanel gamePanel = new GamePanel();
	static Control c = new Control(snake, food, ground, gamePanel);
	private static JFrame frame = new JFrame();
	public static void main(String[] args) {
		
		
		snake.addSnakeListener(c);
		gamePanel.addKeyListener(c);
		GroupLayout groupLayout = getPanel();
		frame.getContentPane().setLayout(groupLayout);
		frame.add(gamePanel);
		frame.setSize(600,490);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		gamePanel.setFocusable(true);
		
		
		//c.newGame();
	}
	public static GroupLayout getPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap(398, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("开始");
		btnNewButton.setBounds(30, 61, 123, 29);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.newGame();
				super.mouseClicked(e);
			}
		});
		JButton btnNewButton_1 = new JButton("一般");
		btnNewButton_1.setBounds(30, 116, 123, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("困难");
		
		btnNewButton_2.setBounds(30, 174, 123, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("退出");
		btnNewButton_3.setBounds(30, 231, 123, 29);
		panel.add(btnNewButton_3);
		
		JLabel label = new JLabel("1.");
		label.setForeground(Color.RED);
		label.setBounds(50, 276, 81, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setForeground(Color.RED);
		label_1.setBounds(50, 312, 81, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setForeground(Color.RED);
		label_2.setBounds(50, 350, 81, 21);
		panel.add(label_2);
		
		JLabel lblNewLabel = new JLabel("author:GotoAuto");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(30, 407, 150, 21);
		panel.add(lblNewLabel);
		//getContentPane().setLayout(groupLayout);
		return groupLayout;
	}
}

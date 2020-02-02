import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BlockPannel extends JPanel implements KeyListener,ActionListener{
	private boolean play = false;
	private JFrame mainFrame,startScreen;
	Thread thread;
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay =2;
	//private int playerX = 310;
	ArrayList<Block> blocks;
	Block ball = new Block(237,435,25,25,"ball.png");
	Block paddle = new Block(175,480,150,25,"paddle.png");
	Animate animate;
	public BlockPannel(JFrame frame, JFrame startScreen) {
		this.mainFrame = frame;
		this.startScreen = startScreen;
		setFocusTraversalKeysEnabled(false);
		reset();
		timer = new Timer(delay,this);
		timer.start();
	}
	private void reset() {
		blocks = new ArrayList<Block>();
		ball = new Block(237, 435, 35, 25, "ball.png");
		paddle = new Block(175, 480, 150, 25, "paddle.png");
		for (int i = 0; i < 8; i++)
			blocks.add(new Block((i*60+2),0,60,25,"blue.png"));
		for (int i = 0; i < 8; i++)
			blocks.add(new Block((i*60+2),35,60,25,"green.png"));
		for (int i = 0; i < 8; i++)
			blocks.add(new Block((i*60+2),70,60,25,"yellow.png"));
		for (int i = 0; i < 8; i++)
			blocks.add(new Block((i*60+2),105,60,25,"red.png"));

		addKeyListener(this);
		setFocusable(true);
	}
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
	//	G.setColor(Color.black);
		//G.fillRect(1, 1, 692, 592);
		paddle.draw(G, this);
		//G.setColor(Color.green);
		//G.fillRect(playerX, 550, 100, 8);
		
		ball.draw(G, this);
		blocks.forEach(block -> {
			block.draw(G, this);
		});
		G.dispose();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			animate = new Animate(this);
			/*new Thread(() ->{
				while(true) {
					update();
					try {
						Thread.sleep(10);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();*/
			
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (this.getWidth() - paddle.width)) {
			play = true;
			//playerX +=20;
			paddle.x += 15;
			
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0 ) {
			play = true;
			//layerX -=20;
		
			paddle.x -= 15;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void update() {
		// TODO Auto-generated method stub
		ball.x += ball.movX;
		
		if(ball.x > (this.getWidth() - 25) || ball.x < 0)
			ball.movX *= -1;
		
		if(ball.y < 0 || ball.intersects(paddle))
			ball.movY *= -1;
		
		ball.y += ball.movY;
		
		if(ball.y > this.getHeight()) {
			//thread = null;
			reset();
			mainFrame.setVisible(false);
			startScreen.setVisible(true);
			
			
		}
		
		blocks.forEach(block -> {
			if(ball.intersects(block) && !block.destroyed) {
				ball.movY *=-1;
				block.destroyed = true;
				
			}
		});
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//timer.start();
		repaint();
		if(play == true) {
			update();
		}
	}
	
}

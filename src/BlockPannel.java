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
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay =8;
	//private int playerX = 310;
	ArrayList<Block> blocks = new ArrayList<>();
	Block ball = new Block(237,435,25,25,"ball.png");
	Block paddle = new Block(175,480,150,25,"paddle.png");
	Animate animate;
	public BlockPannel() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
	//	G.setColor(Color.black);
		//G.fillRect(1, 1, 692, 592);
		paddle.draw(G, this);
		//G.setColor(Color.green);
		//G.fillRect(playerX, 550, 100, 8);
		G.dispose();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			animate = new Animate(this);
			new Thread(() ->{
				while(true) {
					update();
					try {
						Thread.sleep(10);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
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
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		repaint();
	}
	
}

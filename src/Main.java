import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("BrickBackMountain");
		JFrame startScreen = new JFrame();
		JButton start = new JButton("Start");
		BlockPannel panel = new BlockPannel(frame,startScreen);
		start.addActionListener(listener -> {
			startScreen.setVisible(false);
			frame.setVisible(true);
		});
		frame.getContentPane().add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(false);
		frame.setSize(490, 600);
		
		frame.setResizable(false);
		
		startScreen.getContentPane().add(start);
		
		startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startScreen.setVisible(true);
		startScreen.setSize(490, 600);
		
		startScreen.setResizable(false);
	}

}

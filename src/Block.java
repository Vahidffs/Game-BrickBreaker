import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Rectangle{
	Image pic;
	boolean destroyed;
	int movX;
	int movY;
	public Block(int x,int y,int w, int h,String s) {
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
		this.movX = 1;
		this.movY = 1;
		try {
			pic = ImageIO.read(new File("src/" + s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics g, Component c) {
		if(!destroyed) {
			g.drawImage(pic, x, y, width, height, c);
		}
	}
}

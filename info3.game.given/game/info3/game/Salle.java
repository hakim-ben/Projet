package info3.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Salle implements IElement{
	
	BufferedImage img;
	Parameters params;
	
	public Salle(int mode) {
		if (mode==0) {
			this.params = new Screen1();
		}
		if (mode==1) {
			this.params = new Screen2();
		}
	}

	@Override
	public void tick(long elapsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(0, this.params.getMinHeight(), this.params.getWidth(), this.params.BORDER_Y);
	}
	
}

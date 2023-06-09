package info3.game;

import java.awt.Graphics;

public interface IElement {
	
	public void tick(long elapsed);
	public void paint(Graphics g);
}

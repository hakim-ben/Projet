package info3.game;

import java.awt.Dimension;

public abstract class Parameters {
	public static int TOTAL_WIDTH = 1024;
	public static int TOTAL_HEIGHT = 768;
	public static int BORDER_Y = TOTAL_HEIGHT/2;
	public static int SCALE = 2;
	
	// jump data :
//	public static int jumpHeight = 30; // Adjust the desired jump height
//	public static int jumpSpeed = 5; // Adjust the speed of the jump
//	public static int initialY = 0; // Initial Y position of the player
	
	int getWidth() {
		return TOTAL_WIDTH;
	}
	
	abstract int getMaxHeight();
	abstract int getMinHeight();
	abstract int getCenterX();
	abstract int getCenterY();

}

class Screen1 extends Parameters {
	public static int MIN_HEIGHT = 0;
	public static int MAX_HEIGHT = BORDER_Y;
	public static int CENTER_X = TOTAL_WIDTH/2;
	public static int CENTER_Y = MIN_HEIGHT+(MAX_HEIGHT-MIN_HEIGHT)/2;
	@Override
	int getMaxHeight() {
		return MAX_HEIGHT;
	}
	@Override
	int getMinHeight() {
		return MIN_HEIGHT;
	}
	@Override
	int getCenterX() {
		return CENTER_X;
	}
	@Override
	int getCenterY() {
		return CENTER_Y;
	}
}
class Screen2 extends Parameters {
	public static int MIN_HEIGHT = BORDER_Y;
	public static int MAX_HEIGHT = TOTAL_HEIGHT;
	public static int CENTER_X = TOTAL_WIDTH/2;
	public static int CENTER_Y = MIN_HEIGHT+(MAX_HEIGHT-MIN_HEIGHT)/2;
	@Override
	int getMaxHeight() {
		return MAX_HEIGHT;
	}
	@Override
	int getMinHeight() {
		return MIN_HEIGHT;
	}
	@Override
	int getCenterX() {
		return CENTER_X;
	}
	@Override
	int getCenterY() {
		return CENTER_Y;
	}
}
package info3.game;

import java.awt.image.BufferedImage;

abstract class Enemy extends Entity {
	BufferedImage[] m_images;
	int x;
	int y;
	int height;
	int width;
	
	double dmg; // Dégat
	double lives;
	int id; 
	
	Enemy(){
		
	}
	
	abstract void move();
	
	void delete() { // Suppression de l'ennemi en mémoire
		
	}
}

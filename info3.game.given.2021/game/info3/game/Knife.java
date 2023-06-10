package info3.game;

import java.awt.image.BufferedImage;

public class Knife extends Item{
	// Chaque item a une action spécifique : si on attaque avec un couteau, le couteau est lancé (?)
	Knife() {
		super(1);
		//super.images = ;
		super.dmg = 6;
		super.durability = 1;
		super.price = 2;
		super.color = 0;
	}
	
	void interact() {
		
	}
}

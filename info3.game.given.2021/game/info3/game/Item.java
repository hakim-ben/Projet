package info3.game;

import java.awt.image.BufferedImage;

abstract class Item extends Entity {
	
	BufferedImage[] images; // Sprite
	int id; // Id de l'objet
	int dmg; // Dégât de l'item
	int price; // Prix en coins
	int durability; // Nombre de fois qu'on peut l'utiliser
	int color; // rouge (1), bleu (2), aucune couleur (0)
	
	Item(int id){
		this.id = id;
	}
	
	abstract void interact(); // Interagit avec l'item 
	
	
}

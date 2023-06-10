package info3.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity{
	
	BufferedImage[] m_images;
	int x;
	int y;
	int height;
	int width;
	ArrayList<Item> items; // Inventaire du joueur, limité à 5 items par défaut.
	Item currentItem; // Item qu'il a actuellement dans sa main
	int coins; // Coins qu'il a amassé
	double lives; // Les vies en commun des deux joueurs
	double dmg; // Dégât
	
	Player(int x, int y) {
		this.x = x;
		this.y = y;
		//this.m_images = m_images;
	}
	
	public void jump() {
		
	}
	
	public void left() {
		
	}
	
	public void right() {
		
	}
	
	public void down() {
		
	}
	
	// Attaque l'ennemi devant lui en fonction de l'item qu'il a en main
	public void action() {
		if (currentItem == null) {
			// action du player : attaquer avec ses poings
		}
		else {
			currentItem.interact();
		}
	}
	
	void lancer(int id) {
		
	}
	
	public void paint(Graphics g, int width, int height) {
		
	}
}

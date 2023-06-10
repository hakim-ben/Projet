package info3.game;

public class Looter extends Enemy {
	
	Looter(){
		super.x = x;
		super.y = y;
		super.lives = 20; // toujours constant pour l'instant
		super.dmg = -1; // il vole les items du joueur
		
//		// Dépendant des sprites
//		super.images = ;
//		super.height = ;
//		super.width = ;
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		
	}
}

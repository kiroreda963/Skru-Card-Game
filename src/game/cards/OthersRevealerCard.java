package game.cards;

import game.engine.Player;
import game.interfaces.SpecialCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OthersRevealerCard extends NumberCard implements SpecialCard {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+super.toString()+" seeOthers)" ;
	}
	public OthersRevealerCard(int number) {
		super(number);
	
	}
	
	
	
}

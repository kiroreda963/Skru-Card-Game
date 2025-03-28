package game.cards;

import game.engine.Player;
import game.interfaces.SpecialCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SelfRevealerCard extends NumberCard implements SpecialCard {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+super.toString()+" seeYours)";
	}

	public SelfRevealerCard(int number) {
		super(number);
	



}
}

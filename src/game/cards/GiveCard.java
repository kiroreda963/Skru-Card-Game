package game.cards;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GiveCard extends ActionCard {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Give";
	}

	public GiveCard() {
		backImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/back.png"));
		 frontImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/give.png"));
		   
		  // Add images to the StackPane (inherited from Card)
	        getChildren().addAll(backImageView, frontImageView);

	        // Initially show the back image
	        frontImageView.setVisible(false);
	}

}

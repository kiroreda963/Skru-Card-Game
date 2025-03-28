package game.cards;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SwapCard extends ActionCard {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Swap";
	}
	public SwapCard() {
		backImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/back.png"));
		 frontImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/swap.png")); 
		  // Add images to the StackPane (inherited from Card)
	        getChildren().addAll(backImageView, frontImageView);

	        // Initially show the back image
	        frontImageView.setVisible(false);
	}

}

package game.cards;

import game.enums.SkruType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SkruCard extends Card {
	private final SkruType type;

	public SkruType getType() {
		return type;
	}

	public SkruCard(SkruType type) {
		this.type = type;
		backImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/back.png"));
		if(type == type.GREEN)
		 frontImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/-1.png"));  
		else if(type ==type.RED)
			 frontImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/25.png"));  

		  // Add images to the StackPane (inherited from Card)
	        getChildren().addAll(backImageView, frontImageView);

	        // Initially show the back image
	        frontImageView.setVisible(false);
	}

	public int getValue() {
		if (type == SkruType.RED)
			return 25;
		else
			return -1;
	}

	@Override
	public String toString() {
		if (type == SkruType.RED)

			return "REDSkru";
		else
			return "GREENSkru";
	}

}

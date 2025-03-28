package game.cards;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NumberCard extends Card {

    private final int number;

    public String toString() {
        return "" + number;
    }

    public NumberCard(int number) {
        this.number = number;

        // Initialize front and back image views
        backImageView = new ImageView(new Image("file:D:/GIU/prog II skru game/pngs/back.png"));
        String frontImagePath = "file:D:/GIU/prog II skru game/pngs/" + number + ".png";
        frontImageView = new ImageView(new Image(frontImagePath));
        frontImageView.setVisible(false);
        getChildren().addAll(backImageView, frontImageView);        

        // Add images to the StackPane (inherited from Card)
 

        // Initially show the back image
       
    }

    public int getNumber() {
        return number;
    }
}

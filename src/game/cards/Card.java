package game.cards;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class Card extends StackPane {

    private boolean visible;
    public ImageView frontImageView;
    public ImageView backImageView;
    public VBox optionsBox;
    private boolean recentlyDrawed;
    private Button play;
    private Button replicate;
    private Button draw;
    private Button select;


    public boolean isCardVisible() {
        return visible;
    }

    public void setCardVisible(boolean visible) {
        this.visible = visible;
        frontImageView.setVisible(visible);
        backImageView.setVisible(!visible);
    }

    public Card() {
    	optionsBox =new VBox(10);
    	play =new Button("Play");
    	replicate = new Button ("Replicate");
    	draw = new Button("draw");
    	draw.setVisible(false);
    	select = new Button("select");
    	select.setVisible(false);
    	optionsBox.getChildren().addAll(play,replicate,draw,select);
    	optionsBox.setVisible(false);
    	getChildren().add(optionsBox);
    	optionsBox.setAlignment(Pos.CENTER);
    	
    	
//  

    	
      }

	public Button getPlay() {
		return play;
	}

	public Button getReplicate() {
		return replicate;
	}
	
	public Button getDraw() {
		return draw;
	}
	
	public Button getSelect() {
		return select;
	}

	public boolean isRecentlyDrawed() {
		return recentlyDrawed;
	}

	public void setRecentlyDrawed(boolean recentlyDrawed) {
		this.recentlyDrawed = recentlyDrawed;
	}

	
	
	
    
    
    
}

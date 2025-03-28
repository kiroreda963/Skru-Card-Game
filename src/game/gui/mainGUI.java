package game.gui;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
public class mainGUI extends Application {

	
	private TextField Player1Name ;
    private TextField Player2Name ;
    private TextField Player3Name ;
    private TextField Player4Name ;
    @Override
    public void start(Stage primaryStage) {
        // Create the BorderPane as the root layout
        BorderPane menu = new BorderPane();
        GridPane grid = new GridPane();
        BorderPane rulesBorder = new BorderPane();
        Scene firstScene = new Scene(menu, 400, 300);
        Scene secondScene = new Scene(grid,800,650);
        Scene thirdScene = new Scene (rulesBorder,600,800);
        // Create a VBox and configure its contents
        VBox mainMenuVbox = new VBox(10);
        VBox playerName1VBox = new VBox(10);
        VBox playerName2VBox = new VBox(10);
        VBox playerName3VBox = new VBox(10);
        VBox playerName4VBox = new VBox(10);

        mainMenuVbox.setAlignment(Pos.CENTER); // Center contents within the VBox
VBox playersSelectVbox = new VBox(10); 
        // Create and add content to VBox
     //   Label gameName = new Label("Skru");
       // gameName.setStyle("-fx-font-size: 40px;"); // Set the font size for the Label
        Button play = new Button("Play");
        Button rules = new Button("How to play ?!");
        Button back = new Button("Back");
         Player1Name = new TextField();
         Player2Name = new TextField();
         Player3Name = new TextField();
         Player4Name = new TextField();
        Player1Name.setPromptText("Enter your name");
        Button Start = new Button ("START");
        Label PlayerName1 =new Label("Player1:");
        Label PlayerName2 =new Label("Player2:");
        Label PlayerName3 =new Label("Player3:");
        Label PlayerName4 =new Label("Player4:");
        Button sumbit1 = new Button("Submit");
        Button sumbit2 = new Button("Submit");
        Button sumbit3 = new Button("Submit");
        Button sumbit4 = new Button("Submit");
        
        PlayerName1.setFont(new Font("Arial", 24));
        PlayerName1.setTextFill(Color.WHITE);
        PlayerName2.setFont(new Font("Arial", 24));
        PlayerName2.setTextFill(Color.WHITE);
        PlayerName3.setFont(new Font("Arial", 24));
        PlayerName3.setTextFill(Color.WHITE);
        PlayerName4.setFont(new Font("Arial", 24));
        PlayerName4.setTextFill(Color.WHITE);


        mainMenuVbox.getChildren().addAll( play, rules);
        grid.setHgap(400); // Horizontal gap between columns
        grid.setVgap(200); // Vertical gap between rows
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.add(playerName1VBox, 0, 0);
        grid.add(playerName2VBox, 1, 0);
        grid.add(playerName3VBox, 0, 1);
        grid.add(playerName4VBox, 1, 1);
        mainMenuVbox.setPadding(new Insets(150, 0, 0, 0)); // Top padding of 50 pixels

        playerName1VBox.getChildren().addAll(PlayerName1,Player1Name,sumbit1);
        playerName2VBox.getChildren().addAll(PlayerName2,Player2Name,sumbit2);
        playerName3VBox.getChildren().addAll(PlayerName3,Player3Name,sumbit3);
        playerName4VBox.getChildren().addAll(PlayerName4,Player4Name,sumbit4);


        grid.setStyle("-fx-padding: 10;");
       grid.add(back, 1, 2);
       grid.add(Start, 0, 2);
       GridPane.setHalignment(back, HPos.RIGHT);
       GridPane.setValignment(back, VPos.BOTTOM);
       GridPane.setHalignment(playerName1VBox, HPos.RIGHT);
       playerName1VBox.setAlignment(Pos.CENTER);
       playerName2VBox.setAlignment(Pos.CENTER);
       playerName3VBox.setAlignment(Pos.CENTER);
       playerName4VBox.setAlignment(Pos.CENTER);


     //  GridPane.setMargin(playerName1VBox, new Insets(0, 60, 0, 0) );
       //GridPane.setMargin(back, new Insets(0, 0, 0, 200));
        // Create an HBox to center the VBox horizontally in the top region
        HBox hbox = new HBox(mainMenuVbox);
        hbox.setAlignment(Pos.CENTER); // Center the VBox horizontally in HBox

        // Set the HBox to the top of the BorderPane
        menu.setTop(hbox);

        play.setOnAction(e -> primaryStage.setScene(secondScene));
        back.setOnAction(e -> primaryStage.setScene(firstScene));
        
        sumbit1.setOnAction(e -> {
            // Get text from TextField and display it in the Label
        	String input = Player1Name.getText();
        	PlayerName1.setText("Hello, " + input + "!");
        });
        
        sumbit1.setOnAction(e -> {
            // Get text from TextField and display it in the Label
        	String input = Player1Name.getText();
        	PlayerName1.setText("Hello, " + input + "!");
        });
        sumbit2.setOnAction(e -> {
            // Get text from TextField and display it in the Label
        	String input = Player2Name.getText();
        	PlayerName2.setText("Hello, " + input + "!");
        });
        sumbit3.setOnAction(e -> {
            // Get text from TextField and display it in the Label
        	String input = Player3Name.getText();
        	PlayerName3.setText("Hello, " + input + "!");
        });
        sumbit4.setOnAction(e -> {
            // Get text from TextField and display it in the Label
        	String input = Player4Name.getText();
        	PlayerName4.setText("Hello, " + input + "!");
        });
        String player1Name =Player1Name.getText();
        ///////////
        
  	  Image backgroundImage = new Image("file:D:/GIU/prog II skru game/pngs/menu.png");
	     BackgroundImage background = new BackgroundImage(
	             backgroundImage,
	             BackgroundRepeat.NO_REPEAT, // Do not repeat the image
	             BackgroundRepeat.NO_REPEAT, // Do not repeat the image
	             BackgroundPosition.DEFAULT, // Position at the default (top left)d
	             new BackgroundSize(
	                 BackgroundSize.AUTO, // Width
	                 BackgroundSize.AUTO, // Height
	                 true, // Stretch to fit width
	                 true, // Stretch to fit height
	                 true, // Aspect ratio preserving
	                 true  // Image cover the entire area
	             )
	         );
	     menu.setBackground(new Background(background));
	     grid.setBackground(new Background(background));
	     rulesBorder.setBackground(new Background(background));
	     
        
        
        
//////////////////
      Start.setOnAction(e -> {
    	    ArrayList<String> playerNames = new ArrayList<>();
            playerNames.add(Player1Name.getText());
            playerNames.add(Player2Name.getText());
            playerNames.add(Player3Name.getText());
            playerNames.add(Player4Name.getText());
            boolean allNamesEntered = playerNames.stream().allMatch(name -> !name.trim().isEmpty());
            if (allNamesEntered)
            {
            	System.out.println("ready to start");
                Stage secondStage = new Stage();
                GameGui GameGui = new GameGui(this);
                GameGui.start(secondStage); // Call the  to set up and show the second stage
                primaryStage.close();
            }
            else
            	displayAlert("Not Enough Players!","   Please enter the four players names","Continue");
        });
      
      ////////
      VBox rulesBox = new VBox(10); // 10px spacing between elements
      rulesBox.setPadding(new Insets(20)); // Padding around the VBox

      // Rules Label
      Label rulesLabel = new Label("How to Play: Skru Card Game\n\n" +
              "Game Overview\n" +
              "\"Skru\" is a strategic card game for 4 players that uses a standard 52-card deck. The objective is to end each round with the lowest possible card value. The game consists of 5 rounds, and the player with the lowest total score at the end wins.\n\n" +
              "Setup\n" +
              "1. Deal Cards: Each player is dealt 4 cards face down.\n" +
              "2. Look at Your Cards: At the start of each round, look at your two rightmost cards. Do not show your cards to others.\n" +
              "3. Place Remaining Deck: Put the remaining cards face down in the center to form the draw pile. The top card is placed face up next to it to start the discard pile.\n\n" +
              "Game Play\n" +
              "Players take turns in clockwise order. During a turn, you have the following choices:\n" +
              "1. Replace a Card:\n" +
              "- Draw a card from the center pile.\n" +
              "- Replace one of your face-down cards with the drawn card (keep it face down).\n" +
              "- Or, discard the drawn card into the discard pile.\n\n" +
              "2. Replicate a Card:\n" +
              "- Discard a card from your hand if it matches the face-up card in the discard pile.\n" +
              "- If the card matches, your hand size is reduced.\n" +
              "- If it doesn’t match, you must take both cards and add them to your hand.\n\n" +
              "3. Use Special Cards:\n" +
              "- 7 or 8: Peek at one of your own cards.\n" +
              "- 9 or 10: Look at an opponent's card.\n" +
              "- Eye Master Card: Look at a card from each player, including yourself.\n" +
              "- Swap Card: Swap one of your cards with an opponent's card without revealing them.\n" +
              "- Replica Card: Discard any card.\n" +
              "- Give Card: Give one of your cards to any opponent.\n\n" +
              "Ending a Round: Declaring \"Skru\"\n" +
              "A player can declare \"Skru\" after the first three turns to signal the end of the round.\n" +
              "Once \"Skru\" is declared, all players reveal their cards.\n" +
              "The player with the lowest score wins the round.\n" +
              "If the player who declared \"Skru\" does not have the lowest score, their round score is doubled.\n\n" +
              "Scoring\n" +
              "- Lowest Score: The player with the lowest score for the round gets 0 points.\n" +
              "- Other Players: Other players score the sum of their card values.\n" +
              "- Action Cards (7-10, Special Cards): Add 10 points each.\n" +
              "- Red Skru Card: Adds 25 points.\n" +
              "- Green Skru Card: Subtracts 1 point.\n" +
              "- Ties: If multiple players have the lowest score, all of them score 0 points.\n\n" +
              "Winning the Game\n" +
              "The game continues for 5 rounds. The player with the lowest total score at the end of all rounds is the winner.");

      // Make the rules label wrap text
      rulesLabel.setWrapText(true);

      // Create a ScrollPane
      ScrollPane scrollPane = new ScrollPane();
      scrollPane.setContent(rulesLabel);
      scrollPane.setFitToWidth(true); // Adjust width to fit the ScrollPane

      // Create a VBox for layout
      VBox layout = new VBox(10);
      layout.setPadding(new Insets(20));
      layout.getChildren().addAll(scrollPane);

      // Back Button
      Button backButton = new Button("Back");
      backButton.setOnAction(event -> {
          // Handle back button action (this could change to another scene)
          primaryStage.close(); // Close the rules window
      });

      // Add back button to VBox
      layout.getChildren().add(backButton);

      // Create the scene
      Scene rulesScene = new Scene(layout, 700, 700);
      
      rules.setOnAction(e -> {
    	  primaryStage.setScene(rulesScene);
    	    primaryStage.setTitle("Skru Card Game Rules");
      });
      
      
    

	
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Game Menu");
        primaryStage.show();
    }
    public ArrayList<String> getPlayerNames()
    {
    ArrayList <String> result = new ArrayList<>();
    result.add(Player1Name.getText());
    result.add(Player2Name.getText());
    result.add(Player3Name.getText());
    result.add(Player4Name.getText());
    return result;
    	
    }
  
    private void displayAlert(String title, String message,String msgButton) {
        Stage alertStage = new Stage();
        alertStage.setTitle(title);

        Label label = new Label(message);
        Button closeButton = new Button(msgButton);
        //closing is predefined
        closeButton.setOnAction(event -> alertStage.close());

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(closeButton);

        Scene scene = new Scene(pane, 400, 80);
        alertStage.setScene(scene);
        alertStage.show();
    }
    
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

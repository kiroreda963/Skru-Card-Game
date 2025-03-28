package game.gui;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


import game.cards.*;
import game.engine.Game;
import game.engine.Player;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import java.util.ArrayList;
import game.exceptions.*;
public class GameGui  extends Application {

	private Game game;
    private mainGUI mainGuiInstance; // Reference to mainGUI instance

    public GameGui(mainGUI mainGuiInstance) {
        this.mainGuiInstance = mainGuiInstance; // Initialize with the mainGUI instance
    }
	
	    
	@Override
	public void start(Stage primaryStage)  {
		game = new Game(this.makePlayers(mainGuiInstance.getPlayerNames()));
		
		BorderPane mainBoard = new BorderPane();
		GridPane winnerGrid = new GridPane();
		Scene MainScene = new Scene(mainBoard, 1200, 700);	
		  Image backgroundImage = new Image("file:D:/GIU/prog II skru game/pngs/background.png");
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
		     mainBoard.setBackground(new Background(background));
		
		  Label playerName1 =new Label(mainGuiInstance.getPlayerNames().get(0));
		  Label playerName2 =new Label(mainGuiInstance.getPlayerNames().get(1));
		  Label playerName3 =new Label(mainGuiInstance.getPlayerNames().get(2));
		  Label playerName4 =new Label(mainGuiInstance.getPlayerNames().get(3));
		  Button endTrun = new Button ("End Turn");
		  Button declareSkru = new Button ("declare Skru");
		  playerName1.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
		  playerName2.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
		  playerName3.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
		  playerName4.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
		  HBox player1box = new HBox(10);
		  HBox player3box = new HBox(10);
		  HBox player2box=new HBox(10);
		  HBox player4box=new HBox(10);
		  HBox middleBox =new HBox(90);
		  VBox playerName1Options =new VBox(5);
		  VBox playerName2Options =new VBox(5);
		  VBox playerName3Options =new VBox(5);
		  VBox playerName4Options =new VBox(5);
		  HBox player1CardsBox =new HBox(10);
		  HBox player2CardsBox =new HBox(10);
		  HBox player3CardsBox =new HBox(10);
		  HBox player4CardsBox =new HBox(10);
		  StackPane deckPane = new StackPane();
		  StackPane discardDeckPane = new StackPane();
		  

	//////////
		  int [] [] scores = game.getTotalScores();
		
		  Label playersName1 =new Label(mainGuiInstance.getPlayerNames().get(0));
		  Label playersName2 =new Label(mainGuiInstance.getPlayerNames().get(1));
		  Label playersName3 =new Label(mainGuiInstance.getPlayerNames().get(2));
		  Label playersName4 =new Label(mainGuiInstance.getPlayerNames().get(3));
		  Label playernames = new Label ("player names");
		  Label round1 = new Label ("Round 1");
		  Label round2 = new Label ("Round 2");
		  Label round3 = new Label ("Round 3");
		  Label round4 = new Label ("Round 4");
		  Label round5 = new Label ("Round 5");
		  //Label total = new Label ("Total");
		  Button continueplaying = new Button ("continue");
		  winnerGrid.add(playernames,0,0);
		  winnerGrid.add(round1,1,0);
		  winnerGrid.add(round2,2,0);
		  winnerGrid.add(round3,3,0);
		  winnerGrid.add(round4,4,0);
		  winnerGrid.add(round5,5,0);
		  //winnerGrid.add(total, 6,0);
		  winnerGrid.add(playersName1, 0, 1) ;
		  winnerGrid.add(playersName2, 0, 2) ;
		  winnerGrid.add(playersName3, 0, 3) ;
		  winnerGrid.add(playersName4, 0, 4) ;
		  winnerGrid.add(continueplaying, 2, 6);
		  winnerGrid.setHgap(10); // Horizontal gap between columns
	        winnerGrid.setVgap(10); // Vertical gap between rows
	        winnerGrid.setPadding(new Insets(20)); // Top, Right, Bottom, Left padding
		  Scene secondScene = new Scene(winnerGrid,500,300);
//	        mainBoard.setMargin(player4box, new Insets(0, 0, 0, -80)); // Move 10 pixels more to the left
//	        mainBoard.setMargin(player2box, new Insets(0, 0, 0, -200)); // Move 10 pixels more to the left
//	        mainBoard.setMargin(playerName2, new Insets(0, 0, 0, -50)); // Move 10 pixels more to the left
//	        mainBoard.setMargin(playerName4Options, new Insets(0, 0, 0, -65)); // Move 10 pixels more to the left
	        
	     
	       
	        showcardOptions(player1CardsBox,player2CardsBox,player3CardsBox, player4CardsBox,discardDeckPane  );
	        showOptions();
	        showDiscardDeckOptions (player1CardsBox,player2CardsBox,player3CardsBox,player4CardsBox, discardDeckPane);
	        showDeckOptions (player1CardsBox,player2CardsBox,player3CardsBox,player4CardsBox, deckPane,discardDeckPane);
	        
	        endTrun.setOnAction(event ->{
	        	try {
	        		resetOptionBox();
	        		game.endTurn();
	        		 showcardOptions(player1CardsBox,player2CardsBox,player3CardsBox, player4CardsBox,discardDeckPane  );
	        		 showDiscardDeckOptions (player1CardsBox,player2CardsBox,player3CardsBox,player4CardsBox, discardDeckPane);
	     	        showOptions();
	     	        int flag = game.getCurrentRound();
	     	       System.out.println(game.getCurrentPlayer().getTurnCount());
	     	      game.endRound();
	     	       if(game.getCurrentRound()>flag)
	     	       {
	     	    	  Label firstPlayerScore =new Label (getplayerscores ( scores,0,game.getCurrentRound()-1));
	     	    	  winnerGrid.add(firstPlayerScore, game.getCurrentRound()-1, 1);
	     	    	 Label secondPlayerScore =new Label (getplayerscores ( scores,1,game.getCurrentRound()-1));
	     	    	  winnerGrid.add(secondPlayerScore, game.getCurrentRound()-1, 2);
	     	    	 Label thirdPlayerScore =new Label (getplayerscores ( scores,2,game.getCurrentRound()-1));
	     	    	  winnerGrid.add(thirdPlayerScore, game.getCurrentRound()-1, 3);
	     	    	 Label fourthPlayerScore =new Label (getplayerscores ( scores,3,game.getCurrentRound()-1));
	     	    	  winnerGrid.add(fourthPlayerScore, game.getCurrentRound()-1, 4);
	     	    	 if(game.gameOver()==true)
	     	    	 {
	     	    		 
	     	    		 Label winner = new Label("the winner is "+mainGuiInstance.getPlayerNames().get(game.getWinner()));
	     	    		 winnerGrid.add(winner, 2, 7);
	     	    		 continueplaying.setVisible(false);
	     	    		 
	     	    	 }
	     	    	  primaryStage.setScene(secondScene);
	     		        primaryStage.show(); 
	     		        
	     	       }
	     	    	   

	        	}
	        	catch(CannotPlayException exception)
	        	{
	        		displayAlert("Error!","    you  must play a card","Continue");
	        	}
	        });
	        
	        
	        declareSkru.setOnAction(event ->
	        {
	        try {
	        	Player declaredskruplayer = game.getCurrentPlayer();
	        	int playerindex =game.getPlayers().indexOf(declaredskruplayer);
	        	String playername = mainGuiInstance.getPlayerNames().get(playerindex);
	        	game.declareSkru();
	        	displayAlert("announcement!",playername+"   declared Skru  ","Continue");
	        }
	        catch(CannotSkruException exception)
	        {
	        	displayAlert("Error!","   A player has declared Skru or you haven't reached the min # turns  ","Continue");
	        }
	        
	        });
	        
	        continueplaying.setOnAction (event ->
	        {
	        	primaryStage.setScene(MainScene);
	        	  player1box.getChildren().clear();
	        	  player2box.getChildren().clear();
	        	  player3box.getChildren().clear();
	        	  player4box.getChildren().clear();
	        	  middleBox.getChildren().clear();
	        	  player1CardsBox.getChildren().clear();
	        	  player2CardsBox.getChildren().clear();
	        	  player3CardsBox.getChildren().clear();
	        	  player4CardsBox.getChildren().clear();
	        	  showcardOptions(player1CardsBox,player2CardsBox,player3CardsBox, player4CardsBox,discardDeckPane  );
	        	  addcardstoHBox(0,player1CardsBox);
	        	  addcardstoHBox(1,player2CardsBox);
	        	  addcardstoHBox(2,player3CardsBox);
	        	  addcardstoHBox(3,player4CardsBox);
	            
		        showOptions();
		        player1box.getChildren().addAll(player1CardsBox,playerName1Options);
		        player2box.getChildren().addAll(player2CardsBox,playerName2Options);
		        player3box.getChildren().addAll(player3CardsBox,playerName3Options);
		        player4box.getChildren().addAll(player4CardsBox,playerName4Options);
		        showDiscardDeckOptions (player1CardsBox,player2CardsBox,player3CardsBox,player4CardsBox, discardDeckPane);
		        showDeckOptions (player1CardsBox,player2CardsBox,player3CardsBox,player4CardsBox, deckPane,discardDeckPane);
		        middleBox.getChildren().addAll(discardDeckPane,deckPane);
	        	
	        });
	    
	 


		//  mainBoard.setPadding(new Insets(1));
mainBoard.setBottom(player1box);	
mainBoard.setRight(player2box);	
mainBoard.setTop(player3box);	
mainBoard.setLeft(player4box);	
mainBoard.setCenter(middleBox);
player1box.setAlignment(Pos.CENTER);
player3box.setAlignment(Pos.CENTER);
player2box.setAlignment(Pos.BOTTOM_CENTER);
player4box.setAlignment(Pos.BOTTOM_CENTER);
middleBox.setAlignment(Pos.CENTER);


player1box.getChildren().addAll(player1CardsBox,playerName1Options);
player2box.getChildren().addAll(player2CardsBox,playerName2Options);
player3box.getChildren().addAll(player3CardsBox,playerName3Options);
player4box.getChildren().addAll(player4CardsBox,playerName4Options);

middleBox.getChildren().addAll(discardDeckPane,deckPane);
		
playerName1Options.getChildren().addAll(playerName1,endTrun,declareSkru);
playerName2Options.getChildren().addAll(playerName2);
playerName3Options.getChildren().addAll(playerName3);
playerName4Options.getChildren().addAll(playerName4);

addcardstoHBox(0,player1CardsBox);
addcardstoHBox(1,player2CardsBox);
addcardstoHBox(2,player3CardsBox);
addcardstoHBox(3,player4CardsBox);
player3box.setRotate(180);
player4box.setRotate(90);
player2box.setRotate(270);

player2CardsBox.setAlignment(Pos.CENTER);
playerName2Options.setAlignment(Pos.CENTER);
player4CardsBox.setAlignment(Pos.CENTER);
playerName4Options.setAlignment(Pos.CENTER);



DeckOrDiscardAddCards(deckPane,game.getDeck());	
DeckOrDiscardAddCards(discardDeckPane,game.getDiscardDeck());	
		
		//System.out.println(mainGui.getPlayerNames().toString());
		  
			        primaryStage.setFullScreen(true);
		 primaryStage.setTitle("Scru Game Developed by Kiro,joe,Ahmed");
	        primaryStage.setScene(MainScene);
	        primaryStage.show();
	}
	
	public ArrayList<Player> makePlayers (ArrayList<String> names)
	{
		ArrayList<Player> result = new ArrayList<>();
	Player player1 =new Player(names.get(0));
	Player player2 =new Player(names.get(1));
	Player player3 =new Player(names.get(2));
	Player player4 =new Player(names.get(3));
	result.add(player1);
	result.add(player2);
	result.add(player3);
	result.add(player4);
	return result;
	

	}
	public void addcardstoHBox (int indexPlayer,HBox hbox)
	{
		hbox.getChildren().clear();
		ArrayList<Card> playerHand = game.getPlayers().get(indexPlayer).getHand();

		// Iterate through the player's hand from last to first
		for (int i = playerHand.size() - 1; i >= 0; i--) {
		    Card playerHandCard = playerHand.get(i);

		    // Add each card individually to the HBox
		    hbox.getChildren().add(playerHandCard);

		    // Set the size of the card's front and back images
		    playerHandCard.frontImageView.setFitHeight(150);
		    playerHandCard.frontImageView.setFitWidth(100);
		    playerHandCard.backImageView.setFitHeight(150);
		    playerHandCard.backImageView.setFitWidth(100);
		    playerHandCard.frontImageView.setPreserveRatio(true);
	        playerHandCard.backImageView.setPreserveRatio(true);
		}
	}
	public void DeckOrDiscardAddCards (StackPane setOfCards,ArrayList <Card> deckordiscarddeck)
	{
		Card firstCard = deckordiscarddeck.getLast();

		// Set fit height and width for the card's images
		firstCard.frontImageView.setFitHeight(150);  // Set to desired height
		firstCard.frontImageView.setFitWidth(100);
		firstCard.frontImageView.setPreserveRatio(true);  // Preserve the aspect ratio
		firstCard.backImageView.setFitHeight(150);  // Set to desired height
		firstCard.backImageView.setFitWidth(100);
		firstCard.backImageView.setPreserveRatio(true);  // Preserve the aspect ratio

		// Add the card to the discardDeckPane
		setOfCards.getChildren().add(firstCard);
	}
	
	public void updatediscardDeck(StackPane setOfCards)
	{
		 DeckOrDiscardAddCards ( setOfCards,game.getDiscardDeck())	;
	}
	
	public void updateDeck(StackPane setOfCards)
	{
		 DeckOrDiscardAddCards ( setOfCards,game.getDeck())	;
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
	
    private void showcardOptions(HBox p1, HBox p2, HBox p3, HBox p4, StackPane discardDeckPane) {
        // Clear existing cards and reset the HBox for the current player
        int currentPlayerIndex = game.getPlayers().indexOf(game.getCurrentPlayer());
        final HBox currentPlayerBox;  // Declare currentPlayerBox as final

        switch (currentPlayerIndex) {
            case 0: currentPlayerBox = p1; break;
            case 1: currentPlayerBox = p2; break;
            case 2: currentPlayerBox = p3; break;
            case 3: currentPlayerBox = p4; break;
            default: currentPlayerBox = null; // Ensure it's always initialized
        }

        // Clear the current player's box to remove old cards
        currentPlayerBox.getChildren().clear();
        currentPlayerBox.setSpacing(10); // Set consistent spacing
        currentPlayerBox.setAlignment(Pos.CENTER); // Set consistent alignment

        // Loop through the current player's hand to display the card options
        for (Card currentPlayerCard : game.getCurrentPlayer().getHand()) {
            // Make the Play and Replicate buttons visible, hide the Draw button
            currentPlayerCard.getPlay().setVisible(true);
            currentPlayerCard.getReplicate().setVisible(true);
            currentPlayerCard.getDraw().setVisible(false);

            // Reset event handlers for each card
            resetEventHandlers(currentPlayerCard);

            // Set the action for the Play button
            currentPlayerCard.getPlay().setOnAction(event -> {
                try {
                    game.PlayCard(currentPlayerCard);
                    addcardstoHBox(currentPlayerIndex, currentPlayerBox); // Refresh player's hand
                    updatediscardDeck(discardDeckPane); // Update discard deck pane
                    if(currentPlayerCard instanceof GiveCard)
                    {
                    	doGiveAction();
                    	showcardOptions(p1,p2,p3, p4,discardDeckPane  );
                    }
                } catch (CannotPlayException exception) {
                    displayAlert("Error!", "You have already played a card", "Continue");
                } catch (CannotDrawException exception) {
                    displayAlert("Error!", "You must draw a card first", "Continue");
                }
            });

            // Set the action for the Replicate button
            currentPlayerCard.getReplicate().setOnAction(event -> {
                try {
                    game.replicate(currentPlayerCard);
                    addcardstoHBox(currentPlayerIndex, currentPlayerBox); // Refresh player's hand
                    updatediscardDeck(discardDeckPane); // Update discard deck pane
                } catch (CannotPlayException exception) {
                    displayAlert("Error!", "You have already played a card", "Continue");
                }
                    catch (CannotDrawException exception) {
                        displayAlert("Error!", "You must draw a card first", "Continue");
                    }
                
            });

            // Add the card to the player's HBox
            currentPlayerBox.getChildren().add(currentPlayerCard);
        }
    }

    private void showOptions()
    {
    for (Card currentPlayerCard : game.getCurrentPlayer().getHand()) {
        
        currentPlayerCard.setOnMouseEntered(event -> {
            StackPane.setAlignment(currentPlayerCard.optionsBox, Pos.CENTER); // Position the options box at the top-right corner
            currentPlayerCard.optionsBox.toFront(); // Bring the options box to the front
            currentPlayerCard.optionsBox.setVisible(true); // Show the options box when the mouse enters
        });

        currentPlayerCard.setOnMouseExited(event -> currentPlayerCard.optionsBox.setVisible(false)); // Hide the options box when the mouse exits
    }
    }
    
    private void resetOptionBox() {
    for (Card currentPlayerCard : game.getCurrentPlayer().getHand()) {
    	currentPlayerCard.optionsBox.setVisible(false);
    	currentPlayerCard.getPlay().setVisible(false);
    	currentPlayerCard.getReplicate().setVisible(false);
    	currentPlayerCard.setRecentlyDrawed(false);

    }
}
   private void showDiscardDeckOptions (HBox p1,HBox p2,HBox p3, HBox p4,StackPane discardDeckPane)
   {
    if(game.getDiscardDeck().getLast()!=null)
    {
    	Card lastCardDiscard=game.getDiscardDeck().getLast();
    	lastCardDiscard.setOnMouseEntered(event -> {
    	lastCardDiscard.optionsBox.toFront();
     	lastCardDiscard.optionsBox.setVisible(true);
     	lastCardDiscard.optionsBox.setAlignment(Pos.CENTER);
     	lastCardDiscard.getPlay().setVisible(false);
     	lastCardDiscard.getReplicate().setVisible(false);
     	lastCardDiscard.getDraw().setVisible(true);
    	  });
    	lastCardDiscard.setOnMouseExited(event -> lastCardDiscard.optionsBox.setVisible(false));
    	lastCardDiscard.getDraw().setOnAction(event ->{
    		try {
    			game.DrawCardFromDiscardDeck();
    			int currentPlayerIndex= game.getPlayers().indexOf(game.getCurrentPlayer());
        		HBox currentPlayerBox=null;
        		switch(currentPlayerIndex)
        		{
        		case 0: currentPlayerBox=p1;break;
        		case 1: currentPlayerBox=p2;break;
        		case 2: currentPlayerBox=p3;break;
        		case 3: currentPlayerBox=p4;break;
        		
        		}
        		addcardstoHBox(currentPlayerIndex,currentPlayerBox);
        		showOptions();
        		showcardOptions( p1, p2, p3,  p4, discardDeckPane  );
    		}
    		catch ( CannotPlayException exception)
    		{
    			displayAlert("Error!","    you have already drawed a card","Continue");
    		}
    		
    	});
    
    }
    	
    	
    }
   
   private void showDeckOptions (HBox p1,HBox p2,HBox p3, HBox p4,StackPane DeckPane, StackPane discardDeckPane)
   {
	   if(game.getDeck().getLast()!=null)
	    {
	    	Card lastCardDiscard=game.getDeck().getLast();
	    	lastCardDiscard.setOnMouseEntered(event -> {
	    	lastCardDiscard.optionsBox.toFront();
	     	lastCardDiscard.optionsBox.setVisible(true);
	     	lastCardDiscard.optionsBox.setAlignment(Pos.CENTER);
	     	lastCardDiscard.getPlay().setVisible(false);
	     	lastCardDiscard.getReplicate().setVisible(false);
	     	lastCardDiscard.getDraw().setVisible(true);
	     	lastCardDiscard.setRecentlyDrawed(true);
	    	  });
	    	lastCardDiscard.setOnMouseExited(event -> lastCardDiscard.optionsBox.setVisible(false));
	    	lastCardDiscard.getDraw().setOnAction(event ->{
	    		try {
	    			game.DrawCardFromDeck();
	    			int currentPlayerIndex= game.getPlayers().indexOf(game.getCurrentPlayer());
	        		HBox currentPlayerBox=null;
	        		switch(currentPlayerIndex)
	        		{
	        		case 0: currentPlayerBox=p1;break;
	        		case 1: currentPlayerBox=p2;break;
	        		case 2: currentPlayerBox=p3;break;
	        		case 3: currentPlayerBox=p4;break;
	        		
	        		}
	        		addcardstoHBox(currentPlayerIndex,currentPlayerBox);
	        		updateDeck(DeckPane);
	        		//showDeckOptions(p1, p2, p3, p4, DeckPane,discardDeckPane);
//	        		resetEventHandlers(lastCardDiscard);
	        		showcardOptions( p1, p2, p3,  p4, discardDeckPane  );
//	        		refreshCardOptions();
	        		showOptions();
	        		showDeckOptions ( p1, p2, p3,  p4, DeckPane,  discardDeckPane);
	        		//System.out.println(game.getCurrentPlayer().getHand().size());
	    		}
	    		catch ( CannotPlayException exception)
	    		{
	    			displayAlert("Error!","    you have already drawed a card","Continue");
	    		}
	    		
	    	});
   }
   }
  

	// Helper method to clear existing event handlers
	private void resetEventHandlers(Card card) {
	    card.getPlay().setOnAction(null);
	    card.getReplicate().setOnAction(null);
	    card.getDraw().setOnAction(null);
	}


	private HBox getCurrentPlayerBox(int playerIndex, HBox p1, HBox p2, HBox p3, HBox p4) {
	    switch (playerIndex) {
	        case 0:
	            return p1;
	        case 1:
	            return p2;
	        case 2:
	            return p3;
	        case 3:
	            return p4;
	        default:
	            return null; // Should not happen
	    }
	}
	
	private void refreshCardOptions()
	{
		for (Card currentPlayerCard : game.getCurrentPlayer().getHand()) {
			
			currentPlayerCard.getPlay().setVisible(true);
			currentPlayerCard.getReplicate().setVisible(true);
			currentPlayerCard.getDraw().setVisible(false);
			
		}
	}
	
	private void doGiveAction()
	{
		Card lastCard =game.getDiscardDeck().getLast();
		if (lastCard instanceof GiveCard && lastCard.isRecentlyDrawed() )
		{
			Card  [] selectedCards=showSelectButton ();
			Player chosenplayer = findPlayerWithCard(selectedCards[0]);
			//int currentPlayerCardIndex = findCardIndex(selectedCards[0]);
			//int cardIndex = findCardIndex(selectedCards1[0]);
			game.useSpecialCard(chosenplayer, selectedCards[0]);
			
			 }
		
			
		}
	


	private Card[] showSelectButton() {
	    final Card[] selectedCard = new Card[2]; // The array to hold the selected cards
	    final int [] index =new int[2];
	    AtomicInteger i = new AtomicInteger(1); // AtomicInteger to allow modification inside lambda

	    for (Player players : game.getPlayers()) {
	        for (Card playerCards : players.getHand()) {
	            playerCards.getSelect().setVisible(true); // Make the select button visible
	            showOptions(); // Show options for cards (assuming this method does that)
	            
	            // Set an action handler for the select button
	            playerCards.getSelect().setOnAction(event -> {
	                int currentIndex = i.getAndIncrement(); // Get the current index and increment
	                if (currentIndex < selectedCard.length) { // Ensure we don't exceed array bounds
	                    selectedCard[currentIndex] = playerCards; // Assign selected card to array
	                    
	                }
	            });
	        }
	    }
	    return selectedCard;
	}
	
	private Player findPlayerWithCard(Card selectedCard) {
	    for (Player player : game.getPlayers()) { // Assuming `game.getPlayers()` returns a list of all players
	        for (Card playerCard : player.getHand()) { // Assuming `player.getHand()` returns the player's hand (list of cards)
	            if (game.isequal(playerCard, selectedCard)) {
	                return player; // Return the player who owns the card
	                
	            }
	        }
	    }
	    return null; // If no player has the card, return null
	}
	
	private int findCardIndex(Card selectedCard) {
	    for (Player player : game.getPlayers()) { // Assuming `game.getPlayers()` returns a list of all players
	        for (Card playerCard : player.getHand()) { // Assuming `player.getHand()` returns the player's hand (list of cards)
	            if (game.isequal(playerCard, selectedCard)) {
	               
	               return player.getHand().indexOf(selectedCard);
	            }
	        }
	    }
	    return -1; // If no player has the card, return null
	}
	
	private String getplayerscores (int scores[][],int playerindex,int roundnumber)
	{
		int playerscore = scores[playerindex][roundnumber];
		String playerscorestring =String.valueOf(playerscore);
		return playerscorestring;
		
	}
	

	
    
}
	
	
	


	

	



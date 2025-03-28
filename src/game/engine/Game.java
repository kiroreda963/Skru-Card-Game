package game.engine;

import game.cards.ActionCard;
import game.cards.Card;
import game.cards.GiveCard;
import game.cards.MasterEyeCard;
import game.cards.NumberCard;
import game.cards.OthersRevealerCard;
import game.cards.ReplicaCard;
import game.cards.SelfRevealerCard;
import game.cards.SkruCard;
import game.cards.SwapCard;
import game.enums.SkruType;
import game.exceptions.CannotDrawException;
import game.exceptions.CannotPlayException;
import game.exceptions.CannotSkruException;
import game.exceptions.CardActionException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game {

	// milestone 2//
	private Player declaredSkru = null;

	public static final int MAX_NUMBER_OF_ROUNDS = 5;
	public static final int MAX_NUMBER_OF_PLAYERS = 4;

	private int currentRound;
	private Player currentPlayer;
	private int[][] totalScores;
	private ArrayList<Player> players;
	private ArrayList<Card> deck;
	private ArrayList<Card> discardDeck;

	public Player getDeclaredSkru() {
		return declaredSkru;
	}

	public void setDeclaredSkru(Player declaredSkru) {
		this.declaredSkru = declaredSkru;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getDiscardDeck() {
		return discardDeck;
	}

	public void setDiscardDeck(ArrayList<Card> discardDeck) {
		this.discardDeck = discardDeck;
	}

	public static int getMaxNumberOfRounds() {
		return MAX_NUMBER_OF_ROUNDS;
	}

	public static int getMaxNumberOfPlayers() {
		return MAX_NUMBER_OF_PLAYERS;
	}

	public int[][] getTotalScores() {
		return totalScores;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	private static ArrayList<Card> generateDeck() {
		ArrayList<Card> out = new ArrayList<Card>();

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 6; j++) {
				out.add(new NumberCard(j));
			}
			out.add(new MasterEyeCard());
			out.add(new SwapCard());
			out.add(new GiveCard());
			out.add(new SkruCard(SkruType.GREEN));
			out.add(new SkruCard(SkruType.RED));
		}

		for (int i = 0; i < 3; i++) {
			out.add(new SelfRevealerCard(7));
			out.add(new SelfRevealerCard(8));
		}

		for (int i = 0; i < 2; i++) {
			out.add(new OthersRevealerCard(9));
			out.add(new OthersRevealerCard(10));
		}

		for (int i = 0; i < 8; i++) {
			out.add(new NumberCard(0));
			out.add(new ReplicaCard());
		}

		Collections.shuffle(out);

		return out;
	}

	public Game(ArrayList<Player> players) {

		this.totalScores = new int[MAX_NUMBER_OF_PLAYERS][MAX_NUMBER_OF_ROUNDS];
		this.deck = generateDeck();
		this.players = new ArrayList<Player>();
		this.discardDeck = new ArrayList<Card>();
		this.currentRound = 1;
		this.players.addAll(players);

		for (Player p : this.players) {
			for (int i = 0; i < 4; i++) {
				if (i < 2) {
					Card c = this.deck.remove(deck.size() - 1);
					c.setCardVisible(true);
					p.getHand().add(c);
				}

				else
					p.getHand().add(this.deck.remove(deck.size() - 1));
			}
		}

		this.currentPlayer = this.players.get(0);

		Card c = this.deck.remove(deck.size() - 1);
		c.setCardVisible(true);
		discardDeck.add(c);

	}

	// /////////////Milestone 2 ///////////////

	public void PlayCard(Card c) throws CannotPlayException,CannotDrawException {
		if(!currentPlayer.isHasDrawn())
		{
			throw new CannotDrawException("must draw first");
		}
		if (!currentPlayer.getHand().contains(c))
			throw new CannotPlayException("Cannot play card");
		if (currentPlayer.isHasPlayed())
			throw new CannotPlayException("Cannot play card");

		currentPlayer.discardCard(c, discardDeck);
		currentPlayer.setHasPlayed(true);

	}

	// to swap
	public void useSpecialCard(Player p2, int indexCard1, int indexCard2) {
		Card c1 = currentPlayer.getHand().get(indexCard1);
		Card c2 = p2.getHand().get(indexCard2);
		currentPlayer.getHand().add(indexCard1, c2);
		p2.getHand().add(indexCard2, c1);

	}

	// to give
	public void useSpecialCard(Player p2, Card c) {
		int i = currentPlayer.getHand().indexOf(c);
		p2.getHand().add(currentPlayer.getHand().remove(i));
	}

	// show
	public void useSpecialCard(int i1, int i2, int i3, int i4) {
		players.get(0).getHand().get(i1).setCardVisible(true);
		players.get(1).getHand().get(i2).setCardVisible(true);
		players.get(2).getHand().get(i3).setCardVisible(true);
		players.get(3).getHand().get(i4).setCardVisible(true);
	}

	public void declareSkru() throws CannotSkruException {
		if (declaredSkru != null || currentPlayer.isHasPlayed() || currentPlayer.isHasDrawn())
			throw new CannotSkruException("another player declared skru");

		if (currentPlayer.getTurnCount() < 3)
			throw new CannotSkruException(
					"you cannot declare skru before your 3rd turn");

		declaredSkru = currentPlayer;
		currentPlayer.setHasDrawn(true);
		currentPlayer.setHasPlayed(true);

	}

	public void endTurn() throws CannotPlayException {

		if (!currentPlayer.isHasPlayed())
			throw new CannotPlayException(
					"Player shoud play a card before ending his turn");

		currentPlayer.setHasDrawn(false);
		currentPlayer.setHasPlayed(false);
		currentPlayer.setCurrenrTurnTotal(currentPlayer.updateTotal());
		currentPlayer.setTurnCount(currentPlayer.getTurnCount() + 1);
		int i = players.indexOf(currentPlayer);
		int nxt = (i + 1) % 4;
		currentPlayer = players.get(nxt);

		for (Player p : players) {
			for (Card c : p.getHand()) {
				c.setCardVisible(false);
			}
		}

	}

	public void resetGame() {
		deck = generateDeck();
		discardDeck = new ArrayList<Card>();

		for (Player p : this.players) {
			p.getHand().clear();
			p.setCurrenrTurnTotal(0);
			p.setTurnCount(0);
			p.setHasDrawn(false);
			p.setHasPlayed(false);
			for (int i = 0; i < 4; i++) {
				if (i < 2) {
					Card c = this.deck.remove(deck.size() - 1);
					c.setCardVisible(true);
					p.getHand().add(c);
				}

				else
					p.getHand().add(this.deck.remove(deck.size() - 1));
			}
		}

		currentPlayer = this.players.get(0);

		Card c = this.deck.remove(deck.size() - 1);
		c.setCardVisible(true);
		discardDeck.add(c);

	}

	public void endRound() {
		if (declaredSkru != null) {
			int i1 = players.indexOf(currentPlayer);
			int i2 = players.indexOf(declaredSkru);

			if ((i2 - i1) == 1 || (i1 == 3 && i2 == 0)) {
				totalScores[0][currentRound] = players.get(0)
						.getCurrenrTurnTotal();
				totalScores[1][currentRound] = players.get(1)
						.getCurrenrTurnTotal();
				totalScores[2][currentRound] = players.get(2)
						.getCurrenrTurnTotal();
				totalScores[3][currentRound] = players.get(3)
						.getCurrenrTurnTotal();

				currentRound++;
				declaredSkru = null;

				resetGame();
				

			}
			

		}
		

	}

	public void performActionCard(Player p, Card c, int CardIndex)
			throws CardActionException {
		if (c instanceof SelfRevealerCard && (!p.equals(currentPlayer)))
			throw new CardActionException(
					"self reveal cards should only be used on the current player");

		if (c instanceof OthersRevealerCard && (p.equals(currentPlayer)))
			throw new CardActionException(
					"others reveal cards should not be used on the current player");

		p.getHand().get(CardIndex).setCardVisible(true);
	}

	public void DrawCardFromDeck() throws CannotPlayException {
		if (currentPlayer.isHasDrawn())
			throw new CannotPlayException(
					"The Player Has already drawn a card !!");
		Card c = deck.remove(deck.size() - 1);
		c.setCardVisible(true);
		currentPlayer.getHand().add(c);
		currentPlayer.setHasDrawn(true);

	}

	public void DrawCardFromDiscardDeck() throws CannotPlayException {
		if (currentPlayer.isHasDrawn())
			throw new CannotPlayException(
					"The Player Has already drawn a card !!");

		currentPlayer.getHand().add(discardDeck.remove(discardDeck.size() - 1));
		currentPlayer.setHasDrawn(true);

	}

	public boolean gameOver() {
		if (currentRound > 5)
			return true;
		else
			return false;
	}

	public int getWinner() {
		int min = 1000;
		int playerIndex = 0;

		for (int i = 0; i < MAX_NUMBER_OF_PLAYERS; i++) {
			int subtotal = 0;
			for (int j = 0; j < MAX_NUMBER_OF_ROUNDS; j++) {
				subtotal += totalScores[i][j];
			}
			if (subtotal <= min) {
				min = subtotal;
				playerIndex = i;
			}
		}

		return playerIndex;
	}

	public void replicate(Card c) throws CannotPlayException , CannotDrawException  {
	
		if(currentPlayer.isHasPlayed()==true)
			throw new CannotPlayException("you have already played ");
		else
		{
		if (isequal(discardDeck.getLast(),c)) {
			int cardIndex = currentPlayer.getHand().indexOf(c);
			discardDeck.add(currentPlayer.getHand().remove(cardIndex));
			System.out.println("card has been removed");
		} else {
			currentPlayer.getHand().add(
					discardDeck.remove(discardDeck.size() - 1));
			System.out.println("card hasnot been removed");
		}
		currentPlayer.setHasPlayed(true);
		currentPlayer.setHasDrawn(true);
		

	}
	}
	public boolean isequal(Card c1,Card c2)
	{
		NumberCard numberCard1;
		NumberCard numberCard2;
		SkruCard skrucard1;
		SkruCard skrucard2;
		if(c1.getClass()==c2.getClass())
		{
				if(c1 instanceof NumberCard || c1 instanceof OthersRevealerCard || c1 instanceof SelfRevealerCard  )
			{
				  numberCard1 = (NumberCard) c1;
	        numberCard2 = (NumberCard) c2;  // Cast c2 to NumberCard 
	        if (numberCard1.getNumber()==numberCard2.getNumber())
	        	return true;
			}
				
	        else if(c1 instanceof SkruCard)
	        {
	        	skrucard1=(SkruCard) c1;
	        	skrucard2=(SkruCard) c2;
	        	if( skrucard1.getValue()==skrucard2.getValue())
	        		return true;
	        	else 
	        		return false;
	        }
	        else
	        	return true;
		}
	        	
			
				return false;
		
}
	
}

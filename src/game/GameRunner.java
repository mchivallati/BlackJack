package game;

import engine.Dealer;
import engine.Deck;
import engine.Player;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class GameRunner
{

	/**
	 * @param args  String
	 */
	public static void main(String[] args)
	{

		Deck gameDeck = new Deck();
		Dealer dealer = new Dealer(gameDeck.getDeck());
		Player player = new Player(gameDeck.getDeck());

	}
	
}
package game;

import engine.Dealer;
import engine.Deck;
import engine.Player;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class GameRunner
{

	static boolean dealerWin = false;
	static boolean playerWin = false;
	static Deck gameDeck = new Deck();
	static Dealer dealer = new Dealer(gameDeck.getDeck());
	static Player player = new Player(gameDeck.getDeck());

	/**
	 * @param args  String
	 */
	public static void main(String[] args)
	{

		new GameFrame();

	}

	public static void checkRules()
	{

		if (GameRules.isHigher( dealer.getHand() , player.getHand() )) {
			dealerWin = true;
		} else {
			playerWin = true;
		}

	}
	
}
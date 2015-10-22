package game;

import engine.Dealer;
import engine.Deck;
import engine.Player;

import java.awt.*;

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
	static Graphics g;

	/**
	 * @param args  String
	 */
	public static void main(String[] args)
	{

		new GameFrame(g);

	}

	/**
	 *
	 */
	public static void checkRules()
	{

		if (GameRules.isHigher( dealer.getHand() , player.getHand() )) {
			dealerWin = true;
		} else {
			playerWin = true;
		}

	}

	/**
	 *
	 */
	public static void play()
	{



	}
	
}
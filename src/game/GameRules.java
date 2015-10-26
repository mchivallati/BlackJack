package game;

import engine.Card;
import engine.Dealer;
import engine.Deck;
import engine.Player;

import java.util.ArrayList;

/**
 *  Created by chiv on 10/12/2015. Class created to specify the rules of the gae using class methods
 */
public class GameRules
{

	public static boolean dealerWin = false;
	public static boolean playerWin = false;

	//TEMPORARY TEST RUNNER
	public static void main(String[] args)
	{

		Deck deck = new Deck();
		deck.shuffleDeck( 1000 );
		System.out.println("Dealer");
		Dealer d = new Dealer(deck.getDeck());
		System.out.println( d.toString() );
		System.out.println();
		System.out.println("Player");
		Player p = new Player(deck.getDeck());
		System.out.println( p.toString() );
		System.out.println();

		checkRules(d , p);

		System.out.println("Dealer Won: " + dealerWin);
		System.out.println("Player Won: " + playerWin);

	}

	/** USED ONLY IN GAMERULES.JAVA
	 * @param dealer            Dealer the dealer
	 * @param player            Player the player
	 * @return                  boolean true if the dealers wins, false if the player wins
	 */
	private static boolean isHigher(Dealer dealer , Player player)
	{

		return dealer.getHandValue() >= player.getHandValue();

	}


	/** CLASS METHOD
	 * @param dealer            Dealer the dealer
	 * @param player            PLayer the player
	 */
	public static void checkRules( Dealer dealer , Player player)
	{
		if ( isHigher( dealer, player ) ) {
			dealerWin = true;
			playerWin = false;
		} else if ( !isHigher( dealer, player ) ) {
			playerWin = true;
			dealerWin = false;
		}

		if (dealer.isBust() && player.isBust()) {
			System.out.println("You both lose");
			dealerWin = false;
			playerWin = false;
		}
		if ( dealer.isBust() && !player.isBust() ) {
			dealerWin = false;
			playerWin = true;
			System.out.println("The dealer busted");
		} else if (player.isBust() && !dealer.isBust()) {
			playerWin = false;
			dealerWin = true;
			System.out.println("You busted");
		}
	}

}
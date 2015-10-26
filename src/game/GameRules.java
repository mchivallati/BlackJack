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

	/**
	 * @param dealer            Dealer the dealer
	 * @param player            Player the player
	 * @return                  boolean true if the dealers wins, false if the player wins
	 */
	public static boolean isHigher(Dealer dealer , Player player)
	{

		return dealer.getHandValue() >= player.getHandValue();

	}


	/**
	 * @param dealer            Dealer the dealer
	 * @param player            PLayer the player
	 */
	public static void checkRules( Dealer dealer , Player player)
	{

		if ( isHigher( dealer, player ) ) {
			dealerWin = true;
		} else if ( !isHigher( dealer, player ) ) {
			playerWin = true;
		}

		if (dealer.isBust() && player.isBust()) {
			System.out.println("You both lose");
		} else if ( dealer.isBust() ) {
			dealerWin = false;
		} else if (player.isBust()) {
			playerWin = false;
		}
	}


}
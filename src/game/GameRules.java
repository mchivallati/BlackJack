package game;

import engine.Card;
import engine.Dealer;
import engine.Deck;
import engine.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Created by chiv on 10/12/2015. Class created to specify the rules of the gae using class methods
 */
public class GameRules
{

	//TEMPORARY TEST RUNNER
	/*public static void main(String[] args)
	{
		do {
			Deck deck = new Deck();
			deck.shuffleDeck( 1000 );
			System.out.println( "!----------Start of Hand----------!" );
			//System.out.println( "Dealer" );
			Dealer d = new Dealer( deck.getDeck() );
			//System.out.println( d.toString() );
			System.out.println();
			System.out.println( "Player" );
			System.out.println();
			Player p = new Player( deck.getDeck() );
			System.out.println( p.toString() );
			System.out.println();

			d.useDealerAI( deck );
			askAction( p, deck );

			checkRules( d , p );

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~RESULTS~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println( "Dealer Won: " + dealerWin );
			System.out.println(d.toString());
			System.out.println();
			System.out.println( "Player Won: " + playerWin );
			System.out.println(p.toString());
			System.out.println();
			System.out.println( "!----------End of Hand----------!" );
			System.out.println();
		} while (askToReplay());

		System.out.println();
		System.out.println("YOU CANT STOP PLAYING YOU HEATHEN");
		System.out.println("Thanks for playing, don't forget to tip your dev!");

	}*/

	/** USED ONLY IN GAMERULES.JAVA
	 * @param dealer            Dealer the dealer
	 * @param player            Player the player
	 * @return                  boolean true if the dealers wins, false if the player wins
	 */
	private static boolean isHigher(Dealer dealer , Player player)
	{

		return dealer.getHandValue() > player.getHandValue();

	}


	/** CLASS METHOD
	 * @param dealer            Dealer the dealer
	 * @param player            PLayer the player
	 */
	public static void checkRules( Dealer dealer , Player player)
	{

		if (player.isBust() && !dealer.isBust()) {
            System.out.println();
            System.out.println(" :( YOU BUSTED, THE DEALER WINS :(");
            System.out.println();
            System.out.println(dealer.toString());
        } else if (dealer.isBust() && !player.isBust()) {
            System.out.println();
            System.out.println(" :) THE DEALER BUSTED, YOU WIN :)");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if (player.isBust() && dealer.isBust()) {
            System.out.println();
            System.out.println(" :| YOU BOTH BUSTED, NO ONE WINS :|");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if (player.getHandValue() == dealer.getHandValue()) {
            System.out.println();
            System.out.println(" :| ITS A TIE :|");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if ( isHigher( dealer, player ) ) {
            System.out.println();
            System.out.println(" :( THE DEALER BEAT YOU, YOU LOSE :(");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if ( !isHigher( dealer, player ) ) {
            System.out.println();
            System.out.println(" :) YOU BEAT THE DEALER, YOU WIN :)");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        }
	}

}

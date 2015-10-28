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

	public static boolean dealerWin = false;
	public static boolean playerWin = false;

	//TEMPORARY TEST RUNNER
	public static void main(String[] args)
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
		} while (askToPlay());

		System.out.println();
		System.out.println("Thanks for playing, don't forget to tip you dev!");

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

	/**
	 * @param p                 Player the player being asked
	 */
	public static void askAction(Player p , Deck d)
	{

		Scanner scan = new Scanner(System.in);
		System.out.print("Do you want to hit or stay? H/S: ");
		String input = scan.nextLine();
		takeAction(input , p , d.getDeck());
	}


	/**
	 * @return                  boolean true if the player wants to continue playing
	 */
	public static boolean askToPlay()
	{

		Scanner scan = new Scanner(System.in);
		System.out.print( "Do you want to play another hand? Y/N:" );
		String input = scan.nextLine();
		return input.equalsIgnoreCase( "Y" );

	}

	/**
	 * @param input             String can only be H or S
	 * @param p                 Player the player that is being asked
	 * @param deck              ArrayList<Card> the game deck
	 */
	public static void takeAction(String input , Player p , ArrayList<Card> deck)
	{
			if ( input.toUpperCase().equals( "H" ) ) {
				p.hit( deck );
			}

			if ( input.toUpperCase().equals( "S" ) ) {
				p.stay();
			}

			if ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
				System.out.println( "Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
			}

		Scanner finish = new Scanner( System.in );
		String userIn = "";
		if (!p.isBust() && !input.equalsIgnoreCase("S")) {
			System.out.print( "Hit again? Y/N: " );
			userIn = finish.nextLine();
		}

		while (userIn.equalsIgnoreCase("Y")) {
			if ( input.toUpperCase().equals( "H" ) ) {
				p.hit( deck );
			}

			if ( input.toUpperCase().equals( "S" ) ) {
				p.stay();
			}

			if ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
				System.out.println( "Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
			}

				System.out.print( "Hit again? Y/N: " );
				userIn = finish.nextLine();

		}


	}

}
/*
*
*
* ONLY USED FOR THE TEXT BASED VERSION
*
*
*
 */
package game;

import engine.Card;
import engine.Dealer;
import engine.Deck;
import engine.Player;

import java.util.ArrayList;
import java.util.Scanner;


public class GameRunner {
	
	/**
	 * @param args String[] command line arguments
	 */
	public static void main( String[] args ) {
		
		Deck deck = new Deck();
		deck.shuffleDeck( 1000 );
		System.out.println();
		System.out.println( "Dealer" );
		Dealer d = new Dealer( deck.getDeck() );
		//System.out.println( d.showCard() );
		System.out.println();
		System.out.println( "Player" );
		Player p = new Player( deck.getDeck() );
		System.out.println();
		
		doGameSequence( deck, p, d );
		
		do {
			doGameSequence( deck, p, d );
		}
		while ( askToReplay() );
		
	}
	
	/**
	 * @param deck Deck the game deck
	 */
	private static void doGameSequence( Deck deck, Player p, Dealer d ) {
		
		System.out.println( "!----------Start of Hand----------!" );
		
		System.out.println( "$" + p.getPurse() );
		askBet( p );
		
		System.out.println( d.toString() );
		System.out.println( p.toString() );
		
		askAction( p, deck );
		if ( ! p.isBust() ) {
			d.useDealerAI( deck );
		}
		
		GameRules.checkRules( d, p );
		
		System.out.println();
		System.out.println( "END OF HAND" );
		p.returnCardsToDeck( deck.getDeck() );
		d.returnCardsToDeck( deck.getDeck() );
		
	}
	
	/**
	 * @return boolean true if the player wants to continue playing
	 */
	private static boolean askToReplay() {
		
		String input;
		
		do {
			Scanner scan = new Scanner( System.in );
			System.out.print( "Do you want to play another hand? Y/N: " );
			input = scan.nextLine();
			
			if ( ! input.equalsIgnoreCase( "Y" ) && ! input.equalsIgnoreCase( "N" ) ) {
				replayInputErrorMessage();
			}
		} while ( ! input.equalsIgnoreCase( "Y" ) && ! input.equalsIgnoreCase( "N" ) );
		
		return input.equalsIgnoreCase( "Y" );
		
	}
	
	private static void replayInputErrorMessage() {
		
		System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
		System.out.println( " Oops! You entered in a wrong letter. HINT: enter Y for yes and N for no" );
		System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
		
	}
	
	/**
	 * @param p Player the player being asked
	 * @param d Deck the game deck
	 */
	private static void askAction( Player p, Deck d ) //Asks if the player wants to hit or stay
	{
		
		Scanner scan = new Scanner( System.in );
		System.out.print( "Do you want to hit or stay? H/S: " );
		String input = scan.nextLine();
		takeAction( input, p, d.getDeck() );
		scan.close();
	}
	
	private static void askBet( Player p ) {
		
		Scanner scan = new Scanner( System.in );
		System.out.println( "What do you want to bet? (Positive integer value): " );
		int input = scan.nextInt();
		
		while ( input <= 0 && input > p.getPurse() ) {
			System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
			System.out.println( " Oops! You entered in a wrong value. HINT: Make sure you enter a positive integer or you are not betting too much!" );
			System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!\n" );
			System.out.println( "What do you want to bet? (Positive integer value): " );
			input = scan.nextInt();
		}
		
		p.setPurse( p.getPurse() - input );
		p.setBet( input );
		
	}
	
	/**
	 * @param input String can only be H or S
	 * @param p     Player the player that is being asked
	 * @param deck  ArrayList(Card) the game deck
	 *              Method is called by the askAction() method
	 */
	private static void takeAction( String input, Player p, ArrayList<Card> deck ) {
		
		do {
			
			while ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {                          //If the player inputs a wrong string, this dialogue will loop until the player inputs a correct string
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
				System.out.println( " Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
				System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
				
				Scanner scan = new Scanner( System.in );
				System.out.print( "Do you want to hit or stay? H/S: " );
				input = scan.nextLine();
			}
			
			if ( input.toUpperCase().equals( "H" ) ) {                                                                      //If the player wants to hit, the hit() Player object method is called
				p.hit( deck );
			}
			if ( input.toUpperCase().equals( "S" ) ) {                                                                      //If the player wants to stay, the stay() Player object method is called
				p.stay();
			}
			
			if ( p.isBust() ) {
				input = "S";
			} else if ( ! input.equalsIgnoreCase( "S" ) ) {
				Scanner scan = new Scanner( System.in );
				System.out.print( "Do you want to hit or stay? H/S: " );
				input = scan.nextLine();
			}
			
		}
		while ( input.equalsIgnoreCase( "H" ) && ! input.equalsIgnoreCase( "S" ) );
	}
	
}
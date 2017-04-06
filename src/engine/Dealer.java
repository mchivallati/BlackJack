package engine;

import java.util.ArrayList;

/**********************************************************************
 * ${NAME}.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 04052017
 *
 * Variable List:
 *
 * Method List:
 *********************************************************************/
public class Dealer extends Person {
	
	private int winnings;
	
	/**
	 * CONSTRUCTOR
	 *
	 * @param deck ArrayList(Card) game deck
	 */
	public Dealer( ArrayList<Card> deck ) {
		
		initHand( deck );
		setHandValue( hand );
		checkAce();
		winnings = 0;
		
	}
	
	/**
	 * OBJECT METHOD - makes the dealer hit, takes a card form the take and adds it to the dealer's hand
	 *
	 * @param deck ArrayList(Card) game deck
	 */
	@Override
	public void hit( ArrayList<Card> deck ) {
		this.hand.add( deck.get( 0 ) );
		this.handValue += deck.get( 0 ).getVal();
		deck.remove( 0 );
		checkAce();
		setHandValue( this.hand );
	}
	
	/**
	 * OBJECT METHOD - makes the dealer stay, in reality it does nothing but print out that the dealer stayed
	 */
	@Override
	public void stay() {
		if ( ! this.isBust() ) { //Has to check if the player busted before everything so it doesn't print out pointless information
			System.out.println();
			System.out.println( "-----------DEALER----------" );
			System.out.println( "The dealer has elected to stay" );
			System.out.println( "---------------------------" );
			System.out.println();
		}
	}
	
	/**
	 * OBJECT METHOD - establishes when the dealer hits or stays
	 *
	 * @param d ArrayList(Card) game deck
	 */
	public void useDealerAI( Deck d ) {
		
		while ( handValue < 17 ) {
			hit( d.getDeck() );
		}
		
		if ( handValue >= 17 ) {
			stay();
		}
		
	}
	
	/**
	 * @return String gets a card of the dealer's to display, per Blackjack rules
	 */
	public String showCard() {
		return hand.get( 1 ).toString();
	}
	
	public int getWinnings() {
		return winnings;
	}
	
	public void setWinnings( int winnings ) {
		this.winnings = winnings;
	}
	
	@Override
	public String toString() {
		return "\n" + getHand().get( 1 ).toString() + "\n";
	}
	
}

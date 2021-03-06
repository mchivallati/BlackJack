package engine;

import java.util.ArrayList;

/**********************************************************************
 * Player.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 04052017
 *
 * Variable List: purse, bet
 *
 * Method List: PLayer, hit, stay, toString, getPurse, setPurse, getBet, setBet
 *********************************************************************/
public class Player extends Person {
	
	/**
	 * the total amount of money a player has to bet
	 */
	private int purse;
	/**
	 *
	 */
	private int bet;
	
	public Player() {
		
		
	}
	
	/**
	 * CONSTRUCTOR
	 *
	 * @param deck ArrayList(Card) game deck
	 */
	public Player( ArrayList<Card> deck ) {
		
		purse = 100;
		initHand( deck );
		setHandValue( hand );
		checkAce();
		
	}
	
	/**
	 * OBJECT METHOD
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
	 *
	 */
	@Override
	public void stay() {
		System.out.println();
		System.out.println( "-------------------------------------------------------" );
		System.out.println( "You elect to stay with a hand value of " + handValue );
		System.out.println( "------------------------------------------------------" );
		
	}
	
	@Override
	public String toString() {
		String temp = "";
		temp += "Hand Value: " + handValue;
		for ( int i = 0 ; i < hand.size() ; i++ ) {
			temp += "\nCard " + ( i + 1 ) + ":\t" + hand.get( i ).toString();
		}
		
		return temp;
		
	}
	
	public int getPurse() {
		return purse;
	}
	
	public void setPurse( int purse ) {
		this.purse = purse;
	}
	
	public int getBet() {
		return bet;
	}
	
	public void setBet( int bet ) {
		this.bet = bet;
	}
}
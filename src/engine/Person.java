package engine;

import java.util.ArrayList;

/**********************************************************************
 * Person.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 04052017
 *
 * Variable List: hand, handValue
 *
 * Method List: initHand, returnCardsToDeck, getHandValue, setHandValue, getHand, isBust, hasBlackjack, checkAce, toString, hit, stay
 *********************************************************************/
abstract class Person {
	
	ArrayList<Card> hand = new ArrayList<>();
	int handValue;
	
	/**
	 * @param deck ArrayList(Card) game deck
	 */
	void initHand( ArrayList<Card> deck ) {
		
		if ( ! this.hand.isEmpty() ) {
			for ( int i = 0 ; i < this.hand.size() ; i++ ) {
				this.hand.remove( i );
			}
		}
		this.hand.add( deck.get( 0 ) );
		deck.remove( 0 );
		this.hand.add( deck.get( 0 ) );
		deck.remove( 0 );
		
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return int value of the dealers current hand
	 */
	public int getHandValue() {
		return handValue;
	}
	
	
	/**
	 * OBJECT METHOD
	 *
	 * @param hand ArrayList(Card) the persons hand
	 */
	void setHandValue( ArrayList<Card> hand ) {
		handValue = 0;
		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return ArrayList(Card) the hand of the dealer
	 */
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return boolean true if the dealer hand value is over 21
	 */
	public boolean isBust() {
		return this.handValue > 21;
	}
	
	public boolean hasBlackjack() {
		return this.handValue == 21 && this.hand.size() == 2;
	}
	
	/**
	 * OBJECT METHOD
	 */
	void checkAce() {
		
		int aceCounter = 0;
		
		for ( Card aCard : hand ) {                                                                                        //counts how many aces are in the players hand
			if ( aCard.getVal() == 1 ^ aCard.getVal() == 11 ) {
				aceCounter += 1;
			}
		}
		
		if ( aceCounter == 1 ) {
			//If there is only one ace in the player's hand, this element checks if the value of 11 makes the player bust. If is does, it sets the value of the ace to 1
			for ( Card aCard : hand ) {
				if ( ( aCard.getVal() == 1 ^ aCard.getVal() == 11 ) && handValue + 10 <= 21 ) {
					aCard.setVal( 11 );
				} else if ( aCard.getVal() == 11 ) {
					aCard.setVal( 1 );
				}
			}
		} else if ( aceCounter > 1 ) {                                                                                    //If there is more than one ace in the player's hand,
			for ( int i = 0 ; i < hand.size() ; i++ ) {
				if ( ( hand.get( i ).getVal() == 1 ^ hand.get( i ).getVal() == 11 ) && i == 0 && handValue + 10 <= 21 ) {
					hand.get( i ).setVal( 11 );
				} else if ( ( hand.get( i ).getVal() == 1 ^ hand.get( i ).getVal() == 11 ) && i == 0 && handValue + 10 > 21 ) {
					hand.get( i ).setVal( 1 );
				} else if ( ( hand.get( i ).getVal() == 1 ^ hand.get( i ).getVal() == 11 ) && i > 0 && handValue + ( i * 10 ) <= 21 ) {
					hand.get( i ).setVal( 11 );
				} else if ( ( hand.get( i ).getVal() == 1 ^ hand.get( i ).getVal() == 11 ) && i > 0 && handValue + ( i * 10 ) > 21 ) {
					hand.get( i ).setVal( 1 );
				}
				
				setHandValue( hand );
			}
		}
		
		setHandValue( hand );
		
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
	
	/**
	 * @param deck ArrayList(Card) game deck
	 */
	abstract void hit( ArrayList<Card> deck );
	
	abstract void stay();
	
}
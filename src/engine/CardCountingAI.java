package engine;

import java.util.ArrayList;

/**********************************************************************
 * CardCountingAI.java
 * Assignment Number: 
 * Author: Matthew Chivallati
 * Collaborations: 
 * Date: 03292017
 *
 * Variable List: tableCount
 *
 * Method List: CardCountingAI, setBet, doAction, countCards
 *********************************************************************/
public class CardCountingAI extends Player {
	
	private double tableCount = 0;
	
	/**
	 * Default constructor. It calls the default constructor of the Player class
	 */
	public CardCountingAI() {
		
		super();
		
	}
	
	/**
	 * Calls the default constructor of the Player class and set the value of the tableCount.
	 * @param tableCount The count of the table.
	 */
	public CardCountingAI( int tableCount ) {
		
		super();
		this.tableCount = tableCount;
		
	}
	
	/**
	 * Calls the constructor of the Player class that uses a deck object. Also sets the AI's availble money to bet to $100.
	 * @param deck The current game deck.
	 */
	public CardCountingAI( ArrayList<Card> deck ) {
		
		super( deck );
		this.setPurse( 100 );
		
	}
	
	/**
	 * @param tableCount The count of the table.
	 * @param deck The count of the table.
	 */
	public CardCountingAI( int tableCount, ArrayList<Card> deck ) {
		
		super( deck );
		this.tableCount = tableCount;
		
	}
	
	/**
	 * Sets the bet of the AI based on the table count.
	 * @param d The dealer of the current hand.
	 */
	public void setBet( Dealer d ) {
		
		countCards( d );
		
		int calcBet = (int) ( this.getPurse() * ( this.tableCount / 25 ) );
		
		if ( calcBet == 0 ) {
			this.setBet( 10 );
		} else if ( calcBet < 0 ) {
			this.setBet( 1 );
		} else if ( calcBet > this.getPurse() ) {
			this.setBet( this.getPurse() );
		} else {
			this.setBet( calcBet );
		}
		
	}
	
	/**
	 * Determines whether the AI should hit or not.
	 * @param deck The current game deck.
	 */
	public void doAction( Deck deck ) {
		
		while ( handValue < 17 ) {
			super.hit( deck.getDeck() );
		}
		
	}
	
	/**
	 * Calculates the table count based on the cards visible to the Player.
	 * @param d  The dealer of the current hand.
	 */
	private void countCards( Dealer d ) {
		
		if ( d.getHand().get( 0 ).getVal() >= 2 && d.getHand().get( 0 ).getVal() <= 6 ) {
			this.tableCount += 1.0;
		} else if ( d.getHand().get( 0 ).getVal() >= 7 && d.getHand().get( 0 ).getVal() <= 9 ) {
			this.tableCount += 0.0;
		} else if ( d.getHand().get( 0 ).getVal() == 10 || ( d.getHand().get( 0 ).getVal() == 11 || d.getHand().get( 0 ).getVal() == 1 ) ) {
			this.tableCount -= 1.0;
		}
		
		for ( int i = 0 ; i < this.getHand().size() ; i++ ) {
			if ( this.getHand().get( i ).getVal() >= 2 && this.getHand().get( i ).getVal() <= 6 ) {
				this.tableCount += 1.0;
			} else if ( this.getHand().get( i ).getVal() >= 7 && this.getHand().get( i ).getVal() <= 9 ) {
				this.tableCount += 0.0;
			} else if ( this.getHand().get( i ).getVal() == 10 || ( this.getHand().get( i ).getVal() == 11 || this.getHand().get( i ).getVal() == 1 ) ) {
				this.tableCount -= 1.0;
			}
		}
		
	}
	
	//public double getTableCount() { return tableCount; }
	
	//public void setTableCount( int tableCount ) { this.tableCount = tableCount; }
}
package engine;

import java.util.ArrayList;

/**********************************************************************
 * Deck.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 04052017
 *
 * Variable List: deck
 *
 * Method List: Deck, addSpades, addClubs, addHeats, addDiamonds, checkRank, swap, shuffleDeck, getDeck
 *********************************************************************/

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<>();
	
	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Deck() {
		
		addClubs();
		addDiamonds();
		addHearts();
		addSpades();
		
	}
	
	/**
	 * ONLY USED IN DECK.JAVA
	 */
	private void addSpades() {
		
		int val = 1;
		
		for ( int i = 0 ; i < 13 ; i++ ) {
			
			Card s = new Card( "Spades", checkRank( i ), val );
			this.deck.add( s );
			val++;
			
			if ( val > 10 ) {
				val = 10;
			}
			
		}
		
	}
	
	/**
	 * ONLY USED IN DECK.JAVA
	 */
	private void addClubs() {
		
		int val = 1;
		
		for ( int i = 0 ; i < 13 ; i++ ) {
			
			Card c = new Card( "Clubs", checkRank( i ), val );
			this.deck.add( c );
			val++;
			
			if ( val > 10 ) {
				val = 10;
			}
			
		}
		
	}
	
	/**
	 * ONLY USED IN DECK.JAVA
	 */
	private void addHearts() {
		
		int val = 1;
		
		for ( int i = 0 ; i < 13 ; i++ ) {
			
			Card h = new Card( "Hearts", checkRank( i ), val );
			this.deck.add( h );
			val++;
			
			if ( val > 10 ) {
				val = 10;
			}
			
		}
		
	}
	
	/**
	 * ONLY USED IN DECK.JAVA
	 */
	private void addDiamonds() {
		
		int val = 1;
		
		for ( int i = 0 ; i < 13 ; i++ ) {
			
			Card d = new Card( "Diamonds", checkRank( i ), val );
			this.deck.add( d );
			val++;
			
			if ( val > 10 ) {
				val = 10;
			}
			
		}
		
	}
	
	/**
	 * ONLY USED IN DECK.JAVA
	 *
	 * @param i int value to be checked
	 * @return String card rank
	 */
	private String checkRank( int i ) //only to be used with the add*SuitName* methods // i < 13
	{
		
		if ( i == 0 ) {
			
			return "Ace";
			
		} else if ( i == 1 ) {
			
			return "Two";
			
		} else if ( i == 2 ) {
			
			return "Three";
			
		} else if ( i == 3 ) {
			
			return "Four";
			
		} else if ( i == 4 ) {
			
			return "Five";
			
		} else if ( i == 5 ) {
			
			return "Six";
			
		} else if ( i == 6 ) {
			
			return "Seven";
			
		} else if ( i == 7 ) {
			
			return "Eight";
			
		} else if ( i == 8 ) {
			
			return "Nine";
			
		} else if ( i == 9 ) {
			
			return "Ten";
			
		} else if ( i == 10 ) {
			
			return "Jack";
			
		} else if ( i == 11 ) {
			
			return "Queen";
			
		} else if ( i == 12 ) {
			
			return "King";
			
		} else {
			
			return null;
			
		}
		
	}
	
	/*
	  OBJECT METHOD
	 
	void printDeck() {
		
		for ( Card aDeck : deck ) {
			
			System.out.println( aDeck.toString() );
			
		}
		
	}*/
	
	/**
	 * OBJECT METHOD
	 *
	 * @param i int first card location
	 * @param k int second card location
	 */
	private void swap( int i, int k ) {
		
		Card temp = new Card( deck.get( i ).getSuit(), deck.get( i ).getRank(), deck.get( i ).getVal() );
		
		deck.get( i ).setSuit( deck.get( k ).getSuit() );
		deck.get( i ).setRank( deck.get( k ).getRank() );
		deck.get( i ).setVal( deck.get( k ).getVal() );
		
		deck.get( k ).setSuit( temp.getSuit() );
		deck.get( k ).setRank( temp.getRank() );
		deck.get( k ).setVal( temp.getVal() );
		
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @param numShuffles int number of card swaps to be made
	 */
	public void shuffleDeck( int numShuffles ) {
		
		for ( int j = 0 ; j < numShuffles ; j++ ) {
			
			int randomInt1 = util.randomInt( 0, deck.size() - 1 );
			int randomInt2 = util.randomInt( 0, deck.size() - 1 );
			swap( randomInt1, randomInt2 );
			
		}
		
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return returns the ArrayList(Card) to use in the game
	 */
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
}
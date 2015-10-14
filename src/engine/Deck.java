package engine;
import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */

public class Deck
{

	private ArrayList<Card> deck = new ArrayList<Card>();

	/**
	 *
	 */
	public Deck( )
	{

		addClubs();
		addDiamonds();
		addHearts();
		addSpades();

	}

	/**
	 *
	 */
	public void addSpades( )
	{

		int val = 1;

		for ( int i = 0 ; i < 13 ; i++ )
		{

			Card s = new Card( "Spades", checkRank( i ), val );
			this.deck.add( s );
			val++;

		}

	}

	/**
	 *
	 */
	public void addClubs( )
	{

		int val = 1;

		for ( int i = 0 ; i < 13 ; i++ )
		{

			Card c = new Card( "Clubs", checkRank( i ), val );
			this.deck.add( c );
			val++;

		}

	}

	/**
	 *
	 */
	public void addHearts( )
	{

		int val = 1;

		for ( int i = 0 ; i < 13 ; i++ )
		{

			Card h = new Card( "Hearts", checkRank( i ), val );
			this.deck.add( h );
			val++;

		}

	}

	/**
	 *
	 */
	public void addDiamonds( )
	{

		int val = 1;

		for ( int i = 0 ; i < 13 ; i++ )
		{

			Card d = new Card( "Diamonds", checkRank( i ), val );
			this.deck.add( d );
			val++;

		}

	}

	/**
	 * @param i             int value to be checked
	 * @return              String card rank
	 */
	public String checkRank( int i ) //only to be used with the add*SuitName* methods // i < 13
	{

		if ( i == 0 )
		{

			return "Ace";

		}
		else if ( i == 1 )
		{

			return "Two";

		}
		else if ( i == 2 )
		{

			return "Three";

		}
		else if ( i == 3 )
		{

			return "Four";

		}
		else if ( i == 4 )
		{

			return "Five";

		}
		else if ( i == 5 )
		{

			return "Six";

		}
		else if ( i == 6 )
		{

			return "Seven";

		}
		else if ( i == 7 )
		{

			return "Eight";

		}
		else if ( i == 8 )
		{

			return "Nine";

		}
		else if ( i == 9 )
		{

			return "Ten";

		}
		else if ( i == 10 )
		{

			return "Jack";

		}
		else if ( i == 11 )
		{

			return "Queen";

		}
		else if ( i == 12 )
		{

			return "King";

		}
		else
		{

			return null;

		}

	}

	/**
	 *
	 */
	public void printDeck( )
	{

		for ( Card aDeck : deck )
		{

			System.out.println( aDeck.toString() );

		}

	}

	/**
	 * @param i             int first card location
	 * @param k             int second card location
	 */
	public void swap( int i, int k )
	{

		Card temp = new Card( deck.get( i ).getSuit(), deck.get( i ).getRank(), deck.get( i ).getVal() );

		deck.get( i ).setSuit( deck.get( k ).getSuit() );
		deck.get( i ).setRank( deck.get( k ).getRank() );
		deck.get( i ).setVal( deck.get( k ).getVal() );

		deck.get( k ).setSuit( temp.getSuit() );
		deck.get( k ).setRank( temp.getRank() );
		deck.get( k ).setVal( temp.getVal() );

	}

	/**
	 * @param numShuffles   int number of card swaps to be made
	 */
	public void shuffleDeck( int numShuffles )
	{

		for ( int j = 0 ; j < numShuffles ; j++ )
		{

			int randomInt1 = util.randomInt( 0, 51 );
			int randomInt2 = util.randomInt( 0, 51 );
			swap( randomInt1, randomInt2 );

		}

	}

	public ArrayList<Card> getDeck() {return this.deck;}

}
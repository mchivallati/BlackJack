package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Player extends Person
{

	/** CONSTRUCTOR
	 * @param deck          ArrayList<Card> game deck
	 */
	public Player(ArrayList<Card> deck)
	{
		
		initHand(deck);
		setHandValue( hand );
		checkAce();
		
	}

	/** OBJECT METHOD
	 * @param hand          ArrayList<Card> the persons hand
	 */
	public void setHandValue( ArrayList<Card> hand )
	{

		handValue = 0;
		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}

	/** OBJECT METHOD
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void hit( ArrayList<Card> deck )
	{
		this.hand.add( deck.get( 0 ) );
		this.handValue += deck.get(0).getVal();
		deck.remove( 0 );
		checkAce();
		//setHandValue(deck);
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("You take a card from the deck");
		System.out.println( "----------------------------");
		System.out.println(toString());
	}

	/**
	 * 
	 */
	@Override
	public void stay()
	{
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("You elect to stay with a hand value of " + handValue);
		System.out.println( "------------------------------------------------------");

	}
	
}
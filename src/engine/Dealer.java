package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Dealer implements Person
{
	
	ArrayList<Card> hand;
	int handValue;

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	public Dealer(ArrayList<Card> deck)
	{
		
		initCards(deck , deck.size());
		getHandValue(hand);
		
	}
	
	/**
	 * @param deck          ArrayList<Card> game deck
	 * @param numCards      int size of deck
	 */
	@Override
	public void initCards( ArrayList<Card> deck, int numCards )
	{
		
		this.hand.add( deck.get(0) );
		deck.remove(0);
		this.hand.add( deck.get(0) );
		deck.remove(0);

	}

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void returnCards( ArrayList<Card> deck )
	{
		for ( Card aHand : hand ) {
			deck.add( aHand );
		}
	}

	/**
	 * @param hand          ArrayList<Card> the persons hand
	 */
	@Override
	public void getHandValue( ArrayList<Card> hand )
	{

		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void hit( ArrayList<Card> deck )
	{
		this.hand.add( deck.get(0) );
		deck.remove(0);
	}

	/**
	 *
	 */
	@Override
	public void stay()
	{
		
	}

	/**
	 *
	 */
	public void dealerAI()
	{
		
	}

	@Override
	public String toString()
	{
		String temp = "";
		temp += "Hand Value: " + handValue;
		for (int i = 1 ; i <= hand.size() ; i++) {
			temp += "\nCard " + i + ":\t" + hand.get(i).toString();
		}

		return temp;

	}

}
package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Player implements Person
{

	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue;

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	public Player(ArrayList<Card> deck)
	{
		
		initCards(deck , deck.size());
		setHandValue( hand );
		
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

		System.out.println("There are " + deck.size() + " cards left");

	}

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void returnCardsToDeck( ArrayList<Card> deck )
	{
		for ( Card aHand : hand )
		{
			deck.add( aHand );
		}
		System.out.println("There are " + deck.size() + " cards left");
	}

	/**
	 * @param hand          ArrayList<Card> the persons hand
	 */
	public void setHandValue( ArrayList<Card> hand )
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
	 * @return              int value of the players current hand
	 */
	@Override
	public int getHandValue() {return this.handValue;}

	/**
	 * @return              ArrayList<Card> the hand of the dealer
	 */
	public ArrayList<Card> getHand() {return this.hand;}

	/**
	 * 
	 */
	@Override
	public void stay()
	{

	}

	/**
	 * @return              boolean true if the player hand value is over 21
	 */
	@Override
	public boolean isBust() {return this.handValue > 21;}
	
	@Override
	public String toString()
	{
		String temp = "";
		temp += "Hand Value: " + handValue;
		for (int i = 0 ; i < hand.size() ; i++) {
			temp += "\nCard " + i + ":\t" + hand.get(i).toString();
		}
		
		return temp;
		
	}
	
}
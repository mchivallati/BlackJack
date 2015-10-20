package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Dealer implements Person
{

	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue;

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	public Dealer(ArrayList<Card> deck)
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

	}

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void returnCardsToDeck( ArrayList<Card> deck )
	{
		for ( Card aHand : hand ) {
			deck.add( aHand );
		}
	}

	/**
	 * @param hand          ArrayList<Card> the persons hand
	 */
	private void setHandValue( ArrayList<Card> hand )
	{

		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}

	/**
	 * @return              int value of the dealers current hand
	 */
	@Override
	public int getHandValue() {return handValue;}

	/**
	 * @return              ArrayList<Card> the hand of the dealer
	 */
	public ArrayList<Card> getHand() {return this.hand;}

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
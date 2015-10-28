package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Dealer implements Person
{

	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue;

	/** CONSTRUCTOR
	 * @param deck          ArrayList<Card> game deck
	 */
	public Dealer(ArrayList<Card> deck)
	{
		
		initCards(deck , deck.size());
		setHandValue( hand );
		checkAce();
		
	}
	
	/** OBJECT METHOD
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

	/** OBJECT METHOD
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void returnCardsToDeck( ArrayList<Card> deck )
	{
		for ( Card aHand : hand ) {
			deck.add( aHand );
		}
		System.out.println("There are " + deck.size() + " cards left");
	}

	/** OBJECT METHOD
	 * @param hand          ArrayList<Card> the persons hand
	 */
	private void setHandValue( ArrayList<Card> hand )
	{
		handValue = 0;
		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}

	/** OBJECT METHOD
	 * @return              int value of the dealers current hand
	 */
	@Override
	public int getHandValue() {return handValue;}

	/** OBJECT METHOD
	 * @return              ArrayList<Card> the hand of the dealer
	 */
	public ArrayList<Card> getHand() {return this.hand;}

	/** OBJECT METHOD
	 * @param deck          ArrayList<Card> game deck
	 */
	@Override
	public void hit( ArrayList<Card> deck )
	{
		this.hand.add( deck.get(0) );
		this.handValue += deck.get(0).getVal();
		deck.remove(0);
		checkAce();
		//setHandValue(deck);
		System.out.println();
		System.out.println("---------------------");
		System.out.println("The dealer takes a card form the deck");
		System.out.println("---------------------");
		System.out.println();
	}

	/**
	 *
	 */
	@Override
	public void stay()
	{
		System.out.println();
		System.out.println("-----------DEALER----------");
		System.out.println("The dealer has elected to stay");
		System.out.println("---------------------");
		System.out.println();
	}

	/** OBJECT METHOD
	 * @return              boolean true if the dealer hand value is over 21
	 */
	@Override
	public boolean isBust() {return this.handValue > 21;}

	/**
	 *
	 */
	private void checkAce()
	{
		for ( Card aHand : hand ) {
			if ( aHand.getVal() == 1 && handValue + 10 <= 21 ) {
				aHand.setVal( 11 );
			}
		}
		handValue = 0;
		setHandValue( hand );
	}

	/**
	 * OBJECT METHOD
	 */
	public void useDealerAI(Deck d)
	{

		while (handValue < 17) {
			hit(d.getDeck());
		}

		if (handValue >= 17) {
			stay();
		}
		
	}

	@Override
	public String toString()
	{
		String temp = "";
		temp += "Hand Value: " + handValue;
		for (int i = 0 ; i < hand.size() ; i++) {
			temp += "\nCard " + (i + 1) + ":\t" + hand.get(i).toString();
		}

		return temp;

	}

}

package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Player implements Person
{

	private ArrayList<Card> hand = new ArrayList<Card>();
	private int handValue;

	/** CONSTRUCTOR
	 * @param deck          ArrayList<Card> game deck
	 */
	public Player(ArrayList<Card> deck)
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

		this.hand.add( deck.get( 0 ) );
		deck.remove( 0 );
		this.hand.add( deck.get( 0 ) );
		deck.remove( 0 );

	}

	/** OBJECT METHOD
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

	/** OBJECT METHOD
	 * @return              int value of the players current hand
	 */
	@Override
	public int getHandValue() {return this.handValue;}

	/** OBJECT METHOD
	 * @return              ArrayList<Card> the hand of the dealer
	 */
	public ArrayList<Card> getHand() {return this.hand;}

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

	/** OBJECT METHOD
	 * @return              boolean true if the player hand value is over 21
	 */
	@Override
	public boolean isBust() {return this.handValue > 21;}

	/**
	 *
	 */
	private void checkAce()
	{

		int aceCounter = 0;

		for (Card aCard : hand) {																						//counts how many aces are in the players hand
			if (aCard.getVal() == 1  ^ aCard.getVal() == 11) {
				aceCounter += 1;
			}
		}

		if ( aceCounter == 1) {
			//If there is only one ace in the player's hand, this element checks if the value of 11 makes the player bust. If is does, it sets the value of the ace to 1
			for (Card aCard : hand) {
				if ((aCard.getVal() == 1 ^ aCard.getVal() == 11) && handValue + 10 <= 21) {
					aCard.setVal(11);
				} else if (aCard.getVal() == 11) {

					aCard.setVal(1);
				}
			}
		} else if ( aceCounter > 1) {																					//If there is more than one ace in the player's hand,
			for (int i = 0 ; i < hand.size() ; i++) {
				if ((hand.get(i).getVal() == 1 ^ hand.get(i).getVal() == 11) && i == 0 && handValue + 10 <= 21) {
					hand.get(i).setVal(11);
				} else if ((hand.get(i).getVal() == 1 ^ hand.get(i).getVal() == 11) && i == 0 && handValue + 10 > 21) {
					hand.get(i).setVal(1);
				} else if ((hand.get(i).getVal() == 1 ^ hand.get(i).getVal() == 11) && i > 0 && handValue + (i * 10) <= 21) {
					hand.get(i).setVal(11);
				} else if ((hand.get(i).getVal() == 1 ^ hand.get(i).getVal() == 11) && i > 0 && handValue + (i * 10) > 21) {
					hand.get(i).setVal(1);
				}

				setHandValue( hand );
			}
		}

		setHandValue( hand );

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
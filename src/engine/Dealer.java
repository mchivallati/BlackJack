package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Dealer extends Person
{
	
	/** CONSTRUCTOR
	 * @param deck          ArrayList<Card> game deck
	 */
	public Dealer(ArrayList<Card> deck)
	{
		
		initHand(deck);
		setHandValue( hand );
		checkAce();
		
	}

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
		if (!this.isBust()) {
			System.out.println();
			System.out.println("-----------DEALER----------");
			System.out.println("The dealer has elected to stay");
			System.out.println("---------------------");
			System.out.println();
		}
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

	public String showCard() { return hand.get(1).toString(); }


}

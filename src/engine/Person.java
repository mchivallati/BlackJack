package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
interface Person
{

	/**
	 * @param deck          ArrayList<Card> game deck
	 * @param numCards      int size of deck
	 */
	void initCards( ArrayList<Card> deck, int numCards );

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	void returnCardsToDeck(ArrayList<Card> deck);

	int getHandValue();

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	void hit(ArrayList<Card> deck);
	
	void stay();
	
}
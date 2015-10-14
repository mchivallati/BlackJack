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
	void returnCards(ArrayList<Card> deck);

	/**
	 * @param hand          ArrayList<Card> the persons hand
	 */
	void getHandValue(ArrayList<Card> hand);

	/**
	 * @param deck          ArrayList<Card> game deck
	 */
	void hit(ArrayList<Card> deck);
	
	void stay();
	
}
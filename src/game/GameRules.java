package game;

import engine.Card;
import java.util.ArrayList;

/**
 *  Created by chiv on 10/12/2015. Class created to specify the rules of the gae using class methods
 */
public class GameRules
{

	private static int dealerHandValue , playerHandValue;

	/**
	 * @param dealerHand        ArrayList<Card> the dealers hand
	 * @param playerHand        ArrayList<Card> the players hand
	 * @return                  boolean true if the dealers wins, false if the player wins
	 */
	public static boolean isHigher(ArrayList<Card> dealerHand , ArrayList<Card> playerHand)
	{

		for ( Card aDealerHand : dealerHand ) {

			dealerHandValue += aDealerHand.getVal();

		}

		for ( Card aPlayerHand : playerHand ) {

			playerHandValue += aPlayerHand.getVal();

		}

		return dealerHandValue >= playerHandValue;

	}

}
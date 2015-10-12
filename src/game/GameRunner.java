package game;

import engine.Deck;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class GameRunner
{

	/**
	 * @param args  String
	 */
	public static void main(String[] args)
	{

		new GameFrame().setVisible(true);
		Deck gameDeck = new Deck();

	}
	
}
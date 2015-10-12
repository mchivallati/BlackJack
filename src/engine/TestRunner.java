package engine;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class TestRunner
{

	public static void main(String[] args)
	{
		Deck d = new Deck(); //creates new deck object
		d.printDeck(); //printes the unchanged deck

		System.out.println();
		System.out.println("============================");
		System.out.println();

		d.shuffleDeck( 1000 ); //shuffles deck by swapping random cards 1,000 times
		d.printDeck(); //prints the shuffled deck

	}

}
package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Dealer extends Person
{
	
	/**
	 * ArrayList(Chip) all the chips the dealer or "house" has won, represents the gross profits made during the runtime
	 */
	private ArrayList<Chip> winnings = new ArrayList<Chip>();
	/**
	 * int total sum of the winnings
	 */
	private int totalWinnings;
	
	/** CONSTRUCTOR
	 * @param deck          ArrayList(Card) game deck
	 */
	public Dealer(ArrayList<Card> deck)
	{
		
		initHand(deck);
		setHandValue( hand );
		checkAce();
		
	}

	/** OBJECT METHOD - makes the dealer hit, takes a card form the take and adds it to the dealer's hand
	 * @param deck          ArrayList(Card) game deck
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
	 * OBJECT METHOD - makes the dealer stay, in reality it does nothing but print out that the dealer stayed
	 */
	@Override
	public void stay()
	{
		if (!this.isBust()) { //Has to check if the player busted before everything so it doesn't print out pointless information
			System.out.println();
			System.out.println("-----------DEALER----------");
			System.out.println("The dealer has elected to stay");
			System.out.println("---------------------");
			System.out.println();
		}
	}

	/**
	 * OBJECT METHOD - establishes when the dealer hits or stays
	 *  @param d 			ArrayList(Card) game deck
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
	
	/**
	 * @return			String gets a card of the dealer's to display, per Blackjack rules
	 */
	public String showCard() { return hand.get(1).toString(); }
	
	/**
	 * @return 			ArrayList(Chip) gets the winnings of the dealer
	 */
	public ArrayList<Chip> getWinnings() { return winnings; }
	
	/**
	 * OBJECT METHOD - prints all the chips that the dealer has won
	 */
	public void printWinnings()
	{
		
		for ( Chip aChip : this.winnings ) {
			
			System.out.println( aChip.toString() );
			
		}
		
	}
	
	/** OBJECT METHOD - adds all the chips the players lost into the dealers winnings
	 * @param chips		ArrayList(Chip) all the chips that the players lost betting against the dealer
	 */
	public void addWinnings( ArrayList<Chip> chips ) { this.winnings.addAll( chips ); }
	
	/** OBJECT METHOD - sums up all the winnings of the dealer into a numerical value
	 * @return			int sum of the chip values in the winnings
	 */
	public int getTotalWinnings() { return this.totalWinnings = util.sumOfArray( winnings ); }
}

package engine;

import java.util.ArrayList;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Player extends Person
{
	
	public static void main(String[] args)
	{
		
		//testing new purse attribute and chip objects
		Player p = new Player();
		p.printPurse();
		System.out.println( p.getPurseTotal() );
		
		
	}
	
	/**
	 * the total amount of money a player has to bet
	 */
	private ArrayList<Chip> purse = new ArrayList<Chip>();
	private int purseTotal;
	private int currentBet;
	
	public Player()
	{
		
		initPurse();
		setPurseTotal();
		
	}
	
	/** CONSTRUCTOR
	 * @param deck          ArrayList(Card) game deck
	 */
	public Player(ArrayList<Card> deck)
	{
		
		initPurse();
		setPurseTotal();
		initHand(deck);
		setHandValue( hand );
		checkAce();
		
	}

	/** OBJECT METHOD
	 * @param hand          ArrayList(Card) the persons hand
	 */
	public void setHandValue( ArrayList<Card> hand )
	{

		handValue = 0;
		for ( Card aHand : hand ) {
			handValue += aHand.getVal();
		}
		
	}
	
	public int getCurrentBet() { return this.currentBet; }
	
	public void setCurrentBet( int bet ) {}

	/** OBJECT METHOD
	 * @param deck          ArrayList(Card) game deck
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
	
	/** OBJECT METHOD - "getter" for the purse attribute
	 * @return			ArrayList(Chip) the purse of the player
	 */
	public ArrayList<Chip> getPurse() { return this.purse; }
	
	/**
	 * ONLY USED IN CONSTRUCTOR - creates a default starting purse that all player start with
	 */
	private void initPurse()
	{
		
		this.purse.add( new Chip(50) );
		this.purse.add( new Chip(50) );
		this.purse.add( new Chip(25) );
		this.purse.add( new Chip(25) );
		this.purse.add( new Chip(10) );
		this.purse.add( new Chip(10) );
		this.purse.add( new Chip(10) );
		this.purse.add( new Chip(5) );
		this.purse.add( new Chip(5) );
		this.purse.add( new Chip(5) );
		this.purse.add( new Chip(5) );
		
		setPurseTotal();
		
	}
	
	public int getPurseTotal() { return this.purseTotal; }
	
	public void printPurse()
	{
		
		for ( Chip aPurse : this.purse ) {
			
			System.out.println( aPurse.toString() );
			
		}
		
	}
	
	private void setPurseTotal() { this.purseTotal = util.sumOfArray( this.purse ); }
	
}
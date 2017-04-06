package engine;

import java.util.ArrayList;

/**********************************************************************
 * CardCountingAI.java
 * Assignment Number: 
 * Author: Matthew Chivallati
 * Collaborations: 
 * Date: 03292017
 *
 * Variable List: 
 *
 * Method List: 
 *********************************************************************/
public class CardCountingAI extends Player
{
	
	private int tableCount = 0;
	
	public CardCountingAI()
	{
		
		super();
		
	}
	
	public CardCountingAI(int tableCount)
	{
		
		super();
		this.tableCount = tableCount;
		
	}
	
	public CardCountingAI(ArrayList<Card> deck)
	{
		
		super(deck);
		
	}
	
	public CardCountingAI( int tableCount , ArrayList<Card> deck)
	{
		
		super(deck);
		this.tableCount = tableCount;
		
	}
	
	public void setBet( Dealer d )
	{
		
		countCards( d );
		
		int calcBet = this.getPurse() * ( this.tableCount / 100 );
		
		if ( calcBet > this.getPurse() ) {
			this.setBet( this.getPurse() );
		} else {
			this.setBet( calcBet );
		}
		
	}
	
	public void doAction( Deck d )
	{
		
		while ( handValue < 17 ) {
			super.hit( d.getDeck() );
		}
		
	}
	
	private void countCards( Dealer d )
	{
		
		if ( d.getHand().get(0).getVal() >= 2 && d.getHand().get(0).getVal() <= 6 ) {
			this.tableCount += 1;
		} else if ( d.getHand().get(0).getVal() >= 7 && d.getHand().get(0).getVal() <= 9 ) {
			this.tableCount += 0;
		} else if ( d.getHand().get(0).getVal() == 10 || ( d.getHand().get(0).getVal() == 11 || d.getHand().get(0).getVal() == 1 ) ) {
			this.tableCount -= 1;
		}
		
		for ( int i = 0 ; i < this.getHand().size() ; i ++ ) {
			if ( this.getHand().get(i).getVal() >= 2 && this.getHand().get(i).getVal() <= 6 ) {
				this.tableCount += 1;
			} else if ( this.getHand().get(i).getVal() >= 7 && this.getHand().get(i).getVal() <= 9 ) {
				this.tableCount += 0;
			} else if ( this.getHand().get(i).getVal() == 10 || ( this.getHand().get(i).getVal() == 11 || this.getHand().get(i).getVal() == 1 ) ) {
				this.tableCount -= 1;
			}
		}
		
	}
	
	public int getTableCount() { return tableCount; }
	
	public void setTableCount( int tableCount ) { this.tableCount = tableCount; }
}

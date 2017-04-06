package engine;

/**********************************************************************
 * ${NAME}.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 04052017
 *
 * Variable List:
 *
 * Method List:
 *********************************************************************/
public class Card {
	
	private String suit;
	private String rank;
	private int val;
	
	/**
	 *
	 */
	public Card() //default constructor
	{
		
		this.suit = "";
		this.rank = "";
		this.val = 0;
		
	}
	
	/**
	 * CONSTRUCTOR
	 *
	 * @param suit String card suit
	 * @param rank String card rank
	 * @param val  int card point value
	 */
	Card( String suit, String rank, int val ) //main constructor
	{
		
		this.suit = suit;
		this.rank = rank;
		this.val = val;
		
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return String card suit
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return String card rank
	 */
	public String getRank() {
		return this.rank;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return int card point value
	 */
	int getVal() {
		return this.val;
	}
	
	/**
	 * @param rank String card rank
	 */
	void setRank( String rank ) {
		this.rank = rank;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @param suit String card suit
	 */
	void setSuit( String suit ) {
		this.suit = suit;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @param val int card point value
	 */
	void setVal( int val ) {
		this.val = val;
	}
	
	/**
	 * OBJECT METHOD
	 *
	 * @return String representation of a Card
	 */
	@Override
	public String toString() {
		
		return rank + " of " + suit;
		
	}
	
}

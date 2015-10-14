package engine;
/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
public class Card
{

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
	 * @param suit      String card suit
	 * @param rank      String card rank
	 * @param val       int card point value
	 */
	public Card(String suit , String rank , int val) //main constructor
	{

		this.suit = suit;
		this.rank = rank;
		this.val = val;

	}

	/**
	 * @return          String card suit
	 */
	public String getSuit() {return this.suit;}

	/**
	 * @return          String card rank
	 */
	public String getRank() {return this.rank;}

	/**
	 * @return          int card point value
	 */
	public int getVal() {return this.val;}

	/**
	 * @param rank      String card rank
	 */
	void setRank( String rank ) {this.rank = rank;}

	/**
	 * @param suit      String card suit
	 */
	void setSuit( String suit ) {this.suit = suit;}

	/**
	 * @param val       int card point value
	 */
	void setVal( int val ) {this.val = val;}
	
	/**
	 * @return          String representation of a Card
	 */
	@Override
	public String toString()
	{

		return rank + " of " + suit + " with a value of " + val;

	}

}
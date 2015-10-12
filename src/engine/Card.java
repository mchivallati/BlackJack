package engine;

/*
    Created by Matthew Chivallati on 9/9/2015.
 */
public class Card
{

	private String suit;
	private String rank;
	private int val;

	public Card() //default constructor
	{

		this.suit = "";
		this.rank = "";
		this.val = 0;

	}

	public Card(String suit , String rank , int val) //main constructor
	{

		this.suit = suit;
		this.rank = rank;
		this.val = val;

	}

	public String getSuit() {return this.suit;}

	public String getRank() {return this.rank;}

	public int getVal() {return this.val;}

	public void setRank( String rank ) {this.rank = rank;}

	public void setSuit( String suit ) {this.suit = suit;}

	public void setVal( int val ) {this.val = val;}

	@Override

	public String toString()
	{

		return rank + " of " + suit + " with a value of " + val;

	}

}
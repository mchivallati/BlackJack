package engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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

	/** CONSTRUCTOR
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

	/** OBJECT METHOD
	 * @return          String card suit
	 */
	public String getSuit() {return this.suit;}

	/** OBJECT METHOD
	 * @return          String card rank
	 */
	public String getRank() {return this.rank;}

	/** OBJECT METHOD
	 * @return          int card point value
	 */
	public int getVal() {return this.val;}

	/**
	 * @param rank      String card rank
	 */
	void setRank( String rank ) {this.rank = rank;}

	/** OBJECT METHOD
	 * @param suit      String card suit
	 */
	void setSuit( String suit ) {this.suit = suit;}

	/** OBJECT METHOD
	 * @param val       int card point value
	 */
	void setVal( int val ) {this.val = val;}
	
	/** OBJECT METHOD
	 * @return          String representation of a Card
	 */
	@Override
	public String toString()
	{

		return rank + " of " + suit;

	}

	/** OBJECT METHOD
	 * @return          String the path of the card image specific to a card
	 */
	public String getCardImgPath()
	{

		/*Path currentRelativePath = Paths.get( "" );
		String s = currentRelativePath.toAbsolutePath().toString();

		System.out.println( s );*/

		return System.getProperty( "user.dir" ) + "/images/" + val + "_of_" + suit.toLowerCase() + ".png";

	}


	/** OBJECT METHOD
	 * @return          BufferedImage for the card
	 */
	public BufferedImage getCardImg()
	{
		//System.out.println(getCardImgPath());

		BufferedImage cardImg = null;
		try {
			cardImg = ImageIO.read( new File( getCardImgPath() ) );

		} catch (IOException e) {
			System.out.println("The image for " + toString() + " could not be loaded");
		}

		if (cardImg != null) {
			cardImg.getScaledInstance(180, 252, Image.SCALE_DEFAULT);
		}

		return cardImg;

	}

}

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

	/** CONSTRUCTOR
	 * @param suit      String card suit
	 * @param rank      String card rank
	 * @param val       int card point value
	 */
	Card(String suit, String rank, int val) //main constructor
	{

		this.suit = suit;
		this.rank = rank;
		this.val = val;

	}

	/** OBJECT METHOD
	 * @return          String card suit
	 */
	String getSuit() {return this.suit;}

	/** OBJECT METHOD
	 * @return          String card rank
	 */
	String getRank() {return this.rank;}

	/** OBJECT METHOD
	 * @return          int card point value
	 */
	int getVal() {return this.val;}

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
	
	//	public String getCardImgPath()
//	{

		/*Path currentRelativePath = Paths.get( "" );
		String s = currentRelativePath.toAbsolutePath().toString();

		System.out.println( s );*/

		//return System.getProperty( "user.dir" ) + "\images\" + val + "_of_" + suit.toLowerCase() + ".png";
		
//		return "../../images/" + val + "_of_" + suit.toLowerCase() + ".png";

//	}


	/*public BufferedImage getCardImg()
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

	}*/

}

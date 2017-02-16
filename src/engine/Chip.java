package engine;

/**
 * Created by Matthew Chivallati on 2/15/2017.
 */
public class Chip
{
	
	/**
	 * String the color of a Chip object, is dependent on the chipValue
	 */
	private String color;
	/**
	 * int the monetary value of a Chip object
	 */
	private int chipValue;
	
	
	/** CONSTRUCTOR - throws IllegalArgumentException if param is not 1, 5, 10, 25, 50, 100, or 500
	 * @param value		int value of a Chip object, must equal 1, 5, 10, 25, 50, 100, or 500
	 */
	public Chip( int value )
	{
		
		setChipValue( value ); //set the value of a Chip object based on the param
		setColor(); //sets color based on the value
		
	}
	
	/**	OBJECT METHOD - gets the color of a chip object
	 * @return			String color of a chip object
	 */
	public String getColor() { return this.color; }
	
	/** OBJECT METHOD - Sets the color of the Chip object based of the value
	 *  ONLY USED IN Chip.java
	 */
	private void setColor()
	{
		
		switch ( this.chipValue ) {
			
			case 1 : this.color = "Pink"; //if the chip value is 1 its a pink chip
				break;
			
			case 5 : this.color = "Blue"; //if the chip value is 5 its a blue chip
				break;
			
			case 10 : this.color = "Green"; //if the chip value is 10 its a green chip
				break;
			
			case 25 : this.color = "Red"; //if the chip value is 25 its a red chip
				break;
			
			case 50 : this.color = "Yellow"; //if the chip value is 50 its a yellow chip
				break;
			
			case 100 : this.color = "White"; //if the chip value is 100 its a white chip
				break;
			
			case 500 : this.color = "Black"; //if the chip value is 500 its a black chip
				break;
			
			default : color = "Invalid case"; //should never trigger default case, last line of defense against the value not being one of the specified values (can never be too safe)
				break;
			
		}
		
	}
	
	/** OBJECT METHOD - gets the value of a chip object
	 * @return			int value of a Chip object
	 */
	public int getChipValue() { return this.chipValue; }
	
	/** OBJECT METHOD - throws IllegalArgumentException if param is not 1, 5, 10, 25, 50, 100, or 500
	 * @param val			int value a Chip object, must equal 1, 5, 10, 25, 50, 100, or 500
	 */
	public void setChipValue( int val )
	{
		
		if ( val != 1 ^ val != 5 ^ val != 10 ^ val != 25 ^ val != 50 ^ val != 100 ^ val != 500 ) { //If the entered value is not one of the fixed values, the program will throw an IllegalArgumentException during runtime. Don't want to have weird chip values now do we.
			throw new IllegalArgumentException("The entered chip value does not correspond to any chip. Must be 1, 5, 10, 25, 50, 100, or 500");
		}
		
		this.chipValue = val; //If the entered value is one of the specified values, its equates this.chipValue to the param
	
	}
	
	/**
	 * @return		String representation of a Chip object
	 */
	@Override
	public String toString() { return "$" + this.chipValue + " " + this.color + " chip"; }
	
}

package engine;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class util
{

	//---------- Random Number Method ---------//


	/**
	 * @param min           int minimum bound
	 * @param max           int maximum bound
	 * @return              int pseudorandom value withing the given range
	 */
	public static int randomInt( int min, int max )
	{

		int range = ( max + 1 ) - min;

		return (int) ( ( Math.random() * range ) + min );

	}
	
}

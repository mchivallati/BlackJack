package engine;

/**
 *  Created by Matthew Chivallati on 9/9/2015.
 */
class util
{

	//---------- Random Number Method ---------//


	/**
	 * @param min           int minimum bound
	 * @param max           int maximum bound
	 * @return              int pseudo-random value within the given range
	 */
	static int randomInt( int min, int max )
	{

		int range = ( max + 1 ) - min;

		return (int) ( ( Math.random() * range ) + min );

	}
	
}

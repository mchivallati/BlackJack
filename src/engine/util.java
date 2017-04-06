package engine;

import java.util.List;

/**
 *  Created by Matthew Chivallati.
 */
public class util
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

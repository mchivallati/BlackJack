package engine;

import java.util.List;

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
	
	/**
	 * @param a				List(Chip) a list of chips
	 * @return				int sum of the values of the chips in the list
	 */
	static int sumOfArray( List<Chip> a )
	{
		
		if ( a.isEmpty() ) {
			
			return 0;
			
		} else {
			
			return a.get(0).getChipValue() + sumOfArray( a.subList( 1 , a.size() ) );
			
		}
		
	}
	
}

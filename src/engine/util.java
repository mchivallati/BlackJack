package engine;

/**********************************************************************
 * util.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 03292017
 *
 * Variable List:
 *
 * Method List: randomInt
 *********************************************************************/
public class util {
	
	//---------- Random Number Method ---------//
	
	
	/**
	 * @param min int minimum bound
	 * @param max int maximum bound
	 * @return int pseudo-random value within the given range
	 */
	static int randomInt( int min, int max ) {
		
		int range = ( max + 1 ) - min;
		
		return (int) ( ( Math.random() * range ) + min );
		
	}
	
}

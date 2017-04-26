package game;

import engine.Dealer;
import engine.Player;

/**********************************************************************
 * GameRules.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 03292017
 *
 * Variable List:
 *
 * Method List: isHigher, payToPlayer2, payToPlayer3, payToDealer, checkRules
 *********************************************************************/

class GameRules {
	
	/**
	 * USED ONLY IN GAMERULES.JAVA
	 *
	 * @param dealer Dealer the dealer
	 * @param player Player the player
	 * @return boolean true if the dealers wins, false if the player wins
	 */
	static boolean isHigher( Dealer dealer, Player player ) {
		
		return dealer.getHandValue() > player.getHandValue();
		
	}
	
	static void payToPlayer2( Player p ) {
		
		p.setPurse( p.getPurse() + ( p.getBet() * 2 ) );
		
	}
	
	static void payToPlayer3( Player p ) {
		
		p.setPurse( p.getPurse() + ( p.getBet() * 3 ) );
		
	}
	
	static void payToDealer( Dealer d, Player p ) {
		
		d.setWinnings( d.getWinnings() + p.getBet() );
		
	}
	
}

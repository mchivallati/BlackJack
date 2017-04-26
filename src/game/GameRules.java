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
	
	//Only used in text version
	
	/*static void checkBlackjack( Player player )
	{
		
		if ( player.getHandValue() == 21 ) {
			
			System.out.println();
			System.out.println(" :) YOU GOT BLACKJACK, YOU WIN :)");
			System.out.println();
			System.out.println(player.toString());
			payToPlayer3( player );
			
		}
		
	}*/
	
	/**
	 * CLASS METHOD
	 *
	 * @param dealer Dealer the dealer
	 * @param player PLayer the player
	 */
	static void checkRules( Dealer dealer, Player player ) {
		
		if ( player.isBust() && ! dealer.isBust() ) {
			System.out.println();
			System.out.println( " :( YOU BUSTED, THE DEALER WINS :(" );
			System.out.println();
			System.out.println( dealer.toString() );
			payToDealer( dealer, player );
		} else if ( dealer.isBust() && ! player.isBust() ) {
			System.out.println();
			System.out.println( " :) THE DEALER BUSTED, YOU WIN :)" );
			System.out.println();
			System.out.println( dealer.toString() );
			System.out.println();
			System.out.println( player.toString() );
			payToPlayer2( player );
		} else if ( player.isBust() && dealer.isBust() ) {
			System.out.println();
			System.out.println( " :| YOU BOTH BUSTED, NO ONE WINS :|" );
			System.out.println();
			System.out.println( dealer.toString() );
			System.out.println();
			System.out.println( player.toString() );
		} else if ( player.getHandValue() == dealer.getHandValue() ) {
			System.out.println();
			System.out.println( " :| ITS A TIE :|" );
			System.out.println();
			System.out.println( dealer.toString() );
			System.out.println();
			System.out.println( player.toString() );
		} else if ( isHigher( dealer, player ) ) {
			System.out.println();
			System.out.println( " :( THE DEALER BEAT YOU, YOU LOSE :(" );
			System.out.println();
			System.out.println( dealer.toString() );
			System.out.println();
			System.out.println( player.toString() );
			payToDealer( dealer, player );
		} else if ( ! isHigher( dealer, player ) ) {
			System.out.println();
			System.out.println( " :) YOU BEAT THE DEALER, YOU WIN :)" );
			System.out.println();
			System.out.println( dealer.toString() );
			System.out.println();
			System.out.println( player.toString() );
			payToPlayer2( player );
		}
	}
	
}

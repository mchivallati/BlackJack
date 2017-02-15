package game;

import engine.Dealer;
import engine.Player;

/**
 *  Created by chiv on 10/12/2015. Class created to specify the rules of the gae using class methods
 */
class GameRules
{
	
	/** USED ONLY IN GAMERULES.JAVA
	 * @param dealer            Dealer the dealer
	 * @param player            Player the player
	 * @return                  boolean true if the dealers wins, false if the player wins
	 */
	private static boolean isHigher(Dealer dealer , Player player)
	{

		return dealer.getHandValue() > player.getHandValue();

	}


	/** CLASS METHOD
	 * @param dealer            Dealer the dealer
	 * @param player            PLayer the player
	 */
	static void checkRules( Dealer dealer, Player player )
	{

		if (player.isBust() && !dealer.isBust()) {
            System.out.println();
            System.out.println(" :( YOU BUSTED, THE DEALER WINS :(");
            System.out.println();
            System.out.println(dealer.toString());
        } else if (dealer.isBust() && !player.isBust()) {
            System.out.println();
            System.out.println(" :) THE DEALER BUSTED, YOU WIN :)");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if (player.isBust() && dealer.isBust()) {
            System.out.println();
            System.out.println(" :| YOU BOTH BUSTED, NO ONE WINS :|");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if (player.getHandValue() == dealer.getHandValue()) {
            System.out.println();
            System.out.println(" :| ITS A TIE :|");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if ( isHigher( dealer, player ) ) {
            System.out.println();
            System.out.println(" :( THE DEALER BEAT YOU, YOU LOSE :(");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        } else if ( !isHigher( dealer, player ) ) {
            System.out.println();
            System.out.println(" :) YOU BEAT THE DEALER, YOU WIN :)");
            System.out.println();
            System.out.println(dealer.toString());
            System.out.println();
            System.out.println(player.toString());
        }
	}

}

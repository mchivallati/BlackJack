package game;

import java.awt.*;

/**
 * BlackJack
 * Created by CompSci-04 on 10/13/2015.
 */
public class GameFrame
{
	

	public static void initPlayerInfo( Graphics g )
	{

		g.drawRect( 0 , 0 , 600 , 600 );
		GameRunner.player.getHand().get(0).displayCard( g , 50 , 50 );
		GameRunner.player.getHand().get(1).displayCard( g , 80 , 800 );

	}

	public void initDealerInfo(Graphics g)
	{



	}

}
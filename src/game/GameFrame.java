package game;

import javax.swing.*;
import java.awt.*;

/**
 * BlackJack
 * Created by CompSci-04 on 10/13/2015.
 */
public class GameFrame extends JFrame
{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int appWidth = (int) screenSize.getWidth() / 2;
	int appHeight = (int) screenSize.getHeight() / 2;

	public GameFrame(Graphics g)
	{

		super("Blackjack");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(appWidth,appHeight);
		setResizable( false );

		//init methods here

		setVisible(true);
	}

	public void initPlayerInfo(Graphics g)
	{

		g.drawRect( 0 , 0 , appWidth / 2 , appHeight / 2 );


	}

	public void initDealerInfo(Graphics g)
	{



	}

}
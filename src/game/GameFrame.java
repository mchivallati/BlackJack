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
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();

	public GameFrame()
	{

		super("Blackjack");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(screenSize);
		setResizable(false);

		JButton hit = new JButton("Hit");
		add(hit);

		setVisible(true);
	}

}
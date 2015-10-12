package game;
import javax.swing.*;
import java.awt.*;

/**
 * Created by CompSci-04 on 10/9/2015.
 */
public class GameFrame extends JFrame
{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();

	public static void main(String[] args)
	{

		new GameFrame().setVisible(true);

	}

	private GameFrame()
	{

		super("Blackjack");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());


	}

}
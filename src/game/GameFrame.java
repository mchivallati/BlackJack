package game;
import javax.swing.*;
import java.awt.*;

/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class GameFrame extends JFrame
{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();

	/**
	 *
	 */
	GameFrame() {
		super("Blackjack");
		setSize(screenWidth,screenHeight);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	}

}
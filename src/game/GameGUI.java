package game;

import engine.CardCountingAI;
import engine.Dealer;
import engine.Deck;
import engine.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static game.GameRules.*;

/**********************************************************************
 * GameGUI.java
 * Assignment Number:
 * Author: Matthew Chivallati
 * Collaborations:
 * Date: 03292017
 *
 * Variable List: playerCardGrid, dealerCardGrid, textArea, actionBar, winCount, loseCount, bustCount, tieCount, winCountDealer, loseCountDealer, bustCountDealer
 *
 * Method List: start, main, playerGameSequence, aiGameSequence, doDealerAI, countCardsAI, actionBar, askForBet, showCards, refreshPlayerCards, refreshDealerCards, checkBlackjack, checkRules, fullscreen, hitBtn, stayBtn
 *********************************************************************/

public class GameGUI extends Application {
	
	//creates the grid layout for for the dealer's and player's cards
	private GridPane playerCardGrid = new GridPane();
	private GridPane dealerCardGrid = new GridPane();
	private Label pHandValue = new Label();
	
	private FlowPane textArea = new FlowPane();
	private HBox actionBar = new HBox( 25 );
	
	private int winCountPlayer = 0;
	private int loseCountPlayer = 0;
	private int bustCountPlayer = 0;
	private int tieCount = 0;
	private int winCountDealer = 0;
	private int loseCountDealer = 0;
	private int bustCountDealer = 0;
	
	private boolean playAsPlayer;
	
	/**
	 * <p><b>This is the main running method for the GUI. All GUI creation ultimately is called into this method to create my "stunning" GUI.</b></p>
	 *
	 * @param primaryStage <i>required</i>
	 * @throws Exception <i>required</i>
	 */
	@Override
	public void start( Stage primaryStage ) throws Exception {
		
		/*-MAIN PANE AND ROOT STACK PANE CREATION-*///-----------------------------------------------------------------------------------------------------------//
		
		StackPane stack = new StackPane();
		
		//creates the root pane
		Pane pane = new Pane();
		pane.setVisible( false );
		
		//creates the main scene and adds the CSS stylesheet
		// for custom styles
		Scene gameScene = new Scene( stack, 1920, 1080 );
		gameScene.getStylesheets().add( "stylesheet.css" ); //links custom style sheet to the root scene
		
		/*-MENU CREATION-*///--------------------------------------------------------------------------------------------------------//
		
		//wrapper border pane for the grid pane
		BorderPane menu = new BorderPane();
		GridPane menuGrid = new GridPane();
		menuGrid.setHgap( 5 );
		
		//ai selection button
		Button aiBtn = new Button( "Play with AI" );
		aiBtn.setOnAction( e -> {
			playAsPlayer = false;
			menu.setVisible( false );
			pane.setVisible( true );
			aiGameSequence( gameScene );
		} );
		
		//player selection button
		Button playerBtn = new Button( "Play as Player" );
		playerBtn.setOnAction( e -> {
			playAsPlayer = true;
			menu.setVisible( false );
			pane.setVisible( true );
			playerGameSequence( pane, gameScene );
		} );
		
		menuGrid.add( aiBtn, 0, 0 );
		menuGrid.add( playerBtn, 1, 0 );
		menuGrid.setAlignment( Pos.CENTER );
		
		menu.setCenter( menuGrid );
		
		/*-EXIT AND FULLSCREEN BUTTONS-*///------------------------------------------------------------------------------------------------//
		
		//Exit Button
		Button exit = new Button( "Exit" );
		exit.getStyleClass().add( "exit" );
		exit.setMinWidth( 100 );
		StackPane.setAlignment( exit, Pos.TOP_RIGHT );
		exit.setOnAction( e -> Platform.exit() );
		
		//Fullscreen Button
		Button fullscreenBtn = new Button( "Fullscreen" );
		StackPane.setAlignment( fullscreenBtn, Pos.TOP_LEFT );
		fullscreenBtn.setOnAction( e -> fullscreen( primaryStage, pane, fullscreenBtn ) );
		
		/*-THE TEXT AREA THAT SHOWS THE RESULTS-*///------------------------------------------------------------------------------------------//
		
		textArea.layoutXProperty().bind( gameScene.xProperty().add( gameScene.widthProperty().divide( 8 ) ) );
		textArea.layoutYProperty().bind( gameScene.yProperty().add( gameScene.heightProperty().divide( 8 ) ) );
		textArea.setVgap( 8 );
		textArea.setHgap( 4 );
		textArea.setPrefWrapLength( 300 );
		textArea.getStyleClass().add( "text-area" );
			
		/*-FINAL ADDITIONS AND DISPLAYS THE PRIMARY STAGE-*///-------------------------------------------------------------------------------------//
		
		//adds the grids to the pane
		pane.getChildren().add( dealerCardGrid );
		pane.getChildren().add( playerCardGrid );
		pane.getChildren().add( textArea );
		stack.getChildren().addAll( menu, pane, exit );
		
		primaryStage.setTitle( "BlackJack" );
		primaryStage.setScene( gameScene );
		//makes the game fullscreen
		primaryStage.setFullScreen( true );
		primaryStage.show();
		
	}
	
	/**
	 * <p>Main method in case some IDEs do not support the JavaFX start method as a execution point</p>
	 *
	 * @param args inputted console params <i>*not used*</i>
	 */
	public static void main( String[] args ) {
		
		launch( args );
		
	}
	
	/**
	 * <p>
	 * This method contains the sequenced used by the player to play blackjack. Between
	 * the ai and the player, the game sequence needs to be slightly different. This method
	 * is called inside the event handler for the <code>playerBtn</code> button inside
	 * the menu border pane <i>*see line 84*</i>.
	 * </p>
	 *
	 * @param pane      The main pane used for the game. Contains all the cards and other main nodes.
	 * @param gameScene The root scene.
	 */
	private void playerGameSequence( Pane pane, Scene gameScene ) {
		Deck deck = new Deck();
		deck.shuffleDeck( 1000 );
		Dealer d = new Dealer( deck.getDeck() );
		System.out.println( "doing the player game sequence" );
		Player p = new Player( deck.getDeck() );
		
		//for (int i = 0 ; i < 2 ; i ++) {
		askForBet( p, d, deck, pane, gameScene );
		//}
	}
	
	/**
	 * <p>
	 * Very similar to the <code>playerGameSequence(Pane pane, Scene gameScene)</code> method,
	 * but it has a few differences. Namely the exclusion of an hit and stay button, as well
	 * as no bet enter text field. This method is called inside the <code>aiBtn</code> event
	 * handler <i>*see line 75*</i>
	 * </p>
	 *
	 * @param gameScene The root scene.
	 */
	private void aiGameSequence( Scene gameScene ) {
		Deck deck = new Deck();
		deck.shuffleDeck( 1000 );
		Dealer d = new Dealer( deck.getDeck() );
		System.out.println( "doing the ai game sequence" );
		CardCountingAI ai = new CardCountingAI( deck.getDeck() );
		
		ai.setBet( d );
		showCards( ai, d, gameScene );
		checkBlackjack( d, ai );
		if ( ! ai.hasBlackjack() ) {
			countCardsAI( d, ai, deck );
		}
	}
	
	/**
	 * <p>
	 * This method performs the automated decisions used by the dealer. It uses the
	 * <code>useDealerAI(Deck d)</code> implemented in Dealer.java. It is called in both the
	 * game sequences for the ai and player.
	 * </p>
	 *
	 * @param d    The dealer who will be performing actions.
	 * @param deck The deck that the game is currently playing with.
	 * @param p    The player of the current hand (can be AI or regular player).
	 */
	private void doDealerAI( Player p, Dealer d, Deck deck ) {
		
		d.useDealerAI( deck );
		dealerCardGrid.add( new ImageView( new Image( "images/" + d.getHand().get( 1 ).getRank() + "_of_" + d.getHand().get( 1 ).getSuit() + ".png", 200, 300, false, true, false ) ), 1, 1 );
		refreshDealerCards( d );
		if ( d.isBust() ) {
			textArea.getChildren().add( new Label( "\nThe dealer busted\nThe player won" ) );
			bustCountDealer++;
			loseCountDealer++;
			winCountPlayer++;
			payToPlayer2( p );
			try {
				if ( playAsPlayer ) {
					writeToPlayerCSV( p );
				} else {
					writeToAICSV( p );
				}
				writeToDealerCSV( d );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		
		if ( ! playAsPlayer ) {
			checkRules( d, p, textArea );
		}
		
	}
	
	/**
	 * <p>
	 * This method performs the automated decisions used by the ai. It uses the
	 * <code>doAction(Deck deck)</code> method implemented in CountingCardAI.java. It is called in the
	 * game sequences for the ai.
	 * </p>
	 *
	 * @param d    The dealer who will be performing actions.
	 * @param ai   The ai that is playing while counting cards.
	 * @param deck The deck that the game is currently playing with.
	 * @see engine.CardCountingAI
	 */
	private void countCardsAI( Dealer d, CardCountingAI ai, Deck deck ) {
		
		ai.doAction( deck );
		//dealerCardGrid.add( new ImageView( new Image( "images/" + ai.getHand().get( 1 ).getRank() + "_of_" + ai.getHand().get( 1 ).getSuit() + ".png", 200, 300, false, true, false ) ), 1, 0 );
		refreshPlayerCards( ai );
		if ( ai.isBust() ) {
			textArea.getChildren().add( new Label( "\nThe AI busted\nThe dealer won\n" ) );
			bustCountPlayer++;
			loseCountPlayer++;
			winCountDealer++;
			ai.setPurse( ai.getPurse() - ai.getBet() );
			
			try {
				writeToAICSV( ai );
				writeToDealerCSV( d );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		} else {
			doDealerAI( ai, d, deck );
		}
		
	}
	
	/**
	 * <p>
	 * This method creates an HBox on the bottom of the screen filled with the hit button and
	 * stay button. It allows the player to interact and play the game.
	 * </p>
	 *
	 * @param pane  The main pane used for the game. Contains all the cards and other main nodes.
	 * @param scene The root scene.
	 * @param p     The player that will be playing blackjack.
	 * @param d     The dealer who will be performing actions.
	 * @param deck  The deck that the game is currently playing with.
	 */
	private void actionBar( Pane pane, Scene scene, Player p, Dealer d, Deck deck ) {
		
		actionBar.getStyleClass().add( "my-hbox" );
		actionBar.layoutXProperty().bind( scene.widthProperty().divide( 2 ).subtract( actionBar.widthProperty().divide( 2 ) ) );
		actionBar.layoutYProperty().bind( scene.heightProperty().subtract( actionBar.heightProperty() ) );
		Button hit = new Button( "Hit" );
		Button stay = new Button( "Stay" );
		
		hit.setMinWidth( 200 );
		stay.setMinWidth( 200 );
		
		hit.setOnAction( e -> hitBtn( d, p, deck ) );
		stay.setOnAction( e -> stayBtn( actionBar, d, p, deck ) );
		
		actionBar.getChildren().add( hit );
		actionBar.getChildren().add( stay );
		
		pane.getChildren().add( actionBar );
		
	}
	
	/**
	 * <p>
	 * When called, this method creates the area where a player can input their bet. The bet area
	 * has a bet button, a text field for numerical input, and displays the amount of money a
	 * player currently has to bet. If an incorrect value is entered, a Label is added to the bet
	 * area displaying an error message. The bet area will still appear until the player has
	 * entered a bet.
	 * </p>
	 *
	 * @param p         The player that will be playing blackjack.
	 * @param d         The dealer who will be performing actions.
	 * @param pane      The main pane used for the game. Contains all the cards and other main nodes.
	 * @param gameScene The root scene.
	 */
	private void askForBet( Player p, Dealer d, Deck deck, Pane pane, Scene gameScene ) {
		
		//final int[] counter = { 0 };
		Button bet = new Button( "Bet" );
		TextField betInput = new TextField("");
		betInput.setPromptText("Input a bet");
		Label purse = new Label( Integer.toString( p.getPurse() ) );
		Label l = new Label( "Oops! Wrong input	" );
		
		l.setVisible( false );
		
		//for ( int i = 0 ; i < 2 ; i++ ) {
		//actionBar.setVisible( false );
		//l.setVisible( false );
		
		//if ( deck.getDeck().size() < 4 ) {
		//	deck = new Deck();
		//}
		
		//p.initHand( deck.getDeck() );
		//d.initHand( deck.getDeck() );
		
		HBox betBox = new HBox();
		betBox.getChildren().add( l );
		
		betBox.getChildren().add( bet );
		betBox.getChildren().add( betInput );
		betBox.getChildren().add( purse );
		
		betBox.setSpacing( 20 );
		
		betBox.layoutXProperty().bind( gameScene.widthProperty().divide( 2 ).subtract( betBox.widthProperty().divide( 2 ) ) );
		betBox.layoutYProperty().bind( gameScene.heightProperty().divide( 2 ).subtract( betBox.heightProperty() ) );
		
		pane.getChildren().add( betBox );
		
		bet.setOnAction( e -> {
			
			try {
				if ( Integer.parseInt( betInput.getText() ) <= p.getPurse() ) {
					
					p.setBet( Integer.parseInt( betInput.getText() ) );
					
					//displays the cards, see line 137
					showCards( p, d, gameScene );
					
					checkBlackjack( d, p );
					
					if ( ! p.hasBlackjack() ) {
						actionBar( pane, gameScene, p, d, deck );
					}
					
					pane.getChildren().remove( betBox );
					//int i = counter[0]++;
					//if (i < 2) {
					//	askForBet( p , d , deck , pane , gameScene );
					//}
					
				} else {
					throw new NumberFormatException();
				}
			} catch ( NumberFormatException e1 ) {
				
				l.setVisible( true );
				
			}
			
		} );
		
		//}
		
	}
	
	/**
	 * <p>
	 * Here the method takes the player (whether it be an actual player or the ai) and dealer and
	 * gets their respective cards currently in their hands. This is accomplish by naming the images
	 * in the <code>src/images</code> folder. The images of the cards are named using the following
	 * convention:
	 * <p>
	 * <i>cardsRank</i>_of_<i>cardsSuit</i>.png
	 * For example the Ace of Spades card's image name would be "Ace_of_Spades.png"
	 * <p>
	 * </p>
	 *
	 * @param p     The player that will be playing blackjack.
	 * @param d     The dealer who will be performing actions.
	 * @param scene The root scene.
	 */
	private void showCards( Player p, Dealer d, Scene scene ) {
		
		//fetches the images from url
		Image playerCard1 = new Image( "images/" + p.getHand().get( 0 ).getRank() + "_of_" + p.getHand().get( 0 ).getSuit() + ".png", 200, 300, false, true, false );
		Image playerCard2 = new Image( "images/" + p.getHand().get( 1 ).getRank() + "_of_" + p.getHand().get( 1 ).getSuit() + ".png", 200, 300, false, true, false );
		Image dealerCard1 = new Image( "images/" + d.getHand().get( 0 ).getRank() + "_of_" + d.getHand().get( 0 ).getSuit() + ".png", 200, 300, false, true, false );
		Image dealerCard2 = new Image( "images/playing-card-back.png", 200, 300, false, true, false );
		
		//creates displayable images using url
		ImageView pc1 = new ImageView( playerCard1 );
		ImageView pc2 = new ImageView( playerCard2 );
		ImageView dc1 = new ImageView( dealerCard1 );
		ImageView dc2 = new ImageView( dealerCard2 );
		
		//adds dealer cards the grid
		dealerCardGrid.add( new Label( "Dealer" ), 0, 0 );
		dealerCardGrid.add( dc1, 0, 1 );
		dealerCardGrid.add( dc2, 1, 1 );
		
		pHandValue.setText( "Hand Value: " + p.getHandValue() );
		
		//adds player cards to grid
		playerCardGrid.add( new Label( "Player" ), 0, 0 );
		playerCardGrid.add( pHandValue, 1, 0 );
		playerCardGrid.add( pc1, 0, 1 );
		playerCardGrid.add( pc2, 1, 1 );
		
		//dealer grid positioning
		dealerCardGrid.layoutYProperty().bind( scene.heightProperty().divide( 2 ).subtract( scene.heightProperty().divide( 3.5 ) ) );
		dealerCardGrid.layoutXProperty().bind( scene.widthProperty().divide( 2 ).subtract( d.getHand().size() * 100 ) ); //stays centred no matter how many cards are displayed
		
		//player grid positioning relative to the dealer grid
		playerCardGrid.layoutYProperty().bind( dealerCardGrid.layoutYProperty().add( dealerCardGrid.heightProperty().add( scene.heightProperty().divide( 10 ) ) ) );
		playerCardGrid.layoutXProperty().bind( scene.widthProperty().divide( 2 ).subtract( d.getHand().size() * 100 ) ); //stays centred no matter how many cards are displayed
		
	}
	
	/**
	 * <p>
	 * After the player hits, the current cards displayed is not their hand so we need to add the
	 * card they gained. This method accesses the player's hand and retrieves the newest card in
	 * their hand. The method is only called directly after the player hits, so there is only a need
	 * to add the newest card added to the player's hand.
	 * </p>
	 *
	 * @param p The player that will be playing blackjack.
	 */
	private void refreshPlayerCards( Player p ) { //Only called after the player hits
		
		if ( p.getHand().size() != 2 ) {
			playerCardGrid.add( new ImageView( new Image( "images/" + p.getHand().get( p.getHand().size() - 1 ).getRank() + "_of_" + p.getHand().get( p.getHand().size() - 1 ).getSuit() + ".png", 200, 300, false, true, false ) ), p.getHand().size() - 1, 1 );
		}
		
		
		//creates the text showing the value of the player's hand
		playerCardGrid.getChildren().remove( pHandValue );
		playerCardGrid.add( pHandValue, 1, 0 );
		pHandValue.setText( "Hand Value: " + p.getHandValue() );
		
	}
	
	/**
	 * <p>
	 * Identical to the <code>refreshPlayerCards(Player p)</code> method with the exception that it
	 * updates the dealer's displayed cards instead of the player's. It is also only called directly
	 * after the dealer hits.
	 * </p>
	 *
	 * @param d The dealer who will be performing actions.
	 */
	private void refreshDealerCards( Dealer d ) { //Only called after the dealer hits
		
		if ( d.getHand().size() != 2 ) {
			dealerCardGrid.add( new ImageView( new Image( "images/" + d.getHand().get( d.getHand().size() - 1 ).getRank() + "_of_" + d.getHand().get( d.getHand().size() - 1 ).getSuit() + ".png", 200, 300, false, true, false ) ), d.getHand().size() - 1, 1 );
		}
		
	}
	
	/**
	 * <p>
	 * Checks to see of the player has black jack or when the first two cards the player is dealt add
	 * up tp 21.
	 * </p>
	 *
	 * @param dealer The dealer who will be performing actions.
	 * @param player The player that will be playing blackjack.
	 */
	private void checkBlackjack( Dealer dealer, Player player ) {
		
		if ( player.hasBlackjack() ) {
			payToPlayer3( player );
			textArea.getChildren().add( new Label( "\nYou got blackjack\n" ) );
			try {
				if ( playAsPlayer ) {
					writeToPlayerCSV( player );
				} else {
					writeToAICSV( player );
				}
				writeToDealerCSV( dealer );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * <p>
	 * Uses the rules defined in GameRules.java to determined a hands outcome. In other words, this
	 * method checks to see who won and lost the hand. It also accounts of rif there is a tie between
	 * the player and dealer.
	 * </p>
	 *
	 * @param dealer   The dealer who will be performing actions.
	 * @param player   The player that will be playing blackjack.
	 * @param textArea The text area where the result of the hand are shown.
	 */
	private void checkRules( Dealer dealer, Player player, Pane textArea ) {
		
		System.out.println( "checking the rules" );
		Label label = new Label();
		
		if ( ! dealer.isBust() && ! player.isBust() ) {
			if ( player.getHandValue() == dealer.getHandValue() ) {
				label.setText( "\nBoth tied\n" );
				tieCount++;
			} else if ( isHigher( dealer, player ) ) {
				label.setText( "\nThe dealer won the hand\n" );
				winCountDealer++;
				loseCountPlayer++;
				player.setPurse( player.getPurse() - player.getBet() );
				payToDealer( dealer, player );
			} else if ( ! isHigher( dealer, player ) ) {
				label.setText( "\nthe player won the hand\n" );
				winCountPlayer++;
				loseCountDealer++;
				payToPlayer2( player );
			}
			try {
				if ( playAsPlayer ) {
					writeToPlayerCSV( player );
				} else {
					writeToAICSV( player );
				}
				writeToDealerCSV( dealer );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
			
		}
		
		textArea.getChildren().add( label );
	}
	
	//Handlers
	
	/**
	 * <b>EVENT HANDLER</b>
	 * <p>
	 * This method is the event handler for the fullscreen button. When clicked, the primary stage
	 * will become fullscreen.
	 * </p>
	 *
	 * @param primaryStage  The main stage object used in the GUI.
	 * @param pane          The main pane used for the game. Contains all the cards and other main nodes.
	 * @param fullscreenBtn The fullscreen button on the top left of the screen.
	 */
	private void fullscreen( Stage primaryStage, Pane pane, Button fullscreenBtn ) {
		
		primaryStage.setFullScreen( true );
		pane.getChildren().remove( fullscreenBtn );
		
	}
	
	/**
	 * <b>EVENT HANDLER</b>
	 * <p>
	 * This method is the event handler for the hit button. When clicked, the <code>hit(Arraylist deck)</code> method
	 * is called. A new card is added to the players hand and the displayed cards are refreshed using <code>refreshPlayerCards(Player p)</code>
	 * </p>
	 *
	 * @param d    The dealer who will be performing actions.
	 * @param p    The player that will be playing blackjack.
	 * @param deck The deck that the game is currently playing with.
	 */
	private void hitBtn( Dealer d, Player p, Deck deck ) { //has the player hit and updates the shown cards on the gui
		
		p.hit( deck.getDeck() );
		refreshPlayerCards( p );
		if ( p.isBust() ) {
			actionBar.setVisible( false );
			textArea.getChildren().add( new Label( "\nYou busted\nThe dealer won\n" ) );
			winCountDealer++;
			loseCountPlayer++;
			bustCountPlayer++;
			p.setPurse( p.getPurse() - p.getBet() );
			try {
				writeToPlayerCSV( p );
				writeToDealerCSV( d );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * <b>EVENT HANDLER</b>
	 * <p>
	 * This method is the event handler for the stay button. When clicked, the action bar is set
	 * to not visible so the player cannot perform any more actions after the game sequence
	 * progresses.
	 * </p>
	 *
	 * @param actionBar The bar on the HBox on the bottom of the screen that prompts the player to either hit or stay.
	 * @param d         The dealer who will be performing actions.
	 * @param p         The player that will be playing blackjack.
	 * @param deck      The deck that the game is currently playing with.
	 */
	private void stayBtn( HBox actionBar, Dealer d, Player p, Deck deck ) {
		
		actionBar.setVisible( false );
		doDealerAI( p, d, deck );
		checkRules( d, p, textArea );
		
	}
	
	//File I/O
	
	/**
	 * @param ai The player that will be playing blackjack.
	 * @throws IOException Exception is handled at the method call.
	 */
	private void writeToAICSV( Player ai ) throws IOException {
		
		String filePath = "src/statistics/AIstats.csv";
		
		ExpoOutFile output = new ExpoOutFile( filePath ); //Export stream creation
		System.out.println( "Writing to AI File..." );
		
		//writing the stats to file
		output.nextLine();
		output.writeString( "AI" );
		output.writeString( Integer.toString( winCountPlayer ) );
		output.writeString( Integer.toString( loseCountPlayer ) );
		output.writeString( Integer.toString( bustCountPlayer ) );
		output.writeString( Integer.toString( tieCount ) );
		output.writeString( Integer.toString( ai.getPurse() - 100 ) );
		
		output.closeFile();
		System.out.println( "File output stream closed..." );
		
		
	}
	
	/**
	 * @param p The player that will be playing blackjack.
	 * @throws IOException Exception is handled at the method call.
	 */
	private void writeToPlayerCSV( Player p ) throws IOException {
		
		String filePath = "src/statistics/Playerstats.csv";
		
		ExpoOutFile output = new ExpoOutFile( filePath ); //Export stream creation
		System.out.println( "Writing to Player File..." );
		
		//writing the stats to file
		output.nextLine();
		output.writeString( "Player" );
		output.writeString( Integer.toString( winCountPlayer ) );
		output.writeString( Integer.toString( loseCountPlayer ) );
		output.writeString( Integer.toString( bustCountPlayer ) );
		output.writeString( Integer.toString( tieCount ) );
		output.writeString( Integer.toString( p.getPurse() - 100 ) );
		
		output.closeFile();
		System.out.println( "File output stream closed..." );
		
	}
	
	/**
	 * @param d The dealer who will be performing actions.
	 * @throws IOException Exception is handled at the method call.
	 */
	private void writeToDealerCSV( Dealer d ) throws IOException {
		
		String filePath = "src/statistics/Dealerstats.csv";
		
		ExpoOutFile output = new ExpoOutFile( filePath ); //Export stream creation
		System.out.println( "Writing to Dealer File..." );
		
		//writing the stats to file
		output.nextLine();
		output.writeString( "Dealer" );
		output.writeString( Integer.toString( winCountDealer ) );
		output.writeString( Integer.toString( loseCountDealer ) );
		output.writeString( Integer.toString( bustCountDealer ) );
		output.writeString( Integer.toString( tieCount ) );
		output.writeString( Integer.toString( d.getWinnings() ) );
		
		output.closeFile();
		System.out.println( "File output stream closed..." );
		
	}
	
	/**
	 * Utility class to streamline the file writing process
	 */
	private class ExpoOutFile {
		
		private String fileName;
		private BufferedWriter outFile;
		
		
		/**
		 * ExpoOutFile constructor method.
		 * Associates external file name with internal file object.
		 * Constructs file object for writing out string values to an external file.
		 *
		 * @param filePath The file path of the csv file your are writing to.
		 * @throws IOException Exception handled during object creation
		 **/
		ExpoOutFile( String filePath ) throws IOException {
			fileName = filePath;
			outFile = new BufferedWriter( new FileWriter( fileName, true ) );
		}
		
		/**
		 * Writes a single string from internal file object to external hard drive file.
		 *
		 * @param input The data that is being written into the csv file
		 **/
		void writeString( String input ) throws IOException {
			outFile.write( input + "," ); //Comma added for csv file format
		}
		
		
		/*
		  Writes a single string from internal file object to external hard drive file.
		  Additionally a linefeed/carriage return is added.
		 
		  @param input	The data that is being written into the csv file
		 *              @throws IOException Exception handled during object creation
		 *
		public void writelnString(String input) throws IOException
		{
			outFile.write(input + ",");
			outFile.newLine();
		}*/
		
		
		/**
		 * A linefeed/carriage return is added when called.
		 *
		 * @throws IOException Exception handled during object creation
		 */
		void nextLine() throws IOException {
			outFile.newLine();
		}
		
		
		/**
		 * Closes file object.
		 *
		 * @throws IOException Exception handled during object creation
		 **/
		void closeFile() throws IOException {
			outFile.close();
		}
		
	}
	
}
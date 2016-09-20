package game;

import engine.Card;
import engine.Dealer;
import engine.Deck;
import engine.Player;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author          Created by Matthew Chivallati on 9/9/2015.
 */
public class GameRunner
{

    public static void main(String[] args)
    {
        do {
            Deck deck = new Deck();
            deck.shuffleDeck( 1000 );
            System.out.println( "!----------Start of Hand----------!" );
            System.out.println();
            System.out.println( "Dealer" );
            Dealer d = new Dealer( deck.getDeck() );
            System.out.println( d.showCard() );
            System.out.println();
            System.out.println( "Player" );
            Player p = new Player( deck.getDeck() );
            System.out.println( p.toString() );
            System.out.println();

            askAction( p, deck );
            if (!p.isBust()) {
                d.useDealerAI(deck);
            }

            GameRules.checkRules( d , p );

            System.out.println();
            System.out.println("END OF HAND");

        } while (askToReplay());

    }

    /**
     * @return                  boolean true if the player wants to continue playing
     */
    private static boolean askToReplay()
    {

        String input;

        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Do you want to play another hand? Y/N: ");
            input = scan.nextLine();

            if (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                replayInputErrorMessage();
            }
        } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));

        return input.equalsIgnoreCase("Y");

    }

    private static void replayInputErrorMessage()
    {

        System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
        System.out.println( " Oops! You entered in a wrong letter. HINT: enter Y for yes and N for no" );
        System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );

    }

    /**
     * @param p                 Player the player being asked
     */
    private static void askAction(Player p, Deck d) //Asks if the player wants to hit or stay
    {

        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to hit or stay? H/S: ");
        String input = scan.nextLine();
        takeAction(input , p , d.getDeck());
    }


    /**
     * @param input             String can only be H or S
     * @param p                 Player the player that is being asked
     * @param deck              ArrayList<Card> the game deck
     *                          Method is called by the askAction() method
     */
    /*private static void takeAction(String input, Player p, ArrayList<Card> deck)                                        //The method that generates the scanner objects and inputs for the player (NEEDS TO BE OPTIMIZED/MAKE METHOD IN ONE OUTER LOOP)
    {

        while ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {                          //If the player inputs a wrong string, this dialogue will loop until the player inputs a correct string
            System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
            System.out.println( " Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
            System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );

            Scanner scan = new Scanner(System.in);
            System.out.print("Do you want to hit or stay? H/S: ");
            input = scan.nextLine();
        }

        if ( input.toUpperCase().equals( "H" ) ) {                                                                      //If the player wants to hit, the hit() Player object method is called
            p.hit( deck );
        }
        if ( input.toUpperCase().equals( "S" ) ) {                                                                      //If the player wants to stay, the stay() Player object method is called
            p.stay();
        }

        Scanner finish = new Scanner( System.in );                                                                      //Second scanner object for second dialogue
        String userIn = "";

        while (!userIn.equalsIgnoreCase("H") && !userIn.equalsIgnoreCase("S")) {                                        //Asks if the player wants to hit or stay again

            if (!p.isBust() && !input.equalsIgnoreCase("S")) {
                System.out.print("Do you want to hit or stay? H/S: ");
                userIn = finish.nextLine();
            }
        }

        while (userIn.equalsIgnoreCase("H")) {

            if (userIn.equalsIgnoreCase("H")) {
                input = "H";
            } else if (userIn.equalsIgnoreCase("S")) {
                input = "S";
            }

            if ( input.toUpperCase().equals( "H" ) ) {
                p.hit( deck );
            } else if ( input.toUpperCase().equals( "S" ) ) {
                p.stay();
            }

            if ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {
                System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
                System.out.println( "Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
                System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
            }

            System.out.print("Do you want to hit or stay? H/S: ");
            userIn = finish.nextLine();

        }

    }*/

    /**
     * @param input             String can only be H or S
     * @param p                 Player the player that is being asked
     * @param deck              ArrayList<Card> the game deck
     *                          Method is called by the askAction() method
     */
    private static void takeAction(String input , Player p , ArrayList<Card> deck)
    {

        do {

            while ( ! input.toUpperCase().equals( "H" ) && ! input.toUpperCase().equals( "S" ) ) {                          //If the player inputs a wrong string, this dialogue will loop until the player inputs a correct string
                System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
                System.out.println( " Oops! You entered in a wrong letter. HINT: enter H for hit and S for stay" );
                System.out.println( "!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );

                Scanner scan = new Scanner(System.in);
                System.out.print("Do you want to hit or stay? H/S: ");
                input = scan.nextLine();
            }

            if ( input.toUpperCase().equals( "H" ) ) {                                                                      //If the player wants to hit, the hit() Player object method is called
                p.hit( deck );
            }
            if ( input.toUpperCase().equals( "S" ) ) {                                                                      //If the player wants to stay, the stay() Player object method is called
                p.stay();
            }

            if (p.isBust()) {
                input = "S";
            } else if (!input.equalsIgnoreCase("S")) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Do you want to hit or stay? H/S: ");
                input = scan.nextLine();
            }

        }
        while (input.equalsIgnoreCase("H") && !input.equalsIgnoreCase("S"));
    }

}
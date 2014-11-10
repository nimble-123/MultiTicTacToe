package multiTicTacToe.multiTTT;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * MultiTTT class to manage the board and player
 */
public class MultiTTT {
    private static final Logger log = Logger.getLogger(MultiTTT.class.getName());

    /**
     * Instance of Board
     */
    private Board mBoard;

    /**
     * Instance of Player
     */
    private Player mPlayer;

    /**
     * Constructor of MultiTTT
     *
     * @param size Size of fields
     */
    public MultiTTT(int size) {
        this.mBoard = new Board(size);
        this.mPlayer = new Player();

        log.info("Created MultiTTT");

    }

    /**
     * Play the game
     */
    public void play() {
    }

    /**
     * Play the game on console
     */
    public void playConsole() {
        Scanner sc = new Scanner(System.in);
        int nfp = 0;
        log.info("NFP is " + nfp);
        while (!mBoard.isWon(mPlayer)) {
            log.info("NFP is " + nfp);
            System.out.println();
            System.out.println();
            System.out.println("Player " + mPlayer.getSign() + " ist dran!");
            if (mBoard.getNextFieldPos() == 0 || mBoard.getField(mBoard.getNextFieldPos()).isWon(mPlayer)) {
                System.out.println("Freie Feld wahl!!!");
                System.out.print("Bitte geben Sie ihr zu spielendes Feld ein: ");
                int answer1 = sc.nextInt();
                System.out.print("Bitte geben Sie die Position ihres Zuges ein: ");
                int answer2 = sc.nextInt();
                mBoard.setMove(mPlayer, answer1, answer2);
            } else {
                System.out.println("Sie spielen auf Feld " + nfp);
                System.out.print("\nBitte geben Sie die Position ihres Zuges ein: ");
                int answer2 = sc.nextInt();
                mBoard.setMove(mPlayer, mBoard.getNextFieldPos(), answer2);
            }
            nfp = mBoard.getNextFieldPos();
        }
    }
}

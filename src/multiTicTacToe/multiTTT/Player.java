package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Player class
 */
public class Player {
    private static final Logger log = Logger.getLogger(Player.class.getName());

    /**
     * Sign of player
     */
    private char mSign;
    /**
     * Last player
     */
    private char mLastPlayer;

    /**
     * Constructor for Player
     */
    public Player() {
        mSign = 'X';
        mLastPlayer = 'O';
        log.info("Created Player");
    }

    /**
     * Get sign of player
     * @return char X or O
     */
    public char getPlayer() {
        return mSign;
    }

    /**
     * Get last player
     * @return char the last player
     */
    public char getLastPlayer() {
        return mLastPlayer;
    }

    /**
     * Switch to next player
     */
    public void nextPlayer() {
        mSign = (mSign == 'X') ? 'O' : 'X';
        mLastPlayer = (mLastPlayer == 'X') ? 'O' : 'X';
        log.info("Switched Player to " + mSign);
    }
}

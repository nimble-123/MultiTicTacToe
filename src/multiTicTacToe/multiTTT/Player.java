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
     * Constructor for Player
     */
    public Player() {
        mSign = 'X'; //First player is always X
        log.info("Created Player");
    }

    /**
     * Switch to next player
     */
    public void nextPlayer() {
        mSign = (mSign == 'X') ? 'O' : 'X';
        log.info("Switched Player to " + mSign);
    }

    /**
     * Get sign of player
     * @return char X or O
     */
    public char getSign() {
        return mSign;
    }
}

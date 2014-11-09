package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 09.11.14.
 */
public class Player {
    private static final Logger log = Logger.getLogger(Player.class.getName());

    private enum sign {X, O}
    private sign mSign;

    public Player() {
        mSign = sign.X; //First player is always X
        log.info("Created Player");
    }

    /**
     * Switch to next player
     */
    public void nextPlayer() {
        mSign = (mSign == sign.X) ? sign.O : sign.X;
        log.info("Switched Player to " + getSignAsChar());
    }

    /**
     * @return sign X or O from enum sign {X, O}
     */
    public sign getSign() {
        return mSign;
    }

    /**
     * @return char X or O
     */
    public char getSignAsChar() {
        return (mSign == sign.X) ? 'X' : 'O';
    }
}

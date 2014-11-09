package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 09.11.14.
 */
public class Player {
    private static final Logger log = Logger.getLogger(Player.class.getName());

    enum sign {X, O}
    private static sign mSign;

    public Player() {
        mSign = sign.X; //First player is always X
        log.info("Created Player");
    }

    /**
     * Switch to next player
     */
    public void nextPlayer() {
        mSign = (mSign == sign.X) ? sign.O : sign.X;
        log.info("Switched Player to " + getSign());
    }

    /**
     * @return char X or O
     */
    public char getSign() {
        return (mSign == sign.X) ? 'X' : 'O';
    }
}

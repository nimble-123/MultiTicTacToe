package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 07.11.14.
 */
public class MultiTTT {
    private static final Logger log = Logger.getLogger(MultiTTT.class.getName());

    private Board mBoard;
    private Player mPlayer;

    /**
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
        //TODO while Schleife solange bis ein Player gewonnen hat
    }


}

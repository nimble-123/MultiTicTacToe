package multiTicTacToe;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 07.11.14.
 */
public class Board {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    enum state {OPEN, XWON, OWON, DRAW}
    Field mTopLeft, mTopMiddle, mTopRight;
    Field mMidLeft, mMidMiddle, mMidRight;
    Field mBotLeft, mBotMiddle, mBotRight;
    Player mPlayer;

    /**
     * @param size Size of board
     */
    Board(int size) {
        this.mTopLeft = new Field(size); this.mTopMiddle = new Field(size); this.mTopRight = new Field(size);
        this.mMidLeft = new Field(size); this.mMidMiddle = new Field(size); this.mMidRight = new Field(size);
        this.mBotLeft = new Field(size); this.mBotMiddle = new Field(size); this.mBotRight = new Field(size);
        this.mPlayer = new Player();

        log.info("Created Board");

    }

    /**
     * Inner class for representation of inner fields
     */
    private static class Field {
        static state mState;
        char[][] mCoords;

        Field(int size) {
            mState = state.OPEN;
            mCoords = new char[size][size];

            for (int i = 0; i < mCoords.length; i++) {
                for (int j = 0; j < mCoords.length; j++) {
                    mCoords[i][j] = '-';
                }
            }
            log.info("Created Field");
        }

    }

    /**
     * Inner class for player representation
     */
    private static class Player {
        enum sign {X, O}
        static sign mSign;

        Player() {
            this.mSign = Player.mSign.X;
            log.info("Created Player");
        }

        /**
         * Switch to next player
         */
        public void nextPlayer() {
            if (this.mSign == mSign.X) {
                this.mSign = mSign.O;
                log.info("Switched Player to 'O'");
            } else {
                this.mSign = mSign.X;
                log.info("Switched Player to 'X'");
            }
        }

    }
}

package multiTicTacToe;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 07.11.14.
 */
public class Board {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    /**
     * Board variables
     */
    private enum state {OPEN, XWON, OWON, DRAW}
    private Field mTopLeft, mTopMiddle, mTopRight;
    private Field mMidLeft, mMidMiddle, mMidRight;
    private Field mBotLeft, mBotMiddle, mBotRight;
    private Player mPlayer;

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
     * Only for testing purposes
     * @param field
     */
    public void output(Field field) {
        for (int i = 0; i < field.mCoords.length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.mCoords.length; j++) {
                System.out.print(" " + getSign(field, i, j) + " |");
            }
            System.out.println();
        }
        System.out.println(field.getState());
        log.info("Field outputted");
    }

    /**
     * Check board for winner
     */
    public void checkWinner() {

    }

    /**
     * @param place The place in the board. TL, TM, TR, ML, MM, MR, BL, BM, BR
     * @return Field
     */
    public Field getField(String place) {
        switch (place) {
            case "TL":
                return this.mTopLeft;
            case "TM":
                return this.mTopMiddle;
            case "TR":
                return this.mTopRight;
            case "ML":
                return this.mMidLeft;
            case "MM":
                return this.mMidMiddle;
            case "MR":
                return this.mMidRight;
            case "BL":
                return this.mBotLeft;
            case "BM":
                return this.mBotMiddle;
            case "BR":
                return this.mBotRight;
        }
        return null;
    }

    /**
     * @param field
     * @param x
     * @param y
     * @return
     */
    public char getSign(Field field, int x, int y) {
        //log.info("Getting sign");
        return field.mCoords[x][y];
    }

    /**
     * @return X or O as char
     */
    public char getPlayer() {
        if (mPlayer.mSign == Player.sign.X) {
            return 'X';
        } else {
            return 'O';
        }
    }

    /**
     * @param field
     * @param x
     * @param y
     */
    public void setMove(Field field, int x, int y) {
        field.mCoords[x][y] = this.getPlayer();
        mPlayer.nextPlayer();
        log.info("Set Move and switched player");
    }

    /**
     * Inner class for representation of inner fields
     */
    private static class Field {
        private static state mState;
        private char[][] mCoords;

        Field(int size) {
            mState = state.OPEN;
            mCoords = new char[size][size];

            for (int row = 0; row < mCoords.length; row++) {
                for (int col = 0; col < mCoords.length; col++) {
                    mCoords[row][col] = '-';
                }
            }
            log.info("Created Field");
        }

        /**
         * @return mState
         */
        public state getState() {
            return this.mState;
        }
    }

    /**
     * Inner class for player representation
     */
    private static class Player {
        enum sign {X, O}
        private static sign mSign;

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

package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 09.11.14.
 */
public class Field {
    private static final Logger log = Logger.getLogger(Field.class.getName());

    public enum state {OPEN, XWON, OWON, DRAW}
    private static state mState;
    private char[][] mCoords;
    private int mBoardIndex;

    public Field(int size, int mBoardIndex) {
        this.mBoardIndex = mBoardIndex;
        this.mState  = state.OPEN;
        this.mCoords = new char[size + 1][size + 1];

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                mCoords[row][col] = '-';
            }
        }
        log.info("Created Field");
    }

    /**
     * @param field
     * @param x
     * @param y
     */
    public void setMove(char sign, int x, int y) {
        mCoords[x][y] = sign;
        log.info("Set Move @[" + x + "][" + y + "] on Field " + this.getBoardIndex());
    }

    /**
     * @return mState
     */
    public state getState() {
        return mState;
    }

    public int getBoardIndex() {
        return mBoardIndex;
    }

    public char[][] getCoords() {
        return mCoords;
    }

    /**
     * Check if given position in field is already played
     */
    public boolean isSet(int x, int y) {
        //TODO check ob an x,y schon ein Spielerzeichen ist oder noch der '-'
        //TODO bei Erfolg TRUE als Rückgabe

        return false;
    }

    /**
     * Check board for winner
     */
    public boolean isWon() {
        //TODO alle Reihen checken if mCoords[1][1,2,3] == 'X'...
        //TODO alle Spalten checken if mCoords[1,2,3][1] == 'X'...
        //TODO beide Diagonale checken
        //TODO bei Erfolg TRUE als Rückgabe

        return false;
    }

    /**
     * Only for testing purposes
     * @param field
     */
    public void display() {
        for (int i = 0; i < this.getCoords().length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.getCoords().length; j++) {
                System.out.print(" " + this.getCoords()[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println(getState());
        log.info("Displayed Field " + mBoardIndex);
    }

}

package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Field class to hold nine fields represent one tictactoe board
 */
public class Field {
    private static final Logger log = Logger.getLogger(Field.class.getName());

    /**
     * Sign of the whole field
     */
    private char mSign;

    /**
     * Array to hold the fields
     */
    private char[] mField;

    /**
     * Integer to hold the board index
     */
    private int mBoardIndex;

    /**
     * Constructor of Field
     * @param size size of field
     * @param boardIndex position in board
     */
    public Field(int size, int boardIndex) {
        mBoardIndex = boardIndex;
        mField = new char[(size * size) + 1];
        mSign = '-';
        for (int i = 1; i <= (size * size); i++) {
                mField[i] = '-';
        }
        log.info("Created Field");
    }

    /**
     * Set a move on position
     * @param pl Player instance
     * @param pos position on field, left-to-right, row-by-row
     */
    public boolean setMove(Player pl, int pos) {
        if (!isSet(pos)) {
            mField[pos] = pl.getSign();
            pl.nextPlayer();
            log.info("Set Move at position " + pos + " on field " + getBoardIndex());
            return true;
        } else {
            log.warning("Move not allowed. Position already played");
        }

        return false;
    }

    /**
     * Get sign of field
     * @return char X, O, D or -
     */
    public char getSign() {
        return mSign;
    }

    /**
     * Get board index
     * @return int Board Index of field
     */
    public int getBoardIndex() {
        return mBoardIndex;
    }

    /**
     * Check if given position in field is already played
     * @param pos 1-9
     */
    public boolean isSet(int pos) {
        return (mField[pos] == 'X' || mField[pos] == 'O');
    }

    /**
     * Check board for winner
     * @param pl Player
     */
    public boolean isWon(Player pl) {
        char sign = pl.getSign();
        if (mField[1] == sign && mField[2] == sign && mField[3] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[4] == sign && mField[5] == sign && mField[6] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[7] == sign && mField[8] == sign && mField[9] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[1] == sign && mField[4] == sign && mField[7] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[2] == sign && mField[5] == sign && mField[8] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[3] == sign && mField[6] == sign && mField[9] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[1] == sign && mField[5] == sign && mField[9] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }
        if (mField[3] == sign && mField[5] == sign && mField[7] == sign) {
            mSign = sign;
            log.info("Field " + mBoardIndex + " is won by Player " + sign);
            return true;
        }

        return false;
    }

    /**
     * Only for testing purposes
     */
    public void display() {
        for (int i = 1; i <= mField.length; i++) {
            System.out.print("| ");
            System.out.print(mField[i]);
            System.out.print(" |");
            if (i % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println(getSign());
        log.info("Displayed Field " + mBoardIndex);
    }
}

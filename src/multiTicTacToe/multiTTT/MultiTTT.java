package multiTicTacToe.multiTTT;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * MultiTTT class to manage the board and player
 */
public class MultiTTT {
    private static final Logger log = Logger.getLogger(MultiTTT.class.getName());

    private char[][] mBoard;
    private int mNextFieldPos;
    private char mActualPl;
    private char mUnset = '-';
    private char mPlayerX = 'X';
    private char mPlayerO = 'O';
    private char mDraw = 'D';

    /**
     * Constructor of MultiTTT
     *
     * @param mSize Size of fields
     */
    public MultiTTT(int mSize) {
        mBoard = new char[mSize * mSize][mSize * mSize];
        for (int mField = 0; mField < mBoard.length; mField++) {
            for (int i = 0; i < mBoard.length; i++) {
                mBoard[mField][i] = mUnset;
            }
        }
        mNextFieldPos = -1;
        mActualPl = mPlayerX;
        log.info("Created Board with size: " + mSize + "x" + mSize);
    }

    /**
     * Set a move to the field on board
     * @param mField field position on the board (1-9)
     * @param mPos field position on the field
     * @return boolean True wenn der Zug erfolgreich gesetzt wurde, sonst False
     */
    private boolean setMove(int mField, int mPos) {
        //TODO check ob field schon fertig oder nicht player switch beachten
        if (checkField(mField) == mUnset) {
            if (mBoard[mField][mPos] == mUnset) {
                mBoard[mField][mPos] = mActualPl;
                mNextFieldPos = mPos;
                if (checkField(mField) != mUnset) {
                    System.out.println("Field #" + (mField + 1) + " is won by player " + ((mActualPl == mPlayerX) ? mPlayerO : mPlayerX));
                    if (mField == mPos) {
                        mNextFieldPos = -1;
                    }
                }
                log.info("Player " + mActualPl + " made a move on field #" + (mField + 1) + " at position #" + (mPos + 1));
                mActualPl = (mActualPl == 'X') ? mPlayerO : mPlayerX;
                return true;
            }
        }

        return false;
    }

    /**
     * @param mField
     * @return X or O or D or -
     */
    private char checkField(int mField) {
        //TODO Draw is noch nicht abgedeckt
        // check rows
        if (mBoard[mField][0] == mActualPl && mBoard[mField][1] == mActualPl && mBoard[mField][2] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        if (mBoard[mField][3] == mActualPl && mBoard[mField][4] == mActualPl && mBoard[mField][5] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        if (mBoard[mField][6] == mActualPl && mBoard[mField][7] == mActualPl && mBoard[mField][8] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        //check cols
        if (mBoard[mField][0] == mActualPl && mBoard[mField][3] == mActualPl && mBoard[mField][6] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        if (mBoard[mField][1] == mActualPl && mBoard[mField][4] == mActualPl && mBoard[mField][7] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        if (mBoard[mField][2] == mActualPl && mBoard[mField][5] == mActualPl && mBoard[mField][8] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        // check diagonal
        if (mBoard[mField][0] == mActualPl && mBoard[mField][4] == mActualPl && mBoard[mField][8] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }
        if (mBoard[mField][2] == mActualPl && mBoard[mField][4] == mActualPl && mBoard[mField][6] == mActualPl) {
            log.info("Field #" + mField + " is won by player " + mActualPl);
            return mActualPl;
        }

        return mUnset;
    }

    /**
     * Check board for winner
     */
    private char checkBoard() {
        //TODO Draw fehlt noch
        // check rows
        if (checkField(0) == mActualPl && checkField(1) == mActualPl && checkField(2) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        if (checkField(3) == mActualPl && checkField(4) == mActualPl && checkField(5) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        if (checkField(6) == mActualPl && checkField(7) == mActualPl && checkField(8) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        // check cols
        if (checkField(0) == mActualPl && checkField(3) == mActualPl && checkField(6) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        if (checkField(1) == mActualPl && checkField(4) == mActualPl && checkField(7) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        if (checkField(2) == mActualPl && checkField(5) == mActualPl && checkField(8) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        // check diagonal
        if (checkField(0) == mActualPl && checkField(4) == mActualPl && checkField(8) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }
        if (checkField(2) == mActualPl && checkField(4) == mActualPl && checkField(6) == mActualPl) {
            log.info("Game is won by player " + mActualPl);
            return mActualPl;
        }

        return mUnset;
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
        Scanner mScanner = new Scanner(System.in);
        while (checkBoard() == mUnset) {
            System.out.println("Player " + mActualPl + " is on the move!");
            if (mNextFieldPos == -1) {
                System.out.print("Free field choice!!!\nPlease enter the field[1-9]: ");
                int mField = mScanner.nextInt() - 1;
                System.out.print("Please enter your move[1-9]: ");
                int mPos = mScanner.nextInt() - 1;
                setMove(mField, mPos);

            } else {
                System.out.print("Your move is on field #" + (mNextFieldPos + 1) + "\nPlease enter your move[1-9]: ");
                int mPos = mScanner.nextInt() - 1;
                setMove(mNextFieldPos, mPos);
            }
        }
        System.out.println("Game is won by player " + mActualPl + "! Congrats!");
    }
}

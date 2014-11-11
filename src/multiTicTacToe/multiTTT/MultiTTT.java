package multiTicTacToe.multiTTT;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * MultiTTT class to manage the board and player
 */
public class MultiTTT {
    private static final Logger log = Logger.getLogger(MultiTTT.class.getName());

    private String mId;
    private String[][][][] mBoard;
    private String[][] mWinnerBoard;
    private int mNextFieldRow;
    private int mNextFieldCol;
    private int mTurn;


    public MultiTTT(int mSize) {
        mBoard = new String[mSize][mSize][mSize][mSize];
        for (int fieldRow = 0; fieldRow < mBoard.length; fieldRow++) {
            for (int fieldCol = 0; fieldCol < mBoard[fieldRow].length; fieldCol++) {
                mWinnerBoard[fieldRow][fieldCol] = "";
                for (int row = 0; row < mBoard[fieldRow][fieldCol].length; row++) {
                    for (int col = 0; col < mBoard[fieldRow][fieldCol][row].length; col++) {
                        mBoard[fieldRow][fieldCol][row][col] = "";
                    }
                }
            }
        }
        mNextFieldRow = -1;
        mNextFieldCol = -1;
        mTurn = 0;
        log.info("Created Board with size: " + mSize + "x" + mSize);
    }

    private void setMove(int fieldRow, int fieldCol, int moveRow, int moveCol) {
        mBoard[fieldRow][fieldCol][moveRow][moveCol] = (mTurn % 2 == 0) ? "X" : "O";
        mNextFieldRow = moveRow;
        mNextFieldCol = moveCol;
        mTurn++;
        log.info("Player " + ((mTurn % 2 != 0) ? "X" : "O") + " made a move on field " + (fieldRow + 1) + "|" + (fieldCol + 1) +" at position " + (moveRow + 1) + "|" + (moveCol + 1));
    }

    public boolean isWinner(int fieldRow, int fieldCol, int row, int col) {
        String player = mBoard[fieldRow][fieldCol][row][col];

        boolean onDiagonal = (row == col) || (col == -1 * row + (mBoard[fieldRow][fieldCol].length - 1));
        boolean HorizontalWin = true, VerticalWin = true;
        boolean DiagonalWinOne = true, DiagonalWinTwo = true;

        // Check the rows and columns
        for (int n = 0; n < mBoard[fieldRow][fieldCol].length; n++) {
            if (!mBoard[fieldRow][fieldCol][row][n].equals(player))
                HorizontalWin = false;
            if (!mBoard[fieldRow][fieldCol][n][col].equals(player))
                VerticalWin = false;
        }

        // Only check diagonals if the move is on a diagonal
        if (onDiagonal) {
            // Check the diagonals
            for (int n = 0; n < mBoard[fieldRow][fieldCol].length; n++) {
                if (!mBoard[fieldRow][fieldCol][n][n].equals(player))
                    DiagonalWinOne = false;
                if (!mBoard[fieldRow][fieldCol][n][-1 * n + (mBoard[fieldRow][fieldCol].length - 1)].equals(player))
                    DiagonalWinTwo = false;
            }
        } else {
            DiagonalWinOne = false;
            DiagonalWinTwo = false;
        }

        if (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo) {
            mWinnerBoard[fieldRow][fieldCol] = "X";
            log.info("Player " + player + " won field " + (fieldRow + 1) + "|" + (fieldCol + 1));
        }

        return (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);
    }

    private boolean checkBoard() {
        //TODO redesign
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

    public void playConsole() {
        Scanner mScanner = new Scanner(System.in);
        int fieldRow;
        int fieldCol;
        int moveRow;
        int moveCol;
        boolean hasNext = true;
        // solange keiner das spiel gewonnen hat
        while (hasNext = checkBoard()) {
            System.out.println("Player " + ((mTurn % 2 == 0) ? "X" : "O") + " ist dran!");
            // wenn noch kein Feld festgelegt wurde
            if (mNextFieldRow == -1 && mNextFieldCol == -1) {
                System.out.print("Free field choice!!!\nPlease enter the field coords X: ");
                fieldRow = mScanner.nextInt() - 1;
                System.out.print(" Y: ");
                fieldCol = mScanner.nextInt() - 1;
                System.out.print("\nPlease enter the move coords X: ");
                moveRow = mScanner.nextInt() - 1;
                System.out.print(" Y: ");
                moveCol = mScanner.nextInt() - 1;
                // wenn die koordinaten noch nicht belegt sind
                if (mBoard[fieldRow][fieldCol][moveRow][moveCol].equals("")) {
                    setMove(fieldRow, fieldCol, moveRow, moveCol);
                    // wenn durch den aktuellen zug das feld gewonnen wurde
                    if (isWinner(fieldRow, fieldCol, moveRow, moveCol)) {
                        System.out.println("Field " + (fieldRow + 1) + "|" + (fieldCol + 1) + " is won by player " + ((mTurn % 2 != 0) ? "X" : "O"));
                        // wenn das nachfolge feld dass grade gewonnene feld ist
                        if (fieldRow == moveRow && fieldCol == moveCol) {
                            mNextFieldRow = -1;
                            mNextFieldCol = -1;
                        }
                    }
                }
                // wenn ein feld im vorherigen zug festgelegt wurde
            } else {
                System.out.print("Your move is on field " + (mNextFieldRow + 1) + "|" + (mNextFieldCol + 1));
                System.out.print("\nPlease enter the move coords X: ");
                moveRow = mScanner.nextInt() - 1;
                System.out.print(" Y: ");
                moveCol = mScanner.nextInt() - 1;
                // wenn die koordinaten noch nicht belegt sind
                if (mBoard[mNextFieldRow][mNextFieldCol][moveRow][moveCol].equals("")) {
                    // folge feld zwischenspeichern, da setMove diese verändert
                    int tmpRow = mNextFieldRow;
                    int tmpCol = mNextFieldCol;
                    setMove(mNextFieldRow, mNextFieldCol, moveRow, moveCol);
                    // wenn durch den aktuellen zug das feld gewonnen wurde
                    if (isWinner(tmpRow, tmpCol, moveRow, moveCol)) {
                        System.out.println("Field " + (tmpRow + 1) + "|" + (tmpCol + 1) + " is won by player " + ((mTurn % 2 != 0) ? "X" : "O"));
                        // wenn das nachfolge feld dass grade gewonnene feld ist
                        if (tmpRow == moveRow && tmpCol == moveCol) {
                            mNextFieldRow = -1;
                            mNextFieldCol = -1;
                        }
                    }
                }
            }
            // wenn nach 90 zuegen kein gewinner feststeht = DRAW
            if (mTurn == 90) {
                hasNext = false;
            }
        }
        System.out.println("Game won by player " + ((mTurn % 2 == 0) ? "X" : "O") + "! Congrats!");
    }
}

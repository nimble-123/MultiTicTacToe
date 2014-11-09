package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Created by nlsltz on 09.11.14.
 */
public class Board {
    private static final Logger log = Logger.getLogger(Board.class.getName());

    private Field[] mBoard;
    private Field mLastMoveField;

    public Board(int size) {
        this.mBoard = new Field[(size * size) + 1];
        for (int i = 1; i <= (size * size); i++) {
            mBoard[i] = new Field(size, i);
        }
    }

    /**
     * @param pos The place in the board. TL, TM, TR, ML, MM, MR, BL, BM, BR
     * @return Field
     */
    public Field getField(int pos) {
        return this.mBoard[pos];
    }

    /**
     * @return Field[] the board, fields are 1-9
     */
    public Field[] getBoard() {
        return this.mBoard;
    }

    /**
     * @return boolean True wenn der Zug erfolgreich gesetzt wurde, sonst False
     */
    public boolean setMove(Player pl) {
        //TODO Player abfrage
        //TODO Aktuelles Feld entscheiden anhand des zuletzt bespielten Felds inkl. Coords
        //TODO Zug auf Feld setzen
        //TODO beim setzen das Feld auf dem gesetzt wird in mLastMoveField mitspeichern
        //TODO bei Erfolg TRUE zurück

        pl.nextPlayer(); // als letzte Aktion wird der Spieler geswitched

        return false;
    }

    /**
     * Check board for winner
     */
    public void isWon() {
        // check jedes feld auslösen
//        mBoard.getField(1).checkWin();
//        mBoard.getField(2).checkWin();
//        mBoard.getField(3).checkWin();
//        mBoard.getField(4).checkWin();
//        mBoard.getField(5).checkWin();
//        mBoard.getField(6).checkWin();
//        mBoard.getField(7).checkWin();
//        mBoard.getField(8).checkWin();
//        mBoard.getField(9).checkWin();

    }
}

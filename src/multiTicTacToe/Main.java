package multiTicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.Main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        log.info("Started App");
        Board mBoard = new Board(3);
        mBoard.output(mBoard.getField("TL"));

        mBoard.setMove(mBoard.getField("TL"), 0, 0);
        mBoard.checkWinner();
        mBoard.output(mBoard.getField("TL"));

        mBoard.setMove(mBoard.getField("TL"), 1, 1);
        mBoard.checkWinner();
        mBoard.output(mBoard.getField("TL"));

        mBoard.setMove(mBoard.getField("TL"), 0, 1);
        mBoard.checkWinner();
        mBoard.output(mBoard.getField("TL"));

        mBoard.setMove(mBoard.getField("TL"), 1, 2);
        mBoard.checkWinner();
        mBoard.output(mBoard.getField("TL"));

        mBoard.setMove(mBoard.getField("TL"), 0, 2);
        mBoard.checkWinner();
        mBoard.output(mBoard.getField("TL"));

        launch(args);

    }
}

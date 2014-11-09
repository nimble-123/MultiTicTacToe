package multiTicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import multiTicTacToe.multiTTT.MultiTTT;

import java.util.logging.Logger;

/**
 * Main class for JavaFX Application
 */
public class Main extends Application {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.Main.fxml"));
        primaryStage.setTitle("Multi TicTacToe");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        log.info("Started App");
        MultiTTT game = new MultiTTT(3);

        launch(args);

    }
}

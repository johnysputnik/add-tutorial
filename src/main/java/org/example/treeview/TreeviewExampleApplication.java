package org.example.treeview;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.treeview.services.IViewFactory;
import org.example.treeview.services.ViewFactory;

import java.io.IOException;

/**
 * The main application class.
 */
public class TreeviewExampleApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            IViewFactory viewFactory = new ViewFactory();

            viewFactory.buildAndShowStage(primaryStage,
                    "/org/example/treeview/views/MainWindow.fxml");
        } catch (IOException error) {
            error.printStackTrace();
        }

    }
}

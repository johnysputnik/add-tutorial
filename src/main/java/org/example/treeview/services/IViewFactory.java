package org.example.treeview.services;

import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

/**
 * An interface defining methods to create views.
 */
public interface IViewFactory {

    /**
     * Create a view based on a specified fxml resource.
     *
     * @param fxmlResource The path to the fxml resource.
     * @return A pair containing the view and the controller for the view.
     * @throws IOException Failed to load the fxml resource.
     */
    Pair<Parent, Object> createView(String fxmlResource) throws IOException;

    /**
     * Populate the stage with the specified fxml resource and show it.
     *
     * @param stage        The stage to populate.
     * @param fxmlResource The path to the fxml resource.
     * @throws IOException Failed to load the fxml resource.
     */
    void buildAndShowStage(Stage stage, String fxmlResource) throws IOException;
}

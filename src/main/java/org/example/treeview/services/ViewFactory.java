package org.example.treeview.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.example.treeview.views.ICompositeView;

import java.io.IOException;
import java.net.URL;

/**
 * A class defining methods to create views.
 */
public class ViewFactory implements IViewFactory {


    /**
     * Create a view based on a specified fxml resource.
     *
     * @param fxmlResource The path to the fxml resource.
     * @return A pair containing the view and the controller for the view.
     * @throws IOException Failed to load the fxml resource.
     */
    @Override
    public Pair<Parent, Object> createView(String fxmlResource) throws IOException {

        Parent root = null;
        Object controller = null;

        URL url = getClass().getResource(fxmlResource);

        if (url != null) {
            FXMLLoader loader = new FXMLLoader(url);

            root = loader.load();

            controller = loader.getController();
            if (controller instanceof ICompositeView) {
                ICompositeView sd = (ICompositeView) controller;
                sd.buildCompositeView(this);
            }
        }

        return new Pair<>(root, controller);
    }

    /**
     * Populate the stage with the specified fxml resource and show it.
     *
     * @param stage        The stage to populate.
     * @param fxmlResource The path to the fxml resource.
     * @throws IOException Failed to load the fxml resource.
     */
    @Override
    public void buildAndShowStage(Stage stage, String fxmlResource) throws IOException {

        Parent root = createView(fxmlResource).getKey();

        stage.setTitle("Test TreeView");
        stage.setScene(new Scene(root));
        stage.show();
    }

}

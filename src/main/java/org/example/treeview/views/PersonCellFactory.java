package org.example.treeview.views;

import javafx.beans.binding.Bindings;
import javafx.scene.control.TreeCell;
import org.example.treeview.model.ObservablePerson;

/**
 * A factory class for generating the cells to display in the tree view.
 */
public final class PersonCellFactory extends TreeCell<ObservablePerson> {

    @Override
    public void updateItem(ObservablePerson item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            textProperty().bind(Bindings
                    .when(emptyProperty())
                    .then("")
                    .otherwise(item.getName()));
        }

    }
}

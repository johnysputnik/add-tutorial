package org.example.treeview.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.treeview.viewmodels.InfoViewModel;

/**
 * A view controller for the info view.
 */
public class InfoView {

    @FXML
    public TextField nameField;

    private InfoViewModel viewModel;

    /**
     * Set the view model and update the bindings.
     *
     * @param viewModel The viewmodel for the info view.
     */
    public void setViewModel(InfoViewModel viewModel) {
        this.viewModel = viewModel;

        this.viewModel.selectedPerson().addListener((object, oldValue, newValue) -> {
            if (oldValue != null)
                this.nameField.textProperty().unbindBidirectional(oldValue.getName());

            if (newValue != null)
                this.nameField.textProperty().bindBidirectional(newValue.getName());
        });
    }
}

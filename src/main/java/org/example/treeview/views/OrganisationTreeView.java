package org.example.treeview.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import org.example.treeview.model.ObservablePerson;
import org.example.treeview.viewmodels.OrganisationTreeViewModel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * A controller for the organisation tree view.
 */
public class OrganisationTreeView implements Initializable {

    private OrganisationTreeViewModel viewModel;

    @FXML
    public TreeView<ObservablePerson> treeView;

    /**
     * Set the view model and update bindings.
     *
     * @param viewModel The viewmodel for the tree view.
     */
    public void setViewModel(OrganisationTreeViewModel viewModel) {
        this.viewModel = viewModel;

        this.viewModel.onViewModelUpdated((Void) -> {
            treeView.setRoot(this.viewModel.getRoot());
            treeView.getRoot().setExpanded(true);
            return null;
        });
        treeView.setRoot(this.viewModel.getRoot());

        treeView.getSelectionModel().selectedItemProperty().addListener((object, oldValue, newValue) -> {
            viewModel.selectPerson(newValue.getValue().getName().getValue());
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        treeView.setCellFactory(p -> new PersonCellFactory());

    }

}

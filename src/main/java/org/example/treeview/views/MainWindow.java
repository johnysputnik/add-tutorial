package org.example.treeview.views;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.util.Pair;
import org.example.treeview.model.OrganisationModel;
import org.example.treeview.services.IViewFactory;
import org.example.treeview.viewmodels.InfoViewModel;
import org.example.treeview.viewmodels.OrganisationTreeViewModel;

import java.io.IOException;

/**
 * A controller for the MainWindow view.
 */
public class MainWindow implements ICompositeView {

    @FXML
    public SplitPane mainWindowSplitPane;

    private IViewFactory viewFactory;

    /**
     * Build the composite view.
     *
     * @param viewFactory A view factory instance.
     * @throws IOException Unable to build the view.
     */
    @Override
    public void buildCompositeView(IViewFactory viewFactory) throws IOException {
        this.viewFactory = viewFactory;

        OrganisationModel model = new OrganisationModel();

        OrganisationTreeViewModel treeViewModel = new OrganisationTreeViewModel(model);
        Pair<Parent, Object> treeView = viewFactory.createView("/org/example/treeview/views/OrganisationTreeView.fxml");
        OrganisationTreeView treeViewController = (OrganisationTreeView) treeView.getValue();
        treeViewController.setViewModel(treeViewModel);

        InfoViewModel infoViewModel = new InfoViewModel(model);
        Pair<Parent, Object> infoView = viewFactory.createView("/org/example/treeview/views/InfoView.fxml");
        InfoView infoViewController = (InfoView) infoView.getValue();
        infoViewController.setViewModel(infoViewModel);


        model.loadOrganisation("/org/example/treeview/model/test-data.xml");


        ObservableList<Node> items = mainWindowSplitPane.getItems();
        items.addAll(treeView.getKey(), infoView.getKey());
    }
}

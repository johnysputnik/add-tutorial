package org.example.treeview.viewmodels;


import javafx.beans.property.ObjectProperty;
import org.example.treeview.model.ObservablePerson;
import org.example.treeview.model.OrganisationModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestOrganisationTreeViewModel {


    @Test
    public void testGetRoot() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation("/org/example/treeview/model/test-data.xml");
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);

        Assert.assertNotNull(viewModel.getRoot());
    }

    @Test
    public void testUpdateRootOnModelLoad() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);

        model.loadOrganisation("/org/example/treeview/model/test-data.xml");

        Assert.assertNotNull(viewModel.getRoot());
    }

    @Test
    public void testTreeSize() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation("/org/example/treeview/model/test-data.xml");
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);

        Assert.assertEquals("10 tree items loaded", 10,
                viewModel.getRoot().getChildren().size());
    }

    @Test
    public void testUpdateTreeSizeOnModelLoad() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);

        model.loadOrganisation("/org/example/treeview/model/test-data.xml");

        Assert.assertEquals("10 tree items loaded", 10,
                viewModel.getRoot().getChildren().size());
    }

    @Test
    public void testUpdate() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);

        AtomicBoolean fired = new AtomicBoolean(false);
        viewModel.onViewModelUpdated((Void) -> {
            fired.set(true);
            return null;
        });

        model.loadOrganisation("/org/example/treeview/model/test-data.xml");

        Assert.assertTrue(fired.get());
    }

    @Test
    public void testSelectItem() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        OrganisationTreeViewModel viewModel = new OrganisationTreeViewModel(model);
        model.loadOrganisation("/org/example/treeview/model/test-data.xml");

        AtomicBoolean fired = new AtomicBoolean(false);
        ObjectProperty<ObservablePerson> selectedPerson = model.getSelectedPerson();
        selectedPerson.addListener((object, oldValue, newValue) -> {
            Assert.assertEquals("John", newValue.getName().getValue());
            fired.set(true);
        });

        viewModel.selectPerson("John");

        Assert.assertTrue(fired.get());
    }

}

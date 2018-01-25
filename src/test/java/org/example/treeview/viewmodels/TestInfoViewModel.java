package org.example.treeview.viewmodels;

import org.example.treeview.model.OrganisationModel;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestInfoViewModel {

    @Test
    public void testUpdateTreeSizeOnModelLoad() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        InfoViewModel viewModel = new InfoViewModel(model);

        model.loadOrganisation("/org/example/treeview/model/test-data.xml");
        model.selectPerson("John");

        Assert.assertSame(model.getSelectedPerson(), viewModel.selectedPerson());
    }
}

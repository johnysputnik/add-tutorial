package org.example.treeview.model;

import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTestOrganisationModel {


    private final String testDataPath = "/org/example/treeview/model/test-data.xml";

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "John"},
                {1, "Will"},
                {2, "Matt"},
                {3, "Lewis"},
                {4, "Vince"},
                {5, "Graham"},
                {6, "Paul"},
                {7, "Bryan"},
                {8, "Joe"},
                {9, "Cheddary Roy"}
        });
    }

    @Parameterized.Parameter
    public int index;

    @Parameterized.Parameter(1)
    public String itemName;

    @Test
    public void testTreeItems() throws FileNotFoundException {

        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        ObservablePerson organisationRoot = model.getOrganisationRoot();
        ObservableList<ObservablePerson> children = organisationRoot.getChildren();

        ObservablePerson item = children.get(index);

        Assert.assertNotNull("Item not null", item);
        Assert.assertEquals("Correct name", itemName, item.getName().getValue());
    }
}

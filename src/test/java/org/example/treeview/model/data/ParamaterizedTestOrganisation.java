package org.example.treeview.model.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ParamaterizedTestOrganisation {

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

        Organisation model = new Organisation();
        model.loadData("/org/example/treeview/model/test-data.xml");

        Person root = model.root();
        List<Person> children = root.getChildren();
        Person item = children.get(index);
        Assert.assertNotNull("Item not null", item);

        Assert.assertEquals("Correct name", itemName, item.getName());
    }
}

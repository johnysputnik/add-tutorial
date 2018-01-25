package org.example.treeview.model.data;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class TestOrganisation {

    @Test
    public void testLoadData() throws FileNotFoundException {
        Organisation model = new Organisation();
        model.loadData("/org/example/treeview/model/test-data.xml");

        Assert.assertNotNull("Root element created", model.root());
    }

    @Test
    public void testTreeSize() throws FileNotFoundException {
        Organisation model = new Organisation();
        model.loadData("/org/example/treeview/model/test-data.xml");

        Person root = model.root();
        List<Person> children = root.getChildren();
        Assert.assertEquals("10 tree items loaded", 10, children.size());
    }


    @Test(expected = FileNotFoundException.class)
    public void testNonExistingResource() throws FileNotFoundException {
        Organisation model = new Organisation();
        model.loadData("/org/example/treeview/model/no-data.xml");
    }

}

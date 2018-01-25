package org.example.treeview.model;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestOrganisationModel {

    private final String testDataPath = "/org/example/treeview/model/test-data.xml";

    @Test
    public void testLoadOrganisation() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        boolean ok = model.loadOrganisation(testDataPath);
        Assert.assertTrue(ok);
    }

    @Test
    public void testGetOrganisationRoot() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        ObservablePerson organisationRoot = model.getOrganisationRoot();
        Assert.assertNotNull(organisationRoot);
        Assert.assertEquals("root", organisationRoot.getName().getValue());
    }

    @Test
    public void testGetOrganisationRootChildren() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        ObservablePerson organisationRoot = model.getOrganisationRoot();
        ObservableList<ObservablePerson> children = organisationRoot.getChildren();
        Assert.assertEquals(10, children.size());
    }

    @Test
    public void testListenerOnLoad() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        AtomicBoolean listenerFired = new AtomicBoolean(false);
        model.onOrganisationLoaded(modelObject -> {
            listenerFired.set(true);
            return true;
        });

        model.loadOrganisation(testDataPath);
        Assert.assertTrue(listenerFired.get());

    }

    @Test
    public void testSetSelectedPerson() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        ObjectProperty<ObservablePerson> selectedPerson = model.getSelectedPerson();
        Assert.assertNull(selectedPerson.get());

        model.selectPerson("John");

        Assert.assertNotNull(selectedPerson.get());
        Assert.assertEquals("John", selectedPerson.get().getName().getValue());
    }

    @Test
    public void testSelectedPersonListener() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        AtomicBoolean fired = new AtomicBoolean(false);
        ObjectProperty<ObservablePerson> selectedPerson = model.getSelectedPerson();
        selectedPerson.addListener((object, oldValue, newValue) -> {
            Assert.assertEquals("John", newValue.getName().getValue());
            fired.set(true);
        });

        model.selectPerson("John");

        Assert.assertTrue(fired.get());
    }

    @Test
    public void testSetNonExistentSelectedPerson() throws FileNotFoundException {
        OrganisationModel model = new OrganisationModel();
        model.loadOrganisation(testDataPath);

        ObjectProperty<ObservablePerson> selectedPerson = model.getSelectedPerson();
        Assert.assertNull(selectedPerson.get());

        model.selectPerson("Barry White");

        Assert.assertNull(selectedPerson.get());
    }


}

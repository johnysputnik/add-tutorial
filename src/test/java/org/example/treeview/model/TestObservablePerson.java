package org.example.treeview.model;

import javafx.beans.property.StringProperty;
import org.example.treeview.model.data.Person;
import org.junit.Assert;
import org.junit.Test;

public class TestObservablePerson {

    @Test
    public void testGetName() {
        Person personObject = new Person();
        personObject.setName("test");

        ObservablePerson person = new ObservablePerson(personObject);
        StringProperty name = person.getName();

        Assert.assertEquals("test", name.getValue());
    }

    @Test
    public void testUpdateName() {
        Person personObject = new Person();
        personObject.setName("test");

        ObservablePerson person = new ObservablePerson(personObject);
        StringProperty name = person.getName();
        name.setValue("something else");

        Assert.assertEquals("something else", personObject.getName());
    }

    @Test
    public void testUpdateRole() {
        Person personObject = new Person();
        personObject.setName("test");

        ObservablePerson person = new ObservablePerson(personObject);
        StringProperty role = person.getRole();
        role.setValue("new role");

        Assert.assertEquals("new role", personObject.getRole());
    }

}

package org.example.treeview.viewmodels;

import org.example.treeview.model.ObservablePerson;
import org.example.treeview.model.data.Person;
import org.junit.Assert;
import org.junit.Test;


public class TestPersonTreeItem {

    @Test
    public void testPerson() {
        Person person = new Person();
        person.setName("test person");

        ObservablePerson observablePerson = new ObservablePerson(person);

        PersonTreeItem treeItem = new PersonTreeItem(observablePerson);
        Assert.assertEquals(person.getName(), treeItem.getName().getValue());
    }

    @Test
    public void testText() {
        Person person = new Person();
        person.setName("test person");

        ObservablePerson observablePerson = new ObservablePerson(person);

        PersonTreeItem treeItem = new PersonTreeItem(observablePerson);

        observablePerson.getName().setValue("something else");
        Assert.assertEquals("something else", treeItem.getName().getValue());
    }

}

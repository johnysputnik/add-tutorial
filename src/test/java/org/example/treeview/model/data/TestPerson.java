package org.example.treeview.model.data;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void testRole() {
        Person person = new Person();
        person.setRole("test");

        Assert.assertEquals("test", person.getRole());
    }
}

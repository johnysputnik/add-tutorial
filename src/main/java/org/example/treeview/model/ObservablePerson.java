package org.example.treeview.model;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.treeview.model.data.Person;

import java.util.ArrayList;

/**
 * A class that wraps a Person DAO as an observable object.
 */
public class ObservablePerson {

    private final Person person;
    private final SimpleListProperty<ObservablePerson> children;
    private final StringProperty name;
    private final StringProperty role;

    /**
     * Constructor.
     *
     * @param person The person object to wrap.
     */
    public ObservablePerson(Person person) {
        this.person = person;
        this.children = new SimpleListProperty<>(FXCollections.observableList(new ArrayList<>()));
        this.name = new SimpleStringProperty(this.person.getName());
        this.role = new SimpleStringProperty(this.person.getRole());


        if (person.getChildren() != null) {
            for (Person p : person.getChildren()) {
                this.children.add(new ObservablePerson(p));
            }
        }

        // listen for changes to the name

        this.name.addListener((observable, oldValue, newValue) -> this.person.setName(newValue));


        // listen to changes to the role
        //
        this.role.addListener((observable, oldValue, newValue) -> this.person.setRole(newValue));


    }

    /**
     * Get the name of the person as an observable property.
     *
     * @return The person's name.
     */
    public StringProperty getName() {
        return name;
    }

    /**
     * Get the children of the person as an observable list.
     *
     * @return The children of the person.
     */
    public ObservableList<ObservablePerson> getChildren() {
        return children;
    }

    /**
     * Get the role of the person as an observable property.
     *
     * @return The role of the person.
     */
    public StringProperty getRole() {
        return role;
    }

    /**
     * Find a specific named child of this person. Iterate through children.
     *
     * @param name The name of the child to find
     * @return The child, or null if not found.
     */
    public ObservablePerson find(String name) {
        if (name.compareTo(this.getName().getValue()) == 0) {
            return this;
        } else {
            for (ObservablePerson person : children) {
                if (person != null) {
                    ObservablePerson p = person.find(name);
                    if (p != null)
                        return p;
                }
            }
        }
        return null;
    }
}

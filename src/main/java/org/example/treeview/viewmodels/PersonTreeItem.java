package org.example.treeview.viewmodels;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TreeItem;
import org.example.treeview.model.ObservablePerson;

/**
 * A person represented as a TreeItem to display in the treeview in the application.
 */
public class PersonTreeItem extends TreeItem<ObservablePerson> {

    private final ObservablePerson person;

    /**
     * Constructor.
     *
     * @param observablePerson An observable person.
     */
    PersonTreeItem(ObservablePerson observablePerson) {
        super();

        person = observablePerson;

        super.setValue(person);

        if (this.person.getChildren() != null) {
            for (ObservablePerson op : person.getChildren()) {
                getChildren().add(new PersonTreeItem(op));
            }
        }
    }

    /**
     * Get the name of the person.
     *
     * @return The name of the person.
     */
    public StringProperty getName() {
        return person.getName();
    }

}

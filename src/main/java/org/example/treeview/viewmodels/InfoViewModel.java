package org.example.treeview.viewmodels;

import javafx.beans.property.ObjectProperty;
import org.example.treeview.model.ObservablePerson;
import org.example.treeview.model.OrganisationModel;

/**
 * A view model representing the info view in the application.
 */
public class InfoViewModel {

    private final OrganisationModel model;

    /**
     * Constructor.
     *
     * @param model The organisational model.
     */
    public InfoViewModel(OrganisationModel model) {
        this.model = model;
    }

    /**
     * Get the selected person for displaying int the info view.
     *
     * @return The selected person.
     */
    public ObjectProperty<ObservablePerson> selectedPerson() {
        return model.getSelectedPerson();
    }
}

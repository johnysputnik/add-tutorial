package org.example.treeview.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.example.treeview.model.data.Organisation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The organisation model class.
 */
public class OrganisationModel {

    private Organisation organisation = new Organisation();
    private ObservablePerson root;

    private final List<Function<OrganisationModel, Boolean>> callbacks = new ArrayList<>();
    private final ObjectProperty<ObservablePerson> selectedPerson = new SimpleObjectProperty<>();

    /**
     * Load an organisation form a specified data path.
     *
     * @param testDataPath The data path to load the organisation from.
     * @return true if successful.
     * @throws FileNotFoundException The specified file was not found.
     */
    public boolean loadOrganisation(String testDataPath) throws FileNotFoundException {
        boolean success = false;

        organisation.loadData(testDataPath);

        if (organisation.root() != null) {
            root = new ObservablePerson(organisation.root());
            for (Function<OrganisationModel, Boolean> cb : callbacks) {
                cb.apply(this);
            }

            success = true;
        }

        return success;
    }

    /**
     * Get the root of the organisation as an observable property.
     *
     * @return The root of the organisation.
     */
    public ObservablePerson getOrganisationRoot() {
        return root;
    }

    /**
     * Add a callback function that will be called when the organisation is loaded.
     *
     * @param function The callback function.
     */
    public void onOrganisationLoaded(Function<OrganisationModel, Boolean> function) {
        callbacks.add(function);
    }

    /**
     * Get the currently selected person in the organisation.
     *
     * @return An Observable object representing the selected person.
     */
    public ObjectProperty<ObservablePerson> getSelectedPerson() {
        return selectedPerson;
    }

    /**
     * Select a named person within the organisation.
     *
     * @param name The name of the person to select.
     */
    public void selectPerson(String name) {
        selectedPerson.set(root.find(name));
    }
}

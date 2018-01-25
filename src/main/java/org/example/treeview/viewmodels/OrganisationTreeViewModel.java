package org.example.treeview.viewmodels;

import org.example.treeview.model.ObservablePerson;
import org.example.treeview.model.OrganisationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * A view model representing the organisational tree view in the application.
 */
public class OrganisationTreeViewModel {

    private PersonTreeItem root;
    private final OrganisationModel model;
    private List<Function<Void, Void>> callbacks = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param model The organisational model.
     */
    public OrganisationTreeViewModel(OrganisationModel model) {
        this.model = model;
        this.root = null;

        model.onOrganisationLoaded((modelObject) -> loadModel());
        loadModel();
    }

    /**
     * Get the root of the organisation.
     *
     * @return The root of the organisation.
     */
    public PersonTreeItem getRoot() {
        return root;
    }

    /**
     * Load the model.
     *
     * @return true if successful.
     */
    private boolean loadModel() {
        boolean success = false;

        ObservablePerson organisationRoot = model.getOrganisationRoot();

        if (organisationRoot != null) {
            root = new PersonTreeItem(organisationRoot);
            for (Function<Void, Void> cb : callbacks) {
                cb.apply(null);
            }
            success = true;
        }

        return success;
    }

    /**
     * Register a callback function to be called when the view model is updated.
     *
     * @param function A callback function.
     */
    public void onViewModelUpdated(Function<Void, Void> function) {
        callbacks.add(function);
    }

    /**
     * Select a person in the organisation.
     *
     * @param name The name of the person to select.
     */
    public void selectPerson(String name) {
        model.selectPerson(name);
    }
}

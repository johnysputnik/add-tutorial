package org.example.treeview.views;

import org.example.treeview.services.IViewFactory;

import java.io.IOException;

/**
 * An interface defining a view composed of multiple views.
 */
public interface ICompositeView {

    /**
     * Build the composite view.
     *
     * @param viewFactory A view factory instance.
     * @throws IOException Unable to build the view.
     */
    void buildCompositeView(IViewFactory viewFactory) throws IOException;
}

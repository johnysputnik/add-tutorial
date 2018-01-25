package org.example.treeview.model.data;

import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * A data access object representing an organisation.
 */
public class Organisation {

    private Person root;

    /**
     * Load the data from the defined path.
     *
     * @param dataPath The path to the data to load.
     * @throws FileNotFoundException The data file was not found.
     */
    public void loadData(String dataPath) throws FileNotFoundException {

        Class<?>[] classes = new Class[]{Person.class};

        XStream xstream = new XStream();
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        xstream.processAnnotations(Person.class);

        URL dataResource = getClass().getResource(dataPath);
        if (dataResource == null) {
            throw new FileNotFoundException(dataPath);
        }

        root = (Person) xstream.fromXML(dataResource);
    }

    /**
     * Get the root of the organisation.
     *
     * @return The organisation root.
     */
    public Person root() {
        return root;
    }
}

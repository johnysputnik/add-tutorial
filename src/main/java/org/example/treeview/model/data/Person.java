package org.example.treeview.model.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * A data access object representing a person in the organisation.
 */
@XStreamAlias("Person")
public class Person {

    @XStreamAlias("name")
    @XStreamAsAttribute
    private String name;

    private String role;

    @XStreamImplicit
    private final List<Person> children = new ArrayList<Person>();

    /**
     * Get the children of this person.
     *
     * @return The children.
     */
    public List<Person> getChildren() {
        return children;
    }

    /**
     * Get the name of this person.
     *
     * @return The person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the person.
     *
     * @param name The name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the role of the person.
     *
     * @return The person's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role of the person
     *
     * @param role The person's role in the organisation.
     */
    public void setRole(String role) {
        this.role = role;
    }
}

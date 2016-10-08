/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton that coordinates changes in objects that inherit <code>Updating</code>.
 * Adding an object to the controller allows other objects to be linked to it so
 * that any changes to that object will be reflected in the linked objects.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Updater
{

    /**
     * A <code>HashMap</code> that links a parent object to child objects that need
     * to be updated when the parent changes.
     */
    private HashMap<Updating, ArrayList<Updating>> items;

    public Updater()
    {
        items = new HashMap<>();
    }

    /**
     * Adds a new parent object so that other objects can be linked to it.
     *
     * @param object a parent object implementing the <code>Updating</code> interface
     */
    public void addParent(Updating object)
    {
        items.put(object, new ArrayList<Updating>());
    }

    /**
     * Adds a child <code>Updating</code> object to a list of objects linked to a parent
     * object. If the parent object is not found then <code>addObject</code> is called with
     * the parent object passed as an argument.
     *
     * @param parent a parent object
     * @param child a child object to be added
     */
    public void addChild(Updating parent, Updating child)
    {
        if(!hasParent(parent))
        {
            addParent(parent);
        }
        items.get(parent).add(child);
    }

    /**
     * Removes a child object. If there are no remaining child objects linked to the parent
     * object then the parent is removed.
     *
     * @param parent a parent object
     * @param child a child object to be removed
     */
    public void removeChild(Updating parent, Updating child)
    {
        items.get(parent).remove(child);
        if(items.get(parent).isEmpty())
        {
            items.remove(parent);
        }
    }

    /**
     * Checks whether a parent object has already been added.
     *
     * @return <code>true</code> if the parent object has been added
     * and <code>false</code> if it hasn't
     */
    public boolean hasParent(Updating parent)
    {
        return items.containsKey(parent);
    }


    public boolean update(Updating parent)
    {
        if(hasParent(parent))
        {
            for(Updating child : items.get(parent))
            {
                child.update(parent);
            }
            return true;
        }
        return false;
    }

    /**
     * Return all of the child objects linked to the given parent object.
     *
     * @return ArrayList<Updating> containing all of the child objects linked to the given parent object.
     */
    public ArrayList<Updating> getItems(Updating parent)
    {
        return items.get(parent);
    }
}

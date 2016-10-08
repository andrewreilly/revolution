/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Updater;
import core.Updating;
import core.app.window.ApplicationWindow;

/**
 * A subclass of the <code>Updater</code> class that enables a <code>Values</code>
 * object to be used as a parent and links to <code>ActiveItem</code> child objects.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ItemController extends Updater
{
    private static ItemController instance = new ItemController();

    /**
     * BooleanVariable value indicating whether or not the parent value has changed.
     * When this is set to <code>true</code> items that are being updated do
     * not then send their new value to the <code>ItemController</code>,
     * as this would result in an endless loop of updating items.
     */
    private boolean hasChanged = false;

    /**
     * Return the instance of this object used to access its methods.
     *
     * @return the instance of this object used to access its methods
     */
    public static ItemController get()
    {
        return instance;
    }

    /**
     * Iterates over all of the child objects linked to the given parent object
     * and updates their values.
     *
     * @param parent an object implementing the <code>Variables</code> interface
     */
    @Override
    public boolean update(Updating parent)
    {
        if(hasParent(parent))
        {
            if(parent.hasUpdated() | !hasChanged)
            {
                hasChanged = true;
                for(Updating item : getItems(parent))
                {
                    item.hasUpdated(false);
                    if(hasChanged)
                    {
                        item.update(parent);
                    }
                }
                hasChanged = false;
            }
            ApplicationWindow.get().update();
            return true;
        }
        return false;
    }

    /**
     * Indicates whether or not the parent <code>Values</code> object has already changed.
     * Once the parent object has changed child items will no longer attempt to change its
     * value so that an endless loop of changes can be avoided.
     *
     * @return <code>true</code> when the parent <code>Values</code> object has already changed
     * amd <code>false</code> if not.
     */
    public boolean hasChanged()
    {
        return hasChanged;
    }

}

/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

import core.Updating;
import core.app.Name;
import core.app.element.active.ItemController;

/**
 * Abstract base class for <code>Variables</code> objects.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Variable<V> extends Name implements Variables<V>
{

    /**
     * The value represented by this object.
     */
    private V value;

    /**
     * Indicates whether or not the value of this object has changed.
     */
    private boolean hasUpdated;

    /**
     * Simple constructor with a <code>null</code> value.
     */
    public Variable()
    {
        value = null;
        hasUpdated = false;
    }

    /**
     * Creates a <code>Variables</code> object with the given value.
     */
    public Variable(V value)
    {
        this.value = value;
        hasUpdated = false;
    }

    @Override
    public void setValue(V value)
    {
        this.value = value;
        ItemController.get().update(this);
    }

    @Override
    public V getValue()
    {
        return value;
    }

    @Override
    public void update(Updating parent)
    {

    }

    @Override
    public boolean hasUpdated()
    {
        return hasUpdated;
    }

    @Override
    public void hasUpdated(boolean hasUpdated)
    {
        this.hasUpdated = hasUpdated;
    }
}

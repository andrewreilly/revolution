/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

/**
 * Interface for object that have a value.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Values<V>
{

    /**
     * Sets the value of the object.
     *
     * @param value the value of the object
     */
    void setValue(V value);

    /**
     * Returns the value of the object.
     *
     * @return the value of the object
     */
    V getValue();
}

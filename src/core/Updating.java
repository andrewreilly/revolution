/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core;

/**
 * Interface for objects that share a value with other objects. The purpose of this interface
 * is to provide a way for thes objects to be shared so that a change in the value of one
 * will be reflected in a change in the value of others without resulting in endless looping.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Updating
{
    /**
     * Updates this object according to the state of the given parent object.
     *
     * @return <code>true</code> if the parent object is found and <code>false</code> if
     * not.
     */
    void update(Updating parent);

    /**
     * Indicates whether or not this object has been updated.
     *
     * @return <code>true</code> if the object has been updated and <code>false</code> if
     * not.
     */
    boolean hasUpdated();

    /**
     * Sets the state of the object according to whether or not it has been updated.
     *
     * @param hasUpdated <code>true</code> if the object has been updated and <code>false</code>
     * if not.
     */
    void hasUpdated(boolean hasUpdated);
}

/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app;

/**
 * Interface providing functionality for objects that have names. Objects can also have a display name
 * that differs from its regular name.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Nameable
{
    /**
     * Returns the name of this object.
     *
     * @return String the name of this object
     */
    String getName();

    /**
     * Sets the name of this object.
     *
     * @param name the name of this object
     */
    void setName(String name);

    /**
     * Returns the name of this object that is displayed on the screen
     *
     * @return <code>String</code> representing the name of this object when it is displayed on the
     * screen
     */
    String getDisplayName();

    /**
     * Sets the name of this object that is displayed on the screen
     *
     * @param displayName <code>String</code> representing the name of this object when it is displayed on
     * the screen
     */
    void setDisplayName(String displayName);
}

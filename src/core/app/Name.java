/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app;

/**
 * Abstract class used to provide fields and constructors for classes that have names.
 *
 *   @author      Andrew Reilly
 * 	 @version     1.1.0
 */
public abstract class Name implements Nameable
{

    /**
     * The name of this object.
     */
    private String name = null;

    /**
     * The name that is displayed on the screen.
     */
    private String displayName = null;

    /**
     * Constructor for an object that has a name.
     */
    public Name(String name)
    {
        this.name = name;
    }

    /**
     * Constructor for an object that has both a name and a name to be displayed on the screen.
     */
    public Name(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    /**
     * Constructor for an object that has a name.
     */
    public Name()
    {

    }

    /**
     * Returns the name of this object
     *
     * @return <code>String</code> representing the name of this object
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of this object
     *
     * @param name <code>String</code> representing the name of this object
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name of this object that is displayed on the screen
     *
     * @return <code>String</code> representing the name of this object when it is displayed on the
     * screen
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the name of this object that is displayed on the screen
     *
     * @param displayName <code>String</code> representing the name of this object when it is displayed on
     * the screen
     */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

}

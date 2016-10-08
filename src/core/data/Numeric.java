/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

/**
 * A <code>Variables</code> object that represents a number. The generic type must inherit the <code>Number</code>
 * class, for example: <code>Byte</code>, <code>Double</code>, <code>Float</code>, <code>Integer</code>,
 * <code>Long</code> or <code>Short</code>.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */

public class Numeric<V extends Number> extends Variable<V>
{

    private int scale;

    public Numeric(V value)
    {
        setValue(value);
        setScale(0);
    }


    /**
     * Returns the number of decimal places that this <code>Numeric</code> variable is rounded to.
     *
     * @return an <code>int</code> indicating the number of decimal places that this <code>Numeric</code> variable is rounded to.
     */
    public int getScale()
    {
        return scale;
    }

    /**
     * Sets the number of decimal places that this <code>Numeric</code> variable is rounded to.
     *
     * @param scale the number of decimal places that this <code>Numeric</code> variable is rounded to.
     */
    public void setScale(int scale)
    {
        this.scale = scale;
    }
}
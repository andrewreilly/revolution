/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

/**
 * A <code>Range</code> object that is bounded by either by the values 0 and 1, or -1 and 1.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Standard extends Range<Double>
{

    /**
     * Indicates whether or not this variable is signed
     */
    private boolean isSigned;

    /**
     * Creates a <code>Range</code> object with a maximum of 1 and a minimum of either 0, or -1
     *
     * @param isSigned <code>true</code> if the minimum value is -1 and <code>false</code> if it is 0
     */
    public Standard(boolean isSigned)
    {
        super(0.0, 1.0, 0.0);
        this.setSigned(isSigned);
        init();
    }

    /**
     * Creates a <code>Range</code> object with a maximum of 1 and a minimum of either 0, or -1 and
     * with the given initial value.
     *
     * @param value a <code>double</code> indicating the initial value of this variable.
     * @param isSigned <code>true</code> if the minimum value is -1 and <code>false</code> if it is 0
     */
    public Standard(double value, boolean isSigned)
    {
        super(0.0, 1.0, value);
        this.setSigned(isSigned);
        init();
    }

    /**
     * Initialisea this variable by setting the minimum value to -1 if it is signed and 0 if not.
     */
    private void init()
    {
        if(isSigned())
        {
            setMin(-1.0);
        }
        setScale(2);
    }

    /**
     * Returns a <code>boolean</code> value indicating whether or not this variable is signed.
     *
     * @return <code>true</code> if the variable is signed and <code>false</code> if not
     */
    public boolean isSigned()
    {
        return isSigned;
    }

    /**
     * Sets the state of this variable as either signed or unsigned according to the given value. Note that
     * this will call <code>init()</code>
     *
     * @param isSigned <code>true</code> if the variable is signed and <code>false</code> if not
     */
    public void setSigned(boolean isSigned)
    {
        this.isSigned = isSigned;
        init();
    }
}

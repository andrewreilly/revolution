/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

/**
 * A <code>Range</code> object bounded by the values -1 and 1.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class SignedStandard extends Range<Double>
{

    /**
     * A <code>Range</code> object bounded by the values -1 and 1 and with an initial value of 0.
     */
    public SignedStandard()
    {
        super(-1.0, 1.0, 0.0);
    }

    /**
     * A <code>Range</code> object bounded by the values -1 and 1 and with the given value as an
     * initial value.
     *
     * @param value a <code>double</code> indicating the initial value of this variable.
     */
    public SignedStandard(double value)
    {
        super(-1.0, 1.0, value);
    }

}

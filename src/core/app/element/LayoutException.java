/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

/**
 * Exception created when arguments are passed to an <code>AbstractLayout</code> that do not match the horizontal and
 * arguments required to align components correctly.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class LayoutException extends Exception
{

    /**
     * Exception created when arguments are passed to an <code>AbstractLayout</code> that do not match the horizontal and
     * arguments required to align components correctly.
     */
    public LayoutException(Layouts xLayout, Layouts yLayout)
    {
        super("Cannot create layout with xLayout = "  + xLayout + " and yLayout = " + yLayout);
    }
}

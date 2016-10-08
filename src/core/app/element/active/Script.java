/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

/**
 * An interface that allows an <code>Item</code> to run user-defined code when activated.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Script
{

    /**
     * Override this method when writing code to be run when an <code>Item</code> is activated.
     */
    public void run();

}

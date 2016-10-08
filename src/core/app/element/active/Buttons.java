/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.app.window.Windows;
import java.awt.event.ActionListener;

/**
 * Interface for buttons that provides functionality for accessing parent windows.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Buttons extends ActionListener
{

    /**
     * Returns the <code>Windows</code> attached to this <code>Button</code>
     *
     * @return a <code>Window</code> attached to this <code>Button</code>
     */
    Windows getWindow();

    /**
     * Sets the <code>Windows</code> attached to this <code>Button</code>
     *
     * @param window a <code>Window</code> attached to this <code>Button</code>
     */
    void setWindow(Windows window);
}

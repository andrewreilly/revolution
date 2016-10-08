/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core;

import javax.swing.*;
import java.awt.*;

/**
 * A utility class with a variety of unrelated methods.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public final class Utils
{

    /**
     * Sets the minimum, maximum and preferred sizes of the given <code>JComponent</code> to the
     * specified size.
     *
     * @param component the <code>JComponent</code> that is to be resized
     * @param width the <code>int</code> representing width of the component
     * @param height the <code>int</code> representing height of the component
     * @return the resized <code>JComponent</code>
     */
    public static JComponent setComponentSize(JComponent component, int width, int height)
    {
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
        component.setPreferredSize(dimension);
        return component;
    }

}

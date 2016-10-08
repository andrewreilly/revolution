/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

import java.awt.*;

/**
 * Vertical layout that aligns components to the top or bottom.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ListLayout extends AbstractLayout
{

    /**
     * Vertical layout that aligns components to the top or bottom at the centre.
     */
    public ListLayout()
    {
        super(Layouts.CENTRE, Layouts.CENTRE);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setAxis(1);
    }

    /**
     * Vertical layout that aligns components to the top or bottom.
     *
     * @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     * @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public ListLayout(Layouts xLayout, Layouts yLayout)
    {
        super(xLayout, yLayout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setAxis(1);
    }

}
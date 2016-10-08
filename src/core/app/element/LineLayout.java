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
 * Horizontal layout that aligns components to the left or right.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class LineLayout extends AbstractLayout
{

    /**
     * Horizontal layout that aligns components in the centre from left to right.
     */
    public LineLayout()
    {
        super(Layouts.CENTRE, Layouts.CENTRE);
        setAxis(0);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    /**
     * Horizontal layout that aligns components to the left or right.
     *
     * @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     * @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public LineLayout(Layouts xLayout, Layouts yLayout)
    {
        super(xLayout, yLayout);
        if(xLayout == Layouts.LEFT | xLayout == Layouts.CENTRE)
        {
            setAxis(0);
            setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
        else
        {
            setAxis(2);
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
    }

}

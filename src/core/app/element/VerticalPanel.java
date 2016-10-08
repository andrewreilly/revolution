/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

/**
 * A <code>Panel</code> that positions components vertically.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class VerticalPanel extends Panel
{

    /**
     *  A basic constructor that assigns the given values to the <code>xLayout</code> and <code>yLayout</code> fields of
     *  the <code>LineLayout</code> used to align components in this <code>Panel</code>.
     *
     *  @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     *  @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public VerticalPanel(Layouts xLayout, Layouts yLayout)
    {
        createLayout(new ListLayout(xLayout, yLayout));
    }

}

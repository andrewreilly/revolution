/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

import core.Utils;
import javax.swing.*;

/**
 * An extension of the <code>Panel</code> class that includes one of four different borders.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Element extends Panel
{


    /**
     * The width of the border space on this panel. The default value is 3.
     */
    private int spacing = 3;

    /**
     * Creates a panel with a vertical layout and a NONE border
     *
     */
    public Element()
    {
        super();
        update();
    }

    /**
     * Creates a bordered panel with a vertical layout
     *
     * @param border 0 = <code>NONE</code> and 1 = <code>PLAIN</code>
     */
    public Element(int border)
    {
        super();
        setBorder(Borders.getBorder(border, ""));
        update();
    }

    /**
     * Creates a bordered panel with the specified layout.
     *
     * @param layouts the layout used by this <code>Element</code> to organise components
     * @param border 0 = <code>NONE</code> and 1 = <code>PLAIN</code>
     */
    public Element(AbstractLayout layouts, int border)
    {
        super(layouts);
        setBorder(Borders.getBorder(border, ""));
        update();
    }

    /**
     * Creates a bordered panel with the specified layout and adds it to a panel.
     *
     * @param layouts the layout used by this <code>Element</code> to organise components
     * @param panel the parent <code>Panel</code> that this panel will be added to
     * @param border 0 = <code>NONE</code> and 1 = <code>PLAIN</code>
     */
    public Element(AbstractLayout layouts, Panel panel, int border)
    {
        super(layouts, panel);
        setBorder(Borders.getBorder(border, ""));
        update();
    }

    /**
     * Creates a bordered panel with a vertical layout and a title.
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     * @param title the title to be displayed with the border.
     */
    public Element(AbstractLayout layouts, int border, String title)
    {
        super(layouts);
        setBorder(Borders.getBorder(border, title));
        update();
    }


    /**
     * Creates a panel with the specified layout, border and title and adds it to
     * the given panel.
     *
     * @param layouts the layout used by this <code>Element</code> to organise components
     * @param panel the parent <code>Panel</code> that this panel will be added to
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     * @param title the title to be displayed with this border
     */
    public Element(AbstractLayout layouts, Panel panel, int border, String title)
    {
        super(layouts, panel);
        setBorder(Borders.getBorder(border, title));
        update();
    }

    /**
     * Sets the border of this <code>Element</code>.
     *
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     */
    public void setElementBorder(int border)
    {
        setBorder(Borders.getBorder(border, ""));
    }

    /**
     * Sets the border of this <code>Element</code>.
     *
     * @param title a <code>String</code> representing the title of this border
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     */
    public void setElementBorder(int border, String title)
    {
        Borders.getBorder(border, title);
    }

    /**
     * Returns the spacing on this <code>BorderPanel</code>.
     *
     * @return the <int> value representing the spacing on this <code>BorderPanel</code>
     */
    public int getSpacing()
    {
        return spacing;
    }

    /**
     * Sets the spacing on this <code>BorderPanel</code>. Higher values create more space around
     * the edge of the panel.
     *
     * @param spacing the <int> value representing the spacing on this <code>BorderPanel</code>
     */
    public void setSpacing(int spacing)
    {
        this.spacing = spacing;
        setBorder(BorderFactory.createEmptyBorder(spacing, spacing, spacing, spacing));
    }

    /**
     * Sets the minimum, maximum and preferred sizes of this <code>Element</code> to the
     * specified size.
     *
     * @param width the <code>int</code> representing width of the component
     * @param height the <code>int</code> representing height of the component
     */
    public void setSize(int width, int height)
    {
        Utils.setComponentSize(this, width, height);
    }

    /**
     * Sets the alignment of this <code>Element</code>. Values closer to 0 position objects to the
     * left and top, which values closer to 1 position objects closer to the right and bottom.
     *
     * @param x a <code>float</code> indicating the position of added objects. Values closer to 0
     * position objects to the left while values closer to 1 position them to the right.
     * @param y a <code>float</code> indicating the position of added objects. Values closer to 0
     * position objects towards the top while values closer to 1 position them towards the bottom.
     */
    public void setAlignment(float x, float y)
    {
        setAlignmentX(x);
        setAlignmentY(y);
    }

    /**
     * Returns the width of this <code>Element</code>
     *
     * @return the width of this <code>Element</code>
     */
    public int getElementWidth()
    {
        return getPreferredSize().width;
    }

    /**
     * Returns the height of this <code>Element</code>
     *
     * @return the height of this <code>Element</code>
     */
    public int getElementHeight()
    {
        return getPreferredSize().height;
    }

}
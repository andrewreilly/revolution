/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

import core.Utils;
import tests.P;

import javax.swing.*;


/**
 * This class provides the basic building block of GUI elements. It extends
 * <code>JPanel</code> with a <code>BoxLayout</code> with a default horizontal
 * layout, with can be changed.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Panel extends JPanel
{
    private AbstractLayout layouts = null;

    /**
     * The parent <code>Panel</code> that this <code>Panel</code> is be added to.
     */
    private Panel panel = null;

    /**
     * Creates a panel with a centred layout.
     */
    public Panel()
    {
        super();
        createLayout(new LineLayout(Layouts.CENTRE, Layouts.CENTRE));
    }

    /**
     * Creates a panel with the given layout.
     *
     * @param panel the parent <code>Panel</code> that this <code>Panel</code> is added to
     */
    public Panel(Panel panel)
    {
        createLayout(new LineLayout(Layouts.CENTRE, Layouts.CENTRE));
        this.panel = panel;
        panel.add(this);
        panel.update();
    }

    /**
     * Creates a panel with the given layout.
     *
     * @param layouts the layout used by this <code>Panel</code>
     */
    public Panel(AbstractLayout layouts)
    {
        createLayout(layouts);
    }

    /**
     * Creates a panel with the given layout and adds it to the given panel.
     *
     * @param layouts the layout used by this <code>Panel</code>
     * @param panel the panel that this <code>Panel</code> will be added to
     */
    public Panel(AbstractLayout layouts, Panel panel)
    {
        createLayout(layouts);
        this.panel = panel;
        panel.add(this);
        panel.update();
    }

    public void createLayout(AbstractLayout layouts)
    {
        this.layouts = layouts;
        setComponentOrientation(layouts.getComponentOrientation());
        setLayout(new BoxLayout(this, layouts.getAxis()));
    }

    /**
     * Revalidates and repaints the panel.
     */
    public final void update()
    {
        revalidate();
        repaint();
    }

    /**
     * Removes any space between the JComponents contained in this <code>Panel</code> .
     */
    public final void collapse()
    {
        int itemWidth = 0;
        int itemHeight = 0;
        for(int i = 0; i < getComponentCount(); i++)
        {
            if(layouts.getAxis() != 1)
            {
                itemWidth += getComponent(i).getPreferredSize().width;
                int height = getComponent(i).getPreferredSize().height;
                if(height > itemHeight)
                {
                    itemHeight = height;
                }
            }
            else
            {
                itemHeight += getComponent(i).getPreferredSize().height;
                int width = getComponent(i).getPreferredSize().width;
                if(width > itemWidth)
                {
                    itemWidth = width;
                }
            }
        }
        Utils.setComponentSize(this, itemWidth, itemHeight);
    }

    /**
     * Returns the parent panel that this panel is added to.
     *
     * @return the parent <code>Panel</code> that this <code>Panel</code> is added to
     */
    public Panel getPanel()
    {
        return panel;
    }

    /**
     * Returns the <code>AbstractLayout</code> that this panel uses to organise components.
     *
     * @return the <code>AbstractLayout</code> that this panel uses to organise components.
     */
    public AbstractLayout getLayouts()
    {
        return layouts;
    }

    /**
     * Sets the <code>AbstractLayout</code> that this panel uses to organise components.
     *
     * @param layouts <code>AbstractLayout</code> that this panel uses to organise components.
     */
    public void setLayouts(AbstractLayout layouts)
    {
        this.layouts = layouts;
        createLayout(layouts);
    }

    /**
     * Sets a <code>ListLayout</code> with a centred alignment as the layout that this panel uses to organise components.
     */
    public void setListLayout()
    {
        setLayouts(new ListLayout(Layouts.CENTRE, Layouts.CENTRE));
    }

    /**
     * Sets a <code>ListLayout</code> as the layout that this panel uses to organise components.
     *
     * @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this panel.
     * @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this panel.
     */
    public void setListLayout(Layouts xLayout, Layouts yLayout)
    {
        setLayouts(new ListLayout(xLayout, yLayout));
    }

    /**
     * Sets a <code>LineLayout</code> as the layout that this panel uses to organise components.
     *
     * @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this panel.
     * @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this panel.
     */
    public void setLineLayout(Layouts xLayout, Layouts yLayout)
    {
        setLayouts(new LineLayout(xLayout, yLayout));
    }

    /**
     * Sets a <code>LineLayout</code> with a centred alignment as the layout that this panel uses to organise components.
     */
    public void setLineLayout()
    {
        setLayouts(new LineLayout(Layouts.CENTRE, Layouts.CENTRE));
    }
}

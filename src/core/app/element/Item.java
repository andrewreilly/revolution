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
import java.util.ArrayList;

/**
 * The base class from which all items inherit. Items usually used hold a single <code>JComponent</code>.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public abstract class Item<C extends JComponent> extends Element
{
    /**
     * The <code>JComponent</code> held by this item.
     */
    private C component;

    /**
     * An <code>ArrayList</code> of <code>Item</code>s that are disabled whenever this item is not
     * active.
     */
    private ArrayList<Item> disabledItems = new ArrayList<>();

    /**
     * An <code>int</code> value indicating the standard height of item components.
     */
    public static int componentHeight = 20;

    /**
     * Creates an empty <code>Item</code> with the specified border.
     *
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     * contains
     */
    public Item(int border)
    {
        super(border);
    }

    /**
     * Creates an empty <code>Item</code> with no border.
     */
    public Item()
    {
        super(Borders.NONE);
    }

    /**
     * Creates an <code>Item</code> that contains the specified <code>JComponent</code>.
     *
     * @param component a <code>JComponent</code> that this <code>Item</code>
     * contains
     */
    public Item(C component)
    {
        super(Borders.NONE);
        setComponent(component);
    }

    /**
     * Sets the <code>JComponent</code> contained by this <code>Item</code>.
     *
     * @param component a <code>JComponent</code> that this <code>Item</code> contains
     */
    public void setComponent(C component)
    {
        if(this.component != null)
        {
            remove(this.component);
        }
        this.component = component;
        add(component);
    }

    /**
     * Returns the <code>JComponent</code> contained by this <code>Item</code>.
     *
     * @return the <code>JComponent</code> contained by this <code>Item</code>
     */
    public C getComponent()
    {
        return component;
    }

    /**
     * Displays or removes the title assigned to the <code>JComponent</code> held by this <code>Item</code>,
     * if there is one.
     *
     * @param showTitle displays the title when set to <code>true</code> and removes the title when
     * set to <code>false</code>.
     */

    /**
     * Enables or disables the <code>JComponent</code> held by this <code>Item</code>.
     *
     * @param isEnabled enables the <code>JComponent</code> held by this <code>Item</code> when set
     * to <code>true</code> and disables it when set to <code>false</code>.
     */
    public void isEnabled(Boolean isEnabled)
    {
        component.setEnabled(isEnabled);
    }

    /**
     * Returns a <code>boolean</code> indicating whether or not the <code>JComponent</code> held by
     * this <code>Item</code> is enabled or disabled.
     *
     * @return <code>true</code> when the <code>JComponent</code> held by this <code>Item</code> is
     * enabled and <code>false</code> when it is disabled.
     */
    public boolean isEnabled()
    {
        return component.isEnabled();
    }

    /**
     * Overrides the <code>Element</code> method to compensate for differences between the desired
     * size of components and the size of the whole <code>Item</code>. The given parameters refer to
     * the desired size of components and not to the size of this <code>Item</code>, which will be
     * slightly bigger, depending on the setting for spacing on the parent <code>BorderPanel</code>.
     *
     * @param width the <code>int</code> representing width of the component
     * @param height the <code>int</code> representing height of the component
     */
    @Override
    public void setSize(int width, int height)
    {
        Utils.setComponentSize(component, width, height);
        int itemWidth = width + (getSpacing() * 2);
        int itemHeight = height + (getSpacing() * 2);
        Utils.setComponentSize(this, itemWidth, itemHeight);
    }

    /**
     * Flags the given <code>Item</code> for disabling whenever this <code>Item</code> is not active.
     *
     * @param item the <code>Item</code> to be disabled whenever this <code>Item</code> is not active
     */
    public void addDisabledItem(Item item)
    {
        disabledItems.add(item);
    }

    /**
     * Disables all of the <code>Item</code>s that have been flagged for disabling whenever this
     * <code>Item</code> is not active.
     */
    public void disableItems()
    {
        for(Item item : disabledItems)
        {
            item.isEnabled(false);
        }
    }

    /**
     * Enables all of the <code>Item</code>s that have been flagged for disabling whenever this
     * <code>Item</code> is not active.
     */
    public void enableItems()
    {
        for(Item item : disabledItems)
        {
            item.isEnabled(true);
        }
    }

    /**
     * Sets the text to be displayed when the mouse hovers over this <code>Item</code>.
     *
     * @param toolTipText a <code>String</code> representing the text to be displayed when the mouse
     * hovers over this <code>Item</code>
     */
    public void setToolTipText(String toolTipText)
    {
        component.setToolTipText(toolTipText);
    }
}

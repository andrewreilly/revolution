/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Utils;
import core.app.element.Borders;
import core.app.element.Item;
import core.app.element.Label;
import tests.P;

import javax.swing.*;
import java.awt.*;

/**
 * An <code>Item</code> with a component that has text to the left of it.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class TitledItem<C  extends JComponent> extends Item<C>
{
    /**
     * The <code>JLabel</code> used to display the title.
     */
    private JLabel titleLabel = null;

    /**
     * A <code>boolean</code> value indicating whether or not this item has a title that can be
     * displayed next to it.
     */
    private String title = null;

    /**
     * Creates an <code>Item</code> with no component and no title.
     */
    public TitledItem()
    {
        super();
    }

    /**
     * Creates an <code>Item</code> with the given component and title.
     *
     * @param component the component displayed by this <code>Item</code>
     * @param title the title displayed to the left of the component
     */
    public TitledItem(C component, String title)
    {
        super(component);
        this.title = title;
    }

    /**
     * Sets the <code>JComponent</code> contained by this <code>Item</code>. If a title has been assigned
     * to this object then it will appear to the left of the <code>JComponent</code>.
     *
     * @param component a <code>JComponent</code> that this <code>Item</code> contains
     */
    @Override
    public void setComponent(C component)
    {

        removeAll();
        if(title != null)
        {
            titleLabel = new JLabel(title);
            titleLabel.setFont(Label.getDefaultFont());
            int textWidth = getFontMetrics(titleLabel.getFont()).stringWidth(title);
            Utils.setComponentSize(titleLabel, textWidth, componentHeight);
            add(titleLabel);
            add(Box.createRigidArea(new Dimension(5,0)));
            super.setComponent(component);
            int itemSpacing = getSpacing() * 2;
            Utils.setComponentSize(this, titleLabel.getPreferredSize().width + component.getPreferredSize().width + 5 + itemSpacing, componentHeight + itemSpacing);
        }
        else
        {
            removeAll();
            super.setComponent(component);
            setSize(component.getPreferredSize().width, componentHeight);
        }
    }

    /**
     * Sets a title to be displayed next to the item by assigning the given <code>String</code> to the
     * <code>name</code> field and setting <code>hasTitle</code> to <code>true</code>. Note that this
     * title will only appear if <code>setComponent()</code> is called.
     *
     * @param title a <code>String</code> containing the title to be displayed next to this <code>Item</code>
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Returns the title to be displayed next to the item by returning the <code>name</code> field.
     *
     * @return a <code>String</code> containing the title to be displayed next to this <code>Item</code>
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Indicates whether or not this object has a title by returning <code>!(title == null)</code>
     *
     * @return a <code>String</code> containing the title to be displayed next to this <code>Item</code>
     */
    public boolean hasTitle()
    {
        return !(title == null);
    }

    /**
     * Returns the <code>JLabel</code> containing the title to be displayed next to this <code>Item</code>
     *
     * @return a <code>JLabel</code> containing the title to be displayed next to this <code>Item</code>
     */
    public JLabel getTitleLabel()
    {
        return titleLabel;
    }

    @Override
    public void isEnabled(Boolean isEnabled)
    {
        super.setEnabled(isEnabled);
        if(titleLabel != null)
        {
            titleLabel.setEnabled(isEnabled);
        }
    }

    @Override
    public void setSize(int width, int height)
    {
        Utils.setComponentSize(getComponent(), width, height);
        int itemWidth;
        if(title != null)
        {
            itemWidth = titleLabel.getPreferredSize().width + width + (getSpacing() * 3);
        }
        else
        {
            itemWidth = width + (getSpacing() * 2);
        }
        int itemHeight = height + (getSpacing() * 2);
        Utils.setComponentSize(this, itemWidth, itemHeight);
    }

    /**
     * Adjusts the size of this <code>Item</code> following any changes that have been made to the
     * components, such as a change of title or display.
     */
    public void resize()
    {
        int itemWidth;
        if(title != null)
        {
            itemWidth = titleLabel.getPreferredSize().width + getComponent().getPreferredSize().width + (getSpacing() * 3);
        }
        else
        {
            itemWidth = getComponent().getPreferredSize().width + (getSpacing() * 2);
        }
        int itemHeight = getComponent().getPreferredSize().height;
        Utils.setComponentSize(this, itemWidth, itemHeight);
    }
}

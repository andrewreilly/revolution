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
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * An object used to organise the position of <code>Element</code>s in a window. As the
 * <code>Layouter</code> inherits <code>Element</code>, multiple <code>Layouter</code>s
 * can be nested within each other. Elements are attached to <code>Panel</code>s that are
 * arranged using a <code>BorderLayout</code>.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Layouter extends Element
{

    /**
     * A <code>HashMap</code> that is used to store <code>Panel</code>s using a <code>Layout</code>s value as a key.
     */
    private HashMap<Layouts, Panel> panels;

    /**
     * Constructor for a default layout with a <code>BorderLayout</code> and no attached <code>Element</code>s
     */
    public Layouter()
    {
        setLayout(new BorderLayout());
        panels = new HashMap<>();
        Layouts[] locations = {Layouts.CENTRE, Layouts.TOP, Layouts.RIGHT, Layouts.BOTTOM, Layouts.LEFT};
        String[] borders = {BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.EAST, BorderLayout.SOUTH, BorderLayout.WEST};
        Panel panel;
        for(int i = 0; i < 5; i++)
        {
            panel = new Panel();
            panels.put(locations[i], panel);
            add(panel, borders[i]);
        }
    }

    /**
     * Returns the <code>Panel</code> located at the top of the <code>BorderLayout</code>.
     *
     * @return the <code>Panel</code> located at the top of the <code>BorderLayout</code>.
     */
    public Panel getTop()
    {
        return panels.get(Layouts.TOP);
    }

    /**
     * Returns the <code>Panel</code> located at the bottom of the <code>BorderLayout</code>.
     *
     * @return the <code>Panel</code> located at the bottom of the <code>BorderLayout</code>.
     */
    public Panel getBottom()
    {
        return panels.get(Layouts.BOTTOM);
    }

    /**
     * Returns the <code>Panel</code> located to the left of the <code>BorderLayout</code>.
     *
     * @return the <code>Panel</code> located to the left of the <code>BorderLayout</code>.
     */
    public Panel getLeft()
    {
        return panels.get(Layouts.LEFT);
    }

    /**
     * Returns the <code>Panel</code> located to the right of the <code>BorderLayout</code>.
     *
     * @return the <code>Panel</code> located to the right of the <code>BorderLayout</code>.
     */
    public Panel getRight()
    {
        return panels.get(Layouts.RIGHT);
    }

    /**
     * Returns the <code>Panel</code> located at the centre of the <code>BorderLayout</code>.
     *
     * @return the <code>Panel</code> located at the centre of the <code>BorderLayout</code>.
     */
    public Panel getCentre()
    {
        return panels.get(Layouts.CENTRE);
    }

    /**
     * Adds a <code>JComponent</code> to the centre of this <code>Layouter</code>.
     *
     * @param component a <code>JComponent</code> that is added to this <code>Layouter</code>
     */
    public void add(JComponent component)
    {
        setComponentAlignment(Layouts.CENTRE, component);
        panels.get(Layouts.CENTRE).add(component);
    }


    /**
     * Adds a <code>JComponent</code> to the supplied location of this <code>Layouter</code>.
     *
     * @param component a <code>JComponent</code> that is added to this <code>Layouter</code>
     * @param location a <code>String</code> constant denoting the location of the supplied component
     */
    public void add(JComponent component, Layouts location)
    {
        setComponentAlignment(location, component);
        panels.get(location).add(component);
    }


    /**
     * Adds a <code>JComponent</code> to the centre of this <code>Layouter</code> at the supplied index.
     *
     * @param component a <code>JComponent</code> that is added to this <code>Layouter</code>
     * @param index an <code>int</code> denoting the index of the supplied component
     */
    public void add(JComponent component, int index)
    {
        setComponentAlignment(Layouts.CENTRE, component);
        panels.get(Layouts.CENTRE).add(component, index);
    }


    /**
     * Adds a <code>JComponent</code> to the specified location of this <code>Layouter</code> at the
     * supplied index.
     *
     * @param component a <code>JComponent</code> that is added to this <code>Layouter</code>
     * @param location a <code>String</code> constant denoting the location of the supplied component
     * @param index an <code>int</code> denoting the index of the supplied component
     */
    public void add(JComponent component, Layouts location, int index)
    {
        setComponentAlignment(location, component);
        panels.get(location).add(component, index);
    }


    /**
     * Adds an <code>Element</code> to the centre of this <code>Layouter</code>. If the element has a
     * variable and the layouter does not then the layouter will take on the element variable and
     * vice-versa.
     *
     * @param element an <code>Element</code> that is added to this <code>Layouter</code>
     */
    public void add(Element element)
    {
        setElementAlignment(Layouts.CENTRE, element);
        panels.get(Layouts.CENTRE).add(element);
    }


    /**
     * Adds an <code>Element</code> to the supplied location of this <code>Layouter</code>. If the
     * element has a variable and the layouter does not then the layouter will take on the element variable and
     * vice-versa.
     *
     * @param element an <code>Element</code> that is added to this <code>Layouter</code>
     * @param location a <code>String</code> constant denoting the location of the supplied element
     */
    public void add(Element element, Layouts location)
    {
        setElementAlignment(location, element);
        panels.get(location).add(element);
    }


    /**
     * Adds an <code>Element</code> to the centre of this <code>Layouter</code> at the supplied index.
     *
     * @param element an <code>Element</code> that is added to this <code>Layouter</code>
     * @param index an <code>int</code> denoting the index of the supplied element
     */
    public void add(Element element, int index)
    {
        setElementAlignment(Layouts.CENTRE, element);
        panels.get(Layouts.CENTRE).add(element, index);
    }


    /**
     * Adds an <code>Element</code> to the specified location of this <code>Layouter</code> at the
     * supplied index.
     *
     * @param element an <code>Element</code> that is added to this <code>Layouter</code>
     * @param location a <code>String</code> constant denoting the location of the supplied element
     * @param index an <code>int</code> denoting the index of the supplied element
     */
    public void add(Element element, Layouts location, int index)
    {
        setElementAlignment(location, element);
        panels.get(location).add(element, index);
    }


    /**
     * Returns the <code>JComponent</code> at the specified location and index from this <code>Layouter</code>.
     *
     * @param location a <code>String</code> constant denoting the location of the component to be returned
     * @param index an <code>int</code> denoting the index of the of the component to be returned
     * @return the <code>JComponent</code> at the specified location and index
     */
    public JComponent getComponent(String location, int index)
    {
        return (JComponent)panels.get(location).getComponent(index);
    }


    /**
     * Returns the <code>Panel</code> at the specified location.
     *
     * @param location a <code>String</code> constant denoting the location of the <code>Panel</code> to be returned
     * @return the <code>Panel</code> at the specified location
     */
    public Panel getPanel(Layouts location)
    {
        return panels.get(location);
    }


    /**
     * Removes all of the <code>Element</code>s from this <code>Layouter</code>.
     */
    public void removeAllElements()
    {
        for(Map.Entry entry : panels.entrySet())
        {
            Panel panel = (Panel)entry.getValue();
            panel.removeAll();
        }
    }


    /**
     * Removes a <code>JComponent</code> from the centre of this <code>Layouter</code>.
     *
     * @param component a <code>JComponent</code> to be removed from this <code>Layouter</code>.
     */
    public void removeComponent(JComponent component)
    {
        component.getParent().remove(component);
    }


    /**
     * Removes a <code>JComponent</code> from the specified location and index of this <code>Layouter</code>.
     *
     * @param location a <code>String</code> constant denoting the location of the component to be
     * removed
     * @param index an <code>int</code> denoting the index of the of the component to be removed
     */
    public void removeComponent(String location, int index)
    {
        panels.get(location).remove(index);
    }


    /**
     * Sets the horizontal and vertical alignment of the <code>Panel</code> at the specified location.
     *
     * @param location a <code>String</code> constant denoting the location of the component to be returned
     * @param alignmentX a <code>double</code> specifying the horizontal alignment of the panel at
     * the given location
     * @param alignmentY a <code>double</code> specifying the vertical alignment of the panel at
     * the given location
     */
    public void setAlignment(String location, float alignmentX, float alignmentY)
    {
        panels.get(location).setAlignmentX(alignmentX);
        panels.get(location).setAlignmentY(alignmentY);
    }




    /**
     * Sets the horizontal and vertical alignment of the <code>Panel</code> at the centre of this
     * <code>Layouter</code>.
     *
     * @param alignmentX a <code>double</code> specifying the horizontal alignment of the panel at
     * the supplied location
     * @param alignmentY a <code>double</code> specifying the vertical alignment of the panel at
     * the supplied location
     */
    public void setAlignment(float alignmentX, float alignmentY)
    {
        panels.get(Layouts.CENTRE).setAlignmentX(alignmentX);
        panels.get(Layouts.CENTRE).setAlignmentY(alignmentY);
    }

    /**
     * Sets the horizontal and vertical alignment of the supplied <code>Element</code> to the
     * alignment of the <code>Panel</code> at the specified location.
     *
     * @param location a <code>String</code> constant denoting the location of the supplied element
     * @param element an <code>Element</code> that is added to this <code>Layouter</code>
     */
    public void setElementAlignment(Layouts location, Element element)
    {
        element.setAlignmentX(panels.get(location).getLayouts().getX());
        element.setAlignmentY(panels.get(location).getLayouts().getY());
    }


    /**
     * Sets the horizontal and vertical alignment of the supplied <code>Component</code> to the
     * alignment of the <code>Panel</code> at the specified location.
     *
     * @param location a <code>String</code> constant denoting the location of the supplied component
     * @param component a <code>JComponent</code> that is added to this <code>Layouter</code>
     */
    public void setComponentAlignment(Layouts location, JComponent component)
    {
        component.setAlignmentX(panels.get(location).getAlignmentX());
        component.setAlignmentY(panels.get(location).getAlignmentY());
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
    public void setSize(int width, int height)
    {
        Utils.setComponentSize(this, width, height);
    }
}

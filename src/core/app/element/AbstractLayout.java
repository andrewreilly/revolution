/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

import java.awt.ComponentOrientation;

/**
 * Base class for layouts. This class contains all of the parameters needed to create a number of
 * layouts using <code>BoxLayout</code>.
 * 
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class AbstractLayout
{

    /**
     * A <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     */
    private Layouts xLayout;

    /**
     * A <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    private Layouts yLayout;

    /**
     *  An object used by <code>JPanel</code> objects to indicate the orientation of components, for example, whether
     *  they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     */
    private ComponentOrientation componentOrientation;

    /**
     *  A numerical value representing the orientation of components on a <code>JPanel</code>, for example, whether
     *  they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     */
    private int axis;

    /**
     *  A <code>float</code> used to position components on the horizontal axis.
     */
    private float x;

    /**
     *  A <code>float</code> used to position components on the vertical axis.
     */
    private float y;

    /**
     *  A basic constructor that assigns the given values to the <code>xLayout</code> and <code>yLayout</code> fields.
     *
     *  @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     *  @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public AbstractLayout(Layouts xLayout, Layouts yLayout)
    {
        try
        {
            if(xLayout == Layouts.TOP |
                    xLayout == Layouts.BOTTOM |
                    yLayout == Layouts.LEFT |
                    yLayout == Layouts.RIGHT)
            {
                throw new LayoutException(xLayout, yLayout);
            }
            else
            {
                this.xLayout = xLayout;
                this.yLayout = yLayout;
                if(xLayout == Layouts.LEFT)
                {
                    setX(0.0f);
                }
                else if(xLayout == Layouts.RIGHT)
                {
                    setX(1.0f);
                }
                else
                {
                    setX(0.5f);
                }
                if(yLayout == Layouts.TOP)
                {
                    setY(0.0f);
                }
                else if(yLayout == Layouts.BOTTOM)
                {

                    setY(1.0f);
                }
                else
                {
                    setY(0.5f);
                }
            }
        }
        catch(LayoutException e)
        {
            e.printStackTrace();
        }


    }

    /**
     * Returns the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     *
     * @return the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     */
    public Layouts getxLayout()
    {
        return xLayout;
    }

    /**
     * Sets the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     *
     * @param xLayout the <code>Layouts</code> value indicating the horizontal alignment of components in this layout.
     */
    public void setxLayout(Layouts xLayout)
    {
        this.xLayout = xLayout;
    }

    /**
     * Returns the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     *
     * @return the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public Layouts getyLayout()
    {
        return yLayout;
    }

    /**
     * Sets the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     *
     * @param yLayout the <code>Layouts</code> value indicating the vertical alignment of components in this layout.
     */
    public void setyLayout(Layouts yLayout)
    {
        this.yLayout = yLayout;
    }

    /**
     * Returns the <code>ComponentOrientation</code> object indicating the orientation of components, for example, whether
     * they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     *
     * @return the <code>ComponentOrientation</code> indicating the orientation of components in this layout.
     */
    public ComponentOrientation getComponentOrientation()
    {
        return componentOrientation;
    }

    /**
     * Sets the <code>ComponentOrientation</code> object indicating the orientation of components, for example, whether
     * they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     *
     * @return the <code>ComponentOrientation</code> indicating the orientation of components in this layout.
     */
    public void setComponentOrientation(ComponentOrientation componentOrientation)
    {
        this.componentOrientation = componentOrientation;
    }

    /**
     *  Returns a numerical value representing the orientation of components on a <code>JPanel</code>, for example, whether
     *  they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     *
     *  @return an <code>int</code> indicating the orientation of components on a <code>JPanel</code>.
     */
    public int getAxis()
    {
        return axis;
    }

    /**
     *  Sets a numerical value representing the orientation of components on a <code>JPanel</code>, for example, whether
     *  they are arranged vertically or horizontally or placed from right-to-left or left-to-right.
     *
     *  @param axis an <code>int</code> indicating the orientation of components on a <code>JPanel</code>.
     */
    public void setAxis(int axis)
    {
        this.axis = axis;
    }

    /**
     *  Returns a numerical value representing the alignment of components on the horizontal axis. For example, a value
     *  of 0 will align components to the left, while a value of 1 will align them to the right.
     *
     *  @return a <code>float</code> indicating the horizontal alignment of components on a <code>JPanel</code>.
     */
    public float getX()
    {
        return x;
    }

    /**
     *  Sets a numerical value representing the alignment of components on the horizontal axis. For example, a value
     *  of 0 will align components to the left, while a value of 1 will align them to the right.
     *
     *  @return a <code>float</code> indicating the horizontal alignment of components on a <code>JPanel</code>.
     */
    public void setX(float x)
    {
        this.x = x;
    }

    /**
     *  Returns a numerical value representing the alignment of components on the vertical axis. For example, a value
     *  of 0 will align components at the top, while a value of 1 will align them to the bottom.
     *
     *  @return a <code>float</code> indicating the vertical alignment of components on a <code>JPanel</code>.
     */
    public float getY()
    {
        return y;
    }

    /**
     *  Sets a numerical value representing the alignment of components on the vertical axis. For example, a value
     *  of 0 will align components at the top, while a value of 1 will align them to the bottom.
     *
     *  @return a <code>float</code> indicating the vertical alignment of components on a <code>JPanel</code>.
     */
    public void setY(float y)
    {
        this.y = y;
    }

}

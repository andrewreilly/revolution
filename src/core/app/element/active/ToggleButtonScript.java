/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

/**
 * Default <code>Script</code> for the <code>ToggleButton</code>. This simply calls the
 * <code>ToggleButton.toggle()</code> method.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ToggleButtonScript implements Script
{

    /**
     * The <code>ToggleButton</code> associaed with this <code>Script</code>
     */
    private ToggleButton toggleButton;


    /**
     * Constructor for this <code>Script</code>.
     *
     * @param toggleButton the <code>ToggleButton</code> associated with this <code>Script</code>
     */
    public ToggleButtonScript(ToggleButton toggleButton)
    {
        setToggleButton(toggleButton);
    }

    @Override
    public void run()
    {
        toggleButton.toggle();
    }


    /**
     * Returns the <code>ToggleButton</code> associated with this <code>Script</code>
     *
     * @return the <code>ToggleButton</code> associated with this <code>Script</code>
     */
    public ToggleButton getToggleButton()
    {
        return toggleButton;
    }

    /**
     * Sets the <code>ToggleButton</code> to be associated with this <code>Script</code>
     *
     * @param toggleButton  the <code>ToggleButton</code> to be associated with this <code>Script</code>
     */
    public void setToggleButton(ToggleButton toggleButton)
    {
        this.toggleButton = toggleButton;
    }
}

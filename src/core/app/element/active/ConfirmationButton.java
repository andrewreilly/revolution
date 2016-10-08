/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.app.window.Windows;

/**
 * Abstract class for a button typically used to perform actions confirming information
 * related to a <code>Windows</code> object. For example, "Ok" and "Cancel" buttons.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public abstract class ConfirmationButton extends Button implements ConfirmationButtons
{

    /**
     * Creates a <code>Button</code> associated with the given <code>Windows</code>
     * object and displaying the given text.
     *
     * @param text the text displayed  by this <code>Button</code>
     * @param window the <code>Windows</code> object associated with this <code>Button</code>
     */
    public ConfirmationButton(String text, Windows window)
    {
        super(text, window);
        setScript(this);
    }

    @Override
    public String getDisplayName()
    {
        return getText();
    }

    @Override
    public void setDisplayName(String displayName)
    {
        setText(displayName);
    }

}

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
 * A button confirming that information presented in a window is true or acceptable when pressed.
 * Associated behaviour can be implemented by overriding the <code>Windows<.confirm()</code>
 * method.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ConfirmButton extends ConfirmationButton
{

    /**
     * Crates a button with the given text confirming information presented in the given window.
     *
     * @param text the text displayed on this button such as "Yes" or "Ok"
     * @param window the <code>Windows</code> object associated with this button
     */
    public ConfirmButton(String text, Windows window)
    {
        super(text, window);
    }

    @Override
    public void run()
    {
        getWindow().confirm();
    }


}

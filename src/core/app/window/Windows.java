/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.window;

import core.app.element.Item;
import core.app.element.Layouter;
import core.app.element.active.Button;
import core.app.element.active.Buttons;
import core.app.element.active.ConfirmButton;
import core.app.element.active.DisconfirmButton;

import javax.swing.*;
import java.awt.*;

/**
 * Interface for objects with the functionality of windows.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Windows
{

    /**
     * Returns the <code>Layouter</code> used by this <code>Windows</code> object
     *
     * @return the <code>Layouter</code> used by this <code>Windows</code> object
     */
    Layouter getLayouter();

    /**
     * Sets the <code>Layouter</code> used by this <code>Windosw</code> object
     *
     * @param layouter <code>Layouter</code> used by this <code>Windows</code> object
     */
    void setLayouter(Layouter layouter);

    /**
     * Adds a <code>ConfirmButton</code> to this <code>Dialog</code> with the given name
     */
    void addConfirmButton(String confirmButtonName);

    /**
     * Adds a <code>DisconfirmButton</code> to this <code>Dialog</code> with the given name
     */
    void addDisconfirmButton(String disconfirmButtonName);

    /**
     * Adds both a <code>ConfirmButton</code> and a <code>DisconfirmButton</code>
     * +to this <code>Dialog</code> with the given names
     */
    void addConfirmationButtons(String confirmButtonName, String disconfirmButtonName);

    /**
     * Override this method to process actions to confirm information presented in a window
     * or dialog. For example, if a dialog gives the user the option of closing this
     * <code>Windows</code> object, place the code closing the window in this method.
     */
    void confirm();

    /**
     * Override this method to process actions to disconfirm information presented in a window
     * or dialog. For example, if a dialog gives the user the option of closing this
     * <code>Windows</code> object, place the code closing the window in this method.
     */
    void disconfirm();

    /**
     * Indicates whether or not the user has confirmed information presented in this window or dialog.
     */
    boolean isConfirmed();

    /**
     * Sets the state indicating whether or not the user has confirmed information in this
     * <code>Windows</code> object.
     *
     * @param isConfirmed Indicates whether or not the user has confirmed information presented
     * in this window or dialog. <code>true</code> if the user has confirmed and <code>false</code>
     * if not.
     */
    void isConfirmed(boolean isConfirmed);

    /**
     * Returns the <code>ConfirmButton</code> used by this window.
     *
     * @return the <code>ConfirmButton</code> used by this window
     */
    public ConfirmButton getConfirmButton();

    /**
     * Returns the <code>DisonfirmButton</code> used by this window.
     *
     * @return the <code>DisconfirmButton</code> used by this window
     */
    public DisconfirmButton getDisconfirmButton();

    /**
     * Sets the focus on the given button.
     */
    void setFocusOn(Button button);

    /**
     * Sets the focus on the <code>ConfirmButton</code>
     */
    void setFocusOnConfirmButton();

    /**
     * Sets the focus on the <code>DisconfirmButton</code>
     */
    void setFocusOnDisconfirmButton();

    /**
     * Closes this <code>Windows</code> object
     */
    void close();

}

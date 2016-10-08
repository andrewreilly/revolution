/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.data.Variables;
import javax.swing.*;

/**
 * A default <code>Script</code> that is run when a <code>Spinner</code> is changed. This
 * class can be extended to create user-defined scripts.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class SpinnerScript<V extends Number> implements Script
{

    /**
     * The <code>Spinner</code> that activates this <code>Script</code>.
     */
    protected Spinner spinner;

    /**
     * A constructor that creates a script for the given <code>Spinner</code>.
     *
     * @param spinner a <code>Spinner</code> that this script will be assigned to.
     */
    public SpinnerScript(Spinner spinner)
    {
        this.spinner = spinner;
    }

    @Override
    public void run()
    {
        Variables<V> spinnerVariable = spinner.getVariable();
        JSpinner spinnerComponent = (JSpinner)spinner.getComponent();
        if (!ItemController.get().hasChanged())
        {
            spinnerVariable.hasUpdated(false);
            V value = (V)spinnerComponent.getModel().getValue();
            spinnerVariable.setValue(value);
            spinnerVariable.hasUpdated(true);
        }
        else
        {
            if(!spinner.hasUpdated())
            {
                spinner.hasUpdated(true);
                spinnerComponent.getModel().setValue(spinnerVariable.getValue());
            }
        }
    }
}

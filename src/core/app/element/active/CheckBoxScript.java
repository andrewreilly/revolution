/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.data.Variables;

/**
 * A default <code>Script</code> that is run when a <code>CheckBox</code> is checked or unchecked. This
 * class can be extended to create user-defined scripts.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class CheckBoxScript implements Script
{

    /**
     * The <code>CheckBox</code> that activates this <code>Script</code>.
     */
    private CheckBox checkBox;

    /**
     * A constructor that creates a script for the given <code>CheckBox</code>.
     *
     * @param checkBox a <code>CheckBox</code> that this script will be assigned to.
     */
    public CheckBoxScript(CheckBox checkBox)
    {
        this.checkBox = checkBox;
    }

    @Override
    public void run()
    {
        Variables<Boolean> variable = checkBox.getVariable();
        if(checkBox.isSelected())
        {
            checkBox.enableItems();
        }
        else
        {
            checkBox.disableItems();
        }
        if (!ItemController.get().hasChanged())
        {
            variable.hasUpdated(false);
            boolean value = checkBox.isSelected();
            if(value)
            {
                variable.setValue(true);
            }
            else
            {
                variable.setValue(false);
            }
            variable.hasUpdated(true);
        }
        else
        {
            if(!checkBox.hasUpdated())
            {
                checkBox.hasUpdated(true);
                checkBox.isSelected(variable.getValue());
            }
        }
    }

    /**
     * Returns the <code>CheckBox</code> that activates this <code>Script</code>
     *
     * @return the <code>CheckBox</code> that activates this <code>Script</code>
     */
    public CheckBox getCheckBox()
    {
        return checkBox;
    }

}
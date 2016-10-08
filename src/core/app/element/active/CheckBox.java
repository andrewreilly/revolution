/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Updating;
import core.data.Variables;
import tests.P;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * A class for check boxes. Coding actions that occur when the box is checked or unchecked can be done
 * by passing a <code>Script</code> object to the constructor.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */

public class CheckBox extends ActiveItem<JCheckBox, Boolean>
{

    /**
     * Constructor that creates a <code>CheckBox</code> and connects it to the given <code>BooleanVariable</code>.
     *
     * @param booleanVariable a <code>BooleanVariable</code> that this <code>CheckBox</code> is
     * connected to
     */
    public CheckBox(Variables<Boolean> booleanVariable, boolean showTitle)
    {
        super(booleanVariable, showTitle);
        createCheckBox();
    }

    /**
     * Creates objects needed by the constructors
     */
    private void createCheckBox()
    {
        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(getVariable().getValue());
        setComponent(checkBox);
        checkBox.addActionListener(this);
        setScript(new CheckBoxScript(this));

    }

    /**
     * Overrides a method from the <code>ActionListener</code> interface that runs the <code>script</code>
     * when this <code>CheckBox</code> is checked or unchecked.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        runScript();
    }

    /**
     * Indicates whether or not this <code>CheckBox</code> is checked or unchecked.
     *
     * @return <code>true</code> if the <code>CheckBox</code> is checked and <code>false</code> if
     * it is unchecked
     */
    public boolean isSelected()
    {
        return getComponent().isSelected();
    }

    /**
     * Sets the selection status of the <code>CheckBox</code>.
     *
     * @param isSelected <code>true</code> if the <code>CheckBox</code> is checked and <code>false</code> if
     * it is unchecked
     */
    public void isSelected(boolean isSelected)
    {
        getComponent().setSelected(isSelected);
    }

    @Override
    public void update(Updating parent)
    {
        runScript();
    }
}

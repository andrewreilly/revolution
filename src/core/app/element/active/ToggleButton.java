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

import javax.swing.*;

/**
 * A button that switches between two states when pressed. These states are
 * represented by a <code>BooleanVariable</code> that updates whenever the
 * button is pressed. Changing the state of the variable will result in changing
 * the state of the button.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ToggleButton extends Button
{

    /**
     * Text displayed when the value of an associated <code>Variables<Boolean><code/>
     * is <code>true</code>
     */
    private String trueText = "";

    /**
     * Text displayed when the value of an associated <code>Variables<Boolean><code/>
     * is <code>false</code>
     */
    private String falseText = "";


    /**
     * Creates a <code>Button</code> with the specified text.
     *
     * @param variable a <code>Variables<Boolean></code> that stores the toggle state
     * @param trueText a <code>String</code> displayed by this <code>Button</code>
     * @param falseText a <code>String</code> displayed by this <code>Button</code>
     */
    public ToggleButton(Variables<Boolean> variable, String trueText, String falseText)
    {
        setVariable(variable, false);
        this.trueText = trueText;
        this.falseText = falseText;
        if(variable.getValue())
        {
            create(trueText);
        }
        else
        {
            create(falseText);
        }
        setScript(new ToggleButtonScript(this));
    }

    /**
     * Creates a <code>Button</code> with the specified text.
     *
     * @param variable a <code>Variables<Boolean></code> that stores the toggle state
     * @param trueText a <code>String</code> displayed by this <code>Button</code>
     * @param falseText a <code>String</code> displayed by this <code>Button</code>
     * @param script a <code>Script</code> that will run when this <code>Button</code>
     *               is pressed
     */
    public ToggleButton(Variables<Boolean> variable, String trueText, String falseText, Script script)
    {
        setVariable(variable, false);
        this.trueText = trueText;
        this.falseText = falseText;
        if(getVariable().getValue())
        {
            create(trueText);
        }
        else
        {
            create(falseText);
        }
        setScript(script);
    }

    /**
     * Sets parameters to standard values, ensuring that all <code>Button</code>s
     * that call this method will look and act in a similar way.
     *
     * @param trueText a <code>String</code> displayed by this <code>Button</code>
     * @param falseText a <code>String</code> displayed by this <code>Button</code>
     */
    private void create(String trueText, String falseText)
    {
        if(getVariable().getValue())
        {
            setComponent(new JButton(trueText));
        }
        else
        {
            setComponent(new JButton(trueText));
        }
        getComponent().addActionListener(this);
        setComponent(getComponent());
        int trueTextWidth = getFontMetrics(getFont()).stringWidth(trueText);
        int falseTextWidth = getFontMetrics(getFont()).stringWidth(falseText);
        if(trueTextWidth > falseTextWidth)
        {
            setSize(trueTextWidth + 40, componentHeight);
        }
        else
        {
            setSize(falseTextWidth + 40, componentHeight);
        }
    }

    /**
     * Changes to the state of the button to the opposite of its current state.
     *
     * @return a <code>boolean</code> indicating the state that the button has changed to
     */
    public boolean toggle()
    {
        update(getVariable());
        return getVariable().getValue();
    }

    /**
     * Changes the state of the button to the opposite of its current state.
     */
    @Override
    public void update(Updating parent)
    {
        if (!ItemController.get().hasChanged())
        {
            getVariable().hasUpdated(false);
            boolean currentValue = getVariable().getValue();
            getVariable().setValue(!currentValue);
            getVariable().hasUpdated(true);
        }
        else
        {
            if(!hasUpdated())
            {
                hasUpdated(true);
                setText();
            }
        }
    }

    /**
     * Used by other methods to set the button text to the value represented by the variable.
     */
    private void setText()
    {
        if(getVariable().getValue())
        {
            getComponent().setText(trueText);
        }
        else
        {
            getComponent().setText(falseText);
        }
    }

}

/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Updating;
import core.app.Text;
import core.app.element.Label;
import core.data.Variables;

/**
 * Displays the current value of a <code>Variable</code>. The displayed value is updated whenever
 * the value of the <code>Variable</code> changes.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Meter<V> extends ActiveItem<Label, V>
{

    /**
     * Creates a <code>Meter</code> that displays the value of the given <code>Variable</code>.
     *
     * @param variable the <code>Variable</code> that is connected to this <code>Meter</code>
     */
    public Meter(Variables<V> variable, boolean showTitle)
    {
        super(variable, showTitle);
        String string = "" + variable.getValue();;
        Label label = new Label(new Text(string, Text.OUTPUT));
        setTitle(variable.getDisplayName());
        setScript(new MeterScript(this));
        setComponent(label);
        checkScale();
    }

    /**
     * Removes any trailing zeroes in the displayed text when the value is an <code>Integer</code>
     */
    public void checkScale()
    {
        if(getVariable().getValue() instanceof Integer)
        {
            String labelText = getComponent().getText();
            labelText = labelText.replace(".0", "");
            getComponent().setText(labelText);
        }
    }

    /**
     * Returns the text displayed by this <Mcode>Meter</Mcode>
     *
     * @return returns a <code>String</code> indicating the text displayed by this <Mcode>Meter</Mcode>
     */
    public String getText()
    {
        return getComponent().getText();
    }

    /**
     * Sets the text displayed by this <Mcode>Meter</Mcode>
     *
     * @param text a <code>String</code> indicating the text displayed by this <Mcode>Meter</Mcode>
     */
    public void setText(String text)
    {
        getComponent().setText(text);
    }

    @Override
    public void update(Updating parent)
    {
        runScript();
    }
}

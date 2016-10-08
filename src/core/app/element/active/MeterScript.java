/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.data.Variables;
import tests.P;

/**
 * A default <code>Script</code> that is run when a <code>Meter</code> updates.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class MeterScript implements Script
{

    /**
     * The <code>Meter</code> that activates this <code>Script</code>.
     */
    protected Meter meter;

    /**
     * A constructor that creates a script for the given <code>Meter</code>.
     *
     * @param meter a <code>Meter</code> that this script will be assigned to.
     */
    public MeterScript(Meter meter)
    {
        this.meter = meter;
    }

    public void run()
    {
        if(!meter.hasUpdated())
        {
            Variables meterVariable = meter.getVariable();
            meter.hasUpdated(true);
            meter.setText("" + meterVariable.getValue());
            meter.checkScale();
            meter.resize();
        }
    }

}

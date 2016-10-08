/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Updating;
import core.data.Range;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.math.BigDecimal;

/**
 * A class for creating spinners. A <code>Spinner</code> typically has a <code>Variable</code> assigned
 * to it that defines the minimum, maximum and current values of the spinner.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Spinner<V extends Number> extends ActiveItem<JSpinner, V> implements ChangeListener
{

    /**
     * Creates a <code>Spinner</code> using an <code>IntegerVariable</code>.
     *
     * @param variable an <code>IntegerVariable</code> that sets the value parameters and remains
     * connected to this <code>Spinner</code> so that it can be updated as the <code>IntegerVariable</code>
     * changes value.
     */
    public Spinner(Range<V> variable, boolean showTitle)
    {
        super(variable, showTitle);
        Comparable min = new ComparableWrapper(variable.getMin());
        Comparable max = new ComparableWrapper(variable.getMax());
        Double step = 1.0;
        if(variable.getScale() > 0)
        {
            step = new BigDecimal(step).movePointLeft(variable.getScale()).doubleValue();
        }
        else if(variable.getScale() < 0)
        {
            step = new BigDecimal(step).movePointRight(variable.getScale()).doubleValue();
        }
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(variable.getValue(), min, max, step));
        spinner.getModel().setValue(variable.getValue());
        setComponent(spinner);
        spinner.addChangeListener(this);
        setSize(getSize(variable.getMin().doubleValue(), variable.getMax().doubleValue()), componentHeight);

        setScript(new SpinnerScript(this));
    }

    /**
     * Calculates an ideal size for decimal and rational spinners based on the length of the values in
     * the spinner range.
     *
     * @param mn the minimum value in the spinner range
     * @param mx the maximum value in the spinner range
     */
    private int getSize(double mn, double mx)
    {
        if ((mn == -1.0 || mn == 0.0) & mx == 1.0)
        {
            return 50;
        }
        else if (mn >-1 && mx <10)
        {
            return 50;
        }
        else if (mn > -10 && mx <100)
        {
            return 60;
        }
        else if (mn > -100 && mx <1000)
        {
            return 65;
        }
        else
        {
            return 70;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        getScript().run();
    }

    @Override
    public void update(Updating parent)
    {

    }

    /**
     * Wrapper class that allows values to be passd to the <code>SpinnerModel</code> constructor.
     */
    private class ComparableWrapper extends Number implements Comparable
    {

        private double number;

        private ComparableWrapper(Number val)
        {
            number = val.doubleValue();
        }

        @Override
        public int compareTo(Object o)
        {
            if(o instanceof Number)
            {
                Number object = (Number)o;
                Double dbl = object.doubleValue();
                if(number < dbl)
                {
                    return -1;
                }
                else if(number > dbl)
                {
                    return 1;
                }
                return 0;
            }
            else
            {
                throw new NumberFormatException();
            }
        }

        @Override
        public int intValue()
        {
            return (int)number;
        }

        @Override
        public long longValue()
        {
            return (long)number;
        }

        @Override
        public float floatValue()
        {
            return (float)number;
        }

        @Override
        public double doubleValue()
        {
            return number;
        }
    }
}

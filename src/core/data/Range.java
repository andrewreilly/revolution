/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.data;

/**
 * A numeric <code>Variables</code> object that has a limited range.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Range<V extends Number> extends Numeric<V>
{

    /**
     * The minimum value that this <code>Variables</code> object can take
     */
    private V min;

    /**
     * The maximum value that this <code>Variables</code> object can take
     */
    private V max;


    /**
     * Constructs a numeric <code>Variables</code> object that has a limited range.
     *
     * @param minValue the minimum value that this <code>Variables</code> object can take
     * @param maxValue the maximum value that this <code>Variables</code> object can take
     * @param value the initial value of this variable object
     */
    public Range(V minValue, V maxValue, V value)
    {
        super(value);
        min = minValue;
        max = maxValue;
        setValue(value);
    }

    @Override
    public void setValue(V value)
    {
        if(min == null | max == null)
        {
            super.setValue(value);
        }
        else
        {
            super.setValue(constrain(value));
        }

    }

    /**
     * Returns the minimum value that this <code>Variables</code> object can take
     *
     * @return the minimum value that this <code>Variables</code> object can take
     */
    public V getMin()
    {
        return min;
    }



    public void setMin(V min)
    {
        this.min = min;
    }

    /**
     * Returns the maximum value that this <code>Variables</code> object can take
     *
     * @return the maximum value that this <code>Variables</code> object can take
     */
    public V getMax()
    {
        return max;
    }

    /**
     * Sets the maximum value that this <code>Variables</code> object can take
     *
     * @param max the maximum value that this <code>Variables</code> object can take
     */
    public void setMax(V max)
    {
        this.max = max;
    }

    /**
     * Checks if the value is within the range set by this object and changes it to the nearest
     * allowable value if it isn't.
     *
     * @param value the value to be checked
     * @return the value of this <code>Variables</code> object after being checked
     */
    private V constrain(V value)
    {
        value = minLimit(value);
        return maxLimit(value);
    }

    /**
     * Checks if the value is above the minimum value set by this object and changes it to the minimum
     * if it isn't.
     *
     * @param value the value to be checked
     * @return the value of this <code>Variables</code> object after being checked
     */
    private V minLimit(V value)
    {
        if (value.doubleValue() < min.doubleValue())
        {
            return min;
        }
        return value;
    }

    /**
     * Checks if the value is below the maximum value set by this object and changes it to the maximum
     * if it isn't.
     *
     * @param value the value to be checked
     * @return the value of this <code>Variables</code> object after being checked
     */
    private V maxLimit(V value)
    {
        if (value.doubleValue() > max.doubleValue())
        {
            return max;
        }
        return value;
    }

}
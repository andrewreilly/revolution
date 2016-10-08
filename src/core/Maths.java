/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * An abstract class with static methods used for performing basic arithmetic operations. Values can
 * also be returned wrapped as <code>BigDecimal</code> objects.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public final class Maths
{

    private Maths(){}

    /**
     * Wraps <code>double</code> values as a <code>BigDecimal</code>.
     */
    public static BigDecimal wrap(double value)
    {
        return new BigDecimal(value, MathContext.DECIMAL32);
    }

    /**
     * Wraps <code>int</code> values as a <code>BigDecimal</code>.
     */
    public static BigDecimal wrap(int value)
    {
        return new BigDecimal(value, MathContext.DECIMAL32);
    }

    /**
     * Returns the sum of the given values.
     *
     * @param value1 the first value to be added
     * @param value2 the second value, which is added to value1
     * @return a <code>double</code> that is the sum of value1 and value2
     */
    public static double add(double value1, double value2)
    {
        BigDecimal value = wrap(value1).add(wrap(value2));
        return value.doubleValue();
    }

    /**
     * Returns the result of the second value subtracted from the first value.
     *
     * @param value1 the value to be subtracted from
     * @param value2 the value that is subtracted from value1
     * @return a <code>double</code> that results from the subtraction of value1
     * from value2
     */
    public static double subtract(double value1, double value2)
    {
        BigDecimal value = wrap(value1).subtract(wrap(value2));
        return value.doubleValue();
    }

    /**
     * Returns the result of a multiplication of the given values.
     *
     * @param value1 the first value to be multiplied
     * @param value2 the second value to be multiplied
     * @return a <code>double</code> that results from the multiplication of
     * value1 and value2
     */
    public static double multiply(double value1, double value2)
    {
        BigDecimal value = wrap(value1).multiply(wrap(value2));
        return value.doubleValue();
    }

    /**
     * Returns the result of a division of teh first value divided by the second value.
     *
     * @param value1 the dividend
     * @param value2 the divisor, or that value that value1 is divided by
     * @param scale the number of decimal places allowable in the result
     * @return a <code>double</code> that results from the division of
     * value1 by value2
     */
    public static double divide(double value1, double value2, int scale)
    {
        BigDecimal value = wrap(value1).divide(wrap(value2), scale, RoundingMode.HALF_EVEN);
        return value.doubleValue();
    }

    /**
     * Rounds a value up or down.
     *
     * @param value the value to be rounded
     * @param scale the number of decimal places the value is to be rounded to.
     * @return a <code>double</code> that results from the rounding operation
     */
    public static double round(double value, int scale)
    {
        BigDecimal bigDecimal = wrap(value);
        double result = bigDecimal.setScale(scale, RoundingMode.HALF_EVEN).doubleValue();
        return result;
    }
}

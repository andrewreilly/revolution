/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

/**
 * @author Andrew Reilly
 * @version 1.1.0
 */

package tests;

public class P
{

    public static void p(String s)
    {
        System.out.println(s);
    }

    public static void p(Object o)
    {
        System.out.println("" + o);
    }

    public static void s()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}

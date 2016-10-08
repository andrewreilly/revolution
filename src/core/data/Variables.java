/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */



package core.data;

import core.Updating;
import core.app.Nameable;

/**
 * Convenience class for <code>Variables</code> objects.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public interface Variables<V> extends Values<V>, Updating, Nameable
{

}

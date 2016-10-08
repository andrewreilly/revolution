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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The base class from which all major GUI elements inherit. This provides items and widgets
 * with a panel that has a blank border and a horizontal orientation.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public abstract class ActiveItem<C extends JComponent, V> extends TitledItem<C> implements Updating, ActionListener
{

    /**
     * A <code>Variables</code> object that this <code>ActiveItem</code> can be connected to.
     */
    private Variables<V> variable = null;

    /**
     * Indicates whether or not this <code>ActiveItem</code> has been updated since the associated
     * <code>Variables</code> object last changed.
     */
    private boolean hasUpdated = true;

    /**
     * The <code>Script</code> object that can be used to add functionality to this <code>ActiveItem</code>.
     */
    private Script script = null;


    /**
     * Creates an <code>ActiveItem</code> with a horizontal orientation and a blank border.
     */
    public ActiveItem()
    {
        super();
    }

    /**
     * Creates an <code>ActiveItem</code> with a horizontal orientation and a blank border that is
     * associated with the given <code>Variables</code> object.
     */
    public ActiveItem(Variables<V> variable, boolean showTitle)
    {
        setVariable(variable, showTitle);
    }

    /**
     * Creates an <code>ActiveItem</code> with a horizontal orientation and a blank border that is
     * associated with the given <code>Variables</code> object and runs the given <code>Script</code>.
     */
    public ActiveItem(Variables<V> variable, boolean showTitle, Script script)
    {
        setVariable(variable, showTitle);
        setScript(script);
    }

    /**
     * Creates an <code>ActiveItem</code> with a horizontal orientation and a blank border that is
     * connected to the given <code>Script</code> object.
     */
    public ActiveItem(Script script)
    {
        setScript(script);
    }

    /**
     * Sets the <code>Variables</code> object associated with this <code>ActiveItem</code>.
     *
     * @param variable a <code>Variables</code> object associated with this <code>ActiveItem</code>
     * @param showTitle indicates whether or not the variable dsiplay name should be displayed as a title
     *                  next to this <code>ActiveItem</code>
     */
    public void setVariable(Variables<V> variable, boolean showTitle)
    {
        this.variable = variable;
        if(showTitle)
        {
            setTitle(variable.getDisplayName());
        }
        ItemController.get().addChild(variable, this);
    }

    /**
     * Returns the <code>Variables</code> object associated with this <code>ActiveItem</code>.
     *
     * @return the <code>Variables</code> object associated with this <code>ActiveItem</code>
     */
    public Variables<V> getVariable()
    {
        return variable;
    }

    /**
     * Returns a <code>boolean</code> indicating whether or not a <code>Variables</code> object has
     * been associated with this <code>ActiveItem</code>.
     *
     * @return <code>true</code> if this <code>ActiveItem</code> has a <code>Variables</code> object
     * associated with it and <code>false</code> if it doesn't
     */
    public boolean hasVariable()
    {
        if(variable != null)
        {
            return true;
        }
        return false;
    }

    /**
     * Sets the <code>Script</code> that this <code>ActiveItem</code> runs when activated.
     *
     * @param script the <code>Script</code> that this <code>ActiveItem</code> runs when activated
     */
    public void setScript(Script script)
    {
        this.script = script;
    }

    /**
     * Returns the <code>Script</code> that this <code>ActiveItem</code> runs when activated.
     *
     * @return the <code>Script</code> that this <code>ActiveItem</code> runs when activated
     */
    public Script getScript()
    {
        return script;
    }

    /**
     * Runs the <code>Script</code> that is associated with this <code>ActiveItem</code>.
     */
    public void runScript()
    {
        if(getScript() != null)
        {
            getScript().run();
        }
    }

    /**
     * Overrides a method from the <code>ActionListener</code> interface that runs when this object is
     * activated and executes the <code>runScript()</code> method.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        runScript();
    }

    @Override
    public boolean hasUpdated()
    {
        return hasUpdated;
    }

    @Override
    public void hasUpdated(boolean hasUpdated)
    {
        this.hasUpdated = hasUpdated;
    }


}

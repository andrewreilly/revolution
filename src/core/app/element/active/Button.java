/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element.active;

import core.Updating;
import core.app.window.Windows;
import javax.swing.*;

/**
 * A class for creating buttons. Coding actions that occur when the button is pressed can be done by
 * passing a <code>Script</code> object to the constructor.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Button extends ActiveItem<JButton, Boolean> implements Buttons
{

    /**
     * Text displayed on the button
     */
    private String text = "";

    /**
     * A <code>Windows</code> that this button can be connected to. This is
     * typically used to create generic buttons for closing the <code>Window</code>
     * or manipulating its contents.
     */
    private Windows window = null;

    /**
     * Simple constructor for creating a button with no text.
     */
    public Button()
    {
        super();
        create("");
    }

    /**
     * Creates a <code>Button</code> with the specified text.
     *
     * @param text a <code>String</code> displayed by this <code>Button</code>
     */
    public Button(String text)
    {
        create(text);
    }

    /**
     * Creates a <code>Button</code> with the specified text and associates it with
     * the given <code>Windows</code> object.
     *
     * @param text a <code>String</code> displayed by this <code>Button</code>
     * @param window a <code>Windows</code> object that can be controlled by this <code>Button</code>
     */
    public Button(String text, Windows window)
    {
        this.window = window;
        create(text);
    }

    /**
     * Creates a <code>Button</code> with the specified text and the given <code>Script</code>.
     *
     * @param text a <code>String</code> displayed by this <code>Button</code>
     * @param script a <code>Script</code> object that is run when this <code>Button</code> is pressed
     */
    public Button(String text, Script script)
    {
        create(text);
        setScript(script);
    }

    /**
     * Creates a <code>Button</code> with the specified text and associates it with
     * the given <code>Windows</code> object.
     *
     * @param text a <code>String</code> displayed by this <code>Button</code>
     * @param window a <code>Windows</code> object that can be controlled by this <code>Button</code>
     * @param script a <code>Script</code> object that is run when this <code>Button</code> is pressed
     */
    public Button(String text, Windows window, Script script)
    {
        this.window = window;
        create(text);
        setScript(script);
    }

    /**
     * Creates a <code>Button</code> with the specified icon.
     *
     * @param icon an <code>Icon</code> displayed by this <code>Button</code>
     */
    public Button(Icon icon)
    {
        create(icon);
    }

    /**
     * Creates a <code>Button</code> with the specified icon and and associates it with
     * the given <code>Windows</code> object.
     *
     * @param icon an <code>Icon</code> displayed by this <code>Button</code>
     * @param window a <code>Windows</code> object that can be controlled by this <code>Button</code>
     */
    public Button(Icon icon, Windows window)
    {
        this.window = window;
        create(icon);
    }

    /**
     * Creates a <code>Button</code> with the specified icon.
     *
     * @param icon an <code>Icon</code> displayed by this <code>Button</code>
     * @param script a <code>Script</code> object that is run when this <code>Button</code> is pressed
     */
    public Button(Icon icon, Script script)
    {
        create(icon);
        setScript(script);
    }

    /**
     * Creates a <code>Button</code> with the specified icon and  and associates it with
     * the given <code>Windows</code> object.
     *
     * @param icon an <code>Icon</code> displayed by this <code>Button</code>
     * @param window a <code>Windows</code> object that can be controlled by this <code>Button</code>
     * @param script a <code>Script</code> object that is run when this <code>Button</code> is pressed
     */
    public Button(Icon icon, Windows window, Script script)
    {
        this.window = window;
        create(icon);
        setScript(script);
    }

    /**
     * Creates the <code>JButton</code> component and adds this object as as
     * <code>ActionListener</code>. Also sizes the button according to the text size.
     *
     * @param text a <code>String</code> displayed by this <code>Button</code>
     */
    protected void create(String text)
    {
        JButton button = new JButton(text);
        button.addActionListener(this);
        setComponent(button);
        int textWidth = getFontMetrics(getFont()).stringWidth(text);
        setSize(textWidth + 40, componentHeight);
    }

    /**
     * Creates the <code>JButton</code> component and adds this object as as
     * <code>ActionListener</code>. Also sizes the button according to the text size.
     *
     * @param icon an <code>Icon</code> displayed by this <code>Button</code>
     */
    private void create(Icon icon)
    {
        JButton button = new JButton(icon);
        button.addActionListener(this);
        setComponent(button);
        setSize(20, 20);
    }

    /**
     * Returns the text displayed by this <code>Button</code>.
     *
     * @return text a <code>String</code> displayed by this <code>Button</code>
     */
    public String getText()
    {
        return text;
    }

    /**
     * Sets the text displayed by this <code>Button</code>.
     *
     * @param text a <code>String</code> to be displayed by this <code>Button</code>
     */
    public void setText(String text)
    {
        this.text = text;
        getComponent().setText(text);
    }

    @Override
    public Windows getWindow()
    {
        return window;
    }

    @Override
    public void setWindow(Windows window)
    {
        this.window = window;
    }

    /**
     * This method does not have any functionality in the <code>Button</code> class.
     */
    @Override
    public void update(Updating parent)
    {

    }

}

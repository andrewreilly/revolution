/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.element;

import core.app.Text;
import javax.swing.*;
import java.awt.*;

/**
 * A class for creating labels. These can be either text or image labels.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Label extends Item<JLabel>
{

    /**
     * The default <code>Font</code>
     */
    private static Font defaultFont = Text.BUTTON;

    /**
     * Creates a <code>Label</code> with the specified text.
     */
    public Label(String text)
    {
        JLabel label = new JLabel(text);
        label.setFont(defaultFont);
        int textWidth = getFontMetrics(label.getFont()).stringWidth(text);
        setComponent(label);
        setSize(textWidth, componentHeight);
    }

    /**
     * Creates a <code>Label</code> with the specified <code>Text</code>
     * object.
     *
     * @param text a <code>String</code> displayed by this <code>Label</code>
     */
    public Label(Text text)
    {
        JLabel label = new JLabel(text.getText());
        label.setFont(text.getFont());
        int textWidth = getFontMetrics(label.getFont()).stringWidth(text.getText());
        setComponent(label);
        setSize(textWidth, componentHeight);
    }

    /**
     * Creates a <code>Label</code> with the specified <code>ImageIcon</code>.
     *
     * @param image an <code>ImageIcon</code> displayed by this <code>Label</code>
     */
    public Label(ImageIcon image)
    {
        JLabel label = new JLabel(image);
        setComponent(label);
    }

    /**
     * Sets the the text displayed by this <code>Label</code>.
     *
     * @param text a <code>String</code> displayed by this <code>Label</code>
     */
    public void setText(String text)
    {
        int textWidth = getFontMetrics(getComponent().getFont()).stringWidth(text);
        setSize(textWidth, componentHeight);
        getComponent().setText(text);
    }

    /**
     * Returns the the text displayed by this <code>Label</code>.
     *
     * @return the <code>String</code> displayed by this <code>Label</code>
     */
    public String getText()
    {
        return getComponent().getText();
    }

    /**
     * Sets the the image displayed by this <code>Label</code>.
     *
     * @param image an <code>ImageIcon</code> displayed by this <code>Label</code>
     */
    public void setImage(ImageIcon image)
    {
        getComponent().setIcon(image);
    }

    /**
     * Returns the default <code>Font</code>.
     *
     * @return the default <code>Font</code>
     */
    public static Font getDefaultFont()
    {
        return defaultFont;
    }

    /**
     * Creates and returns a <code>JLabel</code> that displays the given text.
     *
     *@param text a <code>String</code> displayed by this <code>Label</code>
     */
    public static JLabel getLabel(Text text)
    {
        JLabel returnedLabel = new JLabel(text.getText());
        returnedLabel.setFont(text.getFont());
        int textWidth = returnedLabel.getFontMetrics(text.getFont()).stringWidth(text.getText());
        returnedLabel.setSize(new Dimension(textWidth, componentHeight));
        return returnedLabel;
    }

    /**
     * Returns the <code>JLabel</code> held by this <code>Item</code>.
     *
     * @return the <code>JLabel</code> held by this <code>Item</code>
     */
    public JLabel getLabel()
    {
        return getComponent();
    }

    /**
     * Sets the <code>JLabel</code> held by this <code>Item</code>.
     *
     * @param label <code>JLabel</code> to held by this <code>Item</code>
     */
    public void setLabel(JLabel label)
    {
        setComponent(label);
    }
}
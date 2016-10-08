/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app;

import java.awt.*;

/**
 * This class provides a wrapper for strings and fonts so that formatting
 * information can be passed along with the string when creating labels etc.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Text
{

    /**
     * Title font for panels and headings
     */
    public static Font TITLE = new Font("SansSerif", Font.BOLD, 12);

    /**
     * Font for plain text
     */
    public static Font TEXT = new Font("Serif",Font.PLAIN, 14);

    /**
     * Font for notes and annotations
     */
    public static Font NOTE = new Font("Serif",Font.ITALIC, 12);

    /**
     * Font for buttons and other components that display text
     */
    public static Font BUTTON = new Font("SansSerif",Font.PLAIN, 12);

    /**
     * Font for instructions to the user
     */
    public static Font INSTRUCTION = new Font("SansSerif",Font.ITALIC, 12);

    /**
     * Font for output data, timers etc
     */
    public static Font OUTPUT = new Font("Monospaced",Font.PLAIN, 12);

    /**
     * A large font for displaying important information
     */
    public static Font LARGE = new Font("SansSerif",Font.PLAIN, 22);

    /**
     * Text to be displayed
     */
    protected String text = null;

    /**
     * Font that is used to display the text
     */
    protected Font font = null;

    /**
     * Constructor for wrapping the string using the <code>TEXT</code> font
     *
     * @param text the <code>String</code> containing the text to be displayed
     */
    public Text(String text)
    {
        this.text = text;
        font = TEXT;
    }

    /**
     * Constructor for wrapping the string and the font
     *
     * @param text the <code>String</code> containing the text to be displayed
     * @param font the <code>Font</code> that is used to display the text
     */
    public Text(String text, Font font)
    {
        this.text = text;
        this.font = font;
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.TITLE</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.TITLE</code>
     * and the specified <code>String</code>.
     */
    public static Text getTitle(String text)
    {
        return new Text(text, TITLE);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.TEXT</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.TEXT</code>
     * and the specified <code>String</code>.
     */
    public static Text getText(String text)
    {
        return new Text(text, TEXT);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.NOTE</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.NOTE</code>
     * and the specified <code>String</code>.
     */
    public static Text getNote(String text)
    {
        return new Text(text, NOTE);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.BUTTON</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.BUTTON</code>
     * and the specified <code>String</code>.
     */
    public static Text getButton(String text)
    {
        return new Text(text, BUTTON);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.INSTRUCTION</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.INSTRUCTION</code>
     * and the specified <code>String</code>.
     */
    public static Text getInstruction(String text)
    {
        return new Text(text, INSTRUCTION);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.OUTPUT</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.OUTPUT</code>
     * and the specified <code>String</code>.
     */
    public static Text getOutput(String text)
    {
        return new Text(text, OUTPUT);
    }

    /**
     * Creates and returns a <code>Text</code> instance with a <code>Font.LARGE</code>
     * font and the specified <code>String</code>.
     *
     * @param text the <code>String</code> that is displayed
     * @return a <code>Text</code> instance created with a <code>Font.LARGE</code>
     * and the specified <code>String</code>.
     */
    public static Text getLarge(String text)
    {
        return new Text(text, LARGE);
    }

    /**
     * Returns the <code>Font</code> used to display the text.
     *
     * @return the <code>Font</code> used to display the text
     */
    public Font getFont()
    {
        return font;
    }

    /**
     * Sets the <code>Font</code> used to display the text.
     *
     * @param font the <code>Font</code> used to display the text
     */
    public void setFont(Font font)
    {
        this.font = font;
    }

    /**
     * Returns the text <code>String</code> that is displayed.
     *
     * @return the text <code>String</code> that is displayed
     */
    public String getText()
    {
        return text;
    }

    /**
     * Returns the text <code>String</code> to display.
     *
     * @param text the text <code>String</code> that is displayed
     */
    public void setText(String text)
    {
        this.text = text;
    }

}

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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Factory class for creating panel borders.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Borders
{

    /**
     * An empty border
     */
    public final static int NONE = 0;

    /**
     * An etched border without a title
     */
    public final static int PLAIN = 1;

    /**
     * An etched border with a title in <code>Text.BUTTON</code> font
     */
    public final static int TITLED = 2;

    /**
     * An etched border with a bold title in <code>Text.BUTTON</code> font
     */
    public final static int BOLD_TITLED = 3;

    /**
     * Constructor included to prevent an instance of this class being created.
     */
    private Borders()
    {

    }

    /**
     * Returns one of the four preset borders available according to the
     * parameters provided. Note that titles do not apply to <code>NONE</code>
     * or <code>PLAIN</code> borders.
     *
     * @param border 0 = <code>NONE</code>, 1 = <code>PLAIN</code>, 2 = <code>TITLED</code> and 3 = <code>BOLD_TITLED</code>
     * @param title the title to be displayed with this border
     */
    static Border getBorder(int border, String title)
    {
        if(border == NONE | border > 3)
        {
            return BorderFactory.createEmptyBorder(3, 3, 3, 3);
        }
        else if(border == PLAIN)
        {
            return BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        }
        else if(border == TITLED)
        {
            return BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), title, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, Text.BUTTON);
        }
        else
        {
            return BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), title,TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, Text.TITLE);
        }
    }

}

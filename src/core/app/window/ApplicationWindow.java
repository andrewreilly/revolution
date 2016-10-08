/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.window;

import javax.swing.*;
import java.awt.*;

/**
 * This class extends the <code>Window</code> class and provides the parent window for the whole
 * application. Closing this window will exit the application.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ApplicationWindow extends Window
{
    private static ApplicationWindow instance = null;

    /**
     * Returns the instance of this object.
     *
     * @return the instance of this object
     */
    public static ApplicationWindow get()
    {
        return instance;
    }

    /**
     * Creates an <code>ApplicationWindow</code> with a <code>JMenuBar</code> and a <code>ToolBar</code>
     * with the current system look-and-feel.
     */
    public ApplicationWindow(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance = this;
        addMenuBar();

        // TODO
//        if(ControlManager.get().hasMenuItems())
//        {
//            for(String menuName : ControlManager.get().getMenuNames())
//            {
//                JMenu menu = new JMenu(menuName);
//                getJMenuBar().add(menu);
//                for(String menuItemName : ControlManager.get().getMenuReference().get(menuName))
//                {
//                    JMenuItem menuItem = ControlManager.get().getMenuItem(menuItemName);
//                    menu.add(menuItem);
//                }
//            }
//        }
//        if(ControlManager.get().hasButtons())
//        {
//            getContentPane().add(getJToolBar(), BorderLayout.NORTH);
//            for(String moduleName : ControlManager.get().getModuleNames())
//            {
//                boolean hasAddedButton = false;
//                for(String controlName : ControlManager.get().getModuleReference().get(moduleName))
//                {
//                    Button button = ControlManager.get().getButton(controlName);
//                    if(button != null)
//                    {
//                        getJToolBar().add(button);
//                        hasAddedButton = true;
//                    }
//                }
//                if(hasAddedButton)
//                {
//                    getJToolBar().addSeparator();
//                }
//            }
//        }
        update();
    }
}

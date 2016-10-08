/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.window;

import core.app.element.Borders;
import core.app.element.Element;
import core.app.element.HorizontalPanel;
import core.app.element.Item;
import core.app.element.Layouter;
import core.app.element.Layouts;
import core.app.element.LineLayout;
import core.app.element.active.Button;
import core.app.element.active.ConfirmButton;
import core.app.element.active.DisconfirmButton;
import core.image.ImageFetcher;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * * A class that extends <code>JFrame</code> to create a window with a
 * <code>Panel</code>. The Revolution logo (icon.jpg) is the default icon.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Window extends JFrame implements Windows
{

    /**
     * <code>Toolkit</code> instance used to get information about the system such as the screen size
     * and to set window icons.
     */
    private static Toolkit toolKit = Toolkit.getDefaultToolkit();

    /**
     * The <code>Layout</code> used by this window to hold components.
     */
    private Layouter layouter;

    /**
     * A <code>JMenuBar<code> object for creating drop-down menus.
     */
    private JMenuBar menuBar = null;

    /**
     * A <code>JToolBar<code> object for creating toolbar buttons.
     */
    private JToolBar toolBar = null;

    /**
     * A button confirming the information displayed by this window.
     */
    private ConfirmButton confirmButton = null;

    /**
     * A button disconfirming or cancelling the information displayed by this window.
     */
    private DisconfirmButton disconfirmButton = null;

    /**
     * Indicates whether or not the user has confirmed the information shown in this window.
     * Default value is <code>true</code>.
     */
    private boolean isConfirmed = true;

    /**
     * Creates an empty <code>Window</code> 200 pixels wide and 120 pixels high.
     */
    public Window()
    {
        super();
        setIconImage(ImageFetcher.get().getImage("ICON_16.gif"));
        setMinimumSize(new Dimension(200, 120));
        create();
    }

    /**
     * Creates an empty <code>Window</code> 200 pixels wide and 120 pixels high with a <code>String</code>
     * title.
     *
     * @param title a <code>String</code> title of the window
     */
    public Window(String title)
    {
        super(title);
        setIconImage(ImageFetcher.get().getImage("ICON_16.gif"));
        setMinimumSize(new Dimension(200, 120));
        create();
    }

    /**
     * Places the <code>Window</code> in the centre of the screen.
     */
    public void centre()
    {
        Dimension screenSize = toolKit.getScreenSize();
        int x = (int)((screenSize.getWidth() - getWidth()) / 2);
        int y = (int)((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    /**
     * Sets the <code>Window</code> size to that of the screen.
     */
    public void fullscreen()
    {
        Dimension screenSize = toolKit.getScreenSize();
        int width = (int)(screenSize.getWidth());
        int height = (int)(screenSize.getHeight() - getHeight());
        setSize(width, height);
        setExtendedState(MAXIMIZED_BOTH);
    }

    @Override
    public Layouter getLayouter()
    {
        return layouter;
    }

    @Override
    public void setLayouter(Layouter layouter)
    {
        remove(this.layouter);
        this.layouter = layouter;
        add(layouter, BorderLayout.CENTER);
    }

    @Override
    public void addConfirmButton(String confirmButtonName)
    {
        confirmButton = new ConfirmButton(confirmButtonName, this);
        Element buttonElement = new Element();
        buttonElement.add(confirmButton);
        addConfirmationButtonsToLayout(buttonElement);
    }

    @Override
    public void addDisconfirmButton(String disconfirmButtonName)
    {
        disconfirmButton = new DisconfirmButton(disconfirmButtonName, this);
        Element buttonElement = new Element();
        buttonElement.add(disconfirmButton);
        addConfirmationButtonsToLayout(buttonElement);
    }

    @Override
    public void addConfirmationButtons(String confirmButtonName, String disconfirmButtonName)
    {
        confirmButton = new ConfirmButton(confirmButtonName, this);
        disconfirmButton = new DisconfirmButton(disconfirmButtonName, this);

        Element buttonElement = new Element(new LineLayout(), Borders.NONE);
        buttonElement.add(confirmButton);
        buttonElement.add(disconfirmButton);
        addConfirmationButtonsToLayout(buttonElement);
    }

    /**
     * Used by the methods adding confirmation buttons, both of which are positioned on the
     * <code>Element</code>
     */
    private void addConfirmationButtonsToLayout(Element element)
    {
        layouter.getBottom().setLineLayout(Layouts.RIGHT, Layouts.BOTTOM);
        layouter.add(element, Layouts.BOTTOM);
        update();
    }

    @Override
    public void confirm()
    {
        isConfirmed = true;
        close();
    }

    @Override
    public void disconfirm()
    {
        isConfirmed = false;
        close();
    }

    @Override
    public boolean isConfirmed()
    {
        return isConfirmed;
    }

    @Override
    public void isConfirmed(boolean isConfirmed)
    {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public ConfirmButton getConfirmButton()
    {
        return confirmButton;
    }

    @Override
    public DisconfirmButton getDisconfirmButton()
    {
        return disconfirmButton;
    }

    @Override
    public void setFocusOn(Button button)
    {
        getRootPane().setDefaultButton(button.getComponent());
        button.getComponent().requestFocusInWindow();
    }

    @Override
    public void setFocusOnConfirmButton()
    {
        getRootPane().setDefaultButton(confirmButton.getComponent());
        confirmButton.getComponent().requestFocusInWindow();
    }

    @Override
    public void setFocusOnDisconfirmButton()
    {
        getRootPane().setDefaultButton(disconfirmButton.getComponent());
        disconfirmButton.getComponent().requestFocusInWindow();
    }

    @Override
    public void close()
    {
        setVisible(false);
        dispose();
    }

    /**
     * Revalidates repaints the <code>Window</code>.
     */
    public void update()
    {
        validate();
        repaint();
    }

    /**
     * Revalidates, packs and repaints the <code>Window</code>.
     */
    public void packAndUpdate()
    {
        validate();
        pack();
        repaint();
    }

    /**
     * Creates and adds the <code>Layouter</code> that is used as a container for content in this <
     * code>Window</code>.
     */
    private void create()
    {
        layouter = new Layouter();
        add(layouter, BorderLayout.CENTER);
    }

    /**
     * Adds a <code>JMenuBar</code> to this window.
     */
    public void addMenuBar()
    {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
    }

    /**
     * Returns the <code>JMenuBar</code> attached to this window.
     *
     * @return the <code>JMenuBar</code> attached to this window and null if there is none
     */
    public JMenuBar getJMenuBar()
    {
        return menuBar;
    }

    /**
     * Adds a <code>JToolBar</code> to this window.
     */
    public void addToolBar()
    {
        toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);
    }

    /**
     * Returns the <code>JToolBar</code> attached to this window.
     *
     * @return the <code>JToolBar</code> attached to this window and null if there is none
     */
    public JToolBar getJToolBar()
    {
        return toolBar;
    }

    /**
     * Adds an <code>Item</code> to the menu bar, if there is one.
     *
     * @param item the <code>Item</code> to be added to the menu bar
     */
    public void addMenuItem(Item item)
    {
        if(menuBar != null)
        {
            menuBar.add(item);
        }
    }

    /**
     * Adds an <code>Item</code> to the tool bar, if there is one.
     *
     * @param item the <code>Item</code> to be added to the tool bar
     */
    public void addToolItem(Item item)
    {
        if(toolBar != null)
        {
            toolBar.add(item);
        }
    }



}
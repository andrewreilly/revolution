/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.window;

import core.app.element.Element;
import core.app.element.Layouter;
import core.app.element.Layouts;
import core.app.element.active.Button;
import core.app.element.active.ConfirmButton;
import core.app.element.active.DisconfirmButton;
import core.image.ImageFetcher;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * A class that extends <code>JDialog</code> to create a dialog with a
 * <code>Panel</code>. The Revolution logo (icon.jpg) is the default icon.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class Dialog extends JDialog implements Windows
{

    /**
     * <code>Toolkit</code> instance used to get information about the system such as the screen size
     * and to set window icons.
     */
    private static Toolkit toolKit = Toolkit.getDefaultToolkit();

    /**
     * The <code>Layouter</code> used by this window to hold components.
     */
    private Layouter layouter;

    /**
     * A button used to confirm information presented in this dialog, usually "Ok" or "Yes"
     */
    private ConfirmButton confirmButton = null;

    /**
     * A button used to disconfirrm information presented in this dialog, usually "Cancel" or "No"
     */
    private DisconfirmButton disconfirmButton = null;

    /**
     * A value indicating whether or not the user confirmed the information presented in this dialog.
     */
    private boolean isConfirmed;

    /**
     * Constructor for creating a dialog that is attached to a <code>Window</code>
     */
    public Dialog(Window parent, String title)
    {
        super(parent, title);
        create();
    }

    /**
     * Constructor for creating a dialog that is attached to a <code>Dialog</code>
     */
    public Dialog(Dialog parent, String title)
    {
        super(parent, title);
        create();
    }

    /**
     * Creates the <code>Dialog</code>, setting the icon and layout.
     */
    private void create()
    {
        setIconImage(toolKit.getImage(ImageFetcher.class.getResource("ICON_16.gif")));
        layouter = new Layouter();
        add(layouter);
        setModal(true);
        setAlwaysOnTop(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
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
        Element buttonElement = new Element();
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

    public ConfirmButton getConfirmButton()
    {
        return confirmButton;
    }

    public DisconfirmButton getDisconfirmButton()
    {
        return disconfirmButton;
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
     * Calls <code>update()</code>, <code>centre()</code> and <code>setVisible(true)</code> on this
     * dialog.
     *
     * @return the <code>DisconfirmButton</code> used by this window
     */
    public void showDialog()
    {
        update();
        centre();
        setVisible(true);
    }

    /**
     * Places the dialog in the centre of the screen.
     */
    public void centre()
    {
        Dimension screenSize = toolKit.getScreenSize();
        int x = (int)((screenSize.getWidth() - getWidth()) / 2);
        int y = (int)((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
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

}

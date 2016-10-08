/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.app.window;

import core.app.element.Label;
import core.app.element.Layouts;
import core.image.ImageFetcher;

/**
 * This class is used to create small dialog windows with a messageLabel such as an error. These are typically
 * created using one of the static factory methods.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class MessageDialog extends Dialog
{

    private Label messageLabel;

    private Label iconLabel;


    /**
     * Creates an <code>MessageDialog</code> window containing all of the panels but without any content.
     *
     * @param title the <code>String</code> this <code>Dialog</code> window
     */
    public MessageDialog(String title)
    {
        super(ApplicationWindow.get(), "");
        getLayouter().getCentre().setLineLayout();
        setIconLabel(new Label(ImageFetcher.get().getImageIcon("ICON_64.gif")));
        getLayouter().add(getIconLabel());
        setMessageLabel(new Label(title));
        getLayouter().add(getMessageLabel());
        getLayouter().getBottom().setLineLayout();
        setAlwaysOnTop(true);
    }

    /**
     * Returns the <code>Label</code> containing the message displayed by this dialog.
     *
     * @return the <code>Label</code> containing the message displayed by this dialog
     */
    public Label getMessageLabel()
    {
        return messageLabel;
    }

    /**
     * Sets the <code>Label</code> containing the message displayed by this dialog.
     *
     * @return the <code>Label</code> containing the message displayed by this dialog
     */
    public void setMessageLabel(Label messageLabel)
    {
        this.messageLabel = messageLabel;
    }

    /**
     * Returns the <code>Label</code> containing the icon displayed by this dialog.
     *
     * @return the <code>Label</code> containing the icon displayed by this dialog
     */
    public Label getIconLabel()
    {
        return iconLabel;
    }

    /**
     * Sets the <code>Label</code> containing the icon displayed by this dialog.
     *
     * @return the <code>Label</code> containing the icon displayed by this dialog
     */
    public void setIconLabel(Label iconLabel)
    {
        this.iconLabel = iconLabel;
    }

    /**
     * Sets the message to display in this dialog.
     *
     * @param messageText a <code>String</code> containing the messageLabel to be displayed.
     */
    public void setMessage(String messageText)
    {
        getMessageLabel().setText(messageText);
    }

    /**
     * Returns the message displayed in this dialog.
     *
     * @return a <code>String</code> containing the message displayed in this dialog
     */
    public String getMessage()
    {
        return getMessageLabel().getText();
    }

    /**
     * Displays a <code>MessageDialog</code> with an error.
     *
     * @param errorMessage <code>String</code> containing an error to display
     */
    public static void showErrorDialog(String errorMessage)
    {
        MessageDialog errorDialog = new MessageDialog(errorMessage);
        errorDialog.setTitle("Error");
        errorDialog.getIconLabel().setImage(ImageFetcher.get().getImageIcon("ERROR_64.gif"));
        errorDialog.addConfirmButton("Ok");
        errorDialog.showDialog();
    }

    /**
     * Displays a <code>MessageDialog</code> with information.
     *
     * @param infoMessage <code>String</code> containing information to display
     */
    public static void showInfoDialog(String infoMessage)
    {
        MessageDialog infoDialog = new MessageDialog(infoMessage);
        infoDialog.setTitle("Information");
        infoDialog.getIconLabel().setImage(ImageFetcher.get().getImageIcon("INFO_64.gif"));
        infoDialog.addConfirmButton("Ok");
        infoDialog.showDialog();
    }

    /**
     * Displays a <code>MessageDialog</code> with a warning.
     *
     * @param warningMessage <code>String</code> containing a warning to display
     */
    public static void showWarningDialog(String warningMessage)
    {
        MessageDialog warningDialog = new MessageDialog(warningMessage);
        warningDialog.setTitle("Warning");
        warningDialog.getIconLabel().setImage(ImageFetcher.get().getImageIcon("WARNING_64.gif"));
        warningDialog.addConfirmButton("Ok");
        warningDialog.showDialog();
    }

    /**
     * Displays a <code>MessageDialog</code> with a question.
     *
     * @param question <code>String</code> containing a question to display
     */
    public static boolean showQuestionDialog(String question)
    {
        MessageDialog questionDialog = new MessageDialog(question);
        questionDialog.setTitle("");
        questionDialog.getIconLabel().setImage(ImageFetcher.get().getImageIcon("QUESTION_64.gif"));
        questionDialog.addConfirmationButtons("Yes", "No");
        questionDialog.showDialog();
        return questionDialog.isConfirmed();
    }


}
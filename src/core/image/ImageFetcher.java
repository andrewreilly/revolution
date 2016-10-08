/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

package core.image;

import core.app.window.MessageDialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

/**
 * A singleton for retrieving images from the images folder.
 *
 * @author Andrew Reilly
 * @version 1.1.0
 */
public class ImageFetcher
{
    private static ImageFetcher instance = new ImageFetcher();

    public static ImageFetcher get()
    {
        return instance;
    }

    /**
     * Retrieves a loaded icon using the image file name
     *
     * @param filename the name of the file containing the icon to be retrieved
     * @return an <code>ImageIcon</code> corresponding to the given file name
     */
    public final ImageIcon getImageIcon(String filename)
    {
        ImageIcon image = null;
        try
        {
            image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(ImageFetcher.class.getResource(filename)));
        }
        catch (Exception e)
        {
            MessageDialog.showErrorDialog("Cannot retrieve image file " + filename);
        }
        return image;
    }

    /**
     * Retrieves a loaded image using the image file name
     *
     * @param filename the name of the file containing the image to be retrieved
     * @return an <code>Image</code> corresponding to the given file name
     */
    public final Image getImage(String filename)
    {
        Image image = null;
        try
        {
            image = Toolkit.getDefaultToolkit().getImage(ImageFetcher.class.getResource(filename));
        }
        catch (Exception e)
        {
            MessageDialog.showErrorDialog("Cannot retrieve image file " + filename);
        }
        return image;
    }
}

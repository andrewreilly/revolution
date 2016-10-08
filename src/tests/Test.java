/*
 *
 * Copyright 2016 by Andrew Reilly
 * Licensed under the Academic Free License version 3.0
 * See the file "LICENSE" for more information
 *
 */

/**
 * @author Andrew Reilly
 * @version 1.1.0
 */

package tests;

import core.app.element.Borders;
import core.app.element.HorizontalPanel;
import core.app.element.Label;
import core.app.element.Layouter;
import core.app.element.Layouts;
import core.app.element.LineLayout;
import core.app.element.ListLayout;
import core.app.element.Panel;
import core.app.element.VerticalPanel;
import core.app.element.active.CheckBox;
import core.app.element.active.Meter;
import core.app.element.active.Spinner;
import core.app.element.active.ToggleButton;
import core.app.window.ApplicationWindow;
import core.app.window.Window;
import core.data.*;

import javax.swing.*;


public class Test
{




    public Test()
    {
        ApplicationWindow app = new ApplicationWindow("Test");
        app.centre();
        app.setVisible(true);

        app.getLayouter().getCentre().setListLayout(Layouts.CENTRE, Layouts.CENTRE);
        app.getLayouter().getLeft().setListLayout(Layouts.LEFT, Layouts.TOP);

        Label label = new Label("Label");
        app.getLayouter().add(label);

        Variables<Boolean> booleanVariable = new Variable<>(true);
        booleanVariable.setDisplayName("Boolean variable");

        ToggleButton toggleButton1 = new ToggleButton(booleanVariable, "True", "False");
        app.getLayouter().add(toggleButton1, Layouts.LEFT);

        ToggleButton toggleButton2 = new ToggleButton(booleanVariable, "True", "False");
        app.getLayouter().add(toggleButton2);

        CheckBox checkBox = new CheckBox(booleanVariable, true);
        app.getLayouter().add(checkBox, Layouts.LEFT);

        Range<Integer> spinnerVariable = new Range<>(1, 10000, 1);
        Spinner spinner = new Spinner<>(spinnerVariable, true);
        app.getLayouter().add(spinner);

        Meter<Integer> integerMeter = new Meter<>(spinnerVariable, false);
        app.getLayouter().add(integerMeter);

        Standard standard = new Standard(true);
        Spinner standardSpinner = new Spinner<>(standard, true);
        app.getLayouter().add(standardSpinner);

        Meter<Boolean> meter = new Meter<>(booleanVariable, false);
        app.getLayouter().add(meter);

        app.addConfirmationButtons("Ok", "Cancel");

        app.packAndUpdate();

//        Window window = new Window();
//        window.getLayouter().getLeft().setLayouts(new LineLayout(Layouts.RIGHT, Layouts.BOTTOM));
//        window.getLayouter().getLeft().setBorder(BorderFactory.createEtchedBorder());
//
//        Label label1 = new Label("Really quite long");
//        window.getLayouter().addElement(label1, Layouts.LEFT);
//        Label label2 = new Label("Short");
//        window.getLayouter().addElement(label2, Layouts.LEFT);
//
//        getPanelDetails(window.getLayouter().getLeft());

//        Panel panel = new Panel();
//
//        Variables<Boolean> booleanVariable = new Variable<>(true);
//        CheckBox checkBox = new CheckBox(booleanVariable, true);
//        checkBox.setElementBorder(Borders.PLAIN);
//        panel.add(checkBox);
//        window.add(panel);

//        window.setVisible(true);



    }

    public void getPanelDetails(Panel panel)
    {
        P.p("X: " + panel.getLayouts().getX() + " " + panel.getComponents()[0].getAlignmentX());
        P.p("Y: " + panel.getLayouts().getY() + " " + panel.getComponents()[0].getAlignmentY());
        BoxLayout layout = (BoxLayout)panel.getLayout();
        P.p("Axis: " + panel.getLayouts().getAxis() + " " + layout.getAxis());
        P.p("Orientation: " + panel.getLayouts().getComponentOrientation().isLeftToRight() + " " + panel.getComponentOrientation().isLeftToRight());
    }

}

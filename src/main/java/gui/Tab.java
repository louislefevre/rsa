package gui;

import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Tab
{
    abstract String getTitle();

    abstract Component createComponent();

    ActionListener activate()
    {
        return event ->
        {
            throw new UnsupportedOperationException("Functionality has not been implemented.");
        };
    }
}

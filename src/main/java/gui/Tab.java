package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Tab
{
    static final int COLUMNS = 50;
    static final int ROWS = 10;

    abstract String getTitle();

    abstract Component createComponent();

    ActionListener activate()
    {
        return event ->
        {
            throw new UnsupportedOperationException("Functionality has not been implemented.");
        };
    }

    static JTextArea createTextArea(String title)
    {
        JTextArea textArea = new JTextArea(ROWS, COLUMNS);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createTitledBorder(title));
        return textArea;
    }

    static JTextArea createEditableTextArea(String title)
    {
        JTextArea textArea = createTextArea(title);
        textArea.setEditable(true);
        return textArea;
    }

    static JTextArea createNonEditableTextArea(String title)
    {
        JTextArea textArea = createTextArea(title);
        textArea.setEditable(false);
        return textArea;
    }

    static Component addAreaPadding(int width, int height)
    {
        return Box.createRigidArea(new Dimension(width, height));
    }
}

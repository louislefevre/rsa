package gui;

import javax.swing.*;
import java.awt.*;

final class InterfaceUtilities
{
    public static final int COLUMNS = 50;
    public static final int ROWS = 10;

    private InterfaceUtilities()
    {
        throw new UnsupportedOperationException();
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

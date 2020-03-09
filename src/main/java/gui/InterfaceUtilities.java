package util;

import javax.swing.*;
import java.awt.*;

public final class InterfaceUtilities
{
    public static final int COLUMNS = 40;
    public static final int ROWS = 5;

    private InterfaceUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static JTextArea createTextArea(String title)
    {
        JTextArea textArea = new JTextArea(ROWS, COLUMNS);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createTitledBorder(title));
        return textArea;
    }

    public static JTextArea createEditableTextArea(String title)
    {
        JTextArea textArea = createTextArea(title);
        textArea.setEditable(true);
        return textArea;
    }

    public static JTextArea createNonEditableTextArea(String title)
    {
        JTextArea textArea = createTextArea(title);
        textArea.setEditable(false);
        return textArea;
    }

    public static Component addAreaPadding(int width, int height)
    {
        return Box.createRigidArea(new Dimension(width, height));
    }
}

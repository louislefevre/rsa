package gui;

import javax.swing.*;
import java.awt.*;

public final class MainInterface extends JFrame
{
    private final static String TITLE = "RSA";

    public MainInterface()
    {
        assembleInterface();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void assembleInterface()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3;
        double height = screenSize.height / 1.25;
        setBounds(0, 0, width, (int)height);

        JTabbedPane tabPane = new JTabbedPane();
        GenerateKeysTab keysTab = new GenerateKeysTab();
        EncryptTab encryptTab = new EncryptTab();
        DecryptTab decryptTab = new DecryptTab();

        tabPane.addTab(keysTab.getTitle(), keysTab.createComponent());
        tabPane.addTab(encryptTab.getTitle(), encryptTab.createComponent());
        tabPane.addTab(decryptTab.getTitle(), decryptTab.createComponent());

        super.setTitle(TITLE);
        super.add(tabPane);
        super.pack();
        super.setVisible(true);
    }
}

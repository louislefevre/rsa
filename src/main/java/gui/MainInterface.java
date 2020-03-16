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
        double width = screenSize.width * 0.5;
        double height = screenSize.height * 0.9;
        setBounds(0, 0, (int)width, (int)height);

        JTabbedPane tabPane = new JTabbedPane();
        GenerateKeysTab keysTab = new GenerateKeysTab();
        EncryptTab encryptTab = new EncryptTab();
        DecryptTab decryptTab = new DecryptTab();

        tabPane.addTab(keysTab.getTitle(), keysTab.createComponent());
        tabPane.addTab(encryptTab.getTitle(), encryptTab.createComponent());
        tabPane.addTab(decryptTab.getTitle(), decryptTab.createComponent());

        super.setTitle(TITLE);
        super.add(tabPane);
        //super.pack();
        super.setVisible(true);
    }
}

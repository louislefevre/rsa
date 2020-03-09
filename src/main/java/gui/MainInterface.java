package gui;

import javax.swing.*;

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

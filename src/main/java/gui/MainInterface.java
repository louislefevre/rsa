package gui;

import javax.swing.*;
import java.awt.*;

public final class MainInterface extends JFrame
{
    public MainInterface()
    {
        this.assembleInterface();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void assembleInterface()
    {
        String title = "RSA Algorithm";
        super.setTitle(title);

        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/icon.png");
        super.setIconImage(image);

        JTabbedPane tabPane = new JTabbedPane();
        GenerateKeysTab keysTab = new GenerateKeysTab();
        EncryptTab encryptTab = new EncryptTab();
        DecryptTab decryptTab = new DecryptTab();
        tabPane.addTab(keysTab.getTitle(), keysTab.createComponent());
        tabPane.addTab(encryptTab.getTitle(), encryptTab.createComponent());
        tabPane.addTab(decryptTab.getTitle(), decryptTab.createComponent());
        super.add(tabPane);
        super.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.5;
        double height = screenSize.getHeight() * 0.9;
        super.setSize((int)width, (int)height);
        super.setLocationRelativeTo(null);

        super.setVisible(true);
    }
}

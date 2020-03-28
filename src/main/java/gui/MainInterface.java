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
        /* Sets the title of the application, which will appear at the top of the interface. */
        String title = "RSA Algorithm";
        super.setTitle(title);

        /* Retrieves the image file from the resources directory and sets it to be the applications
         * image icon. This imagine appears in both the task-bar and next to the title at the top of
         * the interface. */
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/icon.png");
        super.setIconImage(image);

        /* The tabPane represents selection bar that consists of various tabs. Each of these tabs
         * are added to the tabPane by passing their title and layout creation methods.
         * note that the call to pack() is required to correctly adjust the size of the interface contents. */
        JTabbedPane tabPane = new JTabbedPane();
        GenerateKeysTab keysTab = new GenerateKeysTab();
        EncryptTab encryptTab = new EncryptTab();
        DecryptTab decryptTab = new DecryptTab();
        tabPane.addTab(keysTab.getTitle(), keysTab.createComponent());
        tabPane.addTab(encryptTab.getTitle(), encryptTab.createComponent());
        tabPane.addTab(decryptTab.getTitle(), decryptTab.createComponent());
        super.add(tabPane);
        super.pack();

        /* Retrieves the users screen resolution dimensions, and adjusts the size of the
         * interface to be 50% of the width and 90% of the height. The location of the interface
         * is also set to appear in the centre of the screen. */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        do {
             width *= 0.5;
        } while(width >= 1900); // Prevents the window appearing too large on multi-monitor systems
        double height = screenSize.getHeight() * 0.9;
        super.setSize((int)width, (int)height);
        super.setLocationRelativeTo(null);

        /* Displays the interface once all the setup is done.*/
        super.setVisible(true);
    }
}

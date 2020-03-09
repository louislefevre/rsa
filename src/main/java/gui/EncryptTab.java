package gui;

import cryptosystem.RSA;
import util.InterfaceUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

final class EncryptTab extends Tab
{
    private final String title;
    private final JPanel panel;
    private final JButton encryptButton;
    private final JTextArea modulusTextArea, publicKeyTextArea, messageTextArea, encryptedMessageTextArea;

    EncryptTab()
    {
        this.title = "Encrypt Message";
        this.panel = new JPanel();
        this.encryptButton = new JButton("Encrypt Message");
        this.modulusTextArea = InterfaceUtilities.createEditableTextArea("Enter Modulus");
        this.publicKeyTextArea = InterfaceUtilities.createEditableTextArea("Enter Public Key");
        this.messageTextArea = InterfaceUtilities.createEditableTextArea("Enter Plaintext Message");
        this.encryptedMessageTextArea = InterfaceUtilities.createNonEditableTextArea("Encrypted Message");
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    @Override
    JScrollPane createComponent()
    {
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.encryptButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.publicKeyTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.messageTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.encryptButton);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.encryptedMessageTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));

        this.encryptButton.addActionListener(this.activate());

        return new JScrollPane(this.panel);
    }

    @Override
    ActionListener activate()
    {
        return event -> this.encrypt();
    }

    private void encrypt()
    {
        String modulusText = this.modulusTextArea.getText();
        String publicKeyText = this.publicKeyTextArea.getText();
        String messageText = this.messageTextArea.getText();

        RSA rsa = new RSA();
        String encryptedMessage = rsa.encrypt(modulusText, publicKeyText, messageText);

        this.encryptedMessageTextArea.setText(encryptedMessage);
    }
}

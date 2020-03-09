package gui;

import cryptosystem.RSA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

final class DecryptTab extends Tab
{
    private final String title;
    private final JPanel panel;
    private final JButton decryptButton;
    private final JTextArea modulusTextArea, privateKeyTextArea, encryptedMessageTextArea, messageTextArea;

    DecryptTab()
    {
        this.title = "Decrypt Message";
        this.panel = new JPanel();
        this.decryptButton = new JButton("Decrypt Message");
        this.modulusTextArea = InterfaceUtilities.createEditableTextArea("Enter Modulus");
        this.privateKeyTextArea = InterfaceUtilities.createEditableTextArea("Enter Private Key");
        this.encryptedMessageTextArea = InterfaceUtilities.createEditableTextArea("Enter Encrypted Message");
        this.messageTextArea = InterfaceUtilities.createNonEditableTextArea("Decrypted Message");
    }

    @Override
    String getTitle()
    {
        return this.title;
    }

    @Override
    JScrollPane createComponent()
    {
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.decryptButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.privateKeyTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.encryptedMessageTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.decryptButton);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.messageTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));

        this.decryptButton.addActionListener(this.activate());

        return new JScrollPane(this.panel);
    }

    @Override
    ActionListener activate()
    {
        return event -> this.decrypt();
    }

    private void decrypt()
    {
        String modulusText = this.modulusTextArea.getText();
        String privateKeyText = this.privateKeyTextArea.getText();
        String encryptedMessageText = this.encryptedMessageTextArea.getText();

        if(modulusText.isBlank() || privateKeyText.isBlank() || encryptedMessageText.isBlank())
            return;

        RSA rsa = new RSA();
        String decryptedMessage = rsa.decrypt(modulusText, privateKeyText, encryptedMessageText);

        this.messageTextArea.setText(decryptedMessage);
    }
}

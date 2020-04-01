package gui;

import encryption.RSA;

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
        this.modulusTextArea = createEditableTextArea("Enter Modulus");
        this.privateKeyTextArea = createEditableTextArea("Enter Private Key");
        this.encryptedMessageTextArea = createEditableTextArea("Enter Encrypted Message");
        this.messageTextArea = createNonEditableTextArea("Decrypted Message");
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

        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.privateKeyTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.encryptedMessageTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.decryptButton);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.messageTextArea);
        this.panel.add(addAreaPadding(5, 5));

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
        String modulusText = this.modulusTextArea.getText().replaceAll("\\s", ""); // replaceAll removes all spaces present
        String privateKeyText = this.privateKeyTextArea.getText().replaceAll("\\s", "");
        String encryptedMessageText = this.encryptedMessageTextArea.getText();

        RSA rsa = new RSA();
        String decryptedMessage = "";

        if(isStringBlank(modulusText) || isStringBlank(privateKeyText) || isStringBlank(encryptedMessageText))
        {
            String alert = "All text boxes must be filled in.";
            JOptionPane.showMessageDialog(null, alert);
            return;
        }

        try{
            decryptedMessage = rsa.decrypt(modulusText, privateKeyText, encryptedMessageText);
        } catch (ArithmeticException ex) {
            String alert = "Modulus must be a positive integer.";
            JOptionPane.showMessageDialog(null, alert);
        } catch (NumberFormatException ex) {
            String alert = "Invalid number format, must be integer.";
            JOptionPane.showMessageDialog(null, alert);
        }

        this.messageTextArea.setText(decryptedMessage);
    }
}

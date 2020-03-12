package gui;

import encryption.RSA;

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
        this.modulusTextArea = createEditableTextArea("Enter Modulus");
        this.publicKeyTextArea = createEditableTextArea("Enter Public Key");
        this.messageTextArea = createEditableTextArea("Enter Plaintext Message");
        this.encryptedMessageTextArea = createNonEditableTextArea("Encrypted Message");
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

        this.encryptButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.publicKeyTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.messageTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.encryptButton);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.encryptedMessageTextArea);
        this.panel.add(addAreaPadding(5, 5));

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
        String encryptedMessage = "";

        if(modulusText.isEmpty() || publicKeyText.isEmpty() || messageText.isEmpty())
        {
            String alert = "All text boxes must be filled in.";
            JOptionPane.showMessageDialog(null, alert);
            return;
        }

        try{
            encryptedMessage = rsa.encrypt(modulusText, publicKeyText, messageText);
        } catch (ArithmeticException ex) {
            String alert = "Modulus must be a positive integer.";
            JOptionPane.showMessageDialog(null, alert);
        } catch (NumberFormatException ex) {
            String alert = "Invalid number format, must be integer.";
            JOptionPane.showMessageDialog(null, alert);
        }

        this.encryptedMessageTextArea.setText(encryptedMessage);
    }
}

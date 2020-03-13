package gui;

import keys.KeyPair;
import keys.RSAKeyGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

final class GenerateKeysTab extends Tab
{
    private final String title;
    private final JPanel panel;
    private final JButton generateButton;
    private final JTextArea modulusTextArea, publicKeyTextArea, privateKeyTextArea;

    GenerateKeysTab()
    {
        this.title = "Generate Keys";
        this.panel = new JPanel();
        this.generateButton = new JButton("Generate Keys");
        this.modulusTextArea = createNonEditableTextArea("Modulus");
        this.publicKeyTextArea = createNonEditableTextArea("Public Key");
        this.privateKeyTextArea = createNonEditableTextArea("Private Key");
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

        this.generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.generateButton);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.publicKeyTextArea);
        this.panel.add(addAreaPadding(5, 5));
        this.panel.add(this.privateKeyTextArea);
        this.panel.add(addAreaPadding(5, 5));

        this.generateButton.addActionListener(this.activate());

        return new JScrollPane(this.panel);
    }

    @Override
    ActionListener activate()
    {
        return event -> this.generateKeys();
    }

    private void generateKeys()
    {
        KeyPair keyPair = RSAKeyGenerator.generateKeyPair();

        String modulusText = keyPair.getModulusString();
        String publicKeyExponentText = keyPair.getPublicKey().getExponentString();
        String privateKeyExponentText = keyPair.getPrivateKey().getExponentString();

        this.modulusTextArea.setText(modulusText);
        this.publicKeyTextArea.setText(publicKeyExponentText);
        this.privateKeyTextArea.setText(privateKeyExponentText);
    }
}

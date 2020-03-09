package gui;

import keys.KeyPair;
import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyGenerator;
import util.ConversionUtilities;
import util.InterfaceUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigInteger;

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
        this.modulusTextArea = InterfaceUtilities.createNonEditableTextArea("Modulus");
        this.publicKeyTextArea = InterfaceUtilities.createNonEditableTextArea("Public Key");
        this.privateKeyTextArea = InterfaceUtilities.createNonEditableTextArea("Private Key");
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

        this.generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.generateButton);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.modulusTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.publicKeyTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));
        this.panel.add(this.privateKeyTextArea);
        this.panel.add(InterfaceUtilities.addAreaPadding(5, 5));

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
        this.createKeyPair();
    }

    private void createKeyPair()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        BigInteger modulus = keyPair.getModulus();
        BigInteger publicKeyExponent = publicKey.getExponent();
        BigInteger privateKeyExponent = privateKey.getExponent();

        this.setText(modulus, publicKeyExponent, privateKeyExponent);
    }

    private void setText(BigInteger modulus, BigInteger publicKeyExponent, BigInteger privateKeyExponent)
    {
        String modulusText = ConversionUtilities.parseString(modulus);
        String publicKeyExponentText = ConversionUtilities.parseString(publicKeyExponent);
        String privateKeyExponentText = ConversionUtilities.parseString(privateKeyExponent);

        this.modulusTextArea.setText(modulusText);
        this.publicKeyTextArea.setText(publicKeyExponentText);
        this.privateKeyTextArea.setText(privateKeyExponentText);
    }
}

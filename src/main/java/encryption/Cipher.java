package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;

import java.util.Scanner;

public final class Cipher
{
    public Cipher() { }

    public void run()
    {
        // Read the users input.
        String message = readInput();

        // Generate a public and private key.
        RSAKeyPair keyPair = new RSAKeyPair();
        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        // Encrypt and decrypt the message.
        String encryptedMessage = encryptText(message, publicKey);
        String decryptedMessage = decryptText(encryptedMessage, privateKey);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    private static String readInput()
    {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String encryptText(String text, PublicKey publicKey)
    {
        char[] charArray = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int encryptedCharacter = RSA.encrypt(letter, publicKey);
            encryptedText.append((char) encryptedCharacter);
        }

        return encryptedText.toString();
    }

    private static String decryptText(String text, PrivateKey privateKey)
    {
        char[] charArray = text.toCharArray();
        StringBuilder decryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int shiftedLetter = RSA.decrypt(letter, privateKey);
            decryptedText.append((char) shiftedLetter);
        }

        return decryptedText.toString();
    }
}

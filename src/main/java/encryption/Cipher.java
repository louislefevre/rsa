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
        // Read the users input
        String message = readInput();

        // Generate a public and private key
        RSAKeyPair keyPair = new RSAKeyPair();
        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        // Create an RSA algorithm object
        RSA rsa = new RSA();

        // Encrypt the message using one of the keys
        String encryptedMessage = rsa.encrypt(message, publicKey);

        // Decrypt the message using the other key
        String decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);

        // Print the results
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
}

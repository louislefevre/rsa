package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;
import util.TextUtilities;

import java.util.ArrayList;
import java.util.List;
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

        // Convert the input message to a list of ASCII characters.
        List<Integer> asciiMessage = TextUtilities.stringToAsciiList(message);

        // Encrypt each individual character and store the result in encryptedArray.
        List<Integer> encryptedArray = encryptCharacters(asciiMessage, publicKey);

        // Decrypt each individual character and store the result in decryptedArray.
        List<Integer> decryptedArray = decryptCharacters(encryptedArray, privateKey);

        // Convert the decrypted characters back into a string.
        String decryptedMessage = TextUtilities.asciiListToString(decryptedArray);

        System.out.println("Original Message: " + message);
        System.out.println("ASCII Message: " + asciiMessage);
        System.out.println("Encrypted Array: " + encryptedArray);
        System.out.println("Decrypted Array: " + decryptedArray);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    private static String readInput()
    {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static List<Integer> encryptCharacters(List<Integer> charArray, PublicKey publicKey)
    {
        List<Integer> encryptedArray = new ArrayList<>();
        for(int asciiChar : charArray)
        {
            int encryptedCharacter = RSA.encrypt(asciiChar, publicKey);
            encryptedArray.add(encryptedCharacter);
        }
        return encryptedArray;
    }

    private static List<Integer> decryptCharacters(List<Integer> charArray, PrivateKey privateKey)
    {
        List<Integer> decryptedArray = new ArrayList<>();
        for(int encryptedAsciiChar : charArray)
        {
            int decryptedCharacter = RSA.decrypt(encryptedAsciiChar, privateKey);
            decryptedArray.add(decryptedCharacter);
        }
        return decryptedArray;
    }
}

import encryption.RSA;
import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main
{
    public static void main(String[] args)
    {
        String message = readInput();
        if(message.isBlank())
            return;

        byte[] asciiMessage = toASCII(message);

        RSAKeyPair keyPair = new RSAKeyPair();
        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        RSA rsa = new RSA();

        List<Integer> encryptedArray = new ArrayList<>();
        for(byte character : asciiMessage)
        {
            int encryptedCharacter = rsa.encrypt(character, publicKey);
            encryptedArray.add(encryptedCharacter);
        }

        List<Integer> decryptedArray = new ArrayList<>();
        for(int value : encryptedArray)
        {
            int decryptedCharacter = rsa.decrypt(value, privateKey);
            decryptedArray.add(decryptedCharacter);
        }

        String decryptedMessage = toCharacters(decryptedArray);

        System.out.println("Original Message: " + message);
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

    private static byte[] toASCII(String text)
    {
        return text.getBytes();
    }

    private static String toCharacters(List<Integer> list)
    {
        StringBuilder text = new StringBuilder();
        for(int value : list)
        {
            text.append((char) value);
        }
        return text.toString();
    }
}
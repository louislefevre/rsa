package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import util.MathUtilities;

public final class RSA
{
    public RSA() { }

    public String encrypt(String text, PublicKey publicKey)
    {
        char[] charArray = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int encryptedCharacter = encryptCharacter(letter, publicKey);
            encryptedText.append((char) encryptedCharacter);
        }

        return encryptedText.toString();
    }

    public String decrypt(String text, PrivateKey privateKey)
    {
        char[] charArray = text.toCharArray();
        StringBuilder decryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int shiftedLetter = decryptCharacter(letter, privateKey);
            decryptedText.append((char) shiftedLetter);
        }

        return decryptedText.toString();
    }

    private static int encryptCharacter(int message, PublicKey publicKey)
    {
        int exponent = publicKey.getExponent();
        int modulus = publicKey.getModulus();

        return MathUtilities.modularExponentiation(message, exponent, modulus);
    }

    private static int decryptCharacter(int cipher, PrivateKey privateKey)
    {
        int exponent = privateKey.getExponent();
        int modulus = privateKey.getModulus();

        return MathUtilities.modularExponentiation(cipher, exponent, modulus);
    }
}

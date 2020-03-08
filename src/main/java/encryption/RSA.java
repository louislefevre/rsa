package encryption;

import keys.Key;
import util.MathUtilities;

public final class RSA
{
    public RSA() { }

    public String encrypt(String text, Key key)
    {
        char[] charArray = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int encryptedCharacter = encryptCharacter(letter, key);
            encryptedText.append((char) encryptedCharacter);
        }

        return encryptedText.toString();
    }

    public String decrypt(String text, Key key)
    {
        char[] charArray = text.toCharArray();
        StringBuilder decryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            int shiftedLetter = decryptCharacter(letter, key);
            decryptedText.append((char) shiftedLetter);
        }

        return decryptedText.toString();
    }

    private static int encryptCharacter(int message, Key key)
    {
        int exponent = key.getExponent();
        int modulus = key.getModulus();

        return MathUtilities.modularExponentiation(message, exponent, modulus);
    }

    private static int decryptCharacter(int cipher, Key key)
    {
        int exponent = key.getExponent();
        int modulus = key.getModulus();

        return MathUtilities.modularExponentiation(cipher, exponent, modulus);
    }
}

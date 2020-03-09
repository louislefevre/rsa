package encryption;

public final class RSA
{
    public RSA() { }

    public String encrypt(String text, Key key)
    {
        char[] charArray = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for(char letter : charArray)
        {
            if(letter > MathUtilities.ASCIIMax)
                throw new IllegalArgumentException(String.format("Invalid ASCII character: %s. Must be between 0 and 127.", (int)letter));
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
            int decryptCharacter = decryptCharacter(letter, key);
            decryptedText.append((char) decryptCharacter);
        }

        return decryptedText.toString();
    }

    private static int encryptCharacter(int character, Key key)
    {
        int exponent = key.getExponent();
        int modulus = key.getModulus();

        return MathUtilities.modularExponentiation(character, exponent, modulus);
    }

    private static int decryptCharacter(int character, Key key)
    {
        int exponent = key.getExponent();
        int modulus = key.getModulus();

        return MathUtilities.modularExponentiation(character, exponent, modulus);
    }
}

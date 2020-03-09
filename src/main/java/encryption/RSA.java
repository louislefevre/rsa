package encryption;

import java.math.BigInteger;

public final class RSA
{
    public static final int RADIX = 36;
    public static final int SIG_NUM = 1;

    public String encrypt(String modulusText, String exponentText, String messageText)
    {
        BigInteger modulus = parseInteger(modulusText);
        BigInteger exponent = parseInteger(exponentText);
        BigInteger message = stringToBigInteger(messageText);
        BigInteger encryptedMessage = modularExponentiation(message, exponent, modulus);
        return parseString(encryptedMessage);
    }

    public String decrypt(String modulusText, String exponentText, String messageText)
    {
        BigInteger modulus = parseInteger(modulusText);
        BigInteger exponent = parseInteger(exponentText);
        BigInteger message = parseInteger(messageText);
        BigInteger decryptedMessage = modularExponentiation(message, exponent, modulus);
        return bigIntegerToString(decryptedMessage);
    }

    private static BigInteger modularExponentiation(BigInteger message, BigInteger exponent, BigInteger modulus)
    {
        return message.modPow(exponent, modulus);
    }

    private static BigInteger parseInteger(String input)
    {
        return new BigInteger(input, RADIX);
    }

    private static String parseString(BigInteger input)
    {
        return input.toString(RADIX);
    }

    private static BigInteger stringToBigInteger(String text)
    {
        byte[] bytes = text.getBytes();
        return new BigInteger(SIG_NUM, bytes);
    }

    private static String bigIntegerToString(BigInteger text)
    {
        byte[] bytes = text.toByteArray();
        return new String(bytes);
    }
}

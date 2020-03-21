package encryption;

import java.math.BigInteger;

public final class RSA
{
    public static final int RADIX = 36;
    public static final int SIG_NUM = 1;

    public String encrypt(String modulusText, String exponentText, String messageText)
    {
        /* Most of the functions being performed here are for conversion purposes, in regards
         * to converting from BigInteger to String and vice versa. Both the modulus and exponent
         * are first converted from a String into a BigInteger by parsing them as an int. However,
         * the message itself is first converted into bytes and then converted into a BigInteger.
         * Once conversions are done we perform modular exponentiation, which is the basic process
         * behind the RSA algorithm. The result is then converted into a String and output to the user.*/
        BigInteger modulus = parseInteger(modulusText);
        BigInteger exponent = parseInteger(exponentText);
        BigInteger message = stringToBigInteger(messageText);
        BigInteger encryptedMessage = modularExponentiation(message, exponent, modulus);
        return parseString(encryptedMessage);
    }

    public String decrypt(String modulusText, String exponentText, String messageText)
    {
        /* Similarly to encryption, conversion needs to take place to transform the modulus, exponent
         * and message into their BigInteger form. Since the message was retrieve in its byte array form,
         * we don't need to retrieve its bytes like we did before. Again, modular exponentiation is performed
         * to decrypt the message. The result is then converted to a String and output to the user. */
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
        /* In order to transform a String to a BigInteger, we need to retrieve its byte form, as we can
         * only manipulate it when its in the form of an integer. */
        byte[] bytes = text.getBytes();
        return new BigInteger(SIG_NUM, bytes);
    }

    private static String bigIntegerToString(BigInteger text)
    {
        /* Similarly to converting the String form to BigInteger, to convert it back into a String we
         * retrieve the byte array of the BigInteger and parse that as a String. */
        byte[] bytes = text.toByteArray();
        return new String(bytes);
    }
}

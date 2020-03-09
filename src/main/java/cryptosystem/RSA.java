package cryptosystem;

import util.ConversionUtilities;

import java.math.BigInteger;

public final class RSA
{
    public String encrypt(String modulusText, String exponentText, String messageText)
    {
        BigInteger modulus = ConversionUtilities.parseInteger(modulusText);
        BigInteger exponent = ConversionUtilities.parseInteger(exponentText);
        BigInteger message = ConversionUtilities.stringToBigInteger(messageText);
        BigInteger encryptedMessage = message.modPow(exponent, modulus);
        return ConversionUtilities.parseString(encryptedMessage);
    }

    public String decrypt(String modulusText, String exponentText, String messageText)
    {
        BigInteger modulus = ConversionUtilities.parseInteger(modulusText);
        BigInteger exponent = ConversionUtilities.parseInteger(exponentText);
        BigInteger message = ConversionUtilities.parseInteger(messageText);
        BigInteger decryptedMessage = message.modPow(exponent, modulus);
        return ConversionUtilities.bigIntegerToString(decryptedMessage);
    }
}

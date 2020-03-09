package cryptosystem;

import keys.KeyPair;
import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyGenerator;
import org.junit.jupiter.api.Test;
import util.ConversionUtilities;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RSATest
{
    @Test
    public void encryptedMessageShouldBeDifferentFromOriginal()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();

        BigInteger modulus = keyPair.getModulus();
        BigInteger publicExponent = publicKey.getExponent();

        String modulusText = ConversionUtilities.parseString(modulus);
        String publicExponentText = ConversionUtilities.parseString(publicExponent);
        String message = "This is a message!";

        RSA rsa = new RSA();
        String encryptedMessage = rsa.encrypt(modulusText, publicExponentText, message);

        assertNotEquals(encryptedMessage, message);
    }

    @Test
    public void decryptedMessageShouldBeSameAsOriginal()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        BigInteger modulus = keyPair.getModulus();
        BigInteger publicExponent = publicKey.getExponent();
        BigInteger privateExponent = privateKey.getExponent();

        String modulusText = ConversionUtilities.parseString(modulus);
        String publicExponentText = ConversionUtilities.parseString(publicExponent);
        String privateExponentText = ConversionUtilities.parseString(privateExponent);
        String message = "This is a message!";

        RSA rsa = new RSA();
        String encryptedMessage = rsa.encrypt(modulusText, publicExponentText, message);
        String decryptedMessage = rsa.decrypt(modulusText, privateExponentText, encryptedMessage);

        assertEquals(message, decryptedMessage);
    }

    @Test
    public void algorithmShouldWorkWithArbitraryKeyOrder()
    {

    }
}
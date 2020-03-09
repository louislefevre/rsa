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

        String modulus = keyPair.getModulusString();
        String publicExponent = keyPair.getPublicKey().getExponentString();
        String message = "This is a message!";

        RSA rsa = new RSA();
        String encryptedMessage = rsa.encrypt(modulus, publicExponent, message);

        assertNotEquals(encryptedMessage, message);
    }

    @Test
    public void decryptedMessageShouldBeSameAsOriginal()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        String modulus = keyPair.getModulusString();
        String publicExponent = keyPair.getPublicKey().getExponentString();
        String privateExponent = keyPair.getPrivateKey().getExponentString();
        String message = "This is a message!";

        RSA rsa = new RSA();
        String encryptedMessage = rsa.encrypt(modulus, publicExponent, message);
        String decryptedMessage = rsa.decrypt(modulus, privateExponent, encryptedMessage);

        assertEquals(message, decryptedMessage);
    }

    @Test
    public void algorithmShouldWorkWithArbitraryKeyOrder()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        String modulus = keyPair.getModulusString();
        String publicExponent = keyPair.getPublicKey().getExponentString();
        String privateExponent = keyPair.getPrivateKey().getExponentString();
        String message = "This is a message!";

        RSA rsa = new RSA();

        String encryptedMessage = rsa.encrypt(modulus, publicExponent, message);
        String decryptedMessage = rsa.decrypt(modulus, privateExponent, encryptedMessage);
        assertEquals(message, decryptedMessage, "The original message and decrypted message are not the same. (E: Public, D: Private)");

        encryptedMessage = rsa.encrypt(modulus, privateExponent, message);
        decryptedMessage = rsa.decrypt(modulus, publicExponent, encryptedMessage);
        assertEquals(message, decryptedMessage, "The original message and decrypted message are not the same.  (E: Private, D: Public)");
    }

    @Test
    public void algorithmShouldWorkForEveryAsciiCharacter()
    {
        RSA rsa = new RSA();
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        String modulus = keyPair.getModulusString();
        String publicExponent = keyPair.getPublicKey().getExponentString();
        String privateExponent = keyPair.getPrivateKey().getExponentString();

        for (int i = 0; i < 128; i++)
        {
            char character = (char) i;
            String message = Character.toString(character);

            String encryptedMessage = rsa.encrypt(modulus, publicExponent, message);
            String decryptedMessage = rsa.decrypt(modulus, privateExponent, encryptedMessage);

            assertEquals(message, decryptedMessage);
        }
    }
}
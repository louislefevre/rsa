package encryption;

import org.junit.jupiter.api.Test;
import util.MathUtilities;

import static org.junit.jupiter.api.Assertions.*;

class RSATest
{
    @Test
    public void encryptedMessageShouldBeDifferentFromOriginal()
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();

        String message = "This method tests that the message is actually encrypted.";
        String encryptedMessage = rsa.encrypt(message, publicKey);

        assertNotEquals(message, encryptedMessage, "The encrypted message should not be the same as the original message.\n" + publicKey.toString());
    }

    @Test
    public void decryptedMessageShouldBeSameAsOriginal()
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        String message = "This method tests that the message has successfully decrypted.";
        String encryptedMessage = rsa.encrypt(message, publicKey);
        String decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);

        assertEquals(message, decryptedMessage, "The decrypted message should be the same as the original message.");
    }

    @Test
    public void algorithmShouldSuccessfullyEncryptAndDecrypt()
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        String message = "This method tests that the algorithm has successfully encrypted and decrypted.";

        String encryptedMessage = rsa.encrypt(message, publicKey);
        assertNotEquals(message, encryptedMessage, "The encrypted message should not be the same as the original message.");

        String decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);
        assertEquals(message, decryptedMessage, "The decrypted message should be the same as the original message.");
    }

    @Test
    public void algorithmShouldWorkWithArbitraryKeyOrder()
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        String message = "This method tests that the key order doesn't matter.";

        String encryptedMessage = rsa.encrypt(message, publicKey);
        String decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);
        assertEquals(message, decryptedMessage, "The decrypted message should be the same as the original message.");

        encryptedMessage = rsa.encrypt(message, privateKey);
        decryptedMessage = rsa.decrypt(encryptedMessage, publicKey);
        assertEquals(message, decryptedMessage, "The decrypted message should be the same as the original message.");
    }

    @Test
    public void algorithmShouldWorkForEveryCharacter()
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        for (int i = 0; i <= MathUtilities.ASCIIMax; i++)
        {
            char character = (char)i;
            String message = Character.toString(character);

            String alert = "\nCharacter " + message + " failed.";

            String encryptedMessage = rsa.encrypt(message, publicKey);
            assertNotEquals(character, encryptedMessage, "The encrypted message should not be the same as the original message." + alert);

            String decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);
            assertEquals(message, decryptedMessage, "The decrypted message should be the same as the original message." + alert);
        }
    }
}
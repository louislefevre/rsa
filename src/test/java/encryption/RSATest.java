package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;

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

        assertNotEquals(message, encryptedMessage, "The encrypted message should not be the same as the original message.");
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
}
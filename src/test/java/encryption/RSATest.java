package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSATest
{
    @Test
    public void encryptedMessageShouldBeDifferentFromOriginal() //throws Exception
    {
        RSAKeyPair keyPair = new RSAKeyPair();
        RSA rsa = new RSA();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        String message = "Hello!";
        String encryptedMessage = rsa.encrypt(message, publicKey);

        assertNotEquals(message, encryptedMessage, "The encrypted message should have no resemblance to the original text.");
    }
}
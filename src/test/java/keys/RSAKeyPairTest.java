package keys;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RSAKeyPairTest
{
    @Test
    public void keyExponentsShouldBeDifferent()
    {
        RSAKeyPair keyPair = new RSAKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        assertNotEquals(publicKey.getExponent(), privateKey.getExponent(), "The exponent of the keys are the same.");
    }
}
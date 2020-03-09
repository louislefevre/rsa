package keys;

import encryption.RSA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSAKeyPairTest
{
    @Test
    public void keysShouldBeDifferent()
    {
        RSAKeyPair keyPair = new RSAKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        assertNotEquals(publicKey.getExponent(), privateKey.getExponent(), "The exponent of the keys is the same.");
    }

    @Test
    public void keyPairExponentsShouldBeInRange()
    {
        RSAKeyPair keyPair = new RSAKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        System.out.println(publicKey.getExponent());
        System.out.println(publicKey.getModulus());
    }
}
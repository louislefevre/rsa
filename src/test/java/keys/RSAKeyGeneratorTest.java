package keys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RSAKeyGeneratorTest
{
    @Test
    public void keyExponentsAreDifferent()
    {
        KeyPair keyPair = RSAKeyGenerator.generateKeyPair();

        String privateKeyExponent = keyPair.getPrivateKey().getExponentString();
        String publicKeyExponent = keyPair.getPublicKey().getExponentString();

        assertNotEquals(privateKeyExponent, publicKeyExponent);
    }
}
package keys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RSAKeyGeneratorTest
{
    @Test
    public void keyExponentsAreDifferent()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        String privateKeyExponent = keyPair.getPrivateKey().getExponentString();
        String publicKeyExponent = keyPair.getPublicKey().getExponentString();

        assertNotEquals(privateKeyExponent, publicKeyExponent);
    }
}
package keys;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RSAKeyGeneratorTest
{
    @Test
    public void keyExponentsAreDifferent()
    {
        RSAKeyGenerator keyGenerator = new RSAKeyGenerator();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivateKey();
        PublicKey publicKey = keyPair.getPublicKey();

        BigInteger privateExponent = privateKey.getExponent();
        BigInteger publicExponent = publicKey.getExponent();

        assertNotEquals(privateExponent, publicExponent);
    }
}
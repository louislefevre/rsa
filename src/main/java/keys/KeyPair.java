package keys;

import encryption.RSA;

import java.math.BigInteger;

public final class KeyPair
{
    private final Key publicKey;
    private final Key privateKey;
    private final BigInteger modulus;

    public KeyPair(BigInteger publicKeyExponent, BigInteger privateKeyExponent, BigInteger modulus)
    {
        this.publicKey = new Key(publicKeyExponent);
        this.privateKey = new Key(privateKeyExponent);
        this.modulus = modulus;
    }

    public Key getPublicKey()
    {
        return this.publicKey;
    }

    public Key getPrivateKey()
    {
        return this.privateKey;
    }

    public String getModulusString()
    {
        return this.modulus.toString(RSA.RADIX);
    }

    public final class Key
    {
        private final BigInteger exponent;

        Key(BigInteger exponent)
        {
            this.exponent = exponent;
        }

        public String getExponentString()
        {
            return this.exponent.toString(RSA.RADIX);
        }
    }

}

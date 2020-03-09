package keys;

import cryptosystem.RSA;

import java.math.BigInteger;

public final class KeyPair
{
    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private final BigInteger modulus;

    public KeyPair(PublicKey publicKey, PrivateKey privateKey, BigInteger modulus)
    {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.modulus = modulus;
    }

    public PublicKey getPublicKey()
    {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return this.privateKey;
    }

    public BigInteger getModulus()
    {
        return this.modulus;
    }

    public String getModulusString()
    {
        return this.modulus.toString(RSA.RADIX);
    }
}

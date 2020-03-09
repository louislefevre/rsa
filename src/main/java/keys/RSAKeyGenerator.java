package keys;

import java.math.BigInteger;
import java.util.Random;

public final class RSAKeyGenerator
{
    public static final int PRIME_BOUND = 65537;
    public static final int BIT_LENGTH = 2048;

    public RSAKeyGenerator() { }

    public KeyPair generateKeyPair()
    {
        Random random = new MersenneTwister();

        BigInteger primeP = BigInteger.probablePrime(BIT_LENGTH, random);
        BigInteger primeQ = BigInteger.probablePrime(BIT_LENGTH+2, random);
        BigInteger modulus = primeP.multiply(primeQ);
        BigInteger phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));
        BigInteger publicExponent = BigInteger.valueOf(PRIME_BOUND);
        BigInteger privateExponent = publicExponent.modInverse(phi);

        PublicKey publicKey = new PublicKey(publicExponent);
        PrivateKey privateKey = new PrivateKey(privateExponent);

        return new KeyPair(publicKey, privateKey, modulus);
    }
}

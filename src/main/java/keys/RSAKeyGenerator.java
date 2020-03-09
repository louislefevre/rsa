package keys;

import util.MathUtilities;
import util.MersenneTwister;

import java.math.BigInteger;
import java.util.Random;

public final class RSAKeyGenerator
{
    public RSAKeyGenerator() { }

    public KeyPair generateKeyPair()
    {
        Random random = new MersenneTwister();

        BigInteger primeP = BigInteger.probablePrime(MathUtilities.BIT_LENGTH, random);
        BigInteger primeQ = BigInteger.probablePrime(MathUtilities.BIT_LENGTH+2, random);
        BigInteger modulus = primeP.multiply(primeQ);
        BigInteger phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));
        BigInteger publicExponent = BigInteger.valueOf(MathUtilities.PRIME_BOUND);
        BigInteger privateExponent = publicExponent.modInverse(phi);

        PublicKey publicKey = new PublicKey(publicExponent);
        PrivateKey privateKey = new PrivateKey(privateExponent);

        return new KeyPair(publicKey, privateKey, modulus);
    }
}

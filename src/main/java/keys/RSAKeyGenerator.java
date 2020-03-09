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
        Random randomNumberGenerator = new MersenneTwister();

        BigInteger primeP = BigInteger.valueOf(2);
        while (!MathUtilities.isDivisibleByLargePrime(primeP.add(BigInteger.ONE)) &&
               !MathUtilities.isDivisibleByLargePrime(primeP.subtract(BigInteger.ONE)))
            primeP = BigInteger.probablePrime(2048, randomNumberGenerator);

        BigInteger primeQ = BigInteger.valueOf(2);
        while (!MathUtilities.isDivisibleByLargePrime(primeQ.add(BigInteger.ONE)) &&
               !MathUtilities.isDivisibleByLargePrime(primeQ.subtract(BigInteger.ONE)))
            primeQ = BigInteger.probablePrime(2050, randomNumberGenerator);

        BigInteger modulus = primeP.multiply(primeQ);
        BigInteger phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));

        BigInteger publicExponent = BigInteger.valueOf(65537);
        BigInteger privateExponent = publicExponent.modInverse(phi);

        PublicKey publicKey = new PublicKey(publicExponent);
        PrivateKey privateKey = new PrivateKey(privateExponent);

        return new KeyPair(publicKey, privateKey, modulus);
    }
}

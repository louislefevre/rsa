package keys;

import java.math.BigInteger;
import java.util.Random;

public final class RSAKeyGenerator
{
    public static final short BIT_LENGTH = 2048;
    public static final int[] FERMAT_NUMBERS = {65537, 257, 17, 5, 3};

    public RSAKeyGenerator() { }

    public KeyPair generateKeyPair()
    {
        BigInteger primeP = generatePrime(BIT_LENGTH);
        BigInteger primeQ = generatePrime(BIT_LENGTH+2);

        BigInteger modulus = generateModulus(primeP, primeQ);
        BigInteger phi = generatePhi(primeP, primeQ);

        BigInteger publicExponent = generatePublicExponent(phi);
        BigInteger privateExponent = generatePrivateExponent(publicExponent, phi);

        PublicKey publicKey = new PublicKey(publicExponent);
        PrivateKey privateKey = new PrivateKey(privateExponent);

        return new KeyPair(publicKey, privateKey, modulus);
    }

    private static BigInteger generatePrime(int bitLength)
    {
        Random random = new MersenneTwister();
        return BigInteger.probablePrime(bitLength, random);
    }

    private static BigInteger generateModulus(BigInteger primeOne, BigInteger primeTwo)
    {
        return primeOne.multiply(primeTwo);
    }

    private static BigInteger generatePhi(BigInteger primeOne, BigInteger primeTwo)
    {
        return primeOne.subtract(BigInteger.ONE).multiply(primeTwo.subtract(BigInteger.ONE));
    }

    private static BigInteger generatePublicExponent(BigInteger phi)
    {
        for(int value : FERMAT_NUMBERS)
        {
            BigInteger fermatNumber = BigInteger.valueOf(value);
            if(phi.gcd(fermatNumber).equals(BigInteger.ONE))
                return fermatNumber;
        }
        return BigInteger.valueOf(FERMAT_NUMBERS[4]);
    }

    private static BigInteger generatePrivateExponent(BigInteger exponent, BigInteger phi)
    {
        return exponent.modInverse(phi);
    }
}

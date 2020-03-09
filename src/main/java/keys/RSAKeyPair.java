package keys;

import util.MathUtilities;

public final class RSAKeyPair
{
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSAKeyPair()
    {
        this.generateKeys();
    }

    public PublicKey getPublicKey()
    {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return this.privateKey;
    }

    private void generateKeys()
    {
        int primeOne, primeTwo;
        int modulus, phi;
        int publicExponent, privateExponent;

        do {
            primeOne = generatePrime();
            primeTwo = generatePrime();
            modulus = generateModulus(primeOne, primeTwo);
            phi = generatePhi(primeOne, primeTwo);
            publicExponent = generatePublicExponent(phi);
            privateExponent = generatePrivateExponent(publicExponent, phi);
        } while(primeOne == primeTwo || publicExponent == privateExponent || modulus <= MathUtilities.ASCIIMax);

        this.publicKey = new PublicKey(modulus, publicExponent);
        this.privateKey = new PrivateKey(modulus, privateExponent);
    }

    private static int generatePrime()
    {
        int randomNumber;
        do {
            randomNumber = MathUtilities.generateRandomNumber(1, MathUtilities.ASCIIMax);
        } while(!MathUtilities.isPrime(randomNumber));

        return randomNumber;
    }

    private static int generateModulus(int primeOne, int primeTwo)
    {
        return primeOne * primeTwo;
    }

    private static int generatePhi(int primeOne, int primeTwo)
    {
        return (primeOne - 1) * (primeTwo - 1);
    }

    private static int generatePublicExponent(int phi)
    {
        int randomNumber;

        do {
            randomNumber = MathUtilities.generateRandomNumber(1, MathUtilities.ASCIIMax);
        } while(!(randomNumber > 1 && randomNumber < phi && MathUtilities.isCoPrime(randomNumber, phi)));
        return randomNumber;
    }

    private static int generatePrivateExponent(int exponent, int phi)
    {
        return MathUtilities.findInverse(exponent, phi);
    }
}

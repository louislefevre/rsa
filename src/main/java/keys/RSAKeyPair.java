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
        int primeOne;
        int primeTwo;
        do {
            primeOne = generatePrime();
            primeTwo = generatePrime();
        } while(primeOne == primeTwo);

        int modulus = generateModulus(primeOne, primeTwo);
        int phi = generatePhi(primeOne, primeTwo);

        int publicExponent;
        int privateExponent;
        do {
            publicExponent = generatePublicExponent(phi);
            privateExponent = generatePrivateExponent(publicExponent, phi);
        } while(publicExponent == privateExponent);

        this.publicKey = new PublicKey(modulus, publicExponent);
        this.privateKey = new PrivateKey(modulus, privateExponent);
    }

    private static int generatePrime()
    {
        int randomNumber;
        do {
            randomNumber = MathUtilities.generateRandomNumber();
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
            randomNumber = MathUtilities.generateRandomNumber();
        } while(!(randomNumber > 1 && randomNumber < phi && MathUtilities.isCoPrime(randomNumber, phi)));

        return randomNumber;
    }

    private static int generatePrivateExponent(int exponent, int phi)
    {
        return MathUtilities.findInverse(exponent, phi);
    }
}

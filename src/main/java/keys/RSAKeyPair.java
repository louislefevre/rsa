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

    private void generateKeys()
    {
        int primeOne;
        int primeTwo;
        do {
            primeOne = this.generatePrime();
            primeTwo = this.generatePrime();
        } while(primeOne == primeTwo);

        int modulus = this.generateModulus(primeOne, primeTwo);
        int phi = this.generatePhi(primeOne, primeTwo);
        int publicExponent = this.generatePublicExponent(phi);
        int privateExponent = this.generatePrivateExponent(publicExponent, phi);

        this.publicKey = new PublicKey(modulus, publicExponent);
        this.privateKey = new PrivateKey(modulus, privateExponent);
    }

    private int generatePrime()
    {
        int randomNumber;
        do {
            randomNumber = MathUtilities.generateRandomNumber();
        } while(!MathUtilities.isPrime(randomNumber));
        return randomNumber;
    }

    private int generateModulus(int primeOne, int primeTwo)
    {
        return primeOne * primeTwo;
    }

    private int generatePhi(int primeOne, int primeTwo)
    {
        return (primeOne - 1) * (primeTwo - 1);
    }

    private int generatePublicExponent(int phi)
    {
        int randomNumber;

        do {
            randomNumber = MathUtilities.generateRandomNumber();
        } while(!(randomNumber > 1 && randomNumber < phi && MathUtilities.isCoPrime(randomNumber, phi)));


        return randomNumber;
    }

    private int generatePrivateExponent(int exponent, int phi)
    {
        return MathUtilities.findInverse(exponent, phi);
    }

    public PublicKey getPublicKey()
    {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return this.privateKey;
    }
}

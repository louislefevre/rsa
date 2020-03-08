package keys;

import util.MathUtilities;

public class RSAKeyPair
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

    private int generateModulus(int p, int q)
    {
        return p*q;
    }

    private int generatePhi(int p, int q)
    {
        return (p - 1) * (q - 1);
    }

    private int generatePublicExponent(int r)
    {
        int randomNumber;

        do{
            randomNumber = MathUtilities.generateRandomNumber();
        }while(!(randomNumber > 1 && randomNumber < r && MathUtilities.isCoPrime(randomNumber, r)));


        return randomNumber;
    }

    private int generatePrivateExponent(int e, int r)
    {
        return MathUtilities.findInverse(e, r);
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

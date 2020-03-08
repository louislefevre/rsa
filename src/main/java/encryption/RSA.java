package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import util.MathUtilities;

public final class RSA
{
    public RSA() { }

    public static int decrypt(int cipher, PrivateKey privateKey)
    {
        int exponent = privateKey.getExponent();
        int modulus = privateKey.getModulus();

        return MathUtilities.modularExponentiation(cipher, exponent, modulus);
    }

    public static int encrypt(int message, PublicKey publicKey)
    {
        int exponent = publicKey.getExponent();
        int modulus = publicKey.getModulus();

        return MathUtilities.modularExponentiation(message, exponent, modulus);
    }
}

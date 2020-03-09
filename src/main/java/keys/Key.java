package keys;

import cryptosystem.RSA;

import java.math.BigInteger;

abstract class Key
{
    private final BigInteger exponent;

    Key(BigInteger exponent)
    {
        this.exponent = exponent;
    }

    public BigInteger getExponent()
    {
        return this.exponent;
    }

    public String getExponentString()
    {
        return this.exponent.toString(RSA.RADIX);
    }
}

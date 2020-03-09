package keys;

import util.ConversionUtilities;

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
        return ConversionUtilities.parseString(this.exponent);
    }
}

package keys;

import java.math.BigInteger;

public abstract class Key
{
    private final BigInteger exponent;

    Key(BigInteger exponent)
    {
        this.exponent = exponent;
    }

    public BigInteger getExponent()
    {
        return exponent;
    }

    @Override
    public String toString() {
        return "Key{" +
                "exponent=" + exponent +
                '}';
    }
}

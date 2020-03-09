package keys;

import java.math.BigInteger;

public final class PrivateKey extends Key
{
    PrivateKey(BigInteger exponent)
    {
        super(exponent);
    }
}

package keys;

import java.math.BigInteger;

public final class PublicKey extends Key
{
    PublicKey(BigInteger exponent)
    {
        super(exponent);
    }
}

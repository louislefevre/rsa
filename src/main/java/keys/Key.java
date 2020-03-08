package keys;

public abstract class Key
{
    private final int modulus;
    private final int exponent;

    Key(int modulus, int exponent)
    {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    public int getModulus()
    {
        return this.modulus;
    }

    public int getExponent()
    {
        return this.exponent;
    }
}

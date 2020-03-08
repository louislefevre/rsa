package keys;

public abstract class Key
{
    private int modulus;
    private int exponent;

    public Key(int modulus, int exponent)
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

package util;

public final class MathUtilities
{
    public static final int PRIME_BOUND = 65537;
    public static final int BIT_LENGTH = 2048;

    private MathUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static boolean isPrime(int num)
    {
        // https://mkyong.com/java/how-to-determine-a-prime-number-in-java/
        if(num <= 1 || num % 2 == 0)
            return false;

        for(int i = 3; i*i <= num; i+=2)
            if(num % i == 0)
                return false;

        return true;
    }
}

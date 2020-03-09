package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class MathUtilities
{
    public static final List<BigInteger> BIG_INTEGER_PRIMES = new ArrayList<>();
    public static final int PRIME_BOUND = 65537;

    static
    {
        for(int i = 2; i <= PRIME_BOUND; i++)
            if(isPrime(i))
                BIG_INTEGER_PRIMES.add(BigInteger.valueOf(i));
    }

    private MathUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static boolean isDivisibleByLargePrime(BigInteger n)
    {
        BigInteger reduced = n;
        boolean foundDivisor = true;

        while (foundDivisor && !reduced.equals(BigInteger.ZERO))
        {
            foundDivisor = false;

            for (BigInteger p : BIG_INTEGER_PRIMES)
            {
                if (reduced.mod(p).equals(BigInteger.ZERO))
                {
                    reduced = reduced.divide(p);
                    foundDivisor = true;
                    break;
                }
            }
        }

        return reduced.compareTo(BigInteger.valueOf(PRIME_BOUND)) > 0;
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

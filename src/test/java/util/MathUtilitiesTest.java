package util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathUtilitiesTest
{
    @Test
    public void isPrimeShouldIdentifyCorrectly()
    {
        List<BigInteger> bigIntegerPrimes = MathUtilities.BIG_INTEGER_PRIMES;

        for(int i = 0; i < MathUtilities.PRIME_BOUND; i++)
        {
            if(bigIntegerPrimes.contains(BigInteger.valueOf(i)))
                assertTrue(MathUtilities.isPrime(i), String.format("The number '%s' is prime.", i));
            else
                assertFalse(MathUtilities.isPrime(i), String.format("The number '%s' is not prime.", i));
        }
    }

    @Test
    public void isDivisibleByLargePrimeShouldFindDivisor()
    {
        assertTrue(MathUtilities.isDivisibleByLargePrime(BigInteger.valueOf(78031)));
        assertTrue(MathUtilities.isDivisibleByLargePrime(BigInteger.valueOf(2*9*5*7*11*78031)));
        assertFalse(MathUtilities.isDivisibleByLargePrime(BigInteger.valueOf(2*9*5*7*11*63499)));
        assertFalse(MathUtilities.isDivisibleByLargePrime(BigInteger.valueOf(2)));
        assertFalse(MathUtilities.isDivisibleByLargePrime(BigInteger.valueOf(9)));
    }
}
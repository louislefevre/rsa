package util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathUtilitiesTest
{
    @Test
    public void isPrimeShouldIdentifyCorrectly()
    {
        List<BigInteger> bigIntegerPrimes = new ArrayList<>();

        for(int i = 2; i <= MathUtilities.PRIME_BOUND; i++)
            if(MathUtilities.isPrime(i))
                bigIntegerPrimes.add(BigInteger.valueOf(i));

        for(int i = 0; i < MathUtilities.PRIME_BOUND; i++)
        {
            if(bigIntegerPrimes.contains(BigInteger.valueOf(i)))
                assertTrue(MathUtilities.isPrime(i), String.format("The number '%s' is prime.", i));
            else
                assertFalse(MathUtilities.isPrime(i), String.format("The number '%s' is not prime.", i));
        }
    }
}
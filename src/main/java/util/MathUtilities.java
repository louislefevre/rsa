package util;

import java.security.SecureRandom;

public final class MathUtilities
{
    private MathUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static int generateRandomNumber()
    {
        SecureRandom random = new SecureRandom();
        return random.nextInt(100);
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

    public static int findInverse(int numOne, int numTwo)
    {
        int store = numTwo;
        int temp;
        int q;
        int sign = 1;
        int result = 1;
        int s = 0;

        while (numOne!=0)
        {
            q = numTwo / numOne;
            temp = result;
            result = temp * q + s;
            s = temp;
            temp = numOne;
            numOne = numTwo - q * temp;
            numTwo = temp;
            sign = -sign;
        }
        if (sign == -1)
            s = numOne - s;

        return (result - s) % store;
    }

    public static boolean isCoPrime(int numOne, int numTwo)
    {
        return GCD(numOne, numTwo) == 1;
    }

    private static int GCD(int numOne, int numTwo)
    {
        // https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/
        if (numOne == 0 || numTwo == 0)
            return 0;
        if (numOne == numTwo)
            return numOne;
        if (numOne > numTwo)
            return GCD(numOne-numTwo, numTwo);
        return GCD(numOne, numTwo-numOne);
    }
}

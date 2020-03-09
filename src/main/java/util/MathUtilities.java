package util;

import java.security.SecureRandom;

public final class MathUtilities
{
    // This value is based off the amount of values in an ASCII table
    private static final int bound = 5000;

    private MathUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static int getBound()
    {
        return bound;
    }

    public static int generateRandomNumber()
    {
        SecureRandom random = new SecureRandom();
        int number;
        do {
            number = random.nextInt(bound);
        } while(number < 1);
        return number;
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

    public static boolean isCoPrime(int numOne, int numTwo)
    {
        return findGCD(numOne, numTwo) == 1;
    }

    public static int findGCD(int numOne, int numTwo)
    {
        return (numTwo != 0) ? findGCD(numTwo, numOne % numTwo) : numOne;
        // https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/
        /*
        if (numOne == 0 || numTwo == 0)
            return 0;
        if (numOne == numTwo)
            return numOne;
        if (numOne > numTwo)
            return findGCD(numOne-numTwo, numTwo);
        return findGCD(numOne, numTwo-numOne);

         */
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

    public static int modularExponentiation(int base, int power, int modulus)
    {
        int result = 1;
        int update = base % modulus;

        do
        {
            if (power % 2 == 1)
                result = (result * update) % modulus;

            power = (int)Math.floor(power / 2f);
            update = (update * update) % modulus;

        } while(power != 0);

        return result;
    }
}

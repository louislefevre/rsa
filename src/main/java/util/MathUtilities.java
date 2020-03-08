package util;

import java.security.SecureRandom;

public final class MathUtilities
{
    public MathUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static int findInverse(int b, int a)
    {
        int store=a;
        int temp;
        int q;
        int sign=1;
        int r=1;
        int s=0;
        while(b!=0)
        {
            q=a/b;
            temp=r;
            r=temp*q+s;
            s=temp;
            temp=b;
            b=a-q*temp;
            a=temp;
            sign=-sign;
        }
        if(sign==-1)
            s=b-s;

        int answer=(r-s)%store;

        return answer;
    }

    public static boolean isCoPrime(int e, int r)
    {
        // https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/
        if(GCD(e, r) == 1)
            return true;
        return false;
    }

    private static int GCD(int a, int b)
    {
        if(a == 0 || b == 0)
            return 0;
        if(a == b)
            return a;
        if(a > b)
            return GCD(a-b, b);
        return GCD(a, b-a);
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

    public static int generateRandomNumber()
    {
        SecureRandom random = new SecureRandom();
        return random.nextInt(100);
    }
}

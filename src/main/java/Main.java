import java.security.SecureRandom;

public class Main
{
    public static void main(String[] args)
    {
        long p = generateRandomPrimes(5000);
        long q = generateRandomPrimes(5000);
        System.out.println(p);
        System.out.println(q);
    }

    static long generateRandomPrimes(int limit)
    {
        SecureRandom random = new SecureRandom();

        while(true)
        {
            long randomNumber = random.nextInt(limit);

            if(!isPrime(randomNumber))
                continue;

            return randomNumber;
        }
    }

    static boolean isPrime(long num)
    {
        if(num <= 1)
            return false;

        for(int i = 2; i < num; i++)
            if(num % i == 0)
                return false;

        return true;
    }
}

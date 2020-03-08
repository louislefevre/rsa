
import java.util.concurrent.ThreadLocalRandom;

public class OldMain
{
    public static void main(String[] args)
    {
        int loop = 1000;
        int counter = 0;

        for(int i = 0; i < loop; i++) {
            // Retrieve Message
            long m = 44; //6 character limit for 100%

            // Choosing Primes
            long p = generateRandomPrimes(); // 2048-bits
            long q = generateRandomPrimes(); // 2048-bits
            long n = p * q; // 4096-bits

            // Calculating Phi Using Euler Totient Function
            long r = (p - 1) * (q - 1); // Need to find number phi, so that any X raised to phi mod n, equals to 1 (x^phi mod n == 1)

            // Extended Euclid Algorithm
            long e = 65537; //findGenerator(r); // Small number, greater than 2. Commonly is 3, or can use 5,17,257,65537.
            long d = findInverse(r, e); // Inverse of e mod phi

            // Assign Keys
            long[] publicKey = {e, n};
            long privateKey = d;


            long cipherText = fastmodexp(m, publicKey[0], publicKey[1]); // ENCRYPTION
            long decipherText = fastmodexp(cipherText, privateKey, publicKey[1]); //DECRYPTION

           // System.out.println("OriginalText: " + m);
           // System.out.println("CipherText: " + cipherText);
            //System.out.println("DecipherText: " + decipherText);

            if(m == decipherText) counter++;
        }
        System.out.println(counter + "/" + loop);
    }

    static long generateRandomPrimes()
    {
        while(true)
        {
            long randomNumber = getRandom(10, 100);

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

    static long getRandom(long min, long max)
    {
        return ThreadLocalRandom.current().nextLong(min,max);
    }






    static long findGCD(long a, long b)
    {
        if(b == 0)
            return a;
        return findGCD(b, a%b);
    }

    static long findGenerator(long r)
    {
        long num = 0;
        do{
            num = getRandom(0, r);
        }while(!(num > 1) && !(num < r) && !(isPrime(num)));

        if(findGCD(num, r) == 1) {
            return num;
        }

        return findGenerator(r);
    }




    public static long fastmodexp(long x, long n, long m)  //x is the base, n is the power, m is the modulus
    {
        long y=1;
        long u=x%m;

        do
        {								//when I use this algorithm in class:
            if(n % 2 == 1)
                y = (y * u) % m;      //this is equivalent to the 1st column
            n = (long)Math.floor(n/2);
            u = (u * u) % m;
        }while(n != 0);

        return y;
    }




    // b mod a
    static long findInverse(long a, long b)
    {
        long store=a;
        long temp;
        long q;
        long sign=1;
        long r=1;
        long s=0;
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

        long answer=(r-s)%store;

        return answer;
    }
}

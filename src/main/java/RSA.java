/*
* 1. Choose two different prime numbers at random of similar bit-length. They are denoted by p and q.
* 2. Calculate n=p*q. The number n is used as the modules for both private and public keys. Its length
*    is that of the RSA key.
* 3. Calculate a value of Eulers totient function for n: (p-1)*(q-1), denoted as φ(n)
* 4. Choose an integer e that is larger than 1, and smaller than φ(n). The numbers e and φ(n) should be co-prime.
*    The number e is used as the public key exponent.
* 5. Compute a number d such that: d*e = 1 (mod φ(n)). The number d is used as the private key exponent.
*
* NOTES: - Primes might need to be different numbers.
*        - Internally, this method works only with numbers (no text), which are between 0 and n.
*        - It could be the case that the message >= modulus. To avoid, use a do-while loop to generate key
 *         until modulus happen to be exactly N bits.
 *       - It's possible that gcd(phi, publicKey) != 1 in which case the key generation fails. This will only
 *         happen if phi is a multiple of 65537. To avoid, use a do-while loop to generate keys until the gcd is 1.
 *       - All messages should be divided into a number of parts. Then, each part should be converted to a number
 *         (that must be larger than 0 and smaller than n). In practice, the message should be divided into fragments
 *         of the size of a certain number of bits.
 *       - Use the library BigInteger to work with big numbers.
* */



import java.security.SecureRandom;

public class RSA
{
    public RSA()
    {

    }

    public int decrypt(int c, int[] privateKey)
    {
        int n = privateKey[0];
        int d = privateKey[1];

        return this.fastModExp(c, d, n);
    }

    public int encrypt(int m, int[] publicKey)
    {
        int n = publicKey[0];
        int e = publicKey[1];

        return this.fastModExp(m, e, n);
    }

    public int generatePrivateExponent(int e, int r)
    {
        return this.findInverse(e, r);
    }

    public int generatePublicExponent(int r)
    {
        int randomNumber;

        do{
            randomNumber = this.generateRandomNumber();
        }while(!(randomNumber > 1 && randomNumber < r && this.isCoPrime(randomNumber, r)));


        return randomNumber;
    }

    public int generatePhi(int p, int q)
    {
        return (p - 1) * (q - 1);
    }

    public int generateModulus(int p, int q)
    {
        return p*q;
    }

    public int generatePrime()
    {
        int randomNumber;
        do {
            randomNumber = this.generateRandomNumber();
        }while(!this.isPrime(randomNumber));
        return randomNumber;
    }

    private int fastModExp(int x, int n, int m)  //x is the base, n is the power, m is the modulus
    {
        int y=1;
        int u=x%m;

        do
        {								//when I use this algorithm in class:
            if(n % 2 == 1)
                y = (y * u) % m;      //this is equivalent to the 1st column
            n = (int)Math.floor(n/2);
            u = (u * u) % m;
        }while(n != 0);

        return y;
    }

    private int findInverse(int b, int a)
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

    private boolean isCoPrime(int e, int r)
    {
        // https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/
        if(this.GCD(e, r) == 1)
            return true;
        return false;
    }

    private int GCD(int a, int b)
    {
        if(a == 0 || b == 0)
            return 0;
        if(a == b)
            return a;
        if(a > b)
            return GCD(a-b, b);
        return GCD(a, b-a);
    }

    private boolean isPrime(int num)
    {
        // https://mkyong.com/java/how-to-determine-a-prime-number-in-java/
        if(num <= 1 || num % 2 == 0)
            return false;

        for(int i = 3; i*i <= num; i+=2)
            if(num % i == 0)
                return false;

        return true;
    }

    private int generateRandomNumber()
    {
        SecureRandom random = new SecureRandom();
        return random.nextInt(100);
    }
}

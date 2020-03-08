package keys;

import java.security.SecureRandom;

public class RSAKeyPair
{
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSAKeyPair()
    {
        this.generateKeys();
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    private void generateKeys()
    {
        int p = this.generatePrime();
        int q = this.generatePrime();
        int n = this.generateModulus(p, q);
        int r = this.generatePhi(p, q);
        int e = this.generatePublicExponent(r);
        int d = this.generatePrivateExponent(e, r);

        this.publicKey = new PublicKey(n, e);
        this.privateKey = new PrivateKey(n, d);
    }

    private int generatePrivateExponent(int e, int r)
    {
        return this.findInverse(e, r);
    }

    private int generatePublicExponent(int r)
    {
        int randomNumber;

        do{
            randomNumber = this.generateRandomNumber();
        }while(!(randomNumber > 1 && randomNumber < r && this.isCoPrime(randomNumber, r)));


        return randomNumber;
    }

    private int generatePhi(int p, int q)
    {
        return (p - 1) * (q - 1);
    }

    private int generateModulus(int p, int q)
    {
        return p*q;
    }

    private int generatePrime()
    {
        int randomNumber;
        do {
            randomNumber = this.generateRandomNumber();
        }while(!this.isPrime(randomNumber));
        return randomNumber;
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

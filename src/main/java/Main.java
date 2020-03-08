public class Main
{
    public static void main(String[] args)
    {
        // Create RSA algorithm object.
        RSA rsa = new RSA();

        // Generate two random prime numbers, p and q.
        int p = rsa.generatePrime();
        int q = rsa.generatePrime();

        // Calculate n=p*q modulus.
        int n = rsa.generateModulus(p, q);

        // Calculating Phi Using Euler Totient Function.
        int r = rsa.generatePhi(p, q);

        // Generate the exponents.
        int e = rsa.generatePublicExponent(r);
        int d = rsa.generatePrivateExponent(e, r);

        // Assign keys
        int[] publicKey = {n, e};
        int[] privateKey = {n, d};

        // Get message
        int m = 117;

        // Encrypt the message
        int c = rsa.encrypt(m, publicKey);
        int dm = rsa.decrypt(c, privateKey);


        System.out.println("p: "+p);
        System.out.println("q: "+q);
        System.out.println("n: "+n);
        System.out.println("r: "+r);
        System.out.println("e: "+e);
        System.out.println("d: "+d);
        System.out.println("---");
        System.out.println("m: "+m);
        System.out.println("c: "+c);
        System.out.println("dm: "+dm);
    }
}

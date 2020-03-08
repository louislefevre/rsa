public class Main
{
    public static void main(String[] args)
    {
        RSAKeyPair keyPair = new RSAKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        int message = 17;

        RSA rsa = new RSA();
        int encryptedMessage = rsa.encrypt(message, publicKey);
        int decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);

        System.out.println("m: "+message);
        System.out.println("c: "+encryptedMessage);
        System.out.println("dm: "+decryptedMessage);
    }
}

/*
* n = modulus
* */


//        System.out.println("p: "+p);
//        System.out.println("q: "+q);
//        System.out.println("n: "+n);
//        System.out.println("r: "+r);
//        System.out.println("e: "+e);
//        System.out.println("d: "+d);
//        System.out.println("---");
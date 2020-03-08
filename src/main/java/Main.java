import encryption.RSA;
import keys.PrivateKey;
import keys.PublicKey;
import keys.RSAKeyPair;

public class Main
{
    public static void main(String[] args)
    {
        RSAKeyPair keyPair = new RSAKeyPair();

        PublicKey publicKey = keyPair.getPublicKey();
        PrivateKey privateKey = keyPair.getPrivateKey();

        int message = 56;

        RSA rsa = new RSA();
        int encryptedMessage = rsa.encrypt(message, publicKey);
        int decryptedMessage = rsa.decrypt(encryptedMessage, privateKey);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
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
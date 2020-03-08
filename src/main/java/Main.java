import encryption.Cipher;

public final class Main
{
    public static void main(String[] args)
    {
        Cipher cipher = new Cipher();
        cipher.run();
    }
}

/*
* TODO: Use the library BigInteger to work with big numbers.
* TODO: Write tests for running the same message many times, seeing if it ever breaks.
* TODO: Write tests for trying a variety of characters.
*/
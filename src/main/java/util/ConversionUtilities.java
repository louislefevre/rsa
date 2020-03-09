package util;

import java.math.BigInteger;

public final class ConversionUtilities
{
    public static final int RADIX = 36;
    public static final int SIG_NUM = 1;

    private ConversionUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static BigInteger parseInteger(String input)
    {
        return new BigInteger(input, RADIX);
    }

    public static String parseString(BigInteger input)
    {
        return input.toString(RADIX);
    }

    public static BigInteger stringToBigInteger(String text)
    {
        byte[] bytes = text.getBytes();
        return new BigInteger(SIG_NUM, bytes);
    }

    public static String bigIntegerToString(BigInteger text)
    {
        byte[] bytes = text.toByteArray();
        return new String(bytes);
    }
}

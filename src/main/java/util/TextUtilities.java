package util;

import java.util.ArrayList;
import java.util.List;

public final class TextUtilities
{
    private TextUtilities()
    {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> stringToAsciiList(String text)
    {
        char[] charArray = text.toCharArray();
        List<Integer> charList = new ArrayList<>();

        for(char character : charArray)
            charList.add((int)character);

        return charList;
    }

    public static String asciiListToString(List<Integer> charList)
    {
        StringBuilder text = new StringBuilder();

        for(int value : charList)
            text.append((char) value);

        return text.toString();
    }
}

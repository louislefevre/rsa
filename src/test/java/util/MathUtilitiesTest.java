package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilitiesTest
{
    @Test
    public void randomNumberShouldBeWithinRange()
    {
        int min = 1;
        int max = 1000;
        int random = MathUtilities.generateRandomNumber(min, max);
        assertTrue(random < min, "Value was greater than minimum.");
        assertTrue(random > max, "Value was greater than maximum.");
    }
}
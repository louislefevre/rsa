package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilitiesTest
{
    @Test
    public void randomNumberShouldBeWithinRange()
    {
        int random = MathUtilities.generateRandomNumber();
        assertTrue(random > 0, "Random was 0 or less: " + random);
        assertTrue(random < MathUtilities.getBound(), "Message was out of : " + random);
    }
}
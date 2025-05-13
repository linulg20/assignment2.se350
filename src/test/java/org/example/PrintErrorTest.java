package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrintErrorTest {

    @Test
    public void invalidToString_NoException() {
        PrintError error = new PrintError(null, null);
        assertEquals("Invalid instruction ", error.toString());
    }

    @Test
    public void invalidToString_WithException() {
        Exception exception = new NumberFormatException();
        PrintError error = new PrintError(null, exception);
        assertTrue(error.toString().startsWith("Invalid instruction"));
    }

    @Test
    public void doesntDoAnything() {
        // just ensure no exception
        new PrintError(null, null).execute();
    }
}

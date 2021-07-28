package utility;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputOutputTest {
    InputOutput io = new InputOutput();
    String validInput;
    String invalidInput;
    String input;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        validInput = "123p";
        invalidInput = "XX";
        input = "£1.89p";
    }

    @Test
    void ifNotValidateShouldBeZero() {
        String res = io.validate(invalidInput);
        assertEquals("0", res);
    }

    @Test
    void ifValidateShouldBeTheString() {
        String res = io.validate(validInput);
        assertEquals(validInput, res);
    }

    /*@Test
    void correctlyPreprocessed() {
        int res = io.preProcessingInput(validInput);
        assertEquals(123, res);
    }*/

}
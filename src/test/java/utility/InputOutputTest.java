package utility;

import org.junit.jupiter.api.Test;

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

    @Test
    void inputContainsPenceSign() {
        String input = "123p";
        int res = io.preProcessingInput(input);
        assertEquals(123, res);
    }

    @Test
    void inputContainsPoundSign() {
        String input = "£12";
        int res = io.preProcessingInput(input);
        assertEquals(1200, res);
    }

    @Test
    void inputContainsPoundAndPenceSigns() {
        String input = "£12p";
        int res = io.preProcessingInput(input);
        assertEquals(1200, res);
    }

    @Test
    void inputContainsFloatingPointWithoutAnySign() {
        String input = "12.3";
        int res = io.preProcessingInput(input);
        assertEquals(1230, res);
    }

    @Test
    void inputContainsFloatingPointWithPoundSign() {
        String input = "£12.3";
        int res = io.preProcessingInput(input);
        assertEquals(1230, res);
    }

    @Test
    void inputContainsFloatingPointWithPoundAndPenceSigns() {
        String input = "£12.3p";
        int res = io.preProcessingInput(input);
        assertEquals(1230, res);
    }

    @Test
    void inputNeedsTobeRounded() {
        String input = "£12.343p";
        int res = io.preProcessingInput(input);
        assertEquals(1235, res);
    }

    @Test
    void inputIsDecimal() {
        String input = "12";
        int res = io.preProcessingInput(input);
        assertEquals(12, res);
    }

}
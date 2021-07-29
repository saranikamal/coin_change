package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sara
 * Test cases to check the functionality of input validation method.
 */
class InputValidatorTest {
      private final Validator inputValidator = new InputValidator();

    @Test
    void inputWithPoundSignOnly() {
        String input = "£2";
        boolean isValid = inputValidator.isInputValid(input);
        assertTrue(isValid);
    }

    @Test
    void inputWithPenceSignOnly() {
        String input = "2p";
        boolean isValid = inputValidator.isInputValid(input);
        assertTrue(isValid);
    }

    @Test
    void inputWithPenceAndPoundSigns() {
        String input = "£23p";
        boolean isValid = inputValidator.isInputValid(input);
        assertTrue(isValid);
    }

    @Test
    void floatingPointInputWithDotAtBeginning() {
        String input = ".9";
        boolean isValid = inputValidator.isInputValid(input);
        assertTrue(isValid);
    }

    @Test
    void floatingPointInputWithDotAtTheEnd() {
        String input = "9.";
        boolean isValid = inputValidator.isInputValid(input);
        assertFalse(isValid);
    }

    @Test
    void inputMissingDigits() {
        String input = "£p";
        boolean isValid = inputValidator.isInputValid(input);
        assertFalse(isValid);
    }

    @Test
    void wrongCharactersInInput() {
        String input = "1x";
        boolean isValid = inputValidator.isInputValid(input);
        assertFalse(isValid);
    }

    @Test
    void validSymbolsAndNumericWithWrongSymbol() {
        String input = "£1x.0p";
        boolean isValid = inputValidator.isInputValid(input);
        assertFalse(isValid);
    }

    @Test
    void emptyInput() {
        String input = " ";
        boolean isValid = inputValidator.isInputValid(input);
        assertFalse(isValid);
    }
}
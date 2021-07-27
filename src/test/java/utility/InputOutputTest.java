package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputOutputTest {
    InputOutput io = new InputOutput();
    String validInput;
    String invalidInput;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        validInput = "123p";
        invalidInput = "XX";
    }

//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getInput() {
////        String res = io. // getInput();
////        assertEquals("", res);
//    }

    @Test
    void ifNotValidateShouldBeEmpty() {
        String res = io.validate(invalidInput);
        assertEquals("", res);
    }

    @Test
    void ifValidateShouldBeTheString() {
        String res = io.validate(validInput);
        assertEquals(validInput, res);
    }
}
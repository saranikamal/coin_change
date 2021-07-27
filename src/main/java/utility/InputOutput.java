package utility;

import java.util.Scanner;

public class InputOutput {

    private Scanner scanner = new Scanner(System.in);
    private Validator inputValidator = new InputValidator();

    /*I have to close scanner in a graceful way*/

    private String readLine() {
        System.out.println("Enter an amount:");
        return scanner.nextLine();
    }

    private boolean validateInput(String input){
        return inputValidator.isInputValid(input);
    }

    public String getInput(){
      //  validateInput(readLine());
        return "test";
    }
}

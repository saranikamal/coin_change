import java.util.Scanner;

public class InputOutput {

    private Scanner scanner = new Scanner(System.in);

    /*I have to close scanner in a graceful way*/

    public String getInput() {
        System.out.println("Enter an amount:");
        return scanner.nextLine();
    }
}

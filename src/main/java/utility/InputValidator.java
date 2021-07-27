package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator implements Validator {
    @Override
    public boolean isInputValid(String input){
        String regex = "^[£]?[0-9]*\\.?[0-9]+[p]?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

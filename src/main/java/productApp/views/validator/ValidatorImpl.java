package productApp.views.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidatorImpl implements IValidator{



    @Override
    public int isNumeric(String str, int threshold) {

        try {
            int anDouble = Integer.parseInt(str);
            if (anDouble < threshold) {
                return anDouble;
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid Age Number: Should be < 120 ans");
        }

        return 0;
    }


    @Override
    public float isFloat(String str, float threshold) {
        try {
            float aFloat = Float.parseFloat(str);
            if (aFloat < threshold) {
                return aFloat;
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Invalid Price: Should be float 0.0 and < 1000 ans");
        }
        return 0.0F;
    }

    @Override
    public void isValidateDate(String str) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern ( "dd/MM/uuuu" );
        try {
            LocalDate ld = LocalDate.parse ( str , f );
            System.out.println ( "ld: " + ld );
        } catch ( DateTimeParseException e ) {
            System.out.println ( "ERROR: " + e );
        }
    }

    @Override
    public void isValidStr(String str, String pattern) {

        if (str==null || !str.matches(pattern) ) {
            throw new IllegalArgumentException("Invalid " + str + ": You Should follow the pattern == " + pattern);
        }
    }


}

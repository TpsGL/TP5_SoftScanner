package views.validator;

public class ValidatorImpl implements IValidator{



    @Override
    public void isNumeric(String str, double threshold) {

        try {
            double anDouble = Double.parseDouble(str);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid Age Number: Should be < 120 ans");
        }
    }

    @Override
    public void isValidStr(String str, String pattern) {

        if (str==null || !str.matches(pattern) ) {
            throw new IllegalArgumentException("Invalid " + str + ": You Should follow the pattern == " + pattern);
        }
    }


}

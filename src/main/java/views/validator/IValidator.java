package views.validator;

public interface IValidator {

    public void isNumeric(String str, double threshold);

    public void isValidStr(String str, String pattern);

}

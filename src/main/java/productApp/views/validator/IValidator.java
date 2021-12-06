package productApp.views.validator;

public interface IValidator {

    public int isNumeric(String str, int threshold);

    public float isFloat(String str, float threshold);

    public void isValidateDate(String str);

    public void isValidStr(String str, String pattern);

}

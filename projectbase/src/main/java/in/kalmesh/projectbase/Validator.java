package in.kalmesh.projectbase;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Kalmeshwar on 18 Jan 2020 at 18:22.
 */
public class Validator {
    private static Validator validator = null;

    private Validator() {
    }

    public static Validator getInstance() {
        return validator == null ? (validator = new Validator()) : validator;
    }

    public boolean isNotEmpty(String value) {
        return !TextUtils.isEmpty(value);
    }

    public boolean isValidEmail(String str_email) {
        return Patterns.EMAIL_ADDRESS.matcher(str_email).matches();
    }

    public boolean isContainsDigits(String value) {
        return TextUtils.isDigitsOnly(value);
    }

    public boolean hasLength(String value, int length) {
        return value.length() == length;
    }

    public boolean isLessThan(String value, int length) {
        return value.length() < length;
    }

    public boolean isGreaterThan(String value, int length) {
        return value.length() > length;
    }

    public int checkEmpty(String value, int returnDefaultValue) {
        return isNotEmpty(value) ? Integer.parseInt(value) : returnDefaultValue;
    }

    public double checkEmpty(String value, double returnDefaultValue) {
        return isNotEmpty(value) ? Double.parseDouble(value) : returnDefaultValue;
    }

    public String checkEmpty(String value, String returnDefaultValue) {
        return isNotEmpty(value) ? value : String.valueOf(returnDefaultValue);
    }

    public String hasValueAfterDecimal(double dValue) {
        String returnValue = "0";
        if ((dValue == Math.floor(dValue)) && !Double.isInfinite(dValue)) {
            String strQty = String.valueOf(dValue);
            returnValue = strQty.substring(0, strQty.lastIndexOf('.'));
        } else {
            returnValue = String.valueOf(dValue);
        }

        return returnValue;
    }
}
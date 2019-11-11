package in.kalmesh.projectbase;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Kalmeshwar on 02 Jul 2019 at 18:22.
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
}
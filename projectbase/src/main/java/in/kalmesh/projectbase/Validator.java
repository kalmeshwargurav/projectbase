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

    public boolean isNotEmpty(String string) {
        return !TextUtils.isEmpty(string);
    }

    public boolean isSmallerThan(String string, int length) {
        return string.length() < length;
    }

    public boolean isValidEmail(String str_email) {
        return Patterns.EMAIL_ADDRESS.matcher(str_email).matches();
    }
}

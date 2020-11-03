package in.kalmesh.projectbase;

import java.text.DecimalFormat;

/**
 * Created by Kalmeshwar on 03 Nov 2020 at 12:51.
 */
public class DecimalFormatter {
    private DecimalFormat formatter = null;

    public DecimalFormatter() {
        formatter = new DecimalFormat("0.00");
    }

    public DecimalFormatter(int count) {
        if (count > 0) {
            StringBuilder afterValue = new StringBuilder();
            for (int i = 0; i < count; i++) {
                afterValue.append("0");
            }
            formatter = new DecimalFormat("0." + afterValue.toString());
        } else {
            formatter = new DecimalFormat("0.00");
        }
    }

    public String format(String value) {
        String result = "0.00";
        if (formatter != null) {
            if (Validator.getInstance().isNotEmpty(value))
                result = formatter.format(Double.parseDouble(value));
        }
        return result;
    }

    public Double format(Double value) {
        String result = "0.00";
        if (formatter != null)
            result = formatter.format(value);
        return Double.parseDouble(result);
    }

    public float format(Float value) {
        String result = "0.00";
        if (formatter != null)
            result = formatter.format(value);
        return Float.parseFloat(result);
    }
}

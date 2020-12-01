package in.kalmesh.projectbase;

/**
 * Created by Kalmeshwar on 01 Dec 2020 at 12:23.
 */
public class VersionHelper {
    /**
     * Compares one version string to another version string by dotted ordinals.
     * eg. "1.0" > "0.09" ; "0.9.5" < "0.10",
     * also "1.0" < "1.0.0" but "1.0" == "01.00"
     *
     * @param currentAppVersion the currentVersion string
     * @param latestVersion     the latestVersion string
     * @return 0 if equal, -1 if thisVersion &lt; comparedVersion and 1 otherwise.
     */
    public static int compare(String currentAppVersion, String latestVersion) {
        if (currentAppVersion.equals(latestVersion)) {
            return 0;
        }
        int leftStart = 0, rightStart = 0, result;
        do {
            int leftEnd = currentAppVersion.indexOf('.', leftStart);
            int rightEnd = latestVersion.indexOf('.', rightStart);
            Integer leftValue = Integer.parseInt(leftEnd < 0
                    ? currentAppVersion.substring(leftStart)
                    : currentAppVersion.substring(leftStart, leftEnd));
            Integer rightValue = Integer.parseInt(rightEnd < 0
                    ? latestVersion.substring(rightStart)
                    : latestVersion.substring(rightStart, rightEnd));
            result = leftValue.compareTo(rightValue);
            leftStart = leftEnd + 1;
            rightStart = rightEnd + 1;
        } while (result == 0 && leftStart > 0 && rightStart > 0);
        if (result == 0) {
            if (leftStart > rightStart) {
                return containsNonZeroValue(currentAppVersion, leftStart) ? 1 : 0;
            }
            if (leftStart < rightStart) {
                return containsNonZeroValue(latestVersion, rightStart) ? -1 : 0;
            }
        }
        return result;
    }

    private static boolean containsNonZeroValue(String str, int beginIndex) {
        for (int i = beginIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '0' && c != '.') {
                return true;
            }
        }
        return false;
    }
}
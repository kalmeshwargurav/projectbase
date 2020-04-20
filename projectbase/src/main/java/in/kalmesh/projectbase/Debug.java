package in.kalmesh.projectbase;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Debug {
    public static boolean printLog = true;
    public static String log_folderName = "kalmesh";
    public static String log_fileName = "KalmeshAppLogs";
    public static String log_fileExtention = ".txt";
    public static boolean fileWriteEnabled = true;
    private boolean fileWriteCreationFailed = false;
    private static Debug instance = new Debug();
    private File mFile = null;

    public Debug() {
    }

    public static void printLogD(String TAG, String message, boolean saveToFile) {
        if (printLog) {
            final String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            final String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            final int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            final String msgMetaData = "##" + Thread.currentThread() + "## " + className + "." + methodName + "() ## ln " + lineNumber + " ## msg => " + message;
            //final String msgMetaData = "## " + className + "." + methodName + "() \n## ln " + lineNumber + " ## msg => " + msg;

            if (fileWriteEnabled && saveToFile)
                instance.writeToFile(msgMetaData);

            Log.d(TAG, msgMetaData);
        }
    }

    public static void printLogError(String TAG, String message, boolean saveToFile) {
        if (printLog) {
            final String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            final String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            final int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            final String msgMetaData = "##" + Thread.currentThread() + "## " + className + "." + methodName + "() ## ln " + lineNumber + " ## msg => " + message;
            //final String msgMetaData = "## " + className + "." + methodName + "() \n## ln " + lineNumber + " ## msg => " + msg;

            if (fileWriteEnabled && saveToFile)
                instance.writeToFile(msgMetaData);

            Log.e(TAG, msgMetaData);
        }
    }

    public static void printLogException(String TAG, Exception exception, boolean saveToFile) {
        if (printLog) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            String msg = sw.toString(); // stack trace as a string

            final String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            final String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            final int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
            final String msgMetaData = "##" + Thread.currentThread() + "## " + className + "." + methodName + "() ## ln " + lineNumber + " ## msg => " + msg;

            if (fileWriteEnabled && saveToFile)
                instance.writeToFile(msgMetaData);

            Log.e(TAG, msgMetaData);
        }
    }

    public static void printLogV(String TAG, String message) {
        if (printLog)
            Log.v(TAG, message);
    }

    public static void printLogI(String TAG, String message) {
        if (printLog)
            Log.i(TAG, message);
    }

    public static void printLogW(String TAG, String message) {
        if (printLog)
            Log.w(TAG, message);
    }

    private void writeToFile(final String msg) {
        if (!fileWriteCreationFailed) {
            try {
                File fileWriter = getFileWriter();
                String terminalTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault())
                        .format(Calendar.getInstance().getTime());
                BufferedWriter buf = new BufferedWriter(new FileWriter(fileWriter, true));
                buf.append(terminalTime).append(" : ").append(msg).append("\n");
                buf.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private File getFileWriter() throws IOException {
        if (mFile == null) {
            mFile = createFileWriter();
        } else if (mFile.length() > 300000) {    // after 300,000 = 300KB we are creating new log file
            try {
                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/" + log_folderName);
                String terminalTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault())
                        .format(Calendar.getInstance().getTime());
                File to = new File(myDir, log_fileName + terminalTime + log_fileExtention);

                if (mFile.exists())
                    mFile.renameTo(to);
            } catch (Exception e) {
                // TODO: handle exception
            }
            mFile = createFileWriter();
        }
        return mFile;
    }

    private File createFileWriter() {
        File filelog = null;
        try {
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/" + log_folderName);
            myDir.mkdirs();
            filelog = new File(myDir, log_fileName + log_fileExtention);
            filelog.createNewFile();
        } catch (Exception err) {
            fileWriteCreationFailed = true;
            err.printStackTrace();
        }
        return filelog;
    }
}

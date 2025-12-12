package com.staf621.ki4a.injector;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PayloadInjector {
    private static final String TAG = "PayloadInjector";

    public static String formatPayload(String payload) {
        if (payload == null) return "";
        return payload
                .replace("[crlf]", "\r\n")
                .replace("[lf]", "\n")
                .replace("[cr]", "\r")
                .replace("[CRLF]", "\r\n")
                .replace("[LF]", "\n")
                .replace("[CR]", "\r");
    }

    public static boolean writeHeaderFile(String payload, String filePath) {
        if (payload == null || payload.isEmpty()) return false;

        String formattedPayload = formatPayload(payload);

        try {
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(formattedPayload);
            writer.close();
            return true;
        } catch (IOException e) {
            Log.e(TAG, "Error writing header file", e);
            return false;
        }
    }
}

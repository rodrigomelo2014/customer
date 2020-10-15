package com.customer.util;

import java.sql.Timestamp;

import com.customer.constants.LogKey;

public class LogUtil {
    private LogUtil() {}

    public static String formatLog(String methodName, String request, String response) {

        StringBuilder logMessage = new StringBuilder();

        logMessage
                .append(LogKey.NEW_LINE_KEY)
                .append(LogKey.TIMESTAMP_KEY)
                .append(new Timestamp(System.currentTimeMillis()))
                .append(LogKey.NEW_LINE_KEY)
                .append(LogKey.METHOD_KEY)
                .append(methodName)
                .append(LogKey.NEW_LINE_KEY)
                .append(LogKey.INPUT_KEY)
                .append(request)
                .append(LogKey.NEW_LINE_KEY)
                .append(LogKey.OUTPUT_KEY)
                .append(response);

        return logMessage.toString();
    }
}

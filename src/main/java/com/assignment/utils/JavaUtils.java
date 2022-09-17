package com.assignment.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaUtils {

    public static String getDateAndTime() {
        return new SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime());
    }
}

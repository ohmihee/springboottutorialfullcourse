package com.example.javafullcourse.learnAnnonation;

import java.util.Calendar;
import java.util.Date;

public class StandardAnnotation {
    public static void main(String[] args) {
        getDate();
        getMonthFromDate();
    }

    /**
     * Get current system date
     *
     * @return current system date.
     * @deprecated This method will removed in the near future.
     * */
    @Deprecated
    public static Date getDate() {
        return new Date();
    }

    public static int getMonthFromDate() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }
}

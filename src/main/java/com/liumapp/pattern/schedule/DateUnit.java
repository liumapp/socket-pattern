package com.liumapp.pattern.schedule;

/**
 * Created by liumapp on 1/5/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class DateUnit {

    public static enum IntervalUnit {
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK,
        MONTH,
        YEAR;

        private IntervalUnit() {
        }
    }

}

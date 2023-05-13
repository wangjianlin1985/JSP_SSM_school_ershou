// 
// 
// 

package com.ldu.util;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil
{
    public static final String FORMAT1 = "yyyy-MM-dd";
    public static final String FORMAT2 = "yyyy-MM-dd HH:mm";
    public static final String FORMAT3 = "yyyy-MM-dd HH:mm:ss";
    
    public static String getNowDay() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date date = new Date();
        final String _time = sdf.format(date);
        return _time;
    }
    
    public static String getNowDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        final Date date = new Date();
        final String _time = sdf.format(date);
        return _time;
    }
    
    public static String getNowTime() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = new Date();
        final String _time = sdf.format(date);
        return _time;
    }
    
    public static String getDayBeginDate(final long time) {
        final Long three = 86400000L;
        final Long threeDay = time - three;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date threeTime = new Date(threeDay);
        final String _time = sdf.format(threeTime);
        return _time;
    }
    
    public static String getThreeBeginDate(final long time) {
        final Long three = 259200000L;
        final Long threeDay = time - three;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date threeTime = new Date(threeDay);
        final String _time = sdf.format(threeTime);
        return _time;
    }
    
    public static String getMonthBeginDate(final long time) {
        final Long month = 2592000000L;
        final Long threeDay = time - month;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date threeTime = new Date(threeDay);
        final String _time = sdf.format(threeTime);
        return _time;
    }
    
    public static String getThreeDayBeginTime(final long time) {
        final Long three = 259200000L;
        final Long threeDay = time - three;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date threeTime = new Date(threeDay);
        final String _time = sdf.format(threeTime);
        return _time;
    }
    
    public static String getTenBeginTime(final long time) {
        final Long three = 864000000L;
        final Long threeDay = time - three;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date threeTime = new Date(threeDay);
        final String _time = sdf.format(threeTime);
        return _time;
    }
    
    public static Date getDateSecond(final long time) {
        final Long month = 10000L;
        final Long threeDay = time - month;
        final Date threeTime = new Date(threeDay);
        return threeTime;
    }
    
    public static Date getThreeDayBeginTime(final Date time) {
        final Long three = 259200000L;
        final Long threeDay = time.getTime() - three;
        final Date threeTime = new Date(threeDay);
        return threeTime;
    }
    
    public static String formatTimeNew(final Date date) {
        if (date == null) {
            return null;
        }
        String checkTime = String.valueOf(date);
        if (checkTime != null && !"".equals(checkTime) && checkTime.length() > 19) {
            checkTime = checkTime.substring(0, 19);
        }
        return checkTime;
    }
    
    public static String formatTime(final Date date) {
        if (date == null) {
            return null;
        }
        String checkTime = String.valueOf(date);
        if (checkTime != null && !"".equals(checkTime) && checkTime.length() > 19) {
            checkTime = checkTime.substring(0, 16);
        }
        return checkTime;
    }
    
    public static String formatDate(final Date date) {
        if (date == null) {
            return null;
        }
        String checkTime = String.valueOf(date);
        if (checkTime != null && !"".equals(checkTime) && checkTime.length() > 19) {
            checkTime = checkTime.substring(0, 10);
        }
        return checkTime;
    }
    
    public static String formatDate(final String date) {
        if (date == null) {
            return null;
        }
        String checkTime = String.valueOf(date);
        if (checkTime != null && !"".equals(checkTime) && checkTime.length() > 19) {
            checkTime = checkTime.substring(0, 10);
        }
        return checkTime;
    }
    
    public static String formatTime(final String date) {
        if (date == null) {
            return null;
        }
        String checkTime = String.valueOf(date);
        if (checkTime != null && !"".equals(checkTime) && checkTime.length() > 19) {
            checkTime = checkTime.substring(0, 19);
        }
        return checkTime;
    }
    
    public static String getLastTime(final String time, final int lastTime) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newTime = time;
        try {
            final Date date = sdf.parse(time);
            final Long lastTimeDay = lastTime * 24 * 60 * 60 * 1000L;
            final Long lastDay = date.getTime() + lastTimeDay;
            final Date newDate = new Date(lastDay);
            newTime = sdf.format(newDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return newTime;
    }
}

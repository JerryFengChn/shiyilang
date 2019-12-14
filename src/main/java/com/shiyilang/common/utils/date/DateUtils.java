package com.shiyilang.common.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Destription:date process tool
 * using default value when the needed value is null or has exception
 * @Auther:shiyilang
 * @Date:2018/11/29 22:38
 * @Version:1.0
 */
public class DateUtils {
    private static final String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    /**
     * @Description:根据指定格式获取当前时间
     * @Date 2018/11/29 22:41
     * @Param [format]
     * @return java.lang.String
     */
    public static String getCurrentTime(String format){
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * @Description:获取当前时间，格式为：yyyy-MM-dd HH:mm:ss
     * @Date 2018/11/29 22:41
     * @Param []
     * @return java.lang.String
     */
    public static String getCurrentTime(){
        return getCurrentTime(DateFormatUtils.DATE_FORMAT2);
    }

    /**
     * @Description:获取指定格式的当前时间：为空时格式为yyyy-mm-dd HH:mm:ss
     * @Date 2018/11/29 22:41
     * @Param [format]
     * @return java.util.Date
     */
    public static Date getCurrentDate(String format){
         SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
         String dateS = getCurrentTime(format);
         Date date = null;
         try {
            date = sdf.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description:获取当前时间，格式为yyyy-MM-dd HH:mm:ss
     * @Date 2018/11/29 22:42
     * @Param []
     * @return java.util.Date
     */
    public static Date getCurrentDate(){
        return getCurrentDate(DateFormatUtils.DATE_FORMAT2);
    }

    /**
     * @Description:给指定日期加入年份，为空时默认当前时间
     * @Date 2018/11/29 22:42
     * @Param [year, date, format]
     * @return java.lang.String
     */
    public static String addYearToDate(int year,Date date,String format){
        Calendar calender = getCalendar(date,format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calender.add(Calendar.YEAR, year);

        return sdf.format(calender.getTime());
    }

    /**
     * @Description:给指定日期加入年份，为空时默认当前时间
     * @Date 2018/11/29 22:43
     * @Param [year, date, format]
     * @return java.lang.String
     */
    public static String addYearToDate(int year,String date,String format){
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addYearToDate(year, newDate, format);
    }

    /**
     * @Description:给指定日期增加月份 为空时默认当前时间
     * @Date 2018/11/29 22:43
     * @Param [month, date, format]
     * @return java.lang.String
     */
    public static String addMothToDate(int month,Date date,String format) {
        Calendar calender = getCalendar(date,format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calender.add(Calendar.MONTH, month);

        return sdf.format(calender.getTime());
    }

    /**
     * @Description:给指定日期增加月份 为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [month, date, format]
     * @return java.lang.String
     */
    public static String addMothToDate(int month,String date,String format) {
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addMothToDate(month, newDate, format);
    }

    /**
     * @Description:给指定日期增加天数，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [day, date, format]
     * @return java.lang.String
     */
    public static String addDayToDate(int day,Date date,String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.DATE, day);

        return sdf.format(calendar.getTime());
    }

    /**
     * @Description:给指定日期增加天数，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [day, date, format]
     * @return java.lang.String
     */
    public static String addDayToDate(int day,String date,String format) {
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addDayToDate(day, newDate, format);
    }

    /**
     * @Description:给指定日期增加小时，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [hour, date, format]
     * @return java.lang.String
     */
    public static String addHourToDate(int hour,Date date,String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.HOUR, hour);

        return sdf.format(calendar.getTime());
    }

    /**
     * @Description:给指定日期增加小时，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [hour, date, format]
     * @return java.lang.String
     */
    public static String addHourToDate(int hour,String date,String format) {
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addHourToDate(hour, newDate, format);
    }

    /**
     * @Description:给指定的日期增加分钟，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [minute, date, format]
     * @return java.lang.String
     */
    public static String addMinuteToDate(int minute,Date date,String format) {
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.MINUTE, minute);

        return sdf.format(calendar.getTime());
    }

    /**
     * @Description:给指定的日期增加分钟，为空时默认当前时间
     * @Date 2018/11/29 22:44
     * @Param [minute, date, format]
     * @return java.lang.String
     */
    public static String addMinuteToDate(int minute,String date,String format){
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addMinuteToDate(minute, newDate, format);
    }

    /**
     * @Description:给指定日期增加秒，为空时默认当前时间
     * @Date 2018/11/29 22:45
     * @Param [second, date, format]
     * @return java.lang.String
     */
    public static String addSecondToDate(int second,Date date,String format){
        Calendar calendar = getCalendar(date, format);
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        calendar.add(Calendar.SECOND, second);

        return sdf.format(calendar.getTime());
    }

    /**
     * @Description:给指定日期增加秒，为空时默认当前时间
     * @Date 2018/11/29 22:45
     * @Param [second, date, format]
     * @return java.lang.String
     */
    public static String addSecondToDate(int second,String date,String format){
        Date newDate = new Date();
        if(null != date && !"".equals(date)){
            newDate = string2Date(date, format);
        }

        return addSecondToDate(second, newDate, format);
    }

    /**
     * @Description:获取指定格式指定时间的日历
     * @Date 2018/11/29 22:45
     * @Param [date, format]
     * @return java.util.Calendar
     */
    public static Calendar getCalendar(Date date,String format){
        if(date == null){
            date = getCurrentDate(format);
        }

        Calendar calender = Calendar.getInstance();
        calender.setTime(date);

        return calender;
    }

    /**
     * @Description:字符串转换为日期，日期格式为
     * @Date 2018/11/29 22:45
     * @Param [value]
     * @return java.util.Date
     */
    public static Date string2Date(String value){
        if(value == null || "".equals(value)){
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(DateFormatUtils.DATE_FORMAT2);
        Date date = null;

        try {
            value = DateFormatUtils.formatDate(value, DateFormatUtils.DATE_FORMAT2);
            date = sdf.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description:将字符串(格式符合规范)转换成Date
     * @Date 2018/11/29 22:45
     * @Param [value, format]
     * @return java.util.Date
     */
    public static Date string2Date(String value,String format){
        if(value == null || "".equals(value)){
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        Date date = null;

        try {
            value = DateFormatUtils.formatDate(value, format);
            date = sdf.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Description:将日期格式转换成String
     * @Date 2018/11/29 22:46
     * @Param [value, format]
     * @return java.lang.String
     */
    public static String date2String(Date value,String format){
        if(value == null){
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);
        return sdf.format(value);
    }

    /**
     * @Description:日期转换为字符串
     * @Date 2018/11/29 22:46
     * @Param [value]
     * @return java.lang.String
     */
    public static String date2String(Date value){
        if(value == null){
            return null;
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat(DateFormatUtils.DATE_FORMAT2);
        return sdf.format(value);
    }

    /**
     * @Description:获取指定日期的年份
     * @Date 2018/11/29 22:46
     * @Param [value]
     * @return int
     */
    public static int getCurrentYear(Date value){
        String date = date2String(value, DateFormatUtils.DATE_YEAR);
        return Integer.valueOf(date);
    }

    /**
     * @Description:获取指定日期的年份
     * @Date 2018/11/29 22:46
     * @Param [value]
     * @return int
     */
    public static int getCurrentYear(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_YEAR);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_YEAR);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @Description:获取指定日期的月份
     * @Date 2018/11/29 22:46
     * @Param [value]
     * @return int
     */
    public static int getCurrentMonth(Date value){
        String date = date2String(value, DateFormatUtils.DATE_MONTH);
        return Integer.valueOf(date);
    }

    /**
     * @Description:获取指定日期的月份
     * @Date 2018/11/29 22:46
     * @Param [value]
     * @return int
     */
    public static int getCurrentMonth(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_MONTH);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_MONTH);

        return calendar.get(Calendar.MONTH);
    }

    /**
     * @Description:获取指定日期的天份
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentDay(Date value){
        String date = date2String(value, DateFormatUtils.DATE_DAY);
        return Integer.valueOf(date);
    }

    /**
     * @Description:获取指定日期的天份
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentDay(String value){
        Date date = string2Date(value, DateFormatUtils.DATE_DAY);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_DAY);

        return calendar.get(Calendar.DATE);
    }

    /**
     * @Description:获取当前日期为星期几
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return java.lang.String
     */
    public static String getCurrentWeek(Date value) {
        Calendar calendar = getCalendar(value, DateFormatUtils.DATE_FORMAT1);
        int weekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1 < 0 ? 0 : calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return weeks[weekIndex];
    }

    /**
     * @Description:获取当前日期为星期几
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return java.lang.String
     */
    public static String getCurrentWeek(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_FORMAT1);
        return getCurrentWeek(date);
    }

    /**
     * @Description:获取指定日期的小时
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentHour(Date value){
        String date = date2String(value, DateFormatUtils.DATE_HOUR);
        return Integer.valueOf(date);
    }

    /**
     * @Description:获取指定日期的小时
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentHour(String value) {
        Date date = string2Date(value, DateFormatUtils.DATE_HOUR);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_HOUR);

        return calendar.get(Calendar.DATE);
    }

    /**
     * @Description:获取指定日期的分钟
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentMinute(Date value){
        String date = date2String(value, DateFormatUtils.DATE_MINUTE);
        return Integer.valueOf(date);
    }

    /**
     * @Description:获取指定日期的分钟
     * @Date 2018/11/29 22:47
     * @Param [value]
     * @return int
     */
    public static int getCurrentMinute(String value){
        Date date = string2Date(value, DateFormatUtils.DATE_MINUTE);
        Calendar calendar = getCalendar(date, DateFormatUtils.DATE_MINUTE);

        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 比较两个日期相隔多少天(月、年) <br>
     * 例：<br>
     * &nbsp;compareDate("2009-09-12", null, 0);//比较天 <br>
     * &nbsp;compareDate("2009-09-12", null, 1);//比较月 <br> 
     * &nbsp;compareDate("2009-09-12", null, 2);//比较年 <br>
     * 
     * @date Dec 31, 2013
     * @param startDay 需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12   
     * @param endDay 被比较的时间  为空(null)则为当前时间    
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年    
     * @return int
     */    
    public static int compareDate(String startDay,String endDay,int stype) {     
        int n = 0;     
        startDay = DateFormatUtils.formatDate(startDay, "yyyy-MM-dd");
        endDay = DateFormatUtils.formatDate(endDay, "yyyy-MM-dd");
        
        String formatStyle = "yyyy-MM-dd";
        if(1 == stype){
            formatStyle = "yyyy-MM";
        }else if(2 == stype){
            formatStyle = "yyyy";
        }   
             
        endDay = endDay==null ? getCurrentTime("yyyy-MM-dd") : endDay;     
             
        DateFormat df = new SimpleDateFormat(formatStyle);     
        Calendar c1 = Calendar.getInstance();     
        Calendar c2 = Calendar.getInstance();     
        try {     
            c1.setTime(df.parse(startDay));     
            c2.setTime(df.parse(endDay));   
        } catch (Exception e) {    
            e.printStackTrace();
        }     
        while (!c1.after(c2)) {                   // 循环对比，直到相等，n 就是所要的结果     
            n++;     
            if(stype==1){     
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1     
            }     
            else{     
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1     
            }     
        }     
        n = n-1;     
        if(stype==2){     
            n = (int)n/365;     
        }        
        return n;     
    }   
    
    /**
     * 比较两个时间相差多少小时(分钟、秒)
     * @date Jan 2, 2018
     * @param startTime 需要比较的时间 不能为空，且必须符合正确格式：2012-12-12 12:12:
     * @param endTime 需要被比较的时间 若为空则默认当前时间
     * @param type 1：小时   2：分钟   3：秒
     * @return int
     */
    public static int compareTime(String startTime , String endTime , int type) {
        //endTime是否为空，为空默认当前时间
        if(endTime == null || "".equals(endTime)){
            endTime = getCurrentTime();
        }

        SimpleDateFormat sdf = DateFormatUtils.getFormat("");
        int value = 0;
        try {
            Date begin = sdf.parse(startTime);
            Date end = sdf.parse(endTime);
            long between = (end.getTime() - begin.getTime()) / 1000;  //除以1000转换成豪秒
            if(type == 1){   //小时
                value = (int) (between % (24 * 36000) / 3600);
            }
            else if(type == 2){
                value = (int) (between % 3600 / 60);
            }
            else if(type == 3){
                value = (int) (between % 60 / 60);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
    
    /**
     * 比较两个日期的大小。<br>
     * 若date1 > date2 则返回 1<br>
     * 若date1 = date2 则返回 0<br>
     * 若date1 < date2 则返回-1
     * @date:2018年9月9日
     *
     * @param date1  
     * @param date2
     * @param format  待转换的格式
     * @return 比较结果
     */
    public static int compare(String date1, String date2,String format) {
        DateFormat df = DateFormatUtils.getFormat(format);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    /**
     * @Description:获取指定月份的第一天
	 * @Date 2018/11/29 22:49
     * @Param [date]
     * @return java.lang.String
     */
    public static String getMonthFirstDate(String date){
        date = DateFormatUtils.formatDate(date);
        return DateFormatUtils.formatDate(date, "yyyy-MM") + "-01";
    }
    
    /**
     * @Description:获取指定月份的最后一天
     * @Date 2018/11/29 22:49
     * @Param [date]
     * @return java.lang.String
     */
    public static String getMonthLastDate(String date) {
        Date strDate = DateUtils.string2Date(getMonthFirstDate(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strDate);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return DateFormatUtils.formatDate(calendar.getTime());
    }

    /**
     * @Description:获取所在星期的第一天
     * @Date 2018/11/29 22:49
     * @Param [date]
     * @return java.util.Date
     */
    public static Date getWeekFirstDate(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int today = now.get(Calendar.DAY_OF_WEEK);
        int first_day_of_week = now.get(Calendar.DATE) + 2 - today; // 星期一
        now.set(now.DATE, first_day_of_week);
        return now.getTime();
    }

    /**
     * @Description:获取所在星期的最后一天
     * @Date 2018/11/29 22:49
     * @Param [date]
     * @return java.util.Date
     */
    public static Date geWeektLastDate(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        int today = now.get(Calendar.DAY_OF_WEEK);
        int first_day_of_week = now.get(Calendar.DATE) + 2 - today; // 星期一
        int last_day_of_week = first_day_of_week + 6; // 星期日
        now.set(now.DATE, last_day_of_week);
        return now.getTime();
    }
}

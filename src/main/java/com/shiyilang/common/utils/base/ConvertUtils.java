package com.shiyilang.common.utils.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Destription:Convert util
 * using default value when the needed value is null or has exception
 * @Auther:shiyilang
 * @Date:2018/11/29 21:27
 * @Version:1.0
 */
public class ConvertUtils {

    /**
     * @Description:Convert String to int
     * @Date 2018/11/29 21:34
     * @Param [str, defaultValue]
     * @return int
     */
    public static int strToInt(String str, int defaultValue) {
        try {
            defaultValue = Integer.parseInt(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }


    /**
     * @Description:Convert String to Long
     * @Date 2018/11/29 21:37
     * @Param [str, defaultValue]
     * @return long
     */
    public static long strToLong(String str, long defaultValue) {
        try {
            defaultValue = Long.parseLong(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }


    /**
     * @Description:Convert String to float
     * @Date 2018/11/29 21:37
     * @Param [str, defaultValue]
     * @return float
     */
    public static float strToFloat(String str, float defaultValue) {
        try {
            defaultValue = Float.parseFloat(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }

    /**
     * @Description:Convert String to Double
     * @Date 2018/11/29 21:41
     * @Param [str, defaultValue]
     * @return double
     */
    public static double strToDouble(String str, double defaultValue) {
        try {
            defaultValue = Double.parseDouble(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }
    /**
    * @Description:Convert String to Date
    *  @Date 2018/11/29 21:41
    * @Param [str, defaultValue]
    * @return java.util.Date
    */
    public static java.util.Date strToDate(String str,java.util.Date defaultValue) {
        return strToDate(str, "yyyy-MM-dd HH:mm:ss", defaultValue);
    }

    /**
     * @Description:Convert String to format Date
     * @Date 2018/11/29 21:41
     * @Param [str, format, defaultValue]
     * @return java.util.Date
     */

    public static java.util.Date strToDate(String str, String format,java.util.Date defaultValue) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        try {
            defaultValue = fmt.parse(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }

    /**
     * @Description:Convert Date to String
     * @Date 2018/11/29 21:50
     * @Param [date, defaultValue]
     * @return java.lang.String
     */
    public static String dateToStr(java.util.Date date, String defaultValue) {
        return dateToStr(date, "yyyy-MM-dd HH:mm:ss", defaultValue);
    }

    /**
     * @Description:Convert Date to format String
     * @Date 2018/11/29 21:51
     * @Param [date, format, defaultValue]
     * @return java.lang.String
     */
    public static String dateToStr(java.util.Date date, String format, String defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            defaultValue = sdf.format(date);
        } catch (Exception localException) {
        }
        return defaultValue;
    }

    /**
     * @Description:Convert util Date to sqlDate
     * @Date 2018/11/29 21:53
     * @Param [date]
     * @return java.sql.Date
     */
    public static java.sql.Date dateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
/**
 * @Description:Convert sql date to util date
 * @Date 2018/11/29 21:54
 * @Param [date]
 * @return java.util.Date
 */
    public static java.util.Date sqlDateToDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    /**
     * @Description:Convert date to timestamp
     * @Date 2018/11/29 21:54
     * @Param [date]
     * @return java.sql.Timestamp
     */
    public static Timestamp dateToSqlTimestamp(java.util.Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * @Description:Convert timestamp to date
     * @Date 2018/11/29 21:54
     * @Param [date]
     * @return java.util.Date
     */
    public static java.util.Date qlTimestampToDate(Timestamp date) {
        return new java.util.Date(date.getTime());
    }
}

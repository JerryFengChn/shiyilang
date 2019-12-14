package com.shiyilang.common.utils.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Destription:TimeStamp  tool
 * using default value when the needed value is null or has exception
 * @Auther:shiyilang
 * @Date:2018/11/29 22:38
 * @Version:1.0
 */
public class TimestampUtils {

    /**
     * @Description: String转换为TimeStamp
     * @Date 2018/11/29 22:50
     * @Param [value]
     * @return java.sql.Timestamp
     */
    public static Timestamp string2Timestamp(String value){
        if(value == null && !"".equals(value.trim())){
            return null;
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        ts = Timestamp.valueOf(value);
        return ts;
    }

    /**
     * @Description:将Timestamp 转换为String类型，format为null则使用默认格式 yyyy-MM-dd HH:mm:ss
     * @Date 2018/11/29 22:51
     * @Param [value, format]
     * @return java.lang.String
     */
    public static String timestamp2String(Timestamp value,String format){
        if(null == value){
            return "";
        }
        SimpleDateFormat sdf = DateFormatUtils.getFormat(format);

        return sdf.format(value);
    }

    /**
     * @Description:Date转换为Timestamp
     * @Date 2018/11/29 22:51
     * @Param [date]
     * @return java.sql.Timestamp
     */
    public static Timestamp date2Timestamp(Date date){
        if(date == null){
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * @Description:Timestamp转换为Date
     * @Date 2018/11/29 22:51
     * @Param [time]
     * @return java.util.Date
     */
    public static Date timestamp2Date(Timestamp time){
        return time == null ? null : time;
    }
}

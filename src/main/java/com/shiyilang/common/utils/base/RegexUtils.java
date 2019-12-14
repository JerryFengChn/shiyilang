package com.shiyilang.common.utils.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Destription:Regular expression tool class to verify that data conforms to specifications
 * @Auther:shiyilang
 * @Date:2018/11/29 21:27
 * @Version:1.0
 */
public class RegexUtils {

    /**
     * @Description:判断字符串是否符合正则表达式
     * @Date 2018/11/29 22:26
     * @Param [str, regex]
     * @return boolean
     */
    public static boolean find(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        boolean b = m.find();
        return b;
    }

    /**
     * @Description:判断输入的字符串是否符合Email格式.
     * @Date 2018/11/29 22:27
     * @Param [email]
     * @return boolean
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(email).matches();
    }

    /**
     * @Description:判断输入的字符串是否为纯汉字
     * @Date 2018/11/29 22:27
     * @Param [value]
     * @return boolean
     */
    public static boolean isChinese(String value) {
        Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
        return pattern.matcher(value).matches();
    }

    /**
     * @Description:判断是否为浮点数，包括double和float
     * @Date 2018/11/29 22:27
     * @Param [value]
     * @return boolean
     */
    public static boolean isDouble(String value) {
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
        return pattern.matcher(value).matches();
    }

    /**
     * @Description:判断是否为整数
     * @Date 2018/11/29 22:27
     * @Param [value]
     * @return boolean
     */
    public static boolean isInteger(String value) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(value).matches();
    }
}

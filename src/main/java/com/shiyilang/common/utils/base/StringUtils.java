package com.shiyilang.common.utils.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Destription:String Tool Class, which handles strings routinely
 * @Auther:shiyilang
 * @Date:2018/11/29 21:27
 * @Version:1.0
 */
public class StringUtils {

    /**
     * @Description:将半角的符号转换成全角符号.(即英文字符转中文字符)
     * @Date 2018/11/29 22:28
     * @Param [str]
     * @return java.lang.String
     */
    public static String changeToFull(String str) {
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = { "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？" };
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = source.indexOf(str.charAt(i));
            if (pos != -1) {
                result += decode[pos];
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * @Description:将字符转换为编码为Unicode，格式 为'\u0020'<br>
     * @Date 2018/11/29 22:29
     * @Param [ch]
     * @return java.lang.String
     */
    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    /**
     * @Description:进行toString操作，若为空，返回默认值
     * @Date 2018/11/29 22:29
     * @Param [object, nullStr]
     * @return java.lang.String
     */
    public static String toString(Object object,String nullStr){
        return object == null ? nullStr : object.toString();
    }

    /**
     * @Description:将字符串重复N次，null、""不在循环次数里面 <br>
     * @Date 2018/11/29 22:30
     * @Param [value, count]
     * @return java.lang.String
     */
    public static String repeatString(String value,int count){
        if(value == null || "".equals(value) || count <= 1){
            return value;
        }

        int length = value.length();
        if(length == 1){          //长度为1，存在字符
            return repeatChar(value.charAt(0), count);
        }

        int outputLength = length * count;
        switch (length) {
        case 1:
            return repeatChar(value.charAt(0), count);
        case 2:
            char ch0 = value.charAt(0);
            char ch1 = value.charAt(1);
            char[] output2 = new char[outputLength];
            for (int i = count * 2 - 2; i >= 0; i--, i--) {
                output2[i] = ch0;
                output2[i + 1] = ch1;
            }
            return new String(output2);
        default:
            StringBuilder buf = new StringBuilder(outputLength);
            for (int i = 0; i < count; i++) {
                buf.append(value);
            }
            return buf.toString();
        }

    }

    /**
     * @Description:将某个字符重复N次
     * @Date 2018/11/29 22:30
     * @Param [ch, count]
     * @return java.lang.String
     */
    public static String repeatChar(char ch, int count) {
        char[] buf = new char[count];
        for (int i = count - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    /**
     * @Description:判断字符串是否全部都为小写
     * @Date 2018/11/29 22:30
     * @Param [value]
     * @return boolean
     */
    public static boolean isAllLowerCase(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (Character.isLowerCase(value.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description:判断字符串是否全部大写
     * @Date 2018/11/29 22:30
     * @Param [value]
     * @return boolean
     */
    public static boolean isAllUpperCase(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description:反转字符串
     * @Date 2018/11/29 22:31
     * @Param [value]
     * @return java.lang.String
     */
    public static String reverse(String value){
        if(value == null){
            return null;
        }
        return new StringBuffer(value).reverse().toString();
    }

    /**
     * @Description:截取字符串，支持中英文混乱，其中中文当做两位处理
     * @Date 2018/11/29 22:31
     * @Param [resourceString, length]
     * @return java.lang.String
     */
    public static String subString(String resourceString,int length){
        String resultString = "";
        if (resourceString == null || "".equals(resourceString) || length < 1) {
            return resourceString;
        }

        if (resourceString.length() < length) {
            return resourceString;
        }

        char[] chr = resourceString.toCharArray();
        int strNum = 0;
        int strGBKNum = 0;
        boolean isHaveDot = false;

        for (int i = 0; i < resourceString.length(); i++) {
            if (chr[i] >= 0xa1){// 0xa1汉字最小位开始
                strNum = strNum + 2;
                strGBKNum++;
            } else {
                strNum++;
            }

            if (strNum == length || strNum == length + 1) {
                if (i + 1 < resourceString.length()) {
                    isHaveDot = true;
                }
                break;
            }
        }
        resultString = resourceString.substring(0, strNum - strGBKNum);
        if (isHaveDot) {
            resultString = resultString + "...";
        }

        return resultString;
    }

    /**
     * @Description:
     * @Date 2018/11/29 22:31
     * @Param [htmlString, length]
     * @return java.lang.String
     */
    public static String subHTMLString(String htmlString,int length){
        return subString(delHTMLTag(htmlString), length);
    }

    /**
     * @Description:过滤html标签，包括script、style、html、空格、回车标签
     * @Date 2018/11/29 22:32
     * @Param [htmlStr]
     * @return java.lang.String
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);  
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
        Matcher m_style = p_style.matcher(htmlStr);  
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(htmlStr);  
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
  
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);  
        Matcher m_space = p_space.matcher(htmlStr);  
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
        
        return htmlStr.trim(); // 返回文本字符串
    }
}

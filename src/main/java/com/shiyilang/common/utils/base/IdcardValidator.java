package com.shiyilang.common.utils.base;

import java.util.regex.Pattern;

/**
     * @Destription:* --15位身份证号码：第7、8位为出生年份(两位数)，第9、10位为出生月份，第11、12位代表出生日期，第15位代表性别，奇数为男，偶数为女。
 * --18位身份证号码
     * ：第7、8、9、10位为出生年份(四位数)，第11、第12位为出生月份，第13、14位代表出生日期，第17位代表性别，奇数为男，偶数为女。
     * @Auther:shiyilang
     * @Date:2018/11/29 21:55
     * @Version:1.0
     */
public class IdcardValidator {

    /**
     * Code table of provinces and municipalities directly under the Central Government:
     * {11:"Beijing", 12:"Tianjin", 13:"Hebei", 14:"Shanxi", 15:"Inner Mongolia".
     * 21: "Liaoning", 22: "Jilin", 23: "Heilongjiang", 31: "Shanghai", 32: "Jiangsu".
     * 33: "Zhejiang", 34: "Anhui", 35: "Fujian", 36: "Jiangxi", 37: "Shandong", 41: "Henan".
     * 42: "Hubei", "43:" Hunan","44:"Guangdong", "45:" Guangxi","46:"Hainan", "50:" Chongqing".
     * 51: "Sichuan", 52: "Guizhou", 53: "Yunnan", 54: "Tibet", 61: "Shaanxi", 62: "Gansu".
     * 63: "Qinghai", 64: "Ningxia", 65: "Xinjiang", 71: "Taiwan", 81: "Hong Kong", 82: "Macao", 91: "Overseas"}
     */

    // Each weighting factor
    private static int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

    /**
     * @Description:Verify the validity of identity cards
     * @Date 2018/11/29 22:02
     * @Param [idcard]
     * @return boolean
     */
    public boolean isValidatedAllIdcard(String idcard) {
        return this.isValidate18Idcard(idcard);
    }

    /**
     * @Description:
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     *  <p>
     *  顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     *  </p>
     *  <p>
     *  1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
     *  4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     *  6.第17位数字表示性别：奇数表示男性，偶数表示女性；
     *  7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     *  </p>
     *  <p>
     *  第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
     *  2 1 6 3 7 9 10 5 8 4 2
     *  </p>
     *  <p>
     *  2.将这17位数字和系数相乘的结果相加。
     *  </p>
     *  <p>
     *  3.用加出来和除以11，看余数是多少？
     *  </p>
     *  4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
     *  2。
     *  <p>
     *  5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     *  </p>
     * @Date 2018/11/29 22:03
     * @Param [idcard]
     * @return boolean
     */
    public static boolean isValidate18Idcard(String idcard) {
        // Non 18 bits are false.
        if (idcard.length() != 18) {
            return false;
        }
        // Get the top 17
        String idcard17 = idcard.substring(0, 17);
        // Get the 18th bit
        String idcard18Code = idcard.substring(17, 18);
        char c[] = null;
        String checkCode = "";
        // Are they all numbers?
        if (isDigital(idcard17)) {
            c = idcard17.toCharArray();
        } else {
            return false;
        }

        if (null != c) {
            int bit[] = new int[idcard17.length()];
            bit = converCharToInt(c);
            int sum17 = 0;
            sum17 = getPowerSum(bit);
            // The sum value and 11 modulus are used to get the remainder for checking code judgment.
            checkCode = getCheckCodeBySum(sum17);
            if (null == checkCode) {
                return false;
            }
            // If the 18th bit of ID card is matched with the calculated proofreading code, it will be false if the difference is not equal.
            if (!idcard18Code.equalsIgnoreCase(checkCode)) {
                return false;
            }
        }

        return true;
    }

/**
 * @Description:Basic Number and total Number Check of 18-bit ID Card Number
 * @Date 2018/11/29 22:12
 * @Param [idcard]
 * @return boolean
 */
    public static boolean is18Idcard(String idcard) {
        return Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idcard);
    }

/**
 * @Description:Digital Verification
 * @Date 2018/11/29 22:14
 * @Param [str]
 * @return boolean
 */
    private static boolean isDigital(String str) {
        return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
    }


    /**
     * @Description:将身份证的每位和对应位的加权因子相乘之后，再得到和值
     * @Date 2018/11/29 22:15
     * @Param [bit]
     * @return int
     */
    private static int getPowerSum(int[] bit) {
        int sum = 0;
        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }

        return sum;
    }


    /**
     * @Description:将和值与11取模得到余数进行校验码判断
     * @Date 2018/11/29 22:15
     * @Param [sum17]
     * @return java.lang.String
     */
    private static String getCheckCodeBySum(int sum17) {
        String checkCode = null;
        switch (sum17 % 11) {
        case 10:
            checkCode = "2";
            break;
        case 9:
            checkCode = "3";
            break;
        case 8:
            checkCode = "4";
            break;
        case 7:
            checkCode = "5";
            break;
        case 6:
            checkCode = "6";
            break;
        case 5:
            checkCode = "7";
            break;
        case 4:
            checkCode = "8";
            break;
        case 3:
            checkCode = "9";
            break;
        case 2:
            checkCode = "x";
            break;
        case 1:
            checkCode = "0";
            break;
        case 0:
            checkCode = "1";
            break;
        }
        return checkCode;
    }


    /**
     * @Description:Converting character arrays to integer arrays
     * @Date 2018/11/29 22:18
     * @Param [c]
     * @return int[]
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * @Description:
     * @Date 2018/11/29 22:19
     * @Param [idno]
     * @return int
     */
    public static int getUserSex(String idno) {
        String sex="1";
        if(idno!=null){
            if(idno.length()>15){
                sex = idno.substring(16, 17);
            }
        }

        return Integer.parseInt(sex) % 2==0 ? 0:1;
    }
}

package com.shiyilang.common.wcar;

import java.text.ParseException;

public class Selftest {
	public static void main(String args[]) throws ParseException{
//		String str = "4200000000022D4F983AE0000002EFFCA00DC25AD0E1F429046E03B26F0000FE0120A71027102005DC07E5FFC095BE8003E7000100014646C7ABC01C26800BE800383E8006424061A80061A836FC000C04040001900005AB001003A0200000085034000000010A00";
//        String str = "42000000 00022D4F ";
//		byte[] b =Selftest.fromHexString(str);
//      long time1 = System.currentTimeMillis();
//        Date date =  new Date();
//        Date datetime =  new Date(time1);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateFormat.format(date));
//        System.out.println(dateFormat.format(datetime));
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        long time =  new Date().getTime()/(1000*60*60*24);
//        long time2 = Calendar.getInstance().getTimeInMillis();
//        long time1 = System.currentTimeMillis();
//char[] ch = "SDdfjQaK".toCharArray();
//        StringBuffer str = new StringBuffer();
//        for (int i = 0; i < ch.length; i++) {
//            if (ch[i] <= 90 && ch[i] >= 65) {
//                ch[i] += 32;
//            }
//            str.append(ch[i]);
//        }
//		System.out.println("time="+LocalDateTime.now());
//        System.out.println("time="+LocalDateTime.MAX);
//        System.out.println("time="+LocalDateTime.MIN);

//        System.out.println("time="+String.format("%1$s notifications sent to {%2$s}",Integer.toString(6),"fakfdhkak"));
//        System.out.println("time="+MessageFormat.format("%1$s notifications sent to %2$s",Integer.toString(6)));
//        System.out.println("time="+ DateTime.now());
//        System.out.println("time="+new Date());
//        System.out.println("time1="+time1);
//        System.out.println("time2="+time2);
//	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
//	    java.util.Calendar cal = java.util.Calendar.getInstance();
//	    cal.setTime(sdf.parse("2009-4-23"));
//	    cal.add(java.util.Calendar.DATE, -7); // 向前一周；如果需要向后一周，用正数即可
////	    cal.add(java.util.Calendar.MONTH, -1); // 向前一月；如果需要向后一月，用正数即可
//	    System.out.println(sdf.format(cal.getTime()));
//        System.out.println(sdf.parse(sdf.format(cal.getTime())));
//	    charToUpperCase("adkHGJhy".toCharArray());
//      System.out.println("time="+charToUpperCase("adkHGJhy".toCharArray()));
	    Runtime r =Runtime.getRuntime();
	}
	

    private static String charToUpperCase(char[] ch) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] <= 122 && ch[i] >= 97) {
                ch[i] -= 32;
            }
            str.append(ch[i]);
        }
        return str.toString();
    }
	 public static byte[] fromHexString(String s) {
		    int stringLength = s.length();
		    if ((stringLength & 0x1) != 0) {
		      throw new IllegalArgumentException("fromHexString requires an even number of hex characters");
		    }
		    byte[] b = new byte[stringLength / 2];
		    for (int i = 0, j = 0; i < stringLength; i += 2, j++) {
		      int high = charToNibble(s.charAt(i));
		      int low = charToNibble(s.charAt(i + 1));
		      b[j] = (byte) ((high << 4) | low);
		    }

		    return b;
		  }
	 private static int charToNibble(char c) {
		    if ('0' <= c && c <= '9') {
		      return c - '0';
		    } else if ('a' <= c && c <= 'f') {
		      return c - 'a' + 0xa;
		    } else if ('A' <= c && c <= 'F') {
		      return c - 'A' + 0xa;
		    } else {
		      throw new IllegalArgumentException("Invalid hex character: " + c);
		    }
		  }
}

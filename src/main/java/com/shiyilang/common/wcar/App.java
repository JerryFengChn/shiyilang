package com.shiyilang.common.wcar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try {
            boolean b=regular();
            boolean a=regular1();
            System.out.println("xxxxxxxxxx=  " + (a && b) );
        }catch (Exception e){

        }
    }
    private static boolean regular(){
        String s="20130201402135236";
        boolean b=Pattern.matches("(2013).*", s);
        System.out.println( b );
        return b;
    }
    private static boolean regular1(){
        String s="ME0";
        boolean b=Pattern.matches("(ME0|ZE0)", s);
        System.out.println( b );
        return b;
    }

    private static void duration() throws ParseException {
        String start = "2018091516:30:30";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH:mm:ss");
        Date startDate = format.parse(start);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR,5);
        Date startDateAdd = calendar.getTime();
        String end = "2018092015:30:30";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHH:mm:ss");
        Date endDate = format1.parse(end);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(endDate);
        calendar1.add(Calendar.DAY_OF_YEAR,5);
        Date endDateAdd = calendar1.getTime();

        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(startDateAdd);
        XMLGregorianCalendar from = null;
        try {
            from = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {

            e.printStackTrace();
        }
        GregorianCalendar gcal1 = new GregorianCalendar();
        gcal1.setTime(endDateAdd);
        XMLGregorianCalendar to = null;
        try {
            to = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long fromTime = from.toGregorianCalendar().getTimeInMillis();
        long toTime = to.toGregorianCalendar().getTimeInMillis();
        //
        int duration =(int) TimeUnit.MILLISECONDS.toDays(toTime - fromTime);
        System.out.println(startDateAdd);
        System.out.println(endDateAdd);
        System.out.println(duration);
    }
}

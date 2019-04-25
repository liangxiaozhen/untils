package com.ganjiangps.wangdaibus.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
*  计算两个时间相差几年几月
*
*   "2015-09-05","2018-05-10"      2年8月
* */
public class TimeDifferUtil {

    // 前时间  后时间
    public static String getTime(String time1,String time2){
        Calendar calendar=Calendar.getInstance();
        String str1 = time1;
        String str2 = time2;
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        int startmonth=0;
        int aftermonth=0;
        int startday=0;
        int afterday=0;
        Date start=null;
        Date after=null;
        int a[]=new int[2];
        String str3[]=str2.split("-");
        String str22[]=str1.split("-");

        try {
            start=sd.parse(str1);
            after= sd.parse(str2);
            startmonth=Integer.parseInt(str22[1]);
            startday=Integer.parseInt(str22[2]);
            after=sd.parse(str2);
            calendar.setTime(after);
            aftermonth=Integer.parseInt(str3[1]);
            afterday=Integer.parseInt(str3[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(startmonth<aftermonth&&startday<=afterday){
            a=getMonth(start,after);
            if (a[1] == 0){             // 0年则只显示月
                return(a[0]%12+"个月");
            }else if (a[0]%12 == 0){    // 0月则只显示年
                return(a[1]+"年");
            }else {
                return(a[1]+"年"+a[0]%12+"个月");
            }
        }
        if(startmonth<aftermonth&&startday>afterday){
            a=getMonth(start,after);
            if (a[1] == 0){             // 0年则只显示月
                return((a[0]%12-1)+"个月");
            }else if ((a[0]%12-1) == 0){    // 0月则只显示年
                return(a[1]+"年");
            }else {
                return(a[1]+"年"+(a[0]%12-1)+"个月");
            }
        }else if(startmonth==aftermonth&&startday>afterday){
            a=getMonth(start,after);
            if (a[1]-1 == 0){             // 0年则只显示月
                return(a[0]%12+"个月");
            }else if (a[0]%12 == 0){    // 0月则只显示年
                return(a[1]-1+"年");
            }else {
                return(a[1]-1+"年"+(a[0]%12)+"个月");
            }
        }else if(startmonth==aftermonth&&startday<=afterday){
            a=getMonth(start,after);
            if (a[1] == 0){             // 0年则只显示月
                return(a[0]%12+"个月");
            }else if (a[0]%12 == 0){    // 0月则只显示年
                return(a[1]+"年");
            }else {
                return(a[1]+"年"+(a[0]%12)+"个月");
            }
        }else if(startmonth>aftermonth&&startday<afterday){
            a=getMonth(start,after);
            if (a[1]-1 == 0){             // 0年则只显示月
                return(a[0]%12+"个月");
            }else if (a[0]%12 == 0){    // 0月则只显示年
                return(a[1]-1+"年");
            }else {
                return(a[1]-1+"年"+(a[0]%12)+"个月");
            }
        }else if(startmonth>aftermonth&&startday>=afterday){
            a=getMonth(start,after);
            if (a[1]-1 == 0){             // 0年则只显示月
                return((a[0]%12-1)+"个月");
            }else if ((a[0]%12-1) == 0){    // 0月则只显示年
                return(a[1]-1+"年");
            }else {
                return(a[1]-1+"年"+(a[0]%12-1)+"个月");
            }
        }
        return null;
    }
    public static int[] getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        int a[]=new int[2];
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);
        int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
//        System.out.println("year:>>>"+year);
        a[1]=year;
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
            a[0]=year * 12 + month + 1;
            return a;
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
            a[0]=year * 12 + month;
            return a;
        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
            a[0]=year * 12 + month;
            return a;
        } else {
            a[0]=(year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
            return a;
        }
    }


}

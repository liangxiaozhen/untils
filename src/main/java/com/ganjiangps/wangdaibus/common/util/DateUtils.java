package com.ganjiangps.wangdaibus.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017/6/28.
 *
 */
public class DateUtils {
    static final double DAY_MILLIS = 8.64E7D;
    static final String standardPtn = "yyyy-MM-dd HH:mm:ss";//阮鑫
    
    static final String standardSPtn = "yyyy-MM-dd HH:mm:ss.SSS";
    static final String yy_MM_ddPtn = "yyyy-MM-dd";
    static final String HH_mm_ssPtn = "HH:mm:ss";
    static final String sdf_ymdPtn = "yyyy年MM月dd日";
    static final String ymPtn = "yyyyMM";
    static final String ymdPtn = "yyyyMMdd";
    static final String hmsPtn = "HHmmss";
    static final String ymdhmsPtn = "yyyyMMddHHmmss";
    static final String ymdhmsSPtn = "yyyyMMddHHmmssSSS";
    public static final SimpleFastDateFormat standard = SimpleFastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
    public static final SimpleFastDateFormat standardTwo = SimpleFastDateFormat.getInstance("yy-MM-dd HH:mm:ss");
    public static final SimpleFastDateFormat standardThree = SimpleFastDateFormat.getInstance("yy-MM-dd HH:mm");
    
    public static final SimpleFastDateFormat standardS = SimpleFastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleFastDateFormat yy_MM_dd = SimpleFastDateFormat.getInstance("yyyy-MM-dd");
    public static final SimpleFastDateFormat HH_mm_ss = SimpleFastDateFormat.getInstance("HH:mm:ss");
    public static final SimpleFastDateFormat sdf_ymd = SimpleFastDateFormat.getInstance("yyyy年MM月dd日");
    public static final SimpleFastDateFormat ym = SimpleFastDateFormat.getInstance("yyyyMM");
    public static final SimpleFastDateFormat ymd = SimpleFastDateFormat.getInstance("yyyyMMdd");
    public static final SimpleFastDateFormat hms = SimpleFastDateFormat.getInstance("HHmmss");
    public static final SimpleFastDateFormat ymdhms = SimpleFastDateFormat.getInstance("yyyyMMddHHmmss");
    public static final SimpleFastDateFormat ymdhmsS = SimpleFastDateFormat.getInstance("yyyyMMddHHmmssSSS");

    public DateUtils() {
    }

    public static Date str2Date(String dateStr, String pattern) {
        if(!StringUtils.isBlank(dateStr) && !StringUtils.isBlank(pattern)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                return simpleDateFormat.parse(dateStr);
            } catch (ParseException var3) {
                throw new IllegalArgumentException(var3);
            }
        } else {
            throw new IllegalArgumentException("dateStr and pattern must not be null!");
        }
    }

    public static String date2Str(Date date, SimpleFastDateFormat date_sdf) {
        return null == date?null:date_sdf.format(date);
    }

    public static long getMillis() {
        return System.currentTimeMillis();
    }

    public static String formatDate() {
        return standard.format(System.currentTimeMillis());
    }

    public static String formatDate(Date date) {
        return standard.format(date);
    }

    public static String formatDate(long time) {
        return standard.format(time);
    }

    public static String formatDateSSS() {
        return standardS.format(System.currentTimeMillis());
    }

    public static String formatDateSSS(Date date) {
        return standardS.format(date);
    }

    public static String formatDateSSS(long timeMillis) {
        return standardS.format(timeMillis);
    }

    public static String formatYYYYMMdd() {
        return ymd.format(System.currentTimeMillis());
    }

    public static String formatYYYYMMdd(Date date) {
        return ymd.format(date);
    }

    public static String formatYYYYMMdd(long timeMillis) {
        return ymd.format(timeMillis);
    }
     
    public static String formatYY_MM_DD() {
        return yy_MM_dd.format(System.currentTimeMillis());
    }

    public static String formatYY_MM_DD(long timeMillis) {
        return yy_MM_dd.format(timeMillis);
    }

    public static String formatYY_MM_DD(Date date) {
        return yy_MM_dd.format(date);
    }

    public static String formatHH_mm_ss() {
        return HH_mm_ss.format(System.currentTimeMillis());
    }

    public static String formatHH_mm_ss(long timeMillis) {
        return HH_mm_ss.format(timeMillis);
    }

    public static String formatHH_mm_ss(Date date) {
        return HH_mm_ss.format(date);
    }

    public static String formatSdf_ymd() {
        return sdf_ymd.format(System.currentTimeMillis());
    }

    public static String formatSdf_ymd(long timeMillis) {
        return sdf_ymd.format(timeMillis);
    }

    public static String formatSdf_ymd(Date date) {
        return sdf_ymd.format(date);
    }

    public static String formatHHmmss() {
        return hms.format(System.currentTimeMillis());
    }

    public static String formatHHmmss(long timeMillis) {
        return hms.format(timeMillis);
    }

    public static String formatHHmmss(Date date) {
        return hms.format(date);
    }

    public static String formatYYYYMM() {
        return ym.format(System.currentTimeMillis());
    }

    public static String formatYYYYMM(long timeMillis) {
        return ym.format(timeMillis);
    }

    public static String formatYYYYMM(Date date) {
        return ym.format(date);
    }
    
    public static String formatYYMMddHHMMSS(long timeMillis) {
        return standardTwo.format(timeMillis);
    }
    
    public static String formatYYMMddHHMM(long timeMillis) {
        return standardThree.format(timeMillis);
    }
    
    public static String formatYYYYMMDDHHMMSS() {
        return ymdhms.format(System.currentTimeMillis());
    }

    public static String formatYYYYMMDDHHMMSS(long timeMillis) {
        return ymdhms.format(timeMillis);
    }

    public static String formatYYYYMMDDHHMMSS(Date date) {
        return ymdhms.format(date);
    }

    public static String formatYYYYMMddHHmmssSSS() {
        return ymdhmsS.format(System.currentTimeMillis());
    }

    public static String formatYYYYMMddHHmmssSSS(long timeMillis) {
        return ymdhmsS.format(timeMillis);
    }

    public static String formatYYYYMMddHHmmssSSS(Date date) {
        return ymdhmsS.format(date);
    }

    public static String getTime(long unixTimestamp, SimpleFastDateFormat formatter) {
        return formatter.format(unixTimestamp * 1000L);
    }

    public static Long getCurrentMonthZeroTimestamp() {
        Calendar cale = Calendar.getInstance();
        cale.add(2, 0);
        cale.set(5, 1);
        cale.set(11, 0);
        cale.set(12, 0);
        cale.set(13, 0);
        cale.set(14, 0);
        return Long.valueOf(cale.getTime().getTime() / 1000L);
    }

    public static Long getNextMonthZeroTimestamp() {
        Calendar cale = Calendar.getInstance();
        cale.add(2, 1);
        cale.set(5, 1);
        cale.set(11, 0);
        cale.set(12, 0);
        cale.set(13, 0);
        cale.set(14, 0);
        return Long.valueOf(cale.getTime().getTime() / 1000L);
    }

    public static double getDateDiff(long beginTime, long endTime) {
        return Double.valueOf((double)(endTime - beginTime)).doubleValue() / 8.64E7D;
    }
    
    public static double getDateDiffCeil(long beginTime, long endTime) {
        double timediff = Double.valueOf((double)(endTime - beginTime)).doubleValue() / 8.64E7D;    
        double year = timediff/365;
        return Math.ceil(year);
    }

    public static Date getBeforeDay(int day) {
        Calendar cale = Calendar.getInstance();
        cale.set(2, 0);
        cale.add(5, 0 - day);
        cale.set(11, 0);
        cale.set(12, 0);
        cale.set(13, 0);
        cale.set(14, 0);
        return cale.getTime();
    }

    public static Long getCountDate(Long time,int day,int month,int year){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String str=formatYYYYMMdd(time);
        Long dt1 = null;
        try {
            Date dt=sdf.parse(str);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            if(day!=0){
                rightNow.add(Calendar.DAY_OF_YEAR,day);//日期加减
            }
            if(month!=0){
                rightNow.add(Calendar.MONTH,month);//日期加减
            }
            if(year!=0){
                rightNow.add(Calendar.YEAR,year);//日期加减
            }
            dt1=rightNow.getTime().getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dt1;
    }

    /**
     *
     * @Title: subtractMin
     * @Description: TODO(分钟减 n)
     * @param @param date
     * @param @param n
     * @param @return  参数说明
     * @return Date    返回类型
     * @author cjm
     * @throws
     */
    public static Date subtractMin(Date date,int n){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, -n);
            return  calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //根据具体日期转换毫秒数 yyyy-MM-dd HH-mm-ss
    public static Long specialDateToMillis(String sdate){
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	long time=0;
		try {
			time = simpleDateFormat.parse(sdate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return time;
    }
    
    /* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s){
        String res = "";
        try {
  	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = simpleDateFormat.parse(s);
	        Long ts = date.getTime();
	        res = String.valueOf(ts);
        }catch (ParseException e) {
 			e.printStackTrace();
		}
        return res;
    }

    /**
    *
    * @Title: addDateByDay
    * @Description: TODO(日期 加 n)
    * @param @param date
    * @param @param n
    * @param @return  参数说明
    * @return Date    返回类型
    * @author cjm
    * @throws
    */
   public static Date addDateByDay(Date date,int n){
       try {
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(date);
           calendar.add(Calendar.DATE, n);
           return  calendar.getTime();
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
   
   /**
   *
   * @Title: subtractDateByDay
   * @Description: TODO(日期 减 n)
   * @param @param date
   * @param @param n
   * @param @return  参数说明
   * @return Date    返回类型
   * @author cjm
   * @throws
   */
  public static Date subtractDateByDay(Date date,int n){
      try {
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(date);
          calendar.add(Calendar.DATE, -n);
          return  calendar.getTime();
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }

    /**
     * Date 转 Long
     * @param date
     * @return
     */
    public static Long dateToLong(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long longTime = null;
        try {
            String todayStr = sdf.format(date);
            longTime = sdf.parse(todayStr).getTime();//格式转换
            return  longTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return longTime;
    }

    /**
     * Long 转 String
     */
    public static String longToString(Long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = "";
        try {
            strTime = sdf.format(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return strTime;
    }

    /**
     * 得到两个时间戳之间 相差 多少天 多少小时 多少分钟
     * @param nowTime
     * @param endTime
     * @return
     */
    public static String getDayHourMin(Long nowTime, Long endTime){
        long time = endTime - nowTime;
        long day = time / (24 * 60 * 60 * 1000);
        long hour = (time / (60 * 60 * 1000) - day * 24);
        long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
        if(day < 0 || hour < 0 || min < 0){
            day = 0;
            hour = 0;
            min = 0;
        }
        return day+"天"+hour+"小时"+min+"分钟";
    }

    public static void main(String[] args) {
    	System.out.println(formatYYMMddHHMMSS(System.currentTimeMillis()));
    	specialDateToMillis("2014-01-01 00:00:00");
	}
}


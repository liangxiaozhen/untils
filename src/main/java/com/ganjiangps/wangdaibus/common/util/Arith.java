package com.ganjiangps.wangdaibus.common.util;

import   java.math.BigDecimal;   
import java.text.DecimalFormat;

  /**   
    *   由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精   
    *   确的浮点数运算，包括加减乘除和四舍五入。   
    */   
    
  public   class   Arith {   
    
          //默认除法运算精度   
          private   static   final   int   DEF_DIV_SCALE   =   10;   
          
          public static final int PAY_DECIMAL_LENGTH_2 = 2 ;//精确到小数点后2位 
      	  public static final int PAY_DECIMAL_LENGTH_4 = 4 ;//精确到小数点后4位 
      	  public static final String PAY_STATIC_FORMAT_VALUE = "100";
      	  public static final String PAY_RETURN_FORMAT_ZERO_12 = "000000000000"; //12个0
    
    
          //这个类不能实例化   
          private   Arith(){   
          }   
    
          /**
            *   提供精确的加法运算。   
            *   @param   v1   被加数   
            *   @param   v2   加数   
            *   @return   两个参数的和   
            */   
    
          public   static   double   add(double   v1,double   v2){   
                  BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));   
                  BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));   
                  return   b1.add(b2).doubleValue();   
          }
    
          /**   
            *   提供精确的减法运算。   
            *   @param   v1   被减数   
            *   @param   v2   减数   
            *   @return   两个参数的差   
            */   
    
          public   static   double   sub(double   v1,double   v2){   
                  BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));   
                  BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));   
                  return   b1.subtract(b2).doubleValue();   
          }     
    
          /**   
            *   提供精确的乘法运算。   
            *   @param   v1   被乘数   
            *   @param   v2   乘数   
            *   @return   两个参数的积   
            */   
    
          public   static   double   mul(double   v1,double   v2){   
                  BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));   
                  BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));   
                  return   b1.multiply(b2).doubleValue();   
          }  
          /**
           * 把金额转化为以分为单位的数据
           * @param @param money
           * @param @return
           * @return String
           * @author jiangxueyou
           */
          public static String mulStr(String money){
        		Double TransAmt=  Arith.mul(Double.valueOf(money), 100d);
        		String str = TransAmt.toString();
        		String[] str2  = str.split("\\.");
				return str2[0];
          }
          /**
      	 * 返回金额解析,返回double类型的金额
      	 * @param @param money
      	 * @param @return
      	 * @return Double
      	 * @author jiangxueyou
      	 */
      	public static Double getMoney(String money){
      		Double doubleMoney = Arith.div(Double.valueOf(money), 100, 2);
      		return doubleMoney;
      	}
      
    
          /**   
            *   提供（相对）精确的除法运算，当发生除不尽的情况时，精确到   
            *   小数点以后10位，以后的数字四舍五入。   
            *   @param   v1   被除数   
            *   @param   v2   除数   
            *   @return   两个参数的商   
            */   
    
          public   static   double   div(double   v1,double   v2){   
                  return   div(v1,v2,DEF_DIV_SCALE);   
          }   
    
      
    
         /**   
            *   提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指   
            *   定精度，以后的数字四舍五入。   
            *   @param   v1   被除数   
            *   @param   v2   除数   
            *   @param   scale   表示表示需要精确到小数点以后几位。   
            *   @return   两个参数的商   
            */   
          public   static   double   div(double   v1,double   v2,int   scale){
                  if(scale<0){
                          throw   new   IllegalArgumentException(
                          "The   scale   must   be   a   positive   integer   or   zero");
                  }
                  BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));   
                  BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));   
                  return   b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
          }   
    
      
    
          /**   
            *   提供精确的小数位四舍五入处理。   
            *   @param   v   需要四舍五入的数字   
            *   @param   scale   小数点后保留几位   
            *   @return   四舍五入后的结果   
            */
          public   static   double   round(double   v,int   scale){   
                  if(scale<0){   
                          throw   new   IllegalArgumentException(   
                                  "The   scale   must   be   a   positive   integer   or   zero");   
                  }   
                  BigDecimal   b   =   new   BigDecimal(Double.toString(v));   
                  BigDecimal   one   =   new   BigDecimal("1");   
                  return   b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
          }  
          
        /**
      	 * This method is used to format amount according to BOC interface standard.
      	 * @param stringAmt
      	 * @param format
      	 * @return
      	 */
      	public static String formatAmount(String stringAmt, String format) {
      		String returnAmt = "";
      		//System.out.println(Arith.round(Double.valueOf(stringAmt), Iconstant.PAY_DECIMAL_LENGTH)+"--------");
      		if ((!isNullStr(stringAmt)) && stringAmt.replace(".", "").matches("\\d+")) {
      			BigDecimal passAmt = new BigDecimal(Arith.round(Double.valueOf(stringAmt), Arith.PAY_DECIMAL_LENGTH_2)+"");
      			BigDecimal staticAmt = new BigDecimal(Arith.PAY_STATIC_FORMAT_VALUE);
      			String convertString = passAmt.multiply(staticAmt).toString(); 
      			returnAmt = convertString.substring(0, convertString.indexOf("."));
      		}
      		if (format != null && Arith.PAY_RETURN_FORMAT_ZERO_12.equals(format)) {
      			String formatAmt = Arith.PAY_RETURN_FORMAT_ZERO_12;
      			DecimalFormat returnFormat = new DecimalFormat(formatAmt);
      			returnAmt = returnFormat.format(Long.valueOf(returnAmt));
      		}
      		return returnAmt;
      	}
      	
//      	交易金额数字乘以100取整,避免相乘后数字出现精度问题
      	public static String format100Int(String stringAmt) {
      		String returnAmt = "";
      		if (!isNullStr(stringAmt)) {
      			BigDecimal ba = new BigDecimal(String.valueOf(stringAmt));
      	        BigDecimal bb = new BigDecimal(String.valueOf(100d));
      	        BigDecimal bc = ba.multiply(bb);
      	        DecimalFormat df1 = new DecimalFormat("####################################");
      	        returnAmt = df1.format(bc);
      		}
      		return returnAmt;
      	}
      	
      	private static boolean isNullStr(String s) {

    		return (s == null || s.equals("null") || s.equals("")) ? true : false;

    	}

      /**
       * 计算出红包领取的进度条
       * @param total
       * @param balance
       * @return
       */
	  public static Integer getLine(Integer total, Integer balance){
		  double c = Arith.sub(total.doubleValue(),balance.doubleValue());
		  double d = (c / total) *100;
		  BigDecimal bd = BigDecimal.valueOf(d);
		  //保留0位小数
		  BigDecimal bd2 = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
		  return bd2.intValue();
	  }
      	
      	public static void main(String[] args) {

      		System.out.println(Arith.format100Int("0.00"));

      		System.out.println(Arith.format100Int("2222000000000000000000000000000000000000.00"));

		}
  }


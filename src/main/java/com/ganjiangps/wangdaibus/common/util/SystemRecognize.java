package com.ganjiangps.wangdaibus.common.util;

import java.util.Properties;

/**
 * @author yangwp
 * @create 2018-01-25 14:19
 */
public class SystemRecognize {
    public static Properties props;

    static{
        props = System.getProperties();
    }

    /**
     * 获取系统的名称
     * @return
     */
    public static String getOSName(){
        return props.getProperty("os.name");
    }

    /**
     * 获取系统的架构
     * @return
     */
    public static String getOSArch(){
        return props.getProperty("os.arch");
    }

    /**
     * 获取系统的文件分隔符
     * @return
     */
    public static String getFileSeparator(){
        return props.getProperty("file.separator");
    }

    /**
     * 获取系统的属性值
     * @return
     */
    public static String getValue(String propertyName){
        return props.getProperty(propertyName);
        // return System.getProperty(propertyName);
    }

    public static void main(String[] args) {
        System.out.println(SystemRecognize.getOSName());
        System.out.println(SystemRecognize.getOSArch());
        System.out.println(SystemRecognize.getFileSeparator());
    }
}

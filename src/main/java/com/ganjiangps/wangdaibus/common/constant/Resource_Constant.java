package com.ganjiangps.wangdaibus.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源常量类
 * @author yangwp
 * @create 2018-05-10 17:40
 */
public class Resource_Constant {
    public static final Integer MENU = 1;//菜单类型
    public static final Integer BUTTON = 2;//按钮类型
    public static Map<Integer,String> TYPEMAP=new HashMap<>();
    static {
        TYPEMAP.put(MENU,"菜单");
        TYPEMAP.put(BUTTON,"按钮");
    }
}

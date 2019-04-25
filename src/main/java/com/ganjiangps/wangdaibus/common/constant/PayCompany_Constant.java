package com.ganjiangps.wangdaibus.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付公司类型 常量类
 * @author :zhouc
 * @date :2018/3/14 15:59
 */
public class PayCompany_Constant {

    /**
     * 双乾
     */
    public static final Integer SQZF = 1;

    /**
     * 支付公司
     */
    public static final Map PAYCOMPANY = new HashMap<Integer, String>() {{
        put(SQZF, "双乾");
    }};

}

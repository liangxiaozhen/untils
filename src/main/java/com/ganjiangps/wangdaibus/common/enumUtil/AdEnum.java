package com.ganjiangps.wangdaibus.common.enumUtil;

public enum AdEnum {
    //Ad_buy广告状态is_valid  广告购买上架状态(0等待确认 1展示中 2已完成 3已暂停  4已下架 ）
    WRITE(0,"等待确认"),
    DISPLAY(1,"展示中"),
    COMPLETED(2,"已完成"),
    PAUSE(3,"已暂停"),
    OBTAINED(4,"已下架"),

    //payway 付款方式 (1巴士余额 2支付宝 3微信)
    BUSPAY(1,"巴士余额"),
    ZFPAY(2,"支付宝"),
    WXPAY(3,"微信"),

    //addatecyleunit广告周期单位(1天 2周 3年)
    ADCLDAY(1,"天"),
    ADCLWEEK(2,"周"),
    ADCLYEER(1,"年"),

    //模块名称
    NEWSMODEL(1,"首页"),
    MUSICMODEL(2,"资源主列表"),
    PLATFORM(3,"平台数据列表"),
    TEA(4,"巴士茶馆"),
    INFORMATION(5,"网贷资讯"),

    //扫码支付
    ZFBZF(2,"ZFBZF"),
    WXZF(3,"WXZF");
    //所在页面(页面板块)  1首页，2资源主列表，3平台数据列表 4巴士茶馆 5网贷资讯 6巴士茶馆详情页侧边广告  7网贷资讯详情页侧边广告


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    AdEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getPayAway(int code){
        String msg="";
        switch (code){
            case 2:
                msg = AdEnum.ZFBZF.msg;
                break;
            case 3:
                msg = AdEnum.WXZF.msg;
                break;
        }
        return msg;
    }

    public static String isvalid(int code){
        String msg="";
        switch (code){
            case 0:
                msg = AdEnum.WRITE.msg;
                break;
            case 1:
                msg = AdEnum.DISPLAY.msg;
                break;
            case 2:
                msg = AdEnum.COMPLETED.msg;
                break;
            case 3:
                msg = AdEnum.PAUSE.msg;
                break;
            case 4:
                msg = AdEnum.OBTAINED.msg;
                break;
            default:
                msg = AdEnum.DISPLAY.msg;
            break;
        }
        return msg;
    }

    public static String payway(int code){
        String msg="";
        switch (code){
            case 1:
                msg = AdEnum.BUSPAY.msg;
                break;
            case 2:
                msg = AdEnum.ZFPAY.msg;
                break;
            case 3:
                msg = AdEnum.WXPAY.msg;
                break;
            default:
                msg = AdEnum.BUSPAY.msg;
                break;
        }
        return msg;
    }

    public static String addatecyleunit(int code){
        String msg="";
        switch (code){
            case 1:
                msg = AdEnum.ADCLDAY.msg;
                break;
            case 2:
                msg = AdEnum.ADCLWEEK.msg;
                break;
            case 3:
                msg = AdEnum.ADCLYEER.msg;
                break;
            default:
                msg = AdEnum.ADCLDAY.msg;
                break;
        }
        return msg;
    }

    public static String getModelName(int code){
        String msg="";
        switch (code){
            case 1:
                msg = AdEnum.NEWSMODEL.msg;
                break;
            case 2:
                msg = AdEnum.MUSICMODEL.msg;
                break;
            default:
                msg = AdEnum.NEWSMODEL.msg;
                break;
        }
        return msg;
    }
}

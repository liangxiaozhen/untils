package com.ganjiangps.wangdaibus.common.response;

/**
 * 系统内部业务方法处理返回对象
 */
public class ProcessBack {

    public static final String SUCCESS_CODE = "88";//成功状态码
    public static final String FAIL_CODE = "00";//失败状态码
    public static final String EXCEPTION_CODE = "22";//系统异常状态码
    public static final String USERNOTLOGIN = "99";//用户没有登陆-状态码
    public static final String PARAMERROR = "65";//参数异常
    public static final String USERMYSELF="66";//用户本身
    public static final String USERSEND="67";//当前用户作为发送者
    public static final String USERRECEIV="68";//当前用户作为接收者
    public static final String NOUSERCHAR="69";//聊天记录为空
    public static final String USEREROORE="70";//用户信息不存在
    public static final String CHATREIDSNOFOR="71";//redis--私信用户未初始化
    public static final String LACKOFBALANCE="72";//用户余额不足
    public static final String DECLAREQUERYOUT="73";//小蜜蜂  游客申报查询 缓存手机号失效
    public static final String NULLMSG="74";//发送信息为空信息
    public static final String NOTFRIEND="75";//非好友状态
    public static final String ISFRIEND="76";//好友状态
    public static final String NOREVIEW="77";//审核不通过


    public static final String REVIEWSUCCESS = "003";//审核失败

    public static final String WEBUPLOAD_CODE_EXISTED="1000000";//文件或分片已存在
      //other 其他请自己定义

    public static final String SUCCESS_MESSAGE = "操作成功";//成功返回描述
    public static final String FAIL_MESSAGE = "操作失败";//失败返回描述
    public static final String EXCEPTION_MESSAGE = "因网络响应不及时,请联系客服或重新操作";//异常返回描述

    /**406 新增状态码开始*/
    public static final String FAIL_CODE_MOBILE_406 = "001";//失败状态码      手机号
    public static final String FAIL_CODE_PASSWORD_406 = "002";//失败状态码   密码
    public static final String FAIL_CODE_REMCODE_406 = "003";//失败状态码  推荐码
    public static final String FAIL_CODE_SESSION_406 = "004";//失败状态码  Session过期
    /**406 新增状态码结束*/
    
    private String code = ProcessBack.SUCCESS_CODE;//内部方法处理状态码

    private String message = ProcessBack.SUCCESS_MESSAGE;

    private Object data;

    public ProcessBack() {

    }

    public ProcessBack(String code) {
        this.code = code;
    }



    public ProcessBack(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ProcessBack setAjaxException(ProcessBack processBack){
        processBack.setCode(ProcessBack.EXCEPTION_CODE);
        processBack.setMessage("程序异常，请刷新重试或联系客服");
        return processBack;
    }
}

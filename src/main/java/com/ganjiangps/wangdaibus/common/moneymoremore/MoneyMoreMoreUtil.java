package com.ganjiangps.wangdaibus.common.moneymoremore;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: MoneyMoreMoreUtil
 * @Description: TODO(乾多多工具类)
 * @author cjm
 * @date 2018年1月23日 上午9:25:53
 *
 */
public class MoneyMoreMoreUtil {

    //代付请求地址
    //测试提交地址：http://218.4.234.150:9600/merchant/numberPaid.action
    //正式提交地址：https://df.95epay.cn/merchant/numberPaid.action
    public static final String REQUESTURL = "https://df.95epay.cn/merchant/numberPaid.action";

    //代付结果查询请求地址
    //测试提交地址： http://218.4.234.150:9600/merchant/numberPaidQuery.action
    //正式提交地址： https://df.95epay.cn/merchant/numberPaidQuery.action
    public static final String TRADEINFORECONCILIATIONURL = "https://df.95epay.cn/merchant/numberPaidQuery.action";

    //商户私钥路径
    public static final String PFXPATH = "/certificate/200078qm.pfx";// //D:\\certificate\\168885_test.pfx   /certificate/200078qm.pfx
    //双乾测试环境公钥路径
    public static final String CERTPATH = "/certificate/200078qm.cer"; // //D:\\certificate\\95epay_test_cfca.cer   /certificate/200078qm.cer
    //验签公钥
    public static final String VERCERTPATH = "/certificate/95epay_cfca.cer";// /certificate/95epay_cfca.cer

    //商户私钥证书密码
    public static final String PASSWORD = "200078"; //123123  200078
    //商户号
    public static final String MERNO = "200078"; //168885  200078

    /***乾多多代付接口service  定义的常量key ***/
    public static final String STATE = "state";
    public static final String MSG = "msg";
    public static final String SUBMITTIME = "submittime";
    public static final String REQUESTSIGNATURE = "requestsignature";
    public static final String RESPONSESIGNATURE = "responsesignature";

    /**
     * 双乾充值
     */
    //充值商户号
    public static final String CZMERNO = "201503"; //168885      正式 201503
    //充值MD5key
    public static final String CZMD5key = "(DgXSdP_"; //12345678    正式 (DgXSdP_
    //充值请求地址
    public static final String CZREQUESTURL = "https://scan.95epay.cn/ScanCodePayment.action";
    //充值勾兑请求地址
    public static final String CZGDREQUESTURL = "https://query.95epay.cn/searchInterfaceSingleFR.action";
    /**
     * 双乾充值 406
     */
    //充值商户号
    public static final String CZMERNO406 = "201503"; //168885 201503
    //充值MD5key
    public static final String CZMD5key406 = "(DgXSdP_"; //12345678 (DgXSdP_
    //充值请求地址
    public static final String CZREQUESTURL406 = "https://scan.95epay.cn/ScanCodePayment.action";
    //充值勾兑请求地址
    public static final String CZGDREQUESTURL406 = "https://query.95epay.cn/searchInterfaceSingleFR.action";


    /**
     *
     * @Title: doHttpClientPost
     * @Description: TODO(调用接口)
     * @param @param url
     * @param @param formparams
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String doHttpClientPost(String url,List<NameValuePair> formparams){
        // 创建默认的httpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String entitys = EntityUtils.toString(entity, "UTF-8");
                    System.out.println("Response content: " + entitys);
                    return entitys;
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 签名前的字符串
     * @param map
     * @param connector
     * @return
     */
    public static String joinMapValue(Map<String, Object> map, char connector)	{
        StringBuffer b = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()){
            b.append(entry.getKey());
            b.append('=');
            if (entry.getValue() != null){
                b.append(entry.getValue());
            }
            b.append(connector);
        }
        return b.toString().substring(0, b.length()-1);
    }
}

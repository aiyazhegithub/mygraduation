package com.learn.test;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.learn.commons.config.MyConfig;
import com.learn.mapper.PublishGoodsMapper;
import com.learn.pojo.Charge;
import com.learn.pojo.PublishGoods;
import com.learn.service.impl.ChargeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/application.xml");


        ChargeServiceImpl bean = context.getBean(ChargeServiceImpl.class);

        boolean notice = bean.notice(1575726890701L);
        System.out.println("运行成功"+notice);

    }


/*

https://api.mch.weixin.qq.com/pay/unifiedorder
appid wx8a3fcf509313fd74            微信支付分配的公众账号ID
mch_id 1361137902                  微信支付分配的商户号
nonce_str                           随机字符串，长度要求在32位以内。推荐随机数生成算法
body                                商品简单描述，该字段请按照规范传递，具体请见参数规定
out_trade_no                         商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一
total_fee 1                         订单总金额，单位为分，详见支付金额
spbill_create_ip localhost           支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
notify_url "http://localhost:9090"  异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
trade_type NATIVE                        Native支付
product_id                          trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义


*/


    /*
    <xml>
    <appid> 微信支付分配的公众账号ID
        <![CDATA[wx8a3fcf509313fd74]]>
    </appid>
    <bank_type>
        <![CDATA[OTHERS]]>
    </bank_type>
    <cash_fee>  //金额
        <![CDATA[1]]>
    </cash_fee>
    <fee_type>
        <![CDATA[CNY]]>
    </fee_type>
    <is_subscribe>     //是否订阅
        <![CDATA[N]]>
    </is_subscribe>
    <mch_id>        //商户号
        <![CDATA[1361137902]]>
    </mch_id>
    <nonce_str>     //随机字符串，长度要求在32位以内。推荐随机数生成算法
        <![CDATA[df55b6179b6547dfbe44259f96a7ee03]]>
    </nonce_str>
    <openid>
        <![CDATA[o_Tnit6hL68u7gYwhEdKj_bAaItM]]>
    </openid>
    <out_trade_no>      //重点 商户系统内部订单号，要求32个字符内
        <![CDATA[1575713210062]]>
    </out_trade_no>
    <result_code>
        <![CDATA[SUCCESS]]>
    </result_code>
    <return_code>
        <![CDATA[SUCCESS]]>
    </return_code>
    <sign>
        <![CDATA[DD5C9564EBB2DF3CAEBBDE624FF5D7EA]]>
    </sign>
    <time_end>
        <![CDATA[20191207180707]]>
    </time_end>
    <total_fee>
        1
    </total_fee>
    <trade_type>
        <![CDATA[NATIVE]]>
    </trade_type>
    <transaction_id>
        <![CDATA[4200000446201912076139388342]]>
    </transaction_id>
    </xml>
    */
    @Test
    public void test() throws UnknownHostException {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", String.valueOf(Instant.now().toEpochMilli())); //商户系统内部订单号
        data.put("fee_type", "CNY");
        data.put("total_fee", "1100"); //此值为00.00开始
        data.put("spbill_create_ip", InetAddress.getLocalHost().getHostAddress());
        data.put("notify_url", InetAddress.getLocalHost().getHostAddress());
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "1112");

        System.out.println(InetAddress.getLocalHost().getHostAddress());
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);


            String code_url = resp.get("code_url");
            System.out.println(code_url);
            System.out.println(resp);

            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix encode1 = new MultiFormatWriter()
                    .encode(
                            code_url,
                            BarcodeFormat.QR_CODE,
                            230,
                            230, hints);

            Path path = FileSystems.getDefault().getPath("D://", "wxcode.jpg");
            MatrixToImageWriter.writeToPath(encode1, "jpg", path);


            System.out.println(resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void aaa() throws Exception {

        String result = "<xml><appid><![CDATA[wx8a3fcf\n" +
                "509313fd74]]></appid>\n" +
                "<bank_type><![CDATA[OTHERS]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1361137902]]></mch_id>\n" +
                "<nonce_str><![CDATA[df55b6179b6547dfbe44259f96a7ee03]]></nonce_str>\n" +
                "<openid><![CDATA[o_Tnit6hL68u7gYwhEdKj_bAaItM]]></openid>\n" +
                "<out_trade_no><![CDATA[1575713210062]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[DD5C9564EBB2DF3CAEBBDE624FF5D7EA]]></sign>\n" +
                "<time_end><![CDATA[20191207180707]]></time_end>\n" +
                "<total_fee>1</total_fee>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<transaction_id><![CDATA[4200000446201912076139388342]]></transaction_id>\n" +
                "</xml>";

        Map<String, String> stringStringMap = WXPayUtil.xmlToMap(result);

        System.out.println(stringStringMap.get("out_trade_no"));


    }


}

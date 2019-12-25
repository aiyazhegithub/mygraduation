package com.learn.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.learn.commons.tool.TotalData;
import com.learn.commons.utils.SessionUtils;
import com.learn.pojo.Charge;
import com.learn.pojo.UserInfo;
import com.learn.service.impl.ChargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 充值
 */
@Controller
@RequestMapping("charges")
public class ChargeController {

    @Autowired
    private WXPay wxPay;

    @Value("${WXPAYRECALL}")
    private String WXPAYRECALL;

    @Autowired
    ChargeServiceImpl chargeService;


    @RequestMapping("tocharge")
    public String tocharge() {


        return "charges/chargeindex";
    }


    @RequestMapping("toqcode")
    public String toqcode(Double totalMoney, HttpServletRequest request) {

        if (totalMoney == null) {
            request.setAttribute("data", new TotalData("请输入金额"));
            return "charges/chargeindex";
        }

        long l = Instant.now().toEpochMilli();
        request.setAttribute("chargeId", l);

        request.setAttribute("totalMoney", totalMoney);


        return "charges/chargeqcode";
    }

    @RequestMapping("createQCode")
    public void createQCode(Long trade_no,Double totalMoney, HttpServletResponse response, HttpServletRequest request) throws UnknownHostException {
        System.out.println(totalMoney);

        if (totalMoney == null) {
            request.setAttribute("data", new TotalData("请输入金额"));
            return;
        }

        UserInfo userInfo = SessionUtils.getUserInfo(request);
        Charge charge = new Charge();
        charge.setTotalMoney(totalMoney);
        //注解
        charge.setId(trade_no);
        charge.setBeginDate(new Date());
        charge.setUserId(userInfo.getId());

        totalMoney = totalMoney * 100;
        System.out.println(totalMoney);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", String.valueOf(trade_no)); //商户系统内部订单号
        data.put("fee_type", "CNY");
        data.put("total_fee", String.valueOf(totalMoney.intValue())); //此值为00.00开始
        //创建的IP
        //data.put("spbill_create_ip", InetAddress.getLocalHost().getHostAddress());
        data.put("spbill_create_ip", "39.107.41.132");
        data.put("notify_url", WXPAYRECALL);   //回调地址
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "1112");

        try {
            Map<String, String> resp = wxPay.unifiedOrder(data);
//  {nonce_str=KFt0ODUXW5tXHk3h,
//  code_url=weixin://wxpay/bizpayurl?pr=Rkd7jOV,
//  appid=wx8a3fcf509313fd74,
//  sign=6901E9413EFA7EC235F67598D11D4D3A,
//  trade_type=NATIVE,
//  return_msg=OK,
//  result_code=SUCCESS,
//  mch_id=1361137902,
//  return_code=SUCCESS,
//  prepay_id=wx07164738486459557328bf761834569300}


            String code_url = resp.get("code_url");


            if (code_url == null) {
                throw new Exception();
            }
            //此处可以优化
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix encode1 = new MultiFormatWriter()
                    .encode(
                            code_url,
                            BarcodeFormat.QR_CODE,
                            230,
                            230, hints);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(encode1);
            ServletOutputStream outputStream = response.getOutputStream();

            ImageIO.write(bufferedImage, "jpg", outputStream);
            //插入记录
            chargeService.createQCode(charge);

        } catch (Exception e) {
            request.setAttribute("data", new TotalData("发送错误，请刷新页面"));
            e.printStackTrace();
        }


    }

    @ResponseBody
    @RequestMapping("notice")
    public String notice(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServletInputStream inputStream = request.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];

        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byteArrayOutputStream.close();
        inputStream.close();

        String result = new String(byteArrayOutputStream.toByteArray(), "UTF-8");

        if(result.length()==0 || result==null){
            return "";
        }

        Map<String, String> stringStringMap = WXPayUtil.xmlToMap(result);

        String out_trade_no = stringStringMap.get("out_trade_no");

        if (out_trade_no == null) {
            return "";
        }

        Boolean notice = chargeService.notice(Long.valueOf(out_trade_no));

        if (notice == null) {
            return "";
        }

        //成功直接回复
        if (notice) {
            Map<String, String> resp = new HashMap<>();
            resp.put("return_code", "SUCCESS");
            resp.put("return_msg", "");
            return WXPayUtil.mapToXml(resp);
        }


        return "";
    }

    @ResponseBody
    @RequestMapping("isDone")
    public String isDone(Long chargeId) {

        Charge charge =
                chargeService.getChargeMapper().selectByPrimaryKey(chargeId);
        if (charge.getEndDate() != null) {
            return "SUCCESS";
        }


        return "FAIL";
    }


}

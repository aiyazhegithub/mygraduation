package com.learn.commons.config;


import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyConfig implements WXPayConfig {


    @Override
    public String getAppID() {
        return "wx8a3fcf509313fd74";
    }

    @Override
    public String getMchID() {
        return "1361137902 ";
    }

    @Override
    public String getKey() {
        return "367151c5fd0d50f1e34a68a802d6bbca";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 1000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 1000;
    }
}

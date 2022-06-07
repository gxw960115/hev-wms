package com.haier.hevwms.sto.service.vnpt;

import java.net.MalformedURLException;
import java.net.URL;

public class PrintInvoiceService {
    private PublishServiceSoap publishServiceSoap;

    public PublishServiceSoap getPublishServiceSoap() {
//        String url = "https://aquavnadmindemo.vnpt-invoice.com.vn/PublishService.asmx?wsdl";
        String url = "https://aquavn-tt78admindemo.vnpt-invoice.com.vn/PublishService.asmx?wsdl";
        if (publishServiceSoap != null) {
            return publishServiceSoap;
        }
        try {
            URL uurl = new URL(url);//URL在配置文件中动态配置
            PublishService mobileCodeWS = new PublishService(uurl);
            publishServiceSoap = mobileCodeWS.getPublishServiceSoap();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return publishServiceSoap;
    }
}
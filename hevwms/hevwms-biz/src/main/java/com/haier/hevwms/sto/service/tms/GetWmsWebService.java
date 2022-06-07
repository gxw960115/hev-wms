package com.haier.hevwms.sto.service.tms;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.net.MalformedURLException;
import java.net.URL;


public class GetWmsWebService {

    private WmsWebService wmsWebService;

    public WmsWebService getWmsWebService() {
        String url = "https://vntms.haier.net/api/tms/ws/wms?wsdl";
        if (wmsWebService != null) {
            return wmsWebService;
        }
        try {
            URL uurl = new URL(url);//URL在配置文件中动态配置
            WmsWebServiceImplService mobileCodeWS = new WmsWebServiceImplService(uurl);
            wmsWebService = mobileCodeWS.getWmsWebServiceImplPort();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return wmsWebService;
    }
}

package com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2015-12-16T14:29:25.803+08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://www.example.org/TransGoodsReceiveFromINDWMSToGVS/", name = "TransGoodsReceiveFromINDWMSToGVS")
@XmlSeeAlso({ObjectFactory.class})
public interface TransGoodsReceiveFromINDWMSToGVS {

    @WebResult(name = "IT_GR_OUTPUT", targetNamespace = "")
    @RequestWrapper(localName = "TransGoodsReceiveFromINDWMSToGVS", targetNamespace = "http://www.example.org/TransGoodsReceiveFromINDWMSToGVS/", className = "com.haier.otcwms.webinterface.PostSTODNReceiveFromInidaWMSToGVS.TransGoodsReceiveFromINDWMSToGVS_Type")
    @WebMethod(operationName = "TransGoodsReceiveFromINDWMSToGVS", action = "http://www.example.org/TransGoodsReceiveFromINDWMSToGVS/TransGoodsReceiveFromINDWMSToGVS")
    @ResponseWrapper(localName = "TransGoodsReceiveFromINDWMSToGVSResponse", targetNamespace = "http://www.example.org/TransGoodsReceiveFromINDWMSToGVS/", className = "com.haier.otcwms.webinterface.PostSTODNReceiveFromInidaWMSToGVS.TransGoodsReceiveFromINDWMSToGVSResponse")
    public java.util.List<com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS.ZMMSTRUGROUT> transGoodsReceiveFromINDWMSToGVS(
            @WebParam(name = "IT_GR_INPUT", targetNamespace = "")
                    java.util.List<com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS.ZMMSTRUGRIN> itGRINPUT
    );
}

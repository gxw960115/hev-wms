package com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2015-11-27T15:44:57.316+08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://www.example.org/TransGoodsIssueFromINDWMSToGVS/", name = "TransGoodsIssueFromINDWMSToGVS")
@XmlSeeAlso({ObjectFactory.class})
public interface TransGoodsIssueFromINDWMSToGVS {

    @WebResult(name = "OUT", targetNamespace = "")
    @RequestWrapper(localName = "TransGoodsIssueFromINDWMSToGVS", targetNamespace = "http://www.example.org/TransGoodsIssueFromINDWMSToGVS/", className = "com.haier.otcwms.webinterface.PostDNFromIndiaWmsToGVS.TransGoodsIssueFromINDWMSToGVS_Type")
    @WebMethod(operationName = "TransGoodsIssueFromINDWMSToGVS", action = "http://www.example.org/TransGoodsIssueFromINDWMSToGVS/TransGoodsIssueFromINDWMSToGVS")
    @ResponseWrapper(localName = "TransGoodsIssueFromINDWMSToGVSResponse", targetNamespace = "http://www.example.org/TransGoodsIssueFromINDWMSToGVS/", className = "com.haier.otcwms.webinterface.PostDNFromIndiaWmsToGVS.TransGoodsIssueFromINDWMSToGVSResponse")
    public java.util.List<com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS.ZSDWMSTOPGIOUT> transGoodsIssueFromINDWMSToGVS(
            @WebParam(name = "ITEM", targetNamespace = "")
                    java.util.List<com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS.ZSDWMSTOPGIITEM> item
    );
}
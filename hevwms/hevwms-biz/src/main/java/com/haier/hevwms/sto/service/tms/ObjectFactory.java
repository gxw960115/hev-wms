
package com.haier.hevwms.sto.service.tms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.haier.hevwms.sto.service.tms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FinishDnResponse_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "finishDnResponse");
    private final static QName _FinishDn_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "finishDn");
    private final static QName _PushLoadInfoResponse_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "pushLoadInfoResponse");
    private final static QName _PushLoadInfo_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "pushLoadInfo");
    private final static QName _GetDn_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "getDn");
    private final static QName _GetDnResponse_QNAME = new QName("http://wms.services.webservice.api.tms.haier.com/", "getDnResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.haier.hevwms.sto.service.tms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PushLoadInfoResponse }
     * 
     */
    public PushLoadInfoResponse createPushLoadInfoResponse() {
        return new PushLoadInfoResponse();
    }

    /**
     * Create an instance of {@link FinishDn }
     * 
     */
    public FinishDn createFinishDn() {
        return new FinishDn();
    }

    /**
     * Create an instance of {@link FinishDnResponse }
     * 
     */
    public FinishDnResponse createFinishDnResponse() {
        return new FinishDnResponse();
    }

    /**
     * Create an instance of {@link GetDn }
     * 
     */
    public GetDn createGetDn() {
        return new GetDn();
    }

    /**
     * Create an instance of {@link GetDnResponse }
     * 
     */
    public GetDnResponse createGetDnResponse() {
        return new GetDnResponse();
    }

    /**
     * Create an instance of {@link PushLoadInfo }
     * 
     */
    public PushLoadInfo createPushLoadInfo() {
        return new PushLoadInfo();
    }

    /**
     * Create an instance of {@link Load }
     * 
     */
    public Load createLoad() {
        return new Load();
    }

    /**
     * Create an instance of {@link StatusResult }
     * 
     */
    public StatusResult createStatusResult() {
        return new StatusResult();
    }

    /**
     * Create an instance of {@link DnResult }
     * 
     */
    public DnResult createDnResult() {
        return new DnResult();
    }

    /**
     * Create an instance of {@link Material }
     * 
     */
    public Material createMaterial() {
        return new Material();
    }

    /**
     * Create an instance of {@link LoadParam }
     * 
     */
    public LoadParam createLoadParam() {
        return new LoadParam();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishDnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "finishDnResponse")
    public JAXBElement<FinishDnResponse> createFinishDnResponse(FinishDnResponse value) {
        return new JAXBElement<FinishDnResponse>(_FinishDnResponse_QNAME, FinishDnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishDn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "finishDn")
    public JAXBElement<FinishDn> createFinishDn(FinishDn value) {
        return new JAXBElement<FinishDn>(_FinishDn_QNAME, FinishDn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PushLoadInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "pushLoadInfoResponse")
    public JAXBElement<PushLoadInfoResponse> createPushLoadInfoResponse(PushLoadInfoResponse value) {
        return new JAXBElement<PushLoadInfoResponse>(_PushLoadInfoResponse_QNAME, PushLoadInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PushLoadInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "pushLoadInfo")
    public JAXBElement<PushLoadInfo> createPushLoadInfo(PushLoadInfo value) {
        return new JAXBElement<PushLoadInfo>(_PushLoadInfo_QNAME, PushLoadInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "getDn")
    public JAXBElement<GetDn> createGetDn(GetDn value) {
        return new JAXBElement<GetDn>(_GetDn_QNAME, GetDn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wms.services.webservice.api.tms.haier.com/", name = "getDnResponse")
    public JAXBElement<GetDnResponse> createGetDnResponse(GetDnResponse value) {
        return new JAXBElement<GetDnResponse>(_GetDnResponse_QNAME, GetDnResponse.class, null, value);
    }

}

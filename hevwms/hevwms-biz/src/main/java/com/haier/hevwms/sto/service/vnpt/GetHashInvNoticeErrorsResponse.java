
package com.haier.hevwms.sto.service.vnpt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetHashInvNoticeErrorsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getHashInvNoticeErrorsResult"
})
@XmlRootElement(name = "GetHashInvNoticeErrorsResponse")
public class GetHashInvNoticeErrorsResponse {

    @XmlElement(name = "GetHashInvNoticeErrorsResult")
    protected String getHashInvNoticeErrorsResult;

    /**
     * Gets the value of the getHashInvNoticeErrorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetHashInvNoticeErrorsResult() {
        return getHashInvNoticeErrorsResult;
    }

    /**
     * Sets the value of the getHashInvNoticeErrorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetHashInvNoticeErrorsResult(String value) {
        this.getHashInvNoticeErrorsResult = value;
    }

}

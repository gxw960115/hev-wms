
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
 *         &lt;element name="CancelPublishInvoiceResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cancelPublishInvoiceResult"
})
@XmlRootElement(name = "CancelPublishInvoiceResponse")
public class CancelPublishInvoiceResponse {

    @XmlElement(name = "CancelPublishInvoiceResult")
    protected String cancelPublishInvoiceResult;

    /**
     * Gets the value of the cancelPublishInvoiceResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelPublishInvoiceResult() {
        return cancelPublishInvoiceResult;
    }

    /**
     * Sets the value of the cancelPublishInvoiceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelPublishInvoiceResult(String value) {
        this.cancelPublishInvoiceResult = value;
    }

}

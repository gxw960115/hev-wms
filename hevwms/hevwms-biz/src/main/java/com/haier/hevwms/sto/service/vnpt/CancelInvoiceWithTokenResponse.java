
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
 *         &lt;element name="CancelInvoiceWithTokenResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cancelInvoiceWithTokenResult"
})
@XmlRootElement(name = "CancelInvoiceWithTokenResponse")
public class CancelInvoiceWithTokenResponse {

    @XmlElement(name = "CancelInvoiceWithTokenResult")
    protected String cancelInvoiceWithTokenResult;

    /**
     * Gets the value of the cancelInvoiceWithTokenResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelInvoiceWithTokenResult() {
        return cancelInvoiceWithTokenResult;
    }

    /**
     * Sets the value of the cancelInvoiceWithTokenResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelInvoiceWithTokenResult(String value) {
        this.cancelInvoiceWithTokenResult = value;
    }

}

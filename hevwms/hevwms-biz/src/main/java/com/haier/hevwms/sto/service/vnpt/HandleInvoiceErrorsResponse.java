
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
 *         &lt;element name="HandleInvoiceErrorsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "handleInvoiceErrorsResult"
})
@XmlRootElement(name = "HandleInvoiceErrorsResponse")
public class HandleInvoiceErrorsResponse {

    @XmlElement(name = "HandleInvoiceErrorsResult")
    protected String handleInvoiceErrorsResult;

    /**
     * Gets the value of the handleInvoiceErrorsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandleInvoiceErrorsResult() {
        return handleInvoiceErrorsResult;
    }

    /**
     * Sets the value of the handleInvoiceErrorsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandleInvoiceErrorsResult(String value) {
        this.handleInvoiceErrorsResult = value;
    }

}

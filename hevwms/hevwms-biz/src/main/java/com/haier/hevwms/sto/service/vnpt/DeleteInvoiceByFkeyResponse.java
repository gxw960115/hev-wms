
package com.haier.hevwms.sto.service.vnpt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="deleteInvoiceByFkeyResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "deleteInvoiceByFkeyResult"
})
@XmlRootElement(name = "deleteInvoiceByFkeyResponse")
public class DeleteInvoiceByFkeyResponse {

    protected String deleteInvoiceByFkeyResult;

    /**
     * Gets the value of the deleteInvoiceByFkeyResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteInvoiceByFkeyResult() {
        return deleteInvoiceByFkeyResult;
    }

    /**
     * Sets the value of the deleteInvoiceByFkeyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteInvoiceByFkeyResult(String value) {
        this.deleteInvoiceByFkeyResult = value;
    }

}

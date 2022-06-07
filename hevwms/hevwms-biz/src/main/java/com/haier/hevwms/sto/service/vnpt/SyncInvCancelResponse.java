
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
 *         &lt;element name="syncInvCancelResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "syncInvCancelResult"
})
@XmlRootElement(name = "syncInvCancelResponse")
public class SyncInvCancelResponse {

    protected String syncInvCancelResult;

    /**
     * Gets the value of the syncInvCancelResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncInvCancelResult() {
        return syncInvCancelResult;
    }

    /**
     * Sets the value of the syncInvCancelResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncInvCancelResult(String value) {
        this.syncInvCancelResult = value;
    }

}

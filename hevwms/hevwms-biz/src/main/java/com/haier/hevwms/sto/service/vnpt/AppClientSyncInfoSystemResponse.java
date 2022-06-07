
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
 *         &lt;element name="AppClientSyncInfoSystemResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "appClientSyncInfoSystemResult"
})
@XmlRootElement(name = "AppClientSyncInfoSystemResponse")
public class AppClientSyncInfoSystemResponse {

    @XmlElement(name = "AppClientSyncInfoSystemResult")
    protected String appClientSyncInfoSystemResult;

    /**
     * Gets the value of the appClientSyncInfoSystemResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppClientSyncInfoSystemResult() {
        return appClientSyncInfoSystemResult;
    }

    /**
     * Sets the value of the appClientSyncInfoSystemResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppClientSyncInfoSystemResult(String value) {
        this.appClientSyncInfoSystemResult = value;
    }

}

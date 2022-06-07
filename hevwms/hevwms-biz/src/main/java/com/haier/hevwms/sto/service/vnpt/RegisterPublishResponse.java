
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
 *         &lt;element name="RegisterPublishResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "registerPublishResult"
})
@XmlRootElement(name = "RegisterPublishResponse")
public class RegisterPublishResponse {

    @XmlElement(name = "RegisterPublishResult")
    protected String registerPublishResult;

    /**
     * Gets the value of the registerPublishResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterPublishResult() {
        return registerPublishResult;
    }

    /**
     * Sets the value of the registerPublishResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterPublishResult(String value) {
        this.registerPublishResult = value;
    }

}

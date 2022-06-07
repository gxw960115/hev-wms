
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
 *         &lt;element name="ConvertForVerifyResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "convertForVerifyResult"
})
@XmlRootElement(name = "ConvertForVerifyResponse")
public class ConvertForVerifyResponse {

    @XmlElement(name = "ConvertForVerifyResult")
    protected String convertForVerifyResult;

    /**
     * Gets the value of the convertForVerifyResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvertForVerifyResult() {
        return convertForVerifyResult;
    }

    /**
     * Sets the value of the convertForVerifyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvertForVerifyResult(String value) {
        this.convertForVerifyResult = value;
    }

}

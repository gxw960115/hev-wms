
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
 *         &lt;element name="ImportInvByPatternResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "importInvByPatternResult"
})
@XmlRootElement(name = "ImportInvByPatternResponse")
public class ImportInvByPatternResponse {

    @XmlElement(name = "ImportInvByPatternResult")
    protected String importInvByPatternResult;

    /**
     * Gets the value of the importInvByPatternResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportInvByPatternResult() {
        return importInvByPatternResult;
    }

    /**
     * Sets the value of the importInvByPatternResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportInvByPatternResult(String value) {
        this.importInvByPatternResult = value;
    }

}


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
 *         &lt;element name="setCusCertResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setCusCertResult"
})
@XmlRootElement(name = "setCusCertResponse")
public class SetCusCertResponse {

    protected int setCusCertResult;

    /**
     * Gets the value of the setCusCertResult property.
     * 
     */
    public int getSetCusCertResult() {
        return setCusCertResult;
    }

    /**
     * Sets the value of the setCusCertResult property.
     * 
     */
    public void setSetCusCertResult(int value) {
        this.setCusCertResult = value;
    }

}


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
 *         &lt;element name="certSerial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "certSerial",
    "certString",
    "cusCode",
    "username",
    "pass"
})
@XmlRootElement(name = "setCusCert")
public class SetCusCert {

    protected String certSerial;
    protected String certString;
    protected String cusCode;
    protected String username;
    protected String pass;

    /**
     * Gets the value of the certSerial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertSerial() {
        return certSerial;
    }

    /**
     * Sets the value of the certSerial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertSerial(String value) {
        this.certSerial = value;
    }

    /**
     * Gets the value of the certString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertString() {
        return certString;
    }

    /**
     * Sets the value of the certString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertString(String value) {
        this.certString = value;
    }

    /**
     * Gets the value of the cusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusCode() {
        return cusCode;
    }

    /**
     * Sets the value of the cusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusCode(String value) {
        this.cusCode = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPass(String value) {
        this.pass = value;
    }

}

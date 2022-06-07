
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
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comtaxcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "username",
    "password",
    "comtaxcode",
    "pattern",
    "serial",
    "notax",
    "fkey"
})
@XmlRootElement(name = "GetInvoiceByFkey")
public class GetInvoiceByFkey {

    protected String username;
    protected String password;
    protected String comtaxcode;
    protected String pattern;
    protected String serial;
    protected String notax;
    protected String fkey;

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
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the comtaxcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComtaxcode() {
        return comtaxcode;
    }

    /**
     * Sets the value of the comtaxcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComtaxcode(String value) {
        this.comtaxcode = value;
    }

    /**
     * Gets the value of the pattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * Gets the value of the serial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerial(String value) {
        this.serial = value;
    }

    /**
     * Gets the value of the notax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotax() {
        return notax;
    }

    /**
     * Sets the value of the notax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotax(String value) {
        this.notax = value;
    }

    /**
     * Gets the value of the fkey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFkey() {
        return fkey;
    }

    /**
     * Sets the value of the fkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkey(String value) {
        this.fkey = value;
    }

}

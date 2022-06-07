
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
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACpass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certinfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialCert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "account",
    "aCpass",
    "certinfo",
    "serialCert",
    "certType",
    "id"
})
@XmlRootElement(name = "UpdateCertificate")
public class UpdateCertificate {

    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "ACpass")
    protected String aCpass;
    protected String certinfo;
    protected String serialCert;
    protected int certType;
    protected int id;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the aCpass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACpass() {
        return aCpass;
    }

    /**
     * Sets the value of the aCpass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACpass(String value) {
        this.aCpass = value;
    }

    /**
     * Gets the value of the certinfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertinfo() {
        return certinfo;
    }

    /**
     * Sets the value of the certinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertinfo(String value) {
        this.certinfo = value;
    }

    /**
     * Gets the value of the serialCert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialCert() {
        return serialCert;
    }

    /**
     * Sets the value of the serialCert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialCert(String value) {
        this.serialCert = value;
    }

    /**
     * Gets the value of the certType property.
     * 
     */
    public int getCertType() {
        return certType;
    }

    /**
     * Sets the value of the certType property.
     * 
     */
    public void setCertType(int value) {
        this.certType = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}

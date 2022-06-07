
package com.haier.hevwms.sto.service.vnpt;

import java.math.BigDecimal;
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
 *         &lt;element name="pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="noNew" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="publishDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arisingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isUpdate" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "pattern",
    "serial",
    "no",
    "noNew",
    "publishDate",
    "arisingDate",
    "serialO",
    "noO",
    "type",
    "key",
    "isUpdate"
})
@XmlRootElement(name = "GetDataInvHsm")
public class GetDataInvHsm {

    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "ACpass")
    protected String aCpass;
    protected String pattern;
    protected String serial;
    @XmlElement(required = true)
    protected BigDecimal no;
    @XmlElement(required = true)
    protected BigDecimal noNew;
    protected String publishDate;
    protected String arisingDate;
    protected String serialO;
    protected int noO;
    protected int type;
    protected String key;
    protected int isUpdate;

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
     * Gets the value of the no property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNo() {
        return no;
    }

    /**
     * Sets the value of the no property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNo(BigDecimal value) {
        this.no = value;
    }

    /**
     * Gets the value of the noNew property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNoNew() {
        return noNew;
    }

    /**
     * Sets the value of the noNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNoNew(BigDecimal value) {
        this.noNew = value;
    }

    /**
     * Gets the value of the publishDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * Sets the value of the publishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishDate(String value) {
        this.publishDate = value;
    }

    /**
     * Gets the value of the arisingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArisingDate() {
        return arisingDate;
    }

    /**
     * Sets the value of the arisingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArisingDate(String value) {
        this.arisingDate = value;
    }

    /**
     * Gets the value of the serialO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialO() {
        return serialO;
    }

    /**
     * Sets the value of the serialO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialO(String value) {
        this.serialO = value;
    }

    /**
     * Gets the value of the noO property.
     * 
     */
    public int getNoO() {
        return noO;
    }

    /**
     * Sets the value of the noO property.
     * 
     */
    public void setNoO(int value) {
        this.noO = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the isUpdate property.
     * 
     */
    public int getIsUpdate() {
        return isUpdate;
    }

    /**
     * Sets the value of the isUpdate property.
     * 
     */
    public void setIsUpdate(int value) {
        this.isUpdate = value;
    }

}

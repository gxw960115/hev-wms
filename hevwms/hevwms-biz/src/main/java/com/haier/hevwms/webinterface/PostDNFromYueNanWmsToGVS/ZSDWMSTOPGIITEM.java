
package com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZSD_WMS_TO_PGI_ITEM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZSD_WMS_TO_PGI_ITEM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VBELN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WADAT_IST" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BOLNR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="POSNR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WERKS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MATNR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LGORT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LFIMG" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZSD_WMS_TO_PGI_ITEM", propOrder = {
    "vbeln",
    "wadatist",
    "bolnr",
    "posnr",
    "werks",
    "matnr",
    "lgort",
    "lfimg"
})
public class ZSDWMSTOPGIITEM {

    @XmlElement(name = "VBELN", required = true)
    protected String vbeln;
    @XmlElement(name = "WADAT_IST", required = true)
    protected String wadatist;
    @XmlElement(name = "BOLNR", required = true)
    protected String bolnr;
    @XmlElement(name = "POSNR", required = true)
    protected String posnr;
    @XmlElement(name = "WERKS", required = true)
    protected String werks;
    @XmlElement(name = "MATNR", required = true)
    protected String matnr;
    @XmlElement(name = "LGORT", required = true)
    protected String lgort;
    @XmlElement(name = "LFIMG", required = true)
    protected BigDecimal lfimg;

    /**
     * Gets the value of the vbeln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBELN() {
        return vbeln;
    }

    /**
     * Sets the value of the vbeln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBELN(String value) {
        this.vbeln = value;
    }

    /**
     * Gets the value of the wadatist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWADATIST() {
        return wadatist;
    }

    /**
     * Sets the value of the wadatist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWADATIST(String value) {
        this.wadatist = value;
    }

    /**
     * Gets the value of the bolnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBOLNR() {
        return bolnr;
    }

    /**
     * Sets the value of the bolnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBOLNR(String value) {
        this.bolnr = value;
    }

    /**
     * Gets the value of the posnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSNR() {
        return posnr;
    }

    /**
     * Sets the value of the posnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSNR(String value) {
        this.posnr = value;
    }

    /**
     * Gets the value of the werks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWERKS() {
        return werks;
    }

    /**
     * Sets the value of the werks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWERKS(String value) {
        this.werks = value;
    }

    /**
     * Gets the value of the matnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMATNR() {
        return matnr;
    }

    /**
     * Sets the value of the matnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMATNR(String value) {
        this.matnr = value;
    }

    /**
     * Gets the value of the lgort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLGORT() {
        return lgort;
    }

    /**
     * Sets the value of the lgort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLGORT(String value) {
        this.lgort = value;
    }

    /**
     * Gets the value of the lfimg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLFIMG() {
        return lfimg;
    }

    /**
     * Sets the value of the lfimg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLFIMG(BigDecimal value) {
        this.lfimg = value;
    }

}

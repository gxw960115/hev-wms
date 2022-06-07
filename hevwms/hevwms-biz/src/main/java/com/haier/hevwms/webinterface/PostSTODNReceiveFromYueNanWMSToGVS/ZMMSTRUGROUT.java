
package com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * <p>Java class for ZMM_STRU_GR_OUT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZMM_STRU_GR_OUT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EBELN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MBLNR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MSG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZMM_STRU_GR_OUT", propOrder = {
    "ebeln",
    "flag",
    "mblnr",
    "msg"
})
public class ZMMSTRUGROUT {

    @XmlElement(name = "EBELN", required = true)
    protected String ebeln;
    @XmlElement(name = "FLAG", required = true)
    protected String flag;
    @XmlElement(name = "MBLNR", required = true)
    protected String mblnr;
    @XmlElement(name = "MSG", required = true)
    protected String msg;
    
    
    //重新父类的toString方法 add by linzx @20160119
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    
    /**
     * Gets the value of the ebeln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBELN() {
        return ebeln;
    }

    /**
     * Sets the value of the ebeln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBELN(String value) {
        this.ebeln = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLAG() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLAG(String value) {
        this.flag = value;
    }

    /**
     * Gets the value of the mblnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMBLNR() {
        return mblnr;
    }

    /**
     * Sets the value of the mblnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMBLNR(String value) {
        this.mblnr = value;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSG() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSG(String value) {
        this.msg = value;
    }

}

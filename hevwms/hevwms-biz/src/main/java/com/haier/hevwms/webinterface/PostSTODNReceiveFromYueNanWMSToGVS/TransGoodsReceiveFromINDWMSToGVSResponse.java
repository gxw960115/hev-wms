
package com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="IT_GR_OUTPUT" type="{http://www.example.org/TransGoodsReceiveFromINDWMSToGVS/}ZMM_STRU_GR_OUT" maxOccurs="unbounded" minOccurs="0"/>
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
    "itgroutput"
})
@XmlRootElement(name = "TransGoodsReceiveFromINDWMSToGVSResponse")
public class TransGoodsReceiveFromINDWMSToGVSResponse {

    @XmlElement(name = "IT_GR_OUTPUT")
    protected List<ZMMSTRUGROUT> itgroutput;

    /**
     * Gets the value of the itgroutput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itgroutput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getITGROUTPUT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZMMSTRUGROUT }
     * 
     * 
     */
    public List<ZMMSTRUGROUT> getITGROUTPUT() {
        if (itgroutput == null) {
            itgroutput = new ArrayList<ZMMSTRUGROUT>();
        }
        return this.itgroutput;
    }

}

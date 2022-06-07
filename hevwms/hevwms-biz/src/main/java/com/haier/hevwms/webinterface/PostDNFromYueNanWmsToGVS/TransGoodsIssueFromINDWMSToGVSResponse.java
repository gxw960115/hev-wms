
package com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS;

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
 *         &lt;element name="OUT" type="{http://www.example.org/TransGoodsIssueFromINDWMSToGVS/}ZSD_WMS_TO_PGI_OUT" maxOccurs="unbounded" minOccurs="0"/>
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
    "out"
})
@XmlRootElement(name = "TransGoodsIssueFromINDWMSToGVSResponse")
public class TransGoodsIssueFromINDWMSToGVSResponse {

    @XmlElement(name = "OUT")
    protected List<ZSDWMSTOPGIOUT> out;

    /**
     * Gets the value of the out property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the out property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOUT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZSDWMSTOPGIOUT }
     * 
     * 
     */
    public List<ZSDWMSTOPGIOUT> getOUT() {
        if (out == null) {
            out = new ArrayList<ZSDWMSTOPGIOUT>();
        }
        return this.out;
    }

}

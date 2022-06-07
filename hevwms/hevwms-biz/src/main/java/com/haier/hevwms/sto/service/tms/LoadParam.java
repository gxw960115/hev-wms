
package com.haier.hevwms.sto.service.tms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>LoadParam complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoadParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadList" type="{http://wms.services.webservice.api.tms.haier.com/}Load" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadParam", propOrder = {
    "tradeId",
    "loadList"
})
public class LoadParam {

    protected String tradeId;
    @XmlElement(nillable = true)
    protected List<Load> loadList;

    /**
     * ��ȡtradeId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * ����tradeId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeId(String value) {
        this.tradeId = value;
    }

    /**
     * Gets the value of the loadList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Load }
     * 
     * 
     */
    public List<Load> getLoadList() {
        if (loadList == null) {
            loadList = new ArrayList<Load>();
        }
        return this.loadList;
    }

    public void setLoadList(List<Load> loadList) {
        this.loadList = loadList;
    }

    @Override
    public String toString() {
        return "LoadParam{" +
                "tradeId='" + tradeId + '\'' +
                ", loadList=" + loadList +
                '}';
    }
}

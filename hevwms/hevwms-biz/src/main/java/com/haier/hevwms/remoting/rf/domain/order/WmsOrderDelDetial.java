package com.haier.hevwms.remoting.rf.domain.order;

/**
 * @ClassName: OtcwmsOrderDelDetial
 * @Description: (这里用一句话描述这个类的作用)
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:28:44
 * @param
 */
public class WmsOrderDelDetial {

	private String rowId;
	/** SAP凭证单号 */
	private String sapOrderNo;
	/** 条码 */
	private java.lang.String barcode;
	/** 数量 */
	private String qty;

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSapOrderNo() {
		return sapOrderNo;
	}

	public void setSapOrderNo(String sapOrderNo) {
		this.sapOrderNo = sapOrderNo;
	}

	public java.lang.String getBarcode() {
		return barcode;
	}

	public void setBarcode(java.lang.String barcode) {
		this.barcode = barcode;
	}
}

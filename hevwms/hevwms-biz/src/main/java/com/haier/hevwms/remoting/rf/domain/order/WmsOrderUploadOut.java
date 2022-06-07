package com.haier.hevwms.remoting.rf.domain.order;

/**
 * @ClassName: OtcwmsOrderUploadOut
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-17 下午2:46:25
 * @param
 */
public class WmsOrderUploadOut {
	
	private String status; // 0:成功/1:失败/2:删除/3:确定location/4:条码带输入数量
	private String msg; // 信息
	private String location; // 库存地点
	private String matno; // 物料号
	private String matdesc; // 物料描述
	private Integer scanqty; // 订单物料累计扫描数量
	private Integer poqty; // 订单物料需

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMatno() {
		return matno;
	}

	public void setMatno(String matno) {
		this.matno = matno;
	}

	public String getMatdesc() {
		return matdesc;
	}

	public void setMatdesc(String matdesc) {
		this.matdesc = matdesc;
	}

	public Integer getScanqty() {
		return scanqty;
	}

	public void setScanqty(Integer scanqty) {
		this.scanqty = scanqty;
	}

	public Integer getPoqty() {
		return poqty;
	}

	public void setPoqty(Integer poqty) {
		this.poqty = poqty;
	}

}

package com.haier.hevwms.remoting.rf.domain.order;

import java.util.List;

/**
 * @ClassName: OtcwmsOrderDelListOut
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:26:15
 * @param
 */
public class WmsOrderDelListOut {
	private String total; // 总数
	private List<WmsOrderDelDetial> detial;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<WmsOrderDelDetial> getDetial() {
		return detial;
	}

	public void setDetial(List<WmsOrderDelDetial> detial) {
		this.detial = detial;
	}
}

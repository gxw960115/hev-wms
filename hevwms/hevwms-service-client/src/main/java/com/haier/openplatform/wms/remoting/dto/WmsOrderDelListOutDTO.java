package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderDelListOutDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:49:10
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class WmsOrderDelListOutDTO implements Serializable {

	private static final long serialVersionUID = 5412609179143517850L;
	
	private String total;// 总数
	private List<OrderDelDetialDTO> detial;// 条码明细列表

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<OrderDelDetialDTO> getDetial() {
		return detial;
	}

	public void setDetial(List<OrderDelDetialDTO> detial) {
		this.detial = detial;
	}

	@Override
	public String toString() {
		return "WmsOrderDelListOutDTO [total=" + total + ", detial=" + detial + "]";
	}

}

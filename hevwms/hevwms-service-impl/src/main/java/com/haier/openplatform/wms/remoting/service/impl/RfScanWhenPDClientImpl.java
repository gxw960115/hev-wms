package com.haier.openplatform.wms.remoting.service.impl;

import java.util.List;
import java.util.Map;

import com.haier.hevwms.remoting.rf.service.RfScanWhenPDService;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.service.RfScanWhenPDClient;

/**
 * * @author 作者 :sunyanfei
 * 
 * @date 创建时间：2016-3-25 上午11:05:00
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class RfScanWhenPDClientImpl implements RfScanWhenPDClient {
	private RfScanWhenPDService scanWhenPDService;

	@Override
	public OrderIgpOutDTO orderCheck(OrderCheckInDTO in) {
		return scanWhenPDService.orderCkeck(in);
	}

	@Override
	public OrderIgpOutDTO orderDownLoad(OrderCheckInDTO in) {
		return scanWhenPDService.orderDownLoad(in);
	}

	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO in) {
		return scanWhenPDService.orderScan(in);
	}

	@Override
	public Map<String, String> offlineScan(List<OrderUploadInDTO> paramsIn) {
		return scanWhenPDService.offlineScan(paramsIn);
	}

	@Override
	public OrderUploadOutDTO orderDelete(OrderUploadInDTO in) {
		return scanWhenPDService.orderDelete(in);
	}

	@Override
	public WmsOrderDelListOutDTO barcodeDetail(OrderUploadInDTO in) {
		return scanWhenPDService.barcodeDetail(in);
	}

	@Override
	public OrderUploadOutDTO orderIogp(OrderUploadInDTO in) {
		return scanWhenPDService.orderIogp(in);
	}

	public void setScanWhenPDService(RfScanWhenPDService scanWhenPDService) {
		this.scanWhenPDService = scanWhenPDService;
	}

}

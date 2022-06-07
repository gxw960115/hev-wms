package com.haier.hevwms.takestock.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;

public interface OdsPdTempDtlService {
	public Long getScanQty(String orderNo);
	
	public String barcodeCheck(String orderNo,String barcode);
	
	public Map<String , String> add(OdsPdTempDtlDTO dto);
	
	public String orderDelete(OdsPdTempDtlDTO dto);
	
	public List<OdsPdTempDtlDTO> orderDetail(OdsPdTempDtlDTO dto);
	
	public JSONObject searchOdsPdTemps(OdsPdTempDtlDTO pdTempDtlDTO , Long rows, Long page);
	
	public String moveBarcode(Long rowId);
	
	public String updateBarcodeStatus(Long id,String status);
}

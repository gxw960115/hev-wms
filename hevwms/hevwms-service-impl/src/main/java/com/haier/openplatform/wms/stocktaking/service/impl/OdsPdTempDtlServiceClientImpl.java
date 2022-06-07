package com.haier.openplatform.wms.stocktaking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haier.hevwms.takestock.service.OdsPdTempDtlService;
import com.haier.hevwms.takestock.service.OdsPdTempService;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.OdsPdTempDtlServiceClient;

import io.terminus.common.utils.JsonMapper;
import net.sf.json.JSONObject;

public class OdsPdTempDtlServiceClientImpl implements OdsPdTempDtlServiceClient {
	Logger log =Logger.getLogger(OdsPdTempDtlServiceClientImpl.class);
	private OdsPdTempService odsPdTempService;
	
	private OdsPdTempDtlService odsPdTempDtlService;

	public void setOdsPdTempService(OdsPdTempService odsPdTempService) {
		this.odsPdTempService = odsPdTempService;
	}

	public void setOdsPdTempDtlService(OdsPdTempDtlService odsPdTempDtlService) {
		this.odsPdTempDtlService = odsPdTempDtlService;
	}

	@Override
	public String orderCheck(OdsPdTempDtlDTO pdTempDTO) {
		String result=odsPdTempService.orderCheck(pdTempDTO.getOrderNo());
		Long scanQty=odsPdTempDtlService.getScanQty(pdTempDTO.getOrderNo());
		Map<String, String> msg=new HashMap<String, String>();
		msg.put("status", result);
		msg.put("scanQty", String.valueOf(scanQty));
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(msg);
	}

	@Override
	public String orderScan(OdsPdTempDtlDTO pdTempDTO) {
		String msg=odsPdTempService.orderCheck(pdTempDTO.getOrderNo());
		Map<String, String> result=new HashMap<String, String>();
		if ("S".equals(msg)) {
			msg=odsPdTempDtlService.barcodeCheck(pdTempDTO.getOrderNo(), pdTempDTO.getBarcode());
			if ("S".equals(msg)) {
				result=odsPdTempDtlService.add(pdTempDTO);
			}
		}
		result.put("status", msg);
		Long scanQty=odsPdTempDtlService.getScanQty(pdTempDTO.getOrderNo());
		result.put("scanQty", String.valueOf(scanQty));
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	@Override
	public Map<String, String> offlineScan(List<OdsPdTempDtlDTO> list) {
		Map<String , String> result = new HashMap<String, String>();
		String orderNo="";
		for (OdsPdTempDtlDTO odsPdTempDtlDTO : list) {
			orderNo=odsPdTempDtlDTO.getOrderNo();
			String msg=odsPdTempService.orderCheck(orderNo);
			if ("S".equals(msg)) {
				msg=odsPdTempDtlService.barcodeCheck(odsPdTempDtlDTO.getOrderNo(), odsPdTempDtlDTO.getBarcode());
				if ("S".equals(msg)) {
					Map<String , String> res=odsPdTempDtlService.add(odsPdTempDtlDTO);
					if(!"S".equals(res.get("status"))){
						result.put(odsPdTempDtlDTO.getBarcode(), "F"+"&&"+res.get("status"));
					}
				}else{
					result.put(odsPdTempDtlDTO.getBarcode(), "F"+"&&"+msg);
				}
			}else{
				result.put(odsPdTempDtlDTO.getBarcode(), "F"+"&&"+msg);
			}
		}
		result.put("scanQty", odsPdTempDtlService.getScanQty(orderNo)+"");
		return result;
	}
	
	@Override
	public String orderDelete(OdsPdTempDtlDTO pdTempDTO) {
		String msg=odsPdTempDtlService.orderDelete(pdTempDTO);
		Long scanQty=odsPdTempDtlService.getScanQty(pdTempDTO.getOrderNo());
		Map<String, String> result=new HashMap<String, String>();
		result.put("status", msg);
		result.put("scanQty", String.valueOf(scanQty));
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	@Override
	public String orderDetail(OdsPdTempDtlDTO pdTempDtlDTO) {
		List<OdsPdTempDtlDTO> list =odsPdTempDtlService.orderDetail(pdTempDtlDTO);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
	}

	@Override
	public JSONObject searchOdsPdTempdtls(OdsPdTempDtlDTO pdTempDtlDTO, Long rows,
			Long page) {
		return odsPdTempDtlService.searchOdsPdTemps(pdTempDtlDTO, rows, page);
	}

	@Override
	public String moveBarcodes(String ids) {
		try {
			StringBuffer result=new StringBuffer(":");
			String [] rowIds=ids.split(",");
			int sucNum=0;
			int faiNum=0;
			for (String row : rowIds) {
				String msg=odsPdTempDtlService.moveBarcode(Long.parseLong(row));
				if ("S".equals(msg)){
					sucNum++;
				}else {
					faiNum++;
					result.append(msg);
				}
			}
			return "success:"+sucNum+",failed:"+faiNum+result.toString();
		} catch (Exception e) {
			log.debug("moveBarcodes:get data error,ids:"+ids+",error msg:"+e.toString());
			return "Failed,please try again";
		}
		
	}

	@Override
	public String updateBarcodesStatus(String ids, String status) {
		try {
			int sucNum=0;
			int faiNum=0;
			String [] rowIds=ids.split(",");
			for (String id : rowIds) {
				String msg=odsPdTempDtlService.updateBarcodeStatus(Long.parseLong(id), status);
				if ("S".equals(msg)){
					sucNum++;
				}else {
					faiNum++;
				}
			}
			return "success:"+sucNum+",failed:"+faiNum;
		} catch (Exception e) {
			log.debug("updateBarcodesStatus:get data error,ids:"+ids+",error msg:"+e.toString());
			return "Failed,please try again";
		}
	}

}

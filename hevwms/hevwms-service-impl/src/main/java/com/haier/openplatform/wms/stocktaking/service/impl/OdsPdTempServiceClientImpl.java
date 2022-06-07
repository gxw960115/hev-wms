package com.haier.openplatform.wms.stocktaking.service.impl;

import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.hevwms.takestock.service.OdsPdTempService;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;
import com.haier.openplatform.wms.stocktaking.service.OdsPdTempServiceClient;

import io.terminus.pampas.common.UserUtil;
import net.sf.json.JSONObject;

public class OdsPdTempServiceClientImpl implements OdsPdTempServiceClient {
	private OdsPdTempService pdTempService;
	private OdsPdInfoService odsPdInfoService;
	
	public void setPdTempService(OdsPdTempService pdTempService) {
		this.pdTempService = pdTempService;
	}
	
	public void setOdsPdInfoService(OdsPdInfoService odsPdInfoService) {
		this.odsPdInfoService = odsPdInfoService;
	}

	@Override
	public String addPdTempOrder(OdsPdTempDTO pdTempDTO) {
		//  Auto-generated method stub
		String user=UserUtil.getCurrentUser().getName();
		pdTempDTO.setCreateBy(user);
		return pdTempService.addPdTempOrder(pdTempDTO);
	}

	public String updateOrderStatus(OdsPdTempDTO pdTempDTO) {
		//  Auto-generated method stub
		return pdTempService.updateOrderStatus(pdTempDTO);
	}
	
	@Override
	public String updateStatus(String ids,String status) {
		//  Auto-generated method stub
		OdsPdTempDTO pdTempDTO=new OdsPdTempDTO();
		pdTempDTO.setRowId(Long.valueOf(ids));
		pdTempDTO.setStatus(status);
		return pdTempService.updateOrderStatus(pdTempDTO);
	}
	
	@Override
	public JSONObject searchOdsPdTemps(OdsPdTempDTO pdTempDTO, Long rows, Long page) {
		//  Auto-generated method stub
		return pdTempService.searchOdsPdTemps(pdTempDTO, rows, page);
	}

	@Override
	public String getTempPdOrderNo() {
		 String orderNo=odsPdInfoService.selectStocktakingOrderNo();
		 return "TP"+orderNo;
	}


}

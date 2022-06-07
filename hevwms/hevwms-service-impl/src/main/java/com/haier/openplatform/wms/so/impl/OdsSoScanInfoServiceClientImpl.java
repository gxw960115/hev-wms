package com.haier.openplatform.wms.so.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.hevwms.so.service.OdsSoScanInfoService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.OdsSoScanInfoServiceClient;

import net.sf.jasperreports.engine.JasperRunManager;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoScanInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 上午11:12:24
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public class OdsSoScanInfoServiceClientImpl implements OdsSoScanInfoServiceClient {

	private OdsSoScanInfoService odsSoScanInfoService;
	
	@Override
	public Pager<OdsSoScanInfoDTO> searchOdsPoScanInfoByPage(Long page, Long rows, OdsSoScanInfoDTO dto) {
		Pager<OdsSoScanInfoDTO> pager = new Pager<OdsSoScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsSoScanInfoService.searchOdsSoScanInfoByPage(pager, dto);
		return pager;
	}

	@Override
	public Long getExportAmount(OdsSoScanInfoDTO dto) {
		return odsSoScanInfoService.getExportAmount(dto);
	}

	@Override
	public List<OdsSoScanInfoDTO> getOdsPoScanInfos(OdsSoScanInfoDTO dto) {
		return odsSoScanInfoService.getOdsSoScanInfos(dto);
	}

	@Override
	public byte[] printSoDetail(String filePath, Map<String, Object> parameters) {
		byte[] bytes = null;
		Connection conn = null;
		try {
			DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
			conn = datasource.getConnection();
			if (conn == null) {
				return null;
			}
			StringBuffer locations = new StringBuffer();
			String deliveryName = "";
			String deliveryAddress = "";
			String customerPo = "";

			String dn_no = (String) parameters.get("dnNo");
			StgDnDownDTO dto = new StgDnDownDTO();
			dto.setDnNo(dn_no);
            StgDnDownService stgDnDownService = SpringApplicationContextHolder.getBean("stgDnDownService");
			// 根据DN_NO查询数据库中的DN单，获取deliveryName、deliveryAddress、customer和location
			List<StgDnDownDTO> stgDnDownList = stgDnDownService.getStgDnDownsByParam(dto);
			if (stgDnDownList != null && stgDnDownList.size() != 0) {
                List<String> locationNameList = stgDnDownService.getLocationNameByDnNo(dn_no);
                for (int i = 0; i < locationNameList.size(); i++) {
					if (i == locationNameList.size() - 1) {
						locations.append(locationNameList.get(i));
					} else {
						locations.append(locationNameList.get(i)).append(" / ");
					}
				}
				// 获取deliveryName、deliveryAddress、customerPO，该信息同DN单相同
				StgDnDownDTO dnDTO = stgDnDownList.get(0);
				deliveryName = dnDTO.getDeliveryName() == null ? "" : dnDTO.getDeliveryName();
				deliveryAddress = dnDTO.getDeliveryAddress() == null ? "" : dnDTO.getDeliveryAddress();
				customerPo = dnDTO.getCustomerPo() == null ? "" : dnDTO.getCustomerPo();
			}

			parameters.put("locations", locations.toString());
			parameters.put("deliveryName", deliveryName);
			parameters.put("deliveryAddress", deliveryAddress);
			parameters.put("customerPo", customerPo);
			bytes = JasperRunManager.runReportToPdf(filePath, parameters, conn);
			conn.close();
		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return bytes;
	}

	public OdsSoScanInfoService getOdsSoScanInfoService() {
		return odsSoScanInfoService;
	}

	public void setOdsSoScanInfoService(OdsSoScanInfoService odsSoScanInfoService) {
		this.odsSoScanInfoService = odsSoScanInfoService;
	}

	@Override
	public String updateOldBarcode(OdsSoScanInfoDTO odsSoScanInfoDTO) {
		
		ExecuteResult<OdsSoScanInfoDTO> result = odsSoScanInfoService.updateOldBarcode(odsSoScanInfoDTO);
		if (result.isSuccess()){
			return "success";
		} else {
			return "error";
		}
	}

}

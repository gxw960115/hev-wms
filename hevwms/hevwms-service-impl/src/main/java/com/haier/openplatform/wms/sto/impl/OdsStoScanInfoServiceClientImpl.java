package com.haier.openplatform.wms.sto.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.sto.service.OdsStoScanInfoService;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.openplatform.showcase.util.PlantInfo;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.service.OdsStoScanInfoServiceClient;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoScanInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午11:59:05
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public class OdsStoScanInfoServiceClientImpl implements OdsStoScanInfoServiceClient {

	private OdsStoScanInfoService odsStoScanInfoService;
	
	public OdsStoScanInfoService getOdsStoScanInfoService() {
		return odsStoScanInfoService;
	}
	
	public void setOdsStoScanInfoService(OdsStoScanInfoService odsStoScanInfoService) {
		this.odsStoScanInfoService = odsStoScanInfoService;
	}
	
	@Override
	public Pager<OdsStoScanInfoDTO> searchOdsStoScanInfoByPage(Long page, Long rows, OdsStoScanInfoDTO dto) {
		Pager<OdsStoScanInfoDTO> pager = new Pager<OdsStoScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsStoScanInfoService.searchOdsStoScanInfoByPage(pager, dto);
		return pager;
	}

	@Override
	public Long getExportAmount(OdsStoScanInfoDTO dto) {
		return odsStoScanInfoService.getExportAmount(dto);
	}

	@Override
	public List<OdsStoScanInfoDTO> getOdsStoScanInfos(OdsStoScanInfoDTO dto) {
		return odsStoScanInfoService.getOdsStoScanInfos(dto);
	}

	/**
	 * STO报表
	 * @param filePath
	 * @param parameters
	 * @return
	 */
	@Override
	public byte[] printStoDetail(String filePath, Map<String, Object> parameters) {
		byte[] bytes = null;
		Connection conn = null;
		try {
			DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
			conn = datasource.getConnection();
			if (conn == null) {
				return bytes;
			}
			StringBuffer giLocation = new StringBuffer();
			StringBuffer grLocation = new StringBuffer();
			String stoNo = "";

            List<OdsStoScanInfoDTO> stoScanInfoList = 
            		odsStoScanInfoService.getListByBarcodes((String) parameters.get("orderNo"),(String) parameters.get("barcode"));
			if (stoScanInfoList != null && stoScanInfoList.size() > 0) {
                stoNo = stoScanInfoList.get(0).getStoNo();
                StgStoDownDTO stgStoDownDTO = new StgStoDownDTO();
                stgStoDownDTO.setStoNo(stoNo);
                StgStoDownService stoDownService =  SpringApplicationContextHolder.getBean("stgStoDownService");
                List<StgStoDownDTO> stgStoDownList = stoDownService.getStgStoDowns(stgStoDownDTO);
				StringBuffer giLocationTemp = new StringBuffer();
				StringBuffer grLocationTemp = new StringBuffer();
                if (stgStoDownList != null && stgStoDownList.size() > 0) {
					for (int x = 0; x < stgStoDownList.size(); x++) {
						if (x == stgStoDownList.size() - 1) {
							giLocationTemp.append("'").append(stgStoDownList.get(x).getGiLocation()).append("'");
							grLocationTemp.append("'").append(stgStoDownList.get(x).getGrLocation()).append("'");
						} else {
							giLocationTemp.append("'").append(stgStoDownList.get(x).getGiLocation()).append("',");
							grLocationTemp.append("'").append(stgStoDownList.get(x).getGrLocation()).append("',");
						}
					}
					CdLocInfoDAO cdLocInfoDAO = SpringApplicationContextHolder.getBean("cdLocInfoDAO");
					List<CdLocInfoDTO> giCdLocInfoDTOList = cdLocInfoDAO.getCdLocInfoListByCode(giLocationTemp.toString());
					List<CdLocInfoDTO> grCdLocInfoDTOList = cdLocInfoDAO.getCdLocInfoListByCode(grLocationTemp.toString());

					for (int i = 0; i < giCdLocInfoDTOList.size(); i++) {
						if (i == giCdLocInfoDTOList.size() - 1) {
							giLocation.append(giCdLocInfoDTOList.get(i).getName());
						} else {
							giLocation.append(giCdLocInfoDTOList.get(i).getName()).append("/");
						}
					}
					for (int i = 0; i < grCdLocInfoDTOList.size(); i++) {
						if (i == grCdLocInfoDTOList.size() - 1) {
							grLocation.append(grCdLocInfoDTOList.get(i).getName());
						} else {
							grLocation.append(grCdLocInfoDTOList.get(i).getName()).append("/");
						}
					}

                }
            }
			parameters.put("giLocation",giLocation.toString());
			parameters.put("grLocation",grLocation.toString());
			parameters.put("stoNo",stoNo);
            bytes = JasperRunManager.runReportToPdf(filePath,parameters, conn);
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

	@Override
	public Long getExportOdsStoDnScanInfoAmount(OdsStodnScanInfoDTO dto) {
		return odsStoScanInfoService.getOdsStoDnScanInfoCountByParm(dto);
	}

	@Override
	public List<OdsStodnScanInfoDTO> getStoDnScanInfoListByParm(OdsStodnScanInfoDTO dto) {
		return odsStoScanInfoService.getStoDnListByParm(dto);
	}
}

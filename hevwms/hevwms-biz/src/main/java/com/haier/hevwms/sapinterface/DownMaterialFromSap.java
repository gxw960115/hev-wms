package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.List;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.log4j.Logger;

import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.security.dto.OperationLogDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

public class DownMaterialFromSap {
	Logger logger = Logger.getLogger(DownMaterialFromSap.class);
	String rfc_id = "ZMM_AEV_INT_MATERIAL";
	String system_id = "HEVWMS"; 
	String materialNo;
	String createBegin;
	String createEnd;
	String modifyBegin;
	String modifyEnd;
	String userName;
	private OperationLogDAO operationLogDAO;
	private MdMatInfoDAO mdMatInfoDAO;
	
	public DownMaterialFromSap(String materialNo,
							   String createBegin,
							   String createEnd,
							   String modifyBegin,
							   String modifyEnd,
							   OperationLogDAO operationLogDAO,
							   MdMatInfoDAO mdMatInfoDAO) {
		this.materialNo = materialNo;
		this.createBegin = createBegin;
		this.createEnd = createEnd;
		this.modifyBegin = modifyBegin;
		this.modifyEnd = modifyEnd;
		this.operationLogDAO = operationLogDAO;
		this.mdMatInfoDAO = mdMatInfoDAO;
	}

	public DownMaterialFromSap(String materialNo, String createBegin, String createEnd,
			String modifyBegin, String modifyEnd, String userName){
		this.materialNo = materialNo;
		this.createBegin = createBegin;
		this.createEnd = createEnd;
		this.modifyBegin = modifyBegin;
		this.modifyEnd = modifyEnd;
		this.userName = userName;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		mdMatInfoDAO = SpringApplicationContextHolder.getBean("mdMatInfoDAO");
	}
	
	public InterfaceOutDTO exchangeWithSap() {
		logger.info("Exchange with sap start------------------------");
		// ??????????????????
		InterfaceOutDTO result = new InterfaceOutDTO();
		result.setStatus("S");
		result.setMsg("Download success!");

		String message ;
		OperationLogDTO log = new OperationLogDTO();
		log.setUserName(userName);
		log.setAppName("DownloadMaterialFromSap");
		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			logger.info(ex);
			result.setStatus("E");
			result.setMsg("SAP connection failed!");
			return result;
		}
		// SAP ???????????????
		JCoTable codes;
		try{
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);
			
			// ??????????????????
			if (materialNo != null && !"".equals(materialNo)) {
				function.getImportParameterList().setValue("MATNR", materialNo);
			}else {
				// ????????????????????????
				if (createBegin != null) {
					if (createEnd != null) {
						if (createBegin.equals(createEnd)) {
							function.getImportParameterList().setValue("ERSDA_B", createBegin);
						} else {
							function.getImportParameterList().setValue("ERSDA_B", createBegin);
							function.getImportParameterList().setValue("ERSDA_E", createEnd);
						}
					} else {
						function.getImportParameterList().setValue("ERSDA_B", createBegin);
					}
				}  
				// ??????????????????
				if (modifyBegin != null) {
					if (modifyEnd != null) {
						if (modifyBegin.equals(modifyEnd)) {
							function.getImportParameterList().setValue("LAEDA_B", modifyBegin);
						} else {
							function.getImportParameterList().setValue("LAEDA_B", modifyBegin);
							function.getImportParameterList().setValue("LAEDA_E", modifyEnd);
						}
					} else {
						function.getImportParameterList().setValue("LAEDA_B", modifyBegin);
					}
				} 
			}

			logger.info("INPUT Parameters=========>" + function.getImportParameterList());
			function.execute(destination);

			codes = function.getTableParameterList().getTable("OUTPUT");
			logger.info("OUTPUT Table=========>" + codes);
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Catch Exception when download Material: " + message);
			log.setDescription("Execute Sap Function failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);

			result.setStatus("E");
			result.setMsg("Execute SAP Function failed!");
			return result;
		}

		int insertNum = 0;
		int updateNum = 0;
		int deleteNum = 0;
		String materialNo = "";// ?????????
		String materialDesp = "";// ????????????
		String plant = "";// ??????
		String location = "";// ????????????
		String basicUnit = "";// ????????????
		String orderUnit = "";// ????????????
		String orderBasicFactor = "";// ?????????????????????????????????
		String orderFactor = "";// ??????????????????
		String issueUnit = "";// ????????????
		String issueBasicFactor = "";// ?????? ???????????????????????????
		String issueFactor = "";// ??????????????????
		String matType = "";// ????????????
		String mrpCode = "";// MRP?????????
		String purchaseGroup = "";// ?????????
		String oldMat = "";// ?????????
		String delFlag = "";// ????????????
		String volume = "";// ??????
		String volumeUnit = "";// ????????????
		String length = "";// ???
		String width = "";// ???
		String height = "";// ???
		String measureUnit = "";// ???????????????
		String division = "";//?????????

		if (codes != null && codes.getNumRows() > 0) {

			for (int i = 0; i < codes.getNumRows(); i++) {
				codes.setRow(i);
				// ??????????????????
				if ("65C1".equals(codes.getString("WERKS"))) {
					materialNo = codes.getString("MATNR");
					materialDesp = codes.getString("MAKTX");
					plant = codes.getString("WERKS");
					location = codes.getString("LGORT");
					basicUnit = codes.getString("MEINS");
					orderUnit = codes.getString("BSTME");
					orderBasicFactor = codes.getString("BASIC_ORDER");
					orderFactor = codes.getString("CONV_ORDER");
					issueUnit = codes.getString("AUSME");
					issueBasicFactor = codes.getString("BASIC_ISSUE");
					issueFactor = codes.getString("CONV_ISSUE");
					matType = codes.getString("MTART");
					mrpCode = codes.getString("DISPO");
					purchaseGroup = codes.getString("EKGRP");
					oldMat = codes.getString("BISMT");
					delFlag = codes.getString("LVORM");
					volume = codes.getString("VOLUM");
					volumeUnit = codes.getString("VOLEH");
					length = codes.getString("LAENG");
					width = codes.getString("BREIT");
					height = codes.getString("HOEHE");
					measureUnit = codes.getString("MEABM");
					division = codes.getString("SPART");

					if (!"".equals(materialDesp) && materialDesp != null) {
						materialDesp = CommonTool.replace(materialDesp, "'", " ");
						materialDesp = CommonTool.replace(materialDesp, "\"", "");
					}

					MdMatInfoDTO dto = new MdMatInfoDTO();
					dto.setPlant(plant);
					dto.setMaterialNo(materialNo);
					List<MdMatInfoDTO> list = mdMatInfoDAO.getMdMatInfoByParam(dto);
					// ???????????????
					if (list != null && list.size()>0) {
						MdMatInfoDTO temp = list.get(0);
						if (!delFlag.equals("X")){
							temp.setMaterialDesp(materialDesp);
							temp.setBasicUnit(basicUnit);
							temp.setLocation(location);
							temp.setBasicUnit(basicUnit);
							temp.setOrderUnit(orderUnit);
							temp.setOrderBasicFactor(Long.valueOf(orderBasicFactor));
							temp.setOrderFactor(Long.valueOf(orderFactor));
							temp.setIssueUnit(issueUnit);
							temp.setIssueBasicFactor(Long.valueOf(issueBasicFactor));
							temp.setIssueFactor(Long.valueOf(issueFactor));
							temp.setMatType(matType);
							temp.setMrpCode(mrpCode);
							temp.setPurchaseGroup(purchaseGroup);
							temp.setOldMat(oldMat);
							temp.setVolume(Double.valueOf(volume));
							temp.setVolumeUnit(volumeUnit);
							temp.setLength(Double.valueOf(length));
							temp.setWidth(Double.valueOf(width));
							temp.setHigth(Double.valueOf(height));
							temp.setMeasureUnit(measureUnit);
							temp.setDivision(division);
							//mat_scan_type
							if ("Z2".equalsIgnoreCase(division)){
								temp.setMatScanType("SKU");
							} else {
								temp.setMatScanType("CBU");
							}
							temp.setModifyBy(userName);
							temp.setModifyDate(new Date());
							mdMatInfoDAO.update(temp);
							updateNum++;
						} else {
							temp.setCreatedBy(userName);
							temp.setCreatedDate(new Date());
							mdMatInfoDAO.bankupMat(temp);
							mdMatInfoDAO.delete(temp.getRowId());
							deleteNum++;
						}
					} else {
						MdMatInfoDTO temp1 = new MdMatInfoDTO();
						temp1.setMaterialNo(materialNo);
						temp1.setMaterialDesp(materialDesp);
						temp1.setBasicUnit(basicUnit);
						temp1.setPlant(plant);
						temp1.setLocation(location);
						temp1.setBasicUnit(basicUnit);
						temp1.setOrderUnit(orderUnit);
						temp1.setOrderBasicFactor(Long.valueOf(orderBasicFactor));
						temp1.setOrderFactor(Long.valueOf(orderFactor));
						temp1.setIssueUnit(issueUnit);
						temp1.setIssueBasicFactor(Long.valueOf(issueBasicFactor));
						temp1.setIssueFactor(Long.valueOf(issueFactor));
						temp1.setMatType(matType);
						temp1.setMrpCode(mrpCode);
						temp1.setPurchaseGroup(purchaseGroup);
						temp1.setOldMat(oldMat);
						temp1.setVolume(Double.valueOf(volume));
						temp1.setVolumeUnit(volumeUnit);
						temp1.setLength(Double.valueOf(length));
						temp1.setWidth(Double.valueOf(width));
						temp1.setHigth(Double.valueOf(height));
						temp1.setMeasureUnit(measureUnit);
						temp1.setDivision(division);
						if ("Z2".equalsIgnoreCase(division)){
							temp1.setMatScanType("SKU");
						} else {
							temp1.setMatScanType("CBU");
						}
						temp1.setCreatedBy(userName);
						temp1.setCreatedDate(new Date());
						mdMatInfoDAO.save(temp1);
						insertNum++;
					}
				}
			}
			logger.info("Download Material Success!");
			log.setDescription("Execute Sap Function Success:Insert:"+insertNum+", Update:"+updateNum+", Delete:"+deleteNum);
			operationLogDAO.save(log);
		} else {
			log.setDescription("No data is downloaded!");
			operationLogDAO.save(log);
			
			result.setStatus("E");
			result.setMsg("No data is downloaded!");
		}
		return result;
	}

}
